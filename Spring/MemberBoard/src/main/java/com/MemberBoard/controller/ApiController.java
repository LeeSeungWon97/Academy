package com.MemberBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MemberBoard.service.ApiService;

@Controller
public class ApiController {
	@Autowired
	private ApiService apisvc;

	@RequestMapping(value = "/kakaoLoginTest")
	public ModelAndView kakaoLoginTest(String code) throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.print("[코드]: ");
		System.out.println(code);

		String kakaoAccessToken = apisvc.getAccessToken(code);
		System.out.print("[kakaoAccessToken]: ");
		System.out.println(kakaoAccessToken);

		return mav;
	}

}
