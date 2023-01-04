package com.MovieProject.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.MovieProject.dto.MemberDto;

public interface MemberDao {

	@Insert("INSERT INTO MEMBERS(MID, MPW, MNAME, MBIRTH, MADDR, MEMAIL, MPROFILE, MSTATE) VALUES(#{mid},#{mpw},#{mname},TO_DATE(#{mbirth},'YYYY-MM-DD'),#{maddr},#{memail},#{mprofile},'0')")
	public int insertMemberJoin(MemberDto joinInfo);

	@Select("SELECT * FROM MEMBERS WHERE MID = #{mid} AND MPW = #{mpw}")
	public MemberDto selectLogin(MemberDto loginId);

	@Select("SELECT MID FROM MEMBERS WHERE MID = #{inputId}")
	public String selectIdCheck(String inputId);

}
