package com.MemberBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.MemberBoard.dto.BoardDto;
import com.MemberBoard.dto.MemberDto;
import com.MemberBoard.dto.ReplyDto;
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
		ArrayList<BoardDto> boardList = bsvc.callBoardList();
		// 2. 글목록페이지 지정
		mav.addObject("boardList", boardList);
		mav.setViewName("board/BoardList");

		return mav;
	}

	@RequestMapping(value = "/boardWriteForm")
	public ModelAndView boardWriteForm() {
		System.out.println("글작성 페이지 이동요청");
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("loginInfo") != null) {
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

		if (session.getAttribute("loginInfo") == null) {
			mav.setViewName("redirect:/memberLoginForm");
			return mav;
		}

		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
		int insertResult = bsvc.boardWrite(loginInfo, bdto);
		if (insertResult > 0) {
			mav.setViewName("redirect:/boardList");
		} else {
			mav.setViewName("redirect:/boardWriteForm");
		}

		return mav;
	}

	@RequestMapping(value = "/boardView")
	public ModelAndView boardView(int viewbno) {
		System.out.println(viewbno);
		ModelAndView mav = new ModelAndView();

		BoardDto boardView = bsvc.boardView(viewbno);
		mav.addObject("boardView", boardView);

		int blikeCount = bsvc.boardLikeCount(viewbno);
		mav.addObject("blikeCount", blikeCount);

		mav.setViewName("board/BoardView");
		return mav;
	}

	@RequestMapping(value = "/boardModify")
	public ModelAndView boardmodify(BoardDto modBoard) {
		System.out.println("글수정 요청");
		ModelAndView mav = new ModelAndView();
		System.out.println(modBoard);
		int modifyResult = bsvc.boardModify(modBoard);
		if (modifyResult > 0) {
			System.out.println("수정성공");
		} else {
			System.out.println("수정실패");
		}
		mav.setViewName("redirect:/boardView?viewbno=" + modBoard.getBno());
		return mav;
	}

	@RequestMapping(value = "/replyWriter")
	public @ResponseBody String replyWrite(ReplyDto reply) {
		System.out.println("댓글 등록 요청");
		System.out.println(reply);
		String result = "";
		int insertResult = bsvc.replyWrite(reply);
		if (insertResult > 0) {
			result = "OK";
		} else {
			result = "NO";
		}
		return result;
	}

	@RequestMapping(value = "/replyList")
	public @ResponseBody String replyList(int rebno) {
		System.out.println("댓글 목록 조회 요청");
		System.out.println("댓글을 조회할 글번호: " + rebno);
		String replyList = bsvc.replyList(rebno);
		return replyList;
	}

	@RequestMapping(value = "/replyDelete")
	public @ResponseBody String replyDelete(int renum) {
		System.out.println("댓글 삭제 요청");
		System.out.println("요청할 댓글 번호: " + renum);
		int deleteResult = bsvc.deleteReply(renum);
		String result = "NO";
		if (deleteResult > 0) {
			System.out.println("삭제성공");
			result = "OK";
		} else {
			System.out.println("삭제실패");
		}
		return result;
	}

	@RequestMapping(value = "/boardLike")
	public @ResponseBody String boardLike(int lbno, String lmid) {
		System.out.println("게시글 추천 처리 요청");
		System.out.println("추천할 글번호 : " + lbno);
		System.out.println("추천자 아이디 : " + lmid);

		String result = bsvc.boardLike(lbno, lmid);

		return result;
	}

	@RequestMapping(value = "/boardLikeCount_ajax")
	public @ResponseBody String boardLikeCount_ajax(int lbno, String lmid) {
		System.out.println("게시글 추천수 조회 요청");

		String likeInfo = bsvc.boardLikeInfo(lbno, lmid);

		return likeInfo;
	}
	
	@RequestMapping(value = "/replyLike")
	public @ResponseBody String replyLike(int renum, String remid) {
		System.out.println("댓글 추천 요청");
		String reLikeInfo = bsvc.replyLikeInfo(renum, remid);
		
		return reLikeInfo;
	}

}