package com.MemberBoard.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.MemberBoard.dto.BoardDto;
import com.MemberBoard.dto.MemberDto;

public interface MemberDao {

	@Insert("INSERT INTO MEMBERS(MID, MPW, MNAME, MBIRTH, MADDR, MEMAIL, MPROFILE, MSTATE) VALUES(#{mid},#{mpw},#{mname},TO_DATE(#{mbirth},'YYYY-MM-DD'),#{maddr},#{memail},#{mprofile},'0')")
	public int insertMemberJoin(MemberDto member);

	@Select("SELECT MID FROM MEMBERS WHERE MID = #{inputId}")
	public String selectIdCheck(String inputId);

	@Select("SELECT * FROM MEMBERS WHERE MID = #{mid} AND MPW = #{mpw}")
	public MemberDto selectLoginMember(MemberDto member);

	@Select("SELECT * FROM MEMBERS WHERE MID = #{loginId}")
	public MemberDto selectMemInfo(String loginId);

	@Select("SELECT * FROM BOARDS WHERE BWRITER = #{loginId}")
	public ArrayList<BoardDto> selectMemberBoardList(String loginId);

}
