package com.MemberBoard.dao;

import org.apache.ibatis.annotations.Insert;

import com.MemberBoard.dto.MemberDto;

public interface MemberDao {

	@Insert("INSERT INTO MEMBERS(MID, MPW, MNAME, MBIRTH, MADDR, MEMAIL, MPROFILE, MSTATE) VALUES(#{mid},#{mpw},#{mname},TO_DATE(#{mbirth},'YYYY-MM-DD'),#{maddr},#{memail},#{mfile},'0')")
	public int insertMemberJoin(MemberDto member);

}
