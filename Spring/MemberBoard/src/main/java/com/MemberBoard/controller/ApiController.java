package com.MemberBoard.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MemberBoard.dto.BusTagoDto;
import com.MemberBoard.service.ApiService;

@Controller
public class ApiController {
	@Autowired
	private ApiService apisvc;
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/kakaoLoginTest")
	public ModelAndView kakaoLoginTest(String code, RedirectAttributes ra) throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.print("[코드]: ");
		System.out.println(code);

		String kakaoAccessToken = apisvc.getAccessToken(code);
		System.out.print("[kakaoAccessToken]: ");
		System.out.println(kakaoAccessToken);

		ra.addFlashAttribute("kakaoAccessToken", kakaoAccessToken);
		mav.setViewName("redirect:/memberLoginForm");

		return mav;
	}

	@RequestMapping(value = "/memberLogin_kakao")
	public @ResponseBody String memberLogin_kakao(String token) throws Exception {
		System.out.println("memberLogin_kakao 요청");
		System.out.println("accessToken: " + token);
		String kakaoUserInfo_json = apisvc.memberLogin_kakao(token, session);
		return kakaoUserInfo_json;
	}

	@RequestMapping(value = "/memberJoin_kakao")
	public @ResponseBody String memberJoin_kakao(String kakaoId, String kakaoNickName, String kakaoProfile,
			String kakaoEmail) {
		System.out.println("memberJoin_kakao 요청");
		System.out.println("kakaoId : " + kakaoId);
		System.out.println("kakaoNickName : " + kakaoNickName);
		System.out.println("kakaoProfile : " + kakaoProfile);
		System.out.println("kakaoEmail : " + kakaoEmail);
		String kakaoJoinResult = apisvc.memberJoin_kakao(kakaoId, kakaoNickName, kakaoProfile, kakaoEmail);
		return kakaoJoinResult;
	}

	@RequestMapping(value = "/kakaoPay_test")
	public ModelAndView kakaoPay_test() {
		System.out.println("카카오페이 페이지 요청");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("KakaoPay_test");
		return mav;

	}

	@RequestMapping(value = "/kakaoPay_ready")
	public ModelAndView kakaoPay_ready(String prcode, String prname, int prprice, int prcount) throws Exception {
		System.out.println("kakaoPay_ready 요청");
		ModelAndView mav = new ModelAndView();
		String nextPcUrl = apisvc.kakaoPay_ready(prcode, prname, prprice, prcount);
		mav.setViewName("redirect:"+nextPcUrl);
		return mav;
	}
	
	@RequestMapping(value = "/kakaoPay_approval")
	public ModelAndView kakaoPay_approval(String pg_token) throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.println("_approval");
		System.out.println("pg_token : " + pg_token);
		String tid = (String) session.getAttribute("payTid");
		System.out.println("tid: " + tid);
		
		String payResString = apisvc.kakaoPay_approval(tid,pg_token);
		System.out.println(payResString);
		mav.setViewName("redirect:/kakaoPay_test");
		return mav;
	}
	
	@RequestMapping(value = "/kakaoPay_cancel")
	public ModelAndView kakaoPay_cancle() {
		System.out.println("kakaoPay_cancle");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/kakaoPay_test");
		return mav;
	}

	@RequestMapping(value = "/kakaoPay_fail")
	public ModelAndView kakaoPay_fail() {
		System.out.println("kakaoPay_fail");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/kakaoPay_test");
		return mav;
	}
	
	@RequestMapping(value = "/tago_test")
	public ModelAndView tago_test() throws Exception {
		System.out.println("tago_test 페이지 이동 요청");
		ModelAndView mav = new ModelAndView();
		String cityCode = "23";
		String nodeId = "ICB163000060";
		String arrInfoList= apisvc.getBusArrInfoList(cityCode, nodeId);
		mav.setViewName("Tago_test");
		return mav;
	}
}
