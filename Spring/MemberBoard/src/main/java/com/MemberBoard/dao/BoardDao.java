package com.MemberBoard.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.MemberBoard.dto.BoardDto;
import com.MemberBoard.dto.ReplyDto;

public interface BoardDao {

	@Select("SELECT NVL(MAX(BNO),0) FROM BOARDS")
	int selectMaxNum();

	@Select("SELECT NVL(MAX(RENUM),0) FROM REPLYS")
	int selectMaxRenum();

	@Insert("INSERT INTO BOARDS(BNO, BTITLE, BWRITER, BCONTENT, BDATE, BHITS, BFILENAME, BSTATE) VALUES(#{bno}, #{btitle}, #{bwriter}, #{bcontent}, SYSDATE, 0, #{bfilename}, '0')")
	int insertBoardWrite(BoardDto bdto);

	@Select("SELECT * FROM BOARDS")
	ArrayList<BoardDto> selectBoardList();

	@Select("SELECT * FROM BOARDS WHERE BNO = #{viewbno}")
	BoardDto selectBoardView(int viewbno);

	@Update("UPDATE BOARDS SET BHITS = BHITS + 1 WHERE BNO = #{viewbno}")
	void updateBoardHits(int viewbno);

	@Update("UPDATE BOARDS SET BTITLE = #{btitle}, BCONTENT=#{bcontent} WHERE BNO=#{bno}")
	int updateBoardModify(BoardDto modBoard);

	@Insert("INSERT INTO REPLYS(RENUM, REBNO, REWRITER, RECONTENT, REDATE, RESTATE) VALUES(#{renum}, #{rebno}, #{rewriter}, #{recontent}, SYSDATE, '0')")
	int insertReply(ReplyDto reply);

	@Select("SELECT * FROM REPLYS WHERE REBNO = #{rebno} ORDER BY RENUM")
	ArrayList<ReplyDto> selectReplyList(int rebno);

	@Delete("DELETE FROM REPLYS WHERE RENUM = #{renum}")
	int deleteReply(int renum);

	@Select("SELECT LMID FROM BOARDLIKE WHERE LBNO = #{lbno} AND LMID = #{lmid}")
	String selectLikeCheck(@Param("lbno") int lbno, @Param("lmid") String lmid);

	@Insert("INSERT INTO BOARDLIKE(LBNO, LMID, LSTATE) VALUES(#{lbno}, #{lmid}, '0')")
	int insertBoardLike(@Param("lbno") int lbno, @Param("lmid") String lmid);

	@Delete("DELETE FROM BOARDLIKE WHERE LBNO = #{lbno} AND LMID = #{lmid}")
	void deleteBoardLike(@Param("lbno") int lbno, @Param("lmid") String lmid);

	@Select("SELECT COUNT(*) FROM BOARDLIKE WHERE LBNO = #{lbno}")
	int selectLikeCount(int lbno);

	@Select("SELECT COUNT(*) FROM REPLYLIKE WHERE RLNUM = #{renum}")
	int selectReLikeCount(int renum);

	@Select("SELECT RLMID FROM REPLYLIKE WHERE RLNUM = #{renum} AND RLMID = #{remid}")
	String selectReLikeCheck(@Param("renum") int renum, @Param("remid") String remid);

	@Insert("INSERT INTO REPLYLIKE(RLNUM, RLMID) VALUES(#{renum}, #{remid})")
	void insertReplyLike(@Param("renum") int renum, @Param("remid") String remid);

	@Delete("DELETE FROM REPLYLIKE WHERE RLNUM = #{renum} AND RLMID = #{remid} ")
	void deleteReplyLike(@Param("renum") int renum, @Param("remid") String remid);

}
