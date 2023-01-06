package com.MovieProject.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.MovieProject.dto.MovieDto;
import com.MovieProject.dto.TheaterDto;

public interface MovieDao {

	@Select("SELECT MAX(MVCODE) FROM MOVIES")
	String selectMaxMvcode();

	@Insert("INSERT INTO MOVIES (MVCODE, MVTITLE, MVDIR, MVACT, MVGENRE, MVINFO, MVDATE, MVPOS) VALUES(#{mvcode},#{mvtitle},#{mvdir},#{mvact},#{mvgenre},#{mvinfo},#{mvdate},#{mvpos})")
	int insertMovie(MovieDto movie);

	@Select("SELECT MVTITLE FROM MOVIES WHERE MVTITLE=#{mvtitle}")
	String selectCheckMovie(String mvtitle);

	@Select("SELECT * FROM MOVIES")
	ArrayList<MovieDto> selectMovieList();

	@Select("SELECT * FROM MOVIES WHERE MVCODE = #{mvcode}")
	MovieDto selectMovieInfo(String mvcode);

	@Select("SELECT * FROM MOVIES WHERE MVTITLE LIKE '%'||#{mvtitle}||'%'")
	ArrayList<MovieDto> selectSearchTitle(String mvtitle);

	@Select("SELECT * FROM THEATERS")
	ArrayList<TheaterDto> selectTheaterList();

	@Select("SELECT THNAME FROM THEATERS WHERE THCODE IN (SELECT SCTHCODE FROM SCHEDULES WHERE SCMVCODE = #{mvcode})")
	ArrayList<String> selectTheaterName(String mvcode);

	@Select("SELECT THCODE FROM THEATERS WHERE THNAME = #{thname}")
	String selectSearchThcode(String thname);

	@Select("SELECT TO_CHAR(SCDATE,'YYYY-MM-DD') FROM SCHEDULES WHERE SCMVCODE = #{mvcode} AND SCTHCODE = (SELECT THCODE FROM THEATERS WHERE THNAME = #{thname}) GROUP BY TO_CHAR(SCDATE,'YYYY-MM-DD') ORDER BY TO_CHAR(SCDATE,'YYYY-MM-DD') ASC")
	ArrayList<String> selectMovieDate(@Param("mvcode") String mvcode, @Param("thname") String thname);

}
