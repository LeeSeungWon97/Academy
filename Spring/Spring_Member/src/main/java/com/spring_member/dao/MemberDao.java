package com.spring_member.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spring_member.dto.MemberDto;

public interface MemberDao {

	// #호출 시: 'test01'
	// $호출 시: test01
	@Insert("INSERT INTO MEMBERS(MID, MPW, MNAME, MBIRTH) VALUES(#{mid},#{mpw},#{mname},TO_DATE(#{mbirth},'YYYY-MM-DD'))")
	public int insertJoinMember(MemberDto member); // 

	
	// 데이터를 낱개로 여러개 보낼 경우
	@Insert("INSERT INTO MEMBERS(MID, MPW, MNAME, MBIRTH) VALUES(#{mid},#{mpw},#{mname},TO_DATE(#{mbirth},'YYYY-MM-DD'))")
	public int insertJoinMember2(@Param("mid") String mid, @Param("mpw") String mpw);

	
	@Select("SELECT * FROM MEMBERS")
	public ArrayList<MemberDto> selectMemberList();
}
