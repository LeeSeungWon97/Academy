package com.MemberBoard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MemberBoard.service.ApiService;

@Controller
public class ApiController {
	@Autowired
	private ApiService apisvc;
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/kakaoLoginTest")
	public ModelAndView kakaoLoginTest(String code, RedirectAttributes ra) throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.print("[코드]: ");
		System.out.println(code);

		String kakaoAccessToken = apisvc.getAccessToken(code);
		System.out.print("[kakaoAccessToken]: ");
		System.out.println(kakaoAccessToken);
		
		ra.addFlashAttribute("kakaoAccessToken", kakaoAccessToken);
		mav.setViewName("redirect:/memberLoginForm");

		return mav;
	}
	
	@RequestMapping(value = "/memberLogin_kakao")
	public @ResponseBody String memberLogin_kakao(String token) throws Exception {
		System.out.println("memberLogin_kakao 요청");
		System.out.println("accessToken: " + token);
		String kakaoUserInfo_json = apisvc.memberLogin_kakao(token,session);
		return kakaoUserInfo_json;
	}

}
