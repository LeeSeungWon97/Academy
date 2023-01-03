package com.MovieProject.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.MovieProject.dto.MovieDto;
import com.MovieProject.service.MovieService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private MovieService mvsvc;
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		System.out.println("MainPage 요청");
//		
//		return "Main";
//	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		System.out.println("MainPage 요청");
		ModelAndView mav = new ModelAndView();
		ArrayList<MovieDto> movieList = mvsvc.callMovieList();
		mav.addObject("movieList", movieList);
		mav.setViewName("Main");
		return mav;
	}


	@RequestMapping(value = "/addMovieList")
	public String addMovieList() throws IOException {
		System.out.println("/addMovieList 요청");
		int insertResult = mvsvc.addMovieList();
		System.out.println("insertResult: " + insertResult);
		return null;
	}

}
