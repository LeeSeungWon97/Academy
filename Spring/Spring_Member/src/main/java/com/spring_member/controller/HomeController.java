package com.spring_member.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_member.dto.MemberDto;
import com.spring_member.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	private MemberService msvc;
	
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
	public ModelAndView memberJoin(MemberDto member, RedirectAttributes ra) {
		System.out.println("회원가입 요청");
		System.out.println(member);
		ModelAndView mav = new ModelAndView();
		
		int insertResult = msvc.memberJoin(member);
		if(insertResult > 0) {
//			mav.setViewName("Main");
			mav.setViewName("redirect:/");
			ra.addFlashAttribute("msg", "회원가입에 성공했습니다.");
		} else {
			mav.setViewName("Fail");
			mav.addObject("msg","회원가입에 실패 했습니다.");
		}
		return mav;
	}
	
	@RequestMapping(value = "/memberList")
	public ModelAndView memberList() {
		System.out.println("회원 목록 페이지 이동요청");
		ModelAndView mav = new ModelAndView();
		ArrayList<MemberDto> memberList = msvc.memberList();
		
		mav.addObject("memberList",memberList);
		mav.setViewName("회원목록페이지");
		return mav;
	}

}
