package com.MemberBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MemberBoard.dao.MemberDao;
import com.MemberBoard.dto.MemberDto;

@Service
public class MemberService {

	@Autowired
	private MemberDao mdao;
	
	// 회원가입 메소드
	public int memberJoin(MemberDto member) {
		System.out.println("MemberService memberJoin() 호출");
		member.setMprofile(member.getMfile().getOriginalFilename());
		System.out.println("mprofile: "+ member.getMprofile());
		int insertResult = 0;
		try {
//			insertResult = mdao.insertMemberJoin(member);			
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
			if(memberId != null) {
				idCheck = "NO";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return idCheck;
	}

}
