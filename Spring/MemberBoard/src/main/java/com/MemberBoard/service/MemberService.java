package com.MemberBoard.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.MemberBoard.dao.MemberDao;
import com.MemberBoard.dto.BoardDto;
import com.MemberBoard.dto.MemberDto;

@Service
public class MemberService {

	@Autowired
	private MemberDao mdao;

	@Autowired
	private ServletContext context;

	// 회원가입 메소드
	public int memberJoin(MemberDto member) throws IllegalStateException, IOException {
		System.out.println("MemberService memberJoin() 호출");
		MultipartFile mfile = member.getMfile();
		String mprofile = "";
		if (mfile.isEmpty()) {
			System.out.println("첨부파일 없음");
		} else {
			System.out.println("첨부파일 있음");
			// uuid: 랜덤 경로
			UUID uuid = UUID.randomUUID();
			mprofile = uuid.toString() + "_" + mfile.getOriginalFilename();

			String savePath = context.getRealPath("resources/memberProfile");

			System.out.println(savePath);
			File file = new File(savePath, mprofile);
			mfile.transferTo(file);
		}
		System.out.println("mprofile: " + mprofile);
		member.setMprofile(mprofile);
		int insertResult = 0;
		try {
			insertResult = mdao.insertMemberJoin(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertResult;
	}

	public String idCheck(String inputId) {
		System.out.println("MemberService idCheck() 호출");
		String idCheck = "OK";
		try {
			String memberId = mdao.selectIdCheck(inputId);
			if (memberId != null) {
				idCheck = "NO";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return idCheck;
	}

	public MemberDto memberLogin(MemberDto member) {
		System.out.println("MemberService memberLogin()");
		MemberDto loginInfo = mdao.selectLoginMember(member);
		return loginInfo;
	}

	public MemberDto memberInfo(String loginId) {
		System.out.println("MemberService memberInfo()");
		MemberDto memberInfo = mdao.selectMemInfo(loginId);
		return memberInfo;
	}

	public ArrayList<BoardDto> memberBoardList(String loginId) {
		System.out.println("MemberService memberBoardList()");
		ArrayList<BoardDto> boList = mdao.selectMemberBoardList(loginId);
		return boList;
	}

}
