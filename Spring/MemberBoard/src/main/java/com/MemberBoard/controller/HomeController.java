package com.MemberBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public ModelAndView home() {
		System.out.println("메인페이지 이동 요청");
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("Main");
		return mav;
	}
	
}
