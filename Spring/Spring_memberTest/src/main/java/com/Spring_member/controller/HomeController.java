package com.Spring_member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Spring_member.dto.TestDto;

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

		model.addAttribute("serverTime", formattedDate);

		return "home"; // WEB_INF/views/home.jsp => forward 해줄 페이지 파일명 입력
	}

	@RequestMapping(value = "/testPage")
	public String testPage() {
		System.out.println("테스트 페이지 요청");
		return "TestFolder/TestPage";
	}

	@RequestMapping(value = "/mavTest")
	public ModelAndView MavTest() {
		// ModelAndView: 데이터와 페이지의 정보를 담는 객체
		ModelAndView mav = new ModelAndView();

		// 페이지주소
		mav.setViewName("TestFolder/TestPage");

		mav.addObject("testData", "DATA");

		return mav;
	}

	@RequestMapping(value = "/submitTest")
	public ModelAndView SubmitTest(@RequestParam("testId") String data1, String testPw) {
		System.out.println("/submitTest 요청");

		// 방법 1
		// @RequestParam("testId") String data1
		// String data1 = request.getParameter("testId");
		System.out.println("data1: " + data1);

		// 방법 2
		// 변수명을 똑같이 지정
		System.out.println("testPw: " + testPw);
		return null;
	}

	@RequestMapping(value = "/submitTest2")
	public ModelAndView SubmitTest2(@RequestParam(value = "testId", defaultValue = "abc") String testId) {
		System.out.println("/submitTest2 요청");
		System.out.println("testId: " + testId);
		return null;
	}
	
	@RequestMapping(value = "/submitDto")
	public ModelAndView SubmitDto(TestDto tdto) {
		System.out.println("/submitDto 요청");
		System.out.println(tdto);
		return null;
	}

}
