package com.MemberBoard.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.MemberBoard.dto.BoardDto;

public interface BoardDao {

	@Select("SELECT NVL(MAX(BNO),0) FROM BOARDS")
	int selectMaxNum();

	@Insert("INSERT INTO BOARDS(BNO, BTITLE, BWRITER, BCONTENT, BDATE, BHITS, BFILENAME, BSTATE) VALUES(#{bno}, #{btitle}, #{bwriter}, #{bcontent}, SYSDATE, 0, #{bfilename}, '0')")
	int insertBoardWrite(BoardDto bdto);

}
