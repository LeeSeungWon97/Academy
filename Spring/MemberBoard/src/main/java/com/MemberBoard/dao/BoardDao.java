package com.MemberBoard.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.MemberBoard.dto.BoardDto;

public interface BoardDao {

	@Select("SELECT NVL(MAX(BNO),0) FROM BOARDS")
	int selectMaxNum();

	@Insert("INSERT INTO BOARDS(BNO, BTITLE, BWRITER, BCONTENT, BDATE, BHITS, BFILENAME, BSTATE) VALUES(#{bno}, #{btitle}, #{bwriter}, #{bcontent}, SYSDATE, 0, #{bfilename}, '0')")
	int insertBoardWrite(BoardDto bdto);

	@Select("SELECT * FROM BOARDS")
	ArrayList<BoardDto> selectBoardList();

	@Select("SELECT * FROM BOARDS WHERE BNO = #{viewbno}")
	BoardDto selectBoardView(int viewbno);

	@Update("UPDATE BOARDS SET BHITS = BHITS + 1 WHERE BNO = #{viewbno}")
	void updateBoardHits(int viewbno);

}
