package com.MovieProject.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/addMovieList")
	public String addMovieList() throws IOException {
		System.out.println("/addMovieList 요청");
		
		// 1.CGV 영화 페이지 URL
		String cgvurl = "http://www.cgv.co.kr/movies/?lt=1&ft=0";
		
		// 2. Jsoup URL 접속
		Document doc = Jsoup.connect(cgvurl).get();
		
		// 3. 무비차트 출력 DIV 선택
		// selector : #contents > div.wrap-movie-chart > div.sect-movie-chart
		Elements chartDiv = doc.select("#contents > div.wrap-movie-chart > div.sect-movie-chart");
		
		// 4. div의 li태그 선택 
		Elements movieList = chartDiv.select("li");

		for (int i = 0; i < movieList.size(); i++) {
			// 5. 영화의 상세페이지 URL 추출
			// div.box-image > a
			String detailUrl = "http://www.cgv.co.kr"+ movieList.eq(i).select("div.box-image > a").attr("href");
			System.out.println("상세주소: "+detailUrl);
			// 6. 상세페이지로 다시 접속
			Document detailDoc = Jsoup.connect(cgvurl).get();
			
		}
		
		return null;
	}
	
}
