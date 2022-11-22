package com.MemberBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@RequestMapping(value = "/boardList")
	public ModelAndView boardList() {
		System.out.println("전체글목록 페이지 이동 요청");
		ModelAndView mav = new ModelAndView();
		// 1. 글목록 조회

		// 2. 글목록페이지 지정
		mav.setViewName("board/BoardList");

		return mav;
	}

}