package com.spring_member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_member.dao.MemberDao;
import com.spring_member.dto.MemberDto;

@Service
public class MemberService {

	@Autowired
	private MemberDao mdao;

	public int memberJoin(MemberDto member) {
		System.out.println("MemberService memberJoin()");
		System.out.println("회원가입 기능 호출");
		int insertResult = 0;
		try {
			insertResult = mdao.insertJoinMember(member);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("insertResult: " + insertResult);
		return insertResult;
	}

	
	public ArrayList<MemberDto> memberList() {
		System.out.println("MemberService memberList()");
		System.out.println("회원목록 조회 기능 호출");
		ArrayList<MemberDto> memberList = mdao.selectMemberList();
		System.out.println(memberList);
		return memberList;
	}

}
