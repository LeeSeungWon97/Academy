package com.MemberBoard.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.MemberBoard.dto.MemberDto;
import com.MemberBoard.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService msvc;
	
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/memberJoinForm")
	public ModelAndView memberJoinForm() {
		System.out.println("회원가입 페이지 이동요청");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("member/MemberJoinForm");
		return mav;
	}

	@RequestMapping(value = "/memberJoin")
	public ModelAndView memberJoin(MemberDto member) throws IllegalStateException, IOException {
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

	@RequestMapping(value = "/memberIdCheck")
	// ResponseBody >> 데이터 값만 전송
	public @ResponseBody String memberIdCheck(String inputId) {
		System.out.println("아이디 중복체크 확인 요청");
		System.out.println("입력한 아이디: " + inputId);
		String idCheck = msvc.idCheck(inputId);
		return idCheck;
	}
	
	@RequestMapping(value = "/memberLoginForm")
	public ModelAndView memberLoginForm() {
		System.out.println("로그인 페이지 이동요청");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("member/MemberLoginForm");
		return mav;
	}
	
	@RequestMapping(value = "/memberLogin")
	public ModelAndView memberLogin(MemberDto member) {
		System.out.println("로그인 페이지 이동요청");
		ModelAndView mav = new ModelAndView();
		
		MemberDto loginInfo = msvc.memberLogin(member);
		if(loginInfo == null) {
			System.out.println("로그인 실패");
			mav.setViewName("redirect:/memberLoginForm");
		} else {
			System.out.println("로그인 성공");
			session.setAttribute("loginInfo", loginInfo);
			mav.setViewName("redirect:/");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/memberLogout")
	public ModelAndView memberLogout() {
		System.out.println("로그아웃 요청");
		ModelAndView mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("redirect:/");
		return mav;
	}
}
