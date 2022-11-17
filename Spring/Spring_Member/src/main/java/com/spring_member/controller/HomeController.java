package com.spring_member.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_member.dto.MemberDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		System.out.println("메인 페이지 이동 요청");

		return "Main";
	}

	@RequestMapping(value = "/memberJoinForm")
	public ModelAndView memberJoinForm() {
		System.out.println("회원가입 페이지 이동 요청");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("member/MemberJoinForm");
		return mav;
	}

	@RequestMapping(value = "memberJoin")
	public ModelAndView memberJoin(MemberDto member) {
		System.out.println("회원가입 요청");
		System.out.println(member);

		return null;
	}

}
