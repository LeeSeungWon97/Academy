package com.MemberBoard.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MemberBoard.dto.BoardDto;
import com.MemberBoard.dto.MemberDto;
import com.MemberBoard.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService bsvc;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/boardList")
	public ModelAndView boardList() {
		System.out.println("전체글목록 페이지 이동 요청");
		ModelAndView mav = new ModelAndView();
		// 1. 글목록 조회

		// 2. 글목록페이지 지정
		mav.setViewName("board/BoardList");

		return mav;
	}
	
	@RequestMapping(value = "/boardWriteForm")
	public ModelAndView boardWriteForm() {
		System.out.println("글작성 페이지 이동요청");
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("loginInfo") != null) {
			mav.setViewName("board/BoardWriteForm");
		} else {
			mav.setViewName("redirect:/memberLoginForm");
		}
		return mav;
	}
	
	@RequestMapping(value = "/boardWrite")
	public ModelAndView boardWrite(BoardDto bdto) throws IllegalStateException, IOException {
		System.out.println("글작성 요청");
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("loginInfo")==null) {
			mav.setViewName("redirect:/memberLoginForm");
			return mav;
		}
		
		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
		int insertResult = bsvc.boardWrite(loginInfo,bdto);
		if(insertResult >0) {
			mav.setViewName("redirect:/boardList");			
		}else {
			mav.setViewName("redirect:/boardWriteForm");
		}
		
		return mav;
	}
	

}