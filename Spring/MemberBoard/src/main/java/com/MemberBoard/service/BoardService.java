package com.MemberBoard.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.MemberBoard.dao.BoardDao;
import com.MemberBoard.dto.BoardDto;
import com.MemberBoard.dto.MemberDto;
import com.MemberBoard.dto.ReplyDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
public class BoardService {

	@Autowired
	private BoardDao bdao;

	@Autowired
	private ServletContext context;

	public int boardWrite(MemberDto mdto, BoardDto bdto) throws IllegalStateException, IOException {
		System.out.println("BoardService boardWrite()");
		MultipartFile bfile = bdto.getBfile();
		String bfilename = "";
		if (bfile.isEmpty()) {
			System.out.println("첨부파일X");
		} else {
			System.out.println("첨부파일O");
			UUID uuid = UUID.randomUUID();

			bfilename = uuid + "_" + bfile.getOriginalFilename();

			String savePath = context.getRealPath("resources/boardUpload");

			File file = new File(savePath, bfilename);
			bfile.transferTo(file);
		}
		bdto.setBfilename(bfilename);

		int bMaxNum = bdao.selectMaxNum() + 1;
		bdto.setBno(bMaxNum);
		bdto.setBwriter(mdto.getMid());
		System.out.println(bdto);
		int insertResult = bdao.insertBoardWrite(bdto);
		if (insertResult > 0) {
			System.out.println("글등록 성공");
		} else {
			System.out.println("글등록 실패");
		}
		return insertResult;
	}

	public ArrayList<BoardDto> callBoardList() {
		System.out.println("BoardService callBoardList()");
		ArrayList<BoardDto> boardList = bdao.selectBoardList();
		return boardList;
	}

	public BoardDto boardView(int viewbno) {
		System.out.println("BoardService boardView()");

		bdao.updateBoardHits(viewbno);
		BoardDto boardView = bdao.selectBoardView(viewbno);
		return boardView;
	}

	public int boardModify(BoardDto modBoard) {
		System.out.println("BoardService boardModify()");
		int updateResult = 0;
		try {
			updateResult = bdao.updateBoardModify(modBoard);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateResult;
	}

	public int replyWrite(ReplyDto reply) {
		System.out.println("BoardService replyWrite()");
		int renum = bdao.selectMaxRenum() + 1;
		reply.setRenum(renum);

		int insertResult = 0;
		try {
			insertResult = bdao.insertReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertResult;
	}

	public String replyList(int rebno) {
		System.out.println("BoardService replyList()");
		ArrayList<ReplyDto> reList = bdao.selectReplyList(rebno);
		System.out.println(reList);
		for (int i = 0; i < reList.size(); i++) {
			int renum = reList.get(i).getRenum();
			int reLikeCount = bdao.selectReLikeCount(renum);
			reList.get(i).setRelikecount(reLikeCount);
		}
		Gson gson = new Gson();
		String reList_json = gson.toJson(reList);
		System.out.println(reList_json);
		return reList_json;
	}

	public int deleteReply(int renum) {
		System.out.println("BOardService deleteReply()");
		int deleteResult = bdao.deleteReply(renum);
		return deleteResult;
	}

	public String boardLike(int lbno, String lmid) {
		System.out.println("BoardService boardLike()");
		Gson gson = new Gson();
		JsonObject boardLike_json = new JsonObject();

		// 1. 추천유무 확인
		String likeMid = bdao.selectLikeCheck(lbno, lmid);

		if (likeMid == null) {
			System.out.println("추천 입력");
			bdao.insertBoardLike(lbno, lmid);
			boardLike_json.addProperty("likeResult", "1");
		} else {
			System.out.println("추천 취소");
			bdao.deleteBoardLike(lbno, lmid);
			boardLike_json.addProperty("likeResult", "-1");
		}

		// 2. 추천 처리 이후 추천수 조회
		int likeCount = bdao.selectLikeCount(lbno);
		boardLike_json.addProperty("likeCount", likeCount);

		System.out.println(gson.toJson(boardLike_json));
		return gson.toJson(boardLike_json);

	}

	public int boardLikeCount(int viewBno) {
		System.out.println("BoardService boardLike()");
		int likeCount = bdao.selectLikeCount(viewBno);
		return likeCount;
	}

	public String boardLikeInfo(int lbno, String lmid) {
		System.out.println("BoardService boardLikeInfo()");
		int likeCount = bdao.selectLikeCount(lbno);
		String likeMid = bdao.selectLikeCheck(lbno, lmid);
		Gson gson = new Gson();
		JsonObject likeInfo_json = new JsonObject();
		likeInfo_json.addProperty("likeCount", likeCount);
		likeInfo_json.addProperty("likeCheck", likeMid);

		return gson.toJson(likeInfo_json);
	}

	public String replyLike(int renum, String remid) {
		System.out.println("BoardService replyLikeInfo() ");
		Gson gson = new Gson();
		JsonObject reLikeInfo_json = new JsonObject();
		String reLikeCheck = bdao.selectReLikeCheck(renum, remid);
		
		if(reLikeCheck == null) {
			System.out.println("추천 입력");
			bdao.insertReplyLike(renum,remid);
			reLikeInfo_json.addProperty("reLikeResult", "1");
		} else {
			System.out.println("추천 취소");
			bdao.deleteReplyLike(renum,remid);
			reLikeInfo_json.addProperty("reLikeResult", "-1");
		}
		
		int reLikeCount = bdao.selectReLikeCount(renum);
		reLikeInfo_json.addProperty("reLikeCount", reLikeCount);
		
		
		return gson.toJson(reLikeInfo_json);
	}

}
