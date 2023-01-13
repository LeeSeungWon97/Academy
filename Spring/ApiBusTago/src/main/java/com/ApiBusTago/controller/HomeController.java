package com.ApiBusTago.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("MainPage 이동 요청");
		
		return "Main";
	}
	
	@RequestMapping(value = "/dataPortal")
	public ModelAndView dataPortal() throws Exception {
		System.out.println("dataPortal 이동 요청");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("dataPortal");
		return mav;
	}
	
	@RequestMapping(value = "/stationPath")
	public ModelAndView stationPath(String dept_station_code, String dest_station_code) throws Exception {
		System.out.println("경로조회 요청");
		ModelAndView mav = new ModelAndView();
		System.out.println("출발역 코드: " + dept_station_code);
		System.out.println("도착역 코드: " + dest_station_code);
		dataPortalSvc(dept_station_code,dest_station_code);
		mav.setViewName("dataPortal");
		return mav;
	}
	
	private String dataPortalSvc(String dept_station_code, String dest_station_code) throws Exception {
		System.out.println("이동 경로 탐색 데이터 조회 서비스 호출");
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B553766/smt-path/path"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=fq2uJ2z5ar8dmZ7iOHGtSaAxSJ68AZSudJmLPV3Hej62zw08%2FZyPds1uvJUkAzfL4YEuGam0iydmGaa682%2FoVA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dept_station_code","UTF-8") + "=" + URLEncoder.encode(dept_station_code, "UTF-8")); /*출발역 코드*/
        urlBuilder.append("&" + URLEncoder.encode("dest_station_code","UTF-8") + "=" + URLEncoder.encode(dest_station_code, "UTF-8")); /*도착역 코드*/
        urlBuilder.append("&" + URLEncoder.encode("week","UTF-8") + "=" + URLEncoder.encode("DAY", "UTF-8")); /*주중(DAY)/토요일(SAT)/공휴일(HOL)*/
        urlBuilder.append("&" + URLEncoder.encode("search_type","UTF-8") + "=" + URLEncoder.encode("FASTEST", "UTF-8")); /*검색방법 (FASTEST, MINTRF)*/
        urlBuilder.append("&" + URLEncoder.encode("first_last","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*첫차혹은막차 (첫차: 1 / 막차: 2)*/
        urlBuilder.append("&" + URLEncoder.encode("dept_time","UTF-8") + "=" + URLEncoder.encode("120001", "UTF-8")); /*출발시간(HHmmss)*/
        urlBuilder.append("&" + URLEncoder.encode("train_seq","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*출발시간 기준 주변도시철도 예) -1 : 이전도시철도 1 : 다음도시철도*/
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
        
        JsonObject pathObj = JsonParser.parseString(sb.toString()).getAsJsonObject();
        System.out.println(pathObj.get("data"));
        JsonObject dataObj = pathObj.get("data").getAsJsonObject();
        String arrv_time = dataObj.get("arrv_time").getAsString();
        System.out.println("도착 시간: " + arrv_time);
        JsonArray routeList = dataObj.get("route").getAsJsonArray();
        System.out.println(routeList.size());
        for(JsonElement route: routeList) {
        	String station_nm = route.getAsJsonObject().get("station_nm").getAsString();
        	System.out.println("역 이름: " + station_nm);
        }
		return null;
	}
	
}
