package com.MovieProject.service;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieProject.dao.MovieDao;
import com.MovieProject.dto.MovieDto;
import com.MovieProject.dto.TheaterDto;

@Service
public class MovieService {

	@Autowired
	private MovieDao mvdao;

	public int addMovieList() throws IOException {

		int insertResult = 0;

		// 1.CGV 영화 페이지 URL
		String cgvurl = "http://www.cgv.co.kr/movies/?lt=1&ft=0";

		// 2. Jsoup URL 접속
		Document doc = Jsoup.connect(cgvurl).get();

		// 3. 무비차트 출력 DIV 선택
		Elements chartDiv = doc.select("#contents > div.wrap-movie-chart > div.sect-movie-chart");

		// 4. div의 li태그 선택
		Elements movieList = chartDiv.select("li");

		for (int i = 0; i < movieList.size(); i++) {
			// 5. 영화의 상세페이지 URL 추출
			String detailUrl = "http://www.cgv.co.kr" + movieList.eq(i).select("div.box-image > a").attr("href");
			System.out.println("상세주소: " + detailUrl);
			// 6. 상세페이지로 다시 접속
			Document detailDoc = Jsoup.connect(detailUrl).get();
			Elements baseMovie = detailDoc.select("#select_main > div.sect-base-movie");

			// 7. 영화 상세정보 데이터 추출
			Elements contents = baseMovie.select("div.box-contents");

			// 제목
			String mvtitle = contents.select("div.title > strong").text();
			System.out.println("영화제목: " + mvtitle);

			// 영화 중복 체크
			String movieCheck = mvdao.selectCheckMovie(mvtitle);
			if (movieCheck != null) {
				continue;
			}

			// 감독
			String mvdir = contents.select("div.spec > dl > dd:nth-child(2) > a").text();
			System.out.println("영화감독: " + mvdir);

			// 배우
			String mvact = contents.select("div.spec > dl > dd.on").eq(0).text().replace(" , ", ",");
			System.out.println("영화배우: " + mvact);

			// 장르
			String mvgenre = contents.select("div.spec > dl > dd.on").eq(0).next().text().replace("장르 : ", "")
					.replace(", ", "");
			System.out.println("장르: " + mvgenre);

			// 기본정보
			String mvinfo = contents.select("div.spec > dl > dd.on").eq(1).text().replace(" ", "");
			System.out.println("기본정보: " + mvinfo);

			// 개봉일
			String mvdate = contents.select("div.spec > dl > dd.on").eq(2).text().replace("(재개봉)", "");
			System.out.println("개봉일: " + mvdate);

			// 이미지URL
			Elements image = baseMovie.select("div.box-image > a > span > img");
			String mvpos = image.select("img").attr("src");
			System.out.println("영화포스터: " + mvpos);

			// 영화 코드 생성 "MV001", "MV002"...
			String maxMvcode = mvdao.selectMaxMvcode();
			String mvcode = "MV";
			if (maxMvcode == null) {
				mvcode = "MV001";
			} else {
				int mvcodeNum = Integer.parseInt(maxMvcode.replace("MV", ""));
				mvcode = mvcode + String.format("%03d", mvcodeNum + 1);
			}
			System.out.println("영화코드: " + mvcode);

			// dto에 영화 정보 저장
			MovieDto movie = new MovieDto();
			movie.setMvcode(mvcode);
			movie.setMvtitle(mvtitle);
			movie.setMvdir(mvdir);
			movie.setMvact(mvact);
			movie.setMvgenre(mvgenre);
			movie.setMvinfo(mvinfo);
			movie.setMvdate(mvdate);
			movie.setMvpos(mvpos);

			insertResult += mvdao.insertMovie(movie);
		}
		return insertResult;
	}

	public ArrayList<MovieDto> callMovieList() {
		System.out.println("MovieService callMovieList() 호출");
		ArrayList<MovieDto> movieList = mvdao.selectMovieList();
		return movieList;
	}

	public MovieDto callMovieInfo(String mvcode) {
		System.out.println("MovieService callMovieInfo() 호출");
		MovieDto mvInfo = mvdao.selectMovieInfo(mvcode);
		return mvInfo;
	}

	public ArrayList<MovieDto> callSearchTitle(String mvtitle) {
		System.out.println("MovieService callSearchList() 호출");
		ArrayList<MovieDto> searchTitleList = mvdao.selectSearchTitle(mvtitle);
		return searchTitleList;
	}

	public ArrayList<String> getMvAge(ArrayList<MovieDto> movieList) {
		System.out.println("MovieService getMvAge() 호출");
		ArrayList<String> mvAge = new ArrayList<String>();
		for (int i = 0; i < movieList.size(); i++) {
			String info = movieList.get(i).getMvinfo();
			String[] totalInfo = info.split(",");
			String age = totalInfo[0];
			mvAge.add(age);
		}
		return mvAge;
	}

	public ArrayList<TheaterDto> callTheaterList() {
		System.out.println("MovieService callTheaterList() 호출");
		ArrayList<TheaterDto> thList = mvdao.selectTheaterList();
		return thList;
	}

	public ArrayList<String> callTheaterName(String mvcode) {
		System.out.println("MovieService callTheaterName() 호출");
		ArrayList<String> thName = mvdao.selectTheaterName(mvcode);
		return thName;
	}
}
