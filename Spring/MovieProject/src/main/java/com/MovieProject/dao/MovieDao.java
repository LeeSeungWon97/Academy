package com.MovieProject.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.MovieProject.dto.MovieDto;

public interface MovieDao {

	@Select("SELECT MAX(MVCODE) FROM MOVIES")
	String selectMaxMvcode();

	@Insert("INSERT INTO MOVIES (MVCODE, MVTITLE, MVDIR, MVACT, MVGENRE, MVINFO, MVDATE, MVPOS) VALUES(#{mvcode},#{mvtitle},#{mvdir},#{mvact},#{mvgenre},#{mvinfo},#{mvdate},#{mvpos})")
	int insertMovie(MovieDto movie);

	@Select("SELECT MVTITLE FROM MOVIES WHERE MVTITLE=#{mvtitle}")
	String selectCheckMovie(String mvtitle);

	

}
