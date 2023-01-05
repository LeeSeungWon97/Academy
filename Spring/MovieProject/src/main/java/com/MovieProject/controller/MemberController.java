package com.MovieProject.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.MovieProject.dto.MemberDto;
import com.MovieProject.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService msvc;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/memberJoinForm")
	public ModelAndView memberJoinForm() {
		System.out.println("회원가입 페이지 이동 요청");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/MemberJoinForm");	
		return mav;
	}
	
	@RequestMapping(value = "/memberJoin")
	public ModelAndView memberJoin(MemberDto joinInfo) throws IllegalStateException, IOException{
		System.out.println("회원가입 요청");
		ModelAndView mav = new ModelAndView();
		
		// 회원가입 요청 정보 확인
		System.out.println(joinInfo);

		int insertResult = 	msvc.memberJoin(joinInfo);
		if(insertResult == 1) {
			System.out.println("회원가입 성공");
			mav.setViewName("Main");
		}else {
			System.out.println("회원가입 실패");
			mav.setViewName("memberjoinForm");
		}		
		return mav;
	}
	
	@RequestMapping(value = "/memberIdCheck")
	public @ResponseBody String memberIdCheck(String inputId) {
		System.out.println("아이디 중복체크 확인 요청");
		String checkResult = msvc.memberIdCheck(inputId);
		return checkResult;
	}

	@RequestMapping(value="/memberLoginForm")
	public ModelAndView memberLoginForm() {
		System.out.println("로그인 페이지 이동 요청");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/MemberLoginForm");
		return mav;
	}
	
	@RequestMapping(value = "/memberLogin")
	public ModelAndView memberLogin(MemberDto loginId) {
		System.out.println("로그인 요청");
		ModelAndView mav = new ModelAndView();
		System.out.println(loginId);
		MemberDto loginInfo = msvc.memberLogin(loginId);
		String loginCheck = "F";
		if(loginInfo == null) {
			mav.addObject("loginCheck", loginCheck);
			mav.setViewName("redirect:/memberLoginForm");
		}else {
			session.setAttribute("loginInfo", loginInfo);
			loginCheck = "T";
			mav.addObject("loginCheck",loginCheck);
			mav.setViewName("redirect:/");
		}
		return mav;
		
	}
	
	@RequestMapping(value = "/memberLoginout")
	public ModelAndView memberLogout() {
		System.out.println("memberLogout 요청");
		ModelAndView mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("Main");
		return mav;
	}
}
