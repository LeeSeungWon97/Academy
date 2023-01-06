package com.MovieProject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.MovieProject.dto.MovieDto;
import com.MovieProject.dto.TheaterDto;
import com.MovieProject.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService mvsvc;

	@RequestMapping(value = "/movieInfoForm")
	public ModelAndView movieInfoForm(String mvcode) {
		System.out.println("영화정보 페이지 이동 요청");
		System.out.println("mvcode: " + mvcode);
		ModelAndView mav = new ModelAndView();
		MovieDto mvInfo = mvsvc.callMovieInfo(mvcode);
		mav.addObject("mvInfo", mvInfo);
		mav.setViewName("movie/MovieInfoForm");
		return mav;
	}

	@RequestMapping(value = "/mvReservationForm")
	public ModelAndView mvReservationForm() {
		System.out.println("영화예매 페이지 이동 요청");
		ModelAndView mav = new ModelAndView();
		ArrayList<MovieDto> movieList = mvsvc.callMovieList();
		ArrayList<String> age = mvsvc.getMvAge(movieList);
		ArrayList<TheaterDto> theaterList = mvsvc.callTheaterList();
		mav.addObject("movieList", movieList);
		mav.addObject("age", age);
		mav.addObject("theaterList", theaterList);
		mav.setViewName("movie/MovieReservationForm");
		return mav;
	}

	@RequestMapping(value = "/movieSearch")
	public ModelAndView movieSearch(String mvtitle) {
		System.out.println("영화 검색 요청");
		System.out.println(mvtitle);
		ModelAndView mav = new ModelAndView();
		ArrayList<MovieDto> searchTitle = mvsvc.callSearchTitle(mvtitle);
		mav.addObject("movieList", searchTitle);
		mav.setViewName("Main");
		return mav;
	}

	@RequestMapping(value = "/callTheater")
	public @ResponseBody ArrayList<String> callTheater(String mvcode) {
		System.out.println("상영극장 검색 요청");
		ArrayList<String> theaterName = mvsvc.callTheaterName(mvcode);
		return theaterName;
	}
}
