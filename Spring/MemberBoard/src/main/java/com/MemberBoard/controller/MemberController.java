package com.MemberBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MemberBoard.dto.MemberDto;
import com.MemberBoard.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService msvc;

	@RequestMapping(value = "/memberJoinForm")
	public ModelAndView memberJoinForm() {
		System.out.println("회원가입 페이지 이동요청");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("member/MemberJoinForm");
		return mav;
	}

	@RequestMapping(value = "/memberJoin")
	public ModelAndView memberJoin(MemberDto member) {
		System.out.println("회원가입 요청");
		ModelAndView mav = new ModelAndView();
		int insertResult = msvc.memberJoin(member);
		if (insertResult > 0) {
			System.out.println("회원가입 성공");
			mav.setViewName("Main");
		} else {
			System.out.println("회원가입 실패");
			mav.setViewName("member/MemberJoinForm");
		}

		return mav;
	}

}
