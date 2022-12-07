package com.MemberBoard.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class ApiService {

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

		// 2. 가져온 카카오 사용자 정보가 MEMBERS 테이블에 등록되어 있는지 확인
		JsonElement userInfoElement = JsonParser.parseString(sb.toString());
		String kakaoId = userInfoElement.getAsJsonObject().get("id").getAsString();
		System.out.println("kakaoId: " + kakaoId);
		String kakaoNickName = userInfoElement.getAsJsonObject().get("properties").getAsJsonObject().get("nickname").getAsString();
		System.out.println("kakaoNickName: " + kakaoNickName);
		String kakaoProfile = userInfoElement.getAsJsonObject().get("properties").getAsJsonObject().get("profile_image").getAsString();
		System.out.println("kakaoProfile: " + kakaoProfile);
		String kakaoEmail = userInfoElement.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString();
		System.out.println("kakaoEmail: " + kakaoEmail);
		return null;
	}

}
