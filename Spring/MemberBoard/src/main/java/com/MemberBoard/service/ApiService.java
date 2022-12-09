package com.MemberBoard.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MemberBoard.dao.MemberDao;
import com.MemberBoard.dto.BusTagoDto;
import com.MemberBoard.dto.MemberDto;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class ApiService {

	@Autowired
	private MemberDao mdao;
	
	@Autowired
	private HttpSession session;

	// 카카오 토큰
	public String getAccessToken(String code) throws Exception {
		StringBuilder urlBuilder = new StringBuilder("https://kauth.kakao.com/oauth/token");
		urlBuilder.append("?" + URLEncoder.encode("grant_type", "UTF-8") + "="
				+ URLEncoder.encode("authorization_code", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("client_id", "UTF-8") + "="
				+ URLEncoder.encode("fc2f71bf7a40e334fb01ce30ee586a31", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("redirect_uri", "UTF-8") + "="
				+ URLEncoder.encode("http://localhost:8080/controller/kakaoLoginTest", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("code", "UTF-8") + "=" + URLEncoder.encode(code, "UTF-8"));
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

		JsonElement element = JsonParser.parseString(sb.toString());
		String access_token = element.getAsJsonObject().get("access_token").getAsString();
		System.out.println("access_token: " + access_token);
		return access_token;
	}

	// 카카오 계정정보로 로그인
	public String memberLogin_kakao(String token, HttpSession session) throws Exception {
		// 1. 카카오에서 카카오 계정 정보 가져오기
		StringBuilder urlBuilder = new StringBuilder("https://kapi.kakao.com/v2/user/me");
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Bearer " + token);
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

		JsonElement userInfoElement = JsonParser.parseString(sb.toString());
		String kakaoId = userInfoElement.getAsJsonObject().get("id").getAsString();
		System.out.println("kakaoId: " + kakaoId);
		String kakaoNickName = userInfoElement.getAsJsonObject().get("properties").getAsJsonObject().get("nickname")
				.getAsString();
		System.out.println("kakaoNickName: " + kakaoNickName);
		String kakaoProfile = userInfoElement.getAsJsonObject().get("properties").getAsJsonObject().get("profile_image")
				.getAsString();
		System.out.println("kakaoProfile: " + kakaoProfile);
		String kakaoEmail = userInfoElement.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email")
				.getAsString();
		System.out.println("kakaoEmail: " + kakaoEmail);

		// 2. 가져온 카카오 사용자 정보가 MEMBERS 테이블에 등록되어 있는지 확인
		Gson gson = new Gson();
		JsonObject jobj = new JsonObject();

		MemberDto kakaoInfoCheck = mdao.selectMemberInfo_kakao(kakaoId);

		if (kakaoInfoCheck == null) {
			// 등록된 정보가 아닐 경우
			jobj.addProperty("kakaoId", kakaoId);
			jobj.addProperty("kakaoNickName", kakaoNickName);
			jobj.addProperty("kakaoProfile", kakaoProfile);
			jobj.addProperty("kakaoEmail", kakaoEmail);
			jobj.addProperty("joinCheck", "-1");
		} else {
			// 등록된 정보일 경우 로그인 처리
			jobj.addProperty("joinCheck", "1");
			session.setAttribute("loginInfo", kakaoInfoCheck);
		}
		return gson.toJson(jobj);
	}

	public String memberJoin_kakao(String kakaoId, String kakaoNickName, String kakaoProfile, String kakaoEmail) {
		System.out.println("ApiService memberJoin_kakao 호출");
		int insertResult = mdao.insertMember_kakao(kakaoId, kakaoNickName, kakaoProfile, kakaoEmail);
		return insertResult + "";
	}

	public String kakaoPay_ready(String prcode, String prname, int prprice, int prcount) throws Exception {
		StringBuilder urlBuilder = new StringBuilder("https://kapi.kakao.com/v1/payment/ready");
		urlBuilder.append("?" + URLEncoder.encode("cid", "UTF-8") + "=" + URLEncoder.encode("TC0ONETIME", "UTF-8"));
		urlBuilder.append(
				"&" + URLEncoder.encode("partner_order_id", "UTF-8") + "=" + URLEncoder.encode("OD0001", "UTF-8"));
		urlBuilder.append(
				"&" + URLEncoder.encode("partner_user_id", "UTF-8") + "=" + URLEncoder.encode("TEST_STORE", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("item_name", "UTF-8") + "=" + URLEncoder.encode(prname, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("item_code", "UTF-8") + "=" + URLEncoder.encode(prcode, "UTF-8"));
		urlBuilder
				.append("&" + URLEncoder.encode("quantity", "UTF-8") + "=" + URLEncoder.encode(prcount + "", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("total_amount", "UTF-8") + "="
				+ URLEncoder.encode((prprice * prcount) + "", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("tax_free_amount", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("approval_url", "UTF-8") + "="
				+ URLEncoder.encode("http://localhost:8080/controller/kakaoPay_approval", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("cancel_url", "UTF-8") + "="
				+ URLEncoder.encode("http://localhost:8080/controller/kakaoPay_cancel", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("fail_url", "UTF-8") + "="
				+ URLEncoder.encode("http://localhost:8080/controller/kakaoPay_fail", "UTF-8"));
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "KakaoAK b566ed6d248562ed31ffcab819acbf25");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		
		JsonElement readyElement =  JsonParser.parseString(sb.toString());
		JsonObject readyObj = readyElement.getAsJsonObject();
		String tid = readyObj.get("tid").getAsString();
		System.out.println("tid: " + tid);
		session.setAttribute("payTid", tid);
		
		String nextPcUrl = readyObj.get("next_redirect_pc_url").getAsString();
		System.out.println("nextPcUrl : " + nextPcUrl);
		
		return nextPcUrl;

	}

	public String kakaoPay_approval(String tid, String pg_token) throws Exception {
		StringBuilder urlBuilder = new StringBuilder("https://kapi.kakao.com/v1/payment/approve");
		urlBuilder.append("?" + URLEncoder.encode("cid", "UTF-8") + "=" + URLEncoder.encode("TC0ONETIME", "UTF-8"));
		urlBuilder.append(
				"&" + URLEncoder.encode("tid", "UTF-8") + "=" + URLEncoder.encode(tid, "UTF-8"));
		urlBuilder.append(
				"&" + URLEncoder.encode("partner_order_id", "UTF-8") + "=" + URLEncoder.encode("OD0001", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("partner_user_id", "UTF-8") + "=" + URLEncoder.encode("TEST_STORE", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("pg_token", "UTF-8") + "=" + URLEncoder.encode(pg_token, "UTF-8"));
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "KakaoAK b566ed6d248562ed31ffcab819acbf25");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		return null;
	}

	public String getBusArrInfoList(String cityCode, String nodeId) throws Exception {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1613000/ArvlInfoInqireService/getSttnAcctoArvlPrearngeInfoList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=fq2uJ2z5ar8dmZ7iOHGtSaAxSJ68AZSudJmLPV3Hej62zw08%2FZyPds1uvJUkAzfL4YEuGam0iydmGaa682%2FoVA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*데이터 타입(xml, json)*/
        urlBuilder.append("&" + URLEncoder.encode("cityCode","UTF-8") + "=" + URLEncoder.encode(cityCode, "UTF-8")); /*도시코드 [상세기능3 도시코드 목록 조회]에서 조회 가능*/
        urlBuilder.append("&" + URLEncoder.encode("nodeId","UTF-8") + "=" + URLEncoder.encode(nodeId, "UTF-8")); /*정류소ID [국토교통부(TAGO)_버스정류소정보]에서 조회가능*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        JsonElement element = JsonParser.parseString(sb.toString());
        JsonObject body = element.getAsJsonObject().get("response").getAsJsonObject().get("body").getAsJsonObject();
        JsonObject items = body.getAsJsonObject().get("items").getAsJsonObject();
        String arrtime = items.get("arrtime").toString()

        System.out.println(body);
        System.out.println(items);

        
		return null;
	}

}
