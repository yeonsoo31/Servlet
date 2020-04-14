package com.icia.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonNode;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.icia.member.api.KakaoJoinApi;
import com.icia.member.api.KakaoLoginApi;
import com.icia.member.api.NaverJoinApi;
import com.icia.member.api.NaverLoginApi;
import com.icia.member.dto.MemberDTO;
import com.icia.member.service.KakaoService;
import com.icia.member.service.MemberService;


@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private KakaoService kakaoService;
	
	@Autowired
	private NaverJoinApi naverJoinApi;
	
	@Autowired
	private NaverLoginApi naverLoginApi;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String Main() {
		return "Main";
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public String SignUp() {
		return "SignUp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String Login() {
		return "Login";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public ModelAndView MemberJoin(@ModelAttribute MemberDTO member) {
		mav = new ModelAndView();
		return mav = memberService.signUp(member);
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute MemberDTO member) {
		mav = new ModelAndView();
		return mav = memberService.memberLogin(member);
	}

	@RequestMapping(value="/memberList", method=RequestMethod.GET)
	public ModelAndView memberList() {
		mav = memberService.memberList();
		return mav;
	}
	
	@RequestMapping(value="/memberView", method=RequestMethod.GET)
	public ModelAndView memberView(@RequestParam("mid") String mid) {
		mav = memberService.memberView(mid);
		return mav;
	}
	
	@RequestMapping(value="/memberDelete", method=RequestMethod.GET)
	public ModelAndView memberDelete(@RequestParam("mid") String mid) {
		mav = memberService.memberDelete(mid);
		return mav;
	}
	
	@RequestMapping(value="/memberModify", method=RequestMethod.GET)
	public ModelAndView modifyView() {
		String mid = (String) session.getAttribute("loginId");
		mav = memberService.modifyView(mid);
		return mav;
	}
	
	@RequestMapping(value="/memberModify", method=RequestMethod.POST)
	public ModelAndView memberModify(@ModelAttribute MemberDTO member) {
		mav = memberService.memberModify(member);
		return mav;
	}
	
	@RequestMapping(value="/memberLogout", method=RequestMethod.GET)
	public String memberLogout() {
		session.invalidate();
		return "Login";
	}
	
	// 아이디 중복체크
	
	@RequestMapping(value="/idOverlap", method=RequestMethod.POST)
	public @ResponseBody String idOverlap(@RequestParam("mid") String mid) {
		System.out.println("ajax로 넘어온 값"+mid);
		String resultMsg = memberService.idOverlap(mid);
		return resultMsg;
	}
	
	//ajax 이용한 상세조회
	
	@RequestMapping(value="/memberViewAjax", method=RequestMethod.POST)
	public @ResponseBody MemberDTO memberViewAjax(@RequestParam("mid") String mid) {
		System.out.println("ajax로 넘어온 값"+mid);
		MemberDTO memberView = memberService.memberViewAjax(mid);
		return memberView;
	}
	// 카카오 서버 로그인
	@RequestMapping(value="/kakaojoin", method=RequestMethod.GET)
	public ModelAndView kakaoJoin(HttpSession session) {
		String kakaoUrl = KakaoJoinApi.getAuthorizationUrl(session);
		mav = new ModelAndView();
		mav.addObject("kakaoUrl", kakaoUrl);
		System.out.println(kakaoUrl);
		mav.setViewName("KakaoLogin");
		return mav;
	}
	
	// 카카오 서버 인증 통과 후 처리
	@RequestMapping(value="/yyskakaoJoinOK")
	public ModelAndView kakaoJoinOK
			(@RequestParam("code") String code, HttpSession session) {
		mav = new ModelAndView();
		JsonNode token = KakaoJoinApi.getAccessToken(code);
		
		JsonNode profile = KakaoJoinApi.getKakaoUserInfo(token.path("access_token"));
		
		System.out.println("profile값 "+profile);
		
		mav = kakaoService.kakaoJoin(profile);
		
		return mav;
	}
	
	// 카카오 로그인
	
	@RequestMapping(value="/kakaologin", method=RequestMethod.GET)
	public ModelAndView kakaoLogin(HttpSession session) {
		String kakaoUrl = KakaoLoginApi.getAuthorizationUrl(session);
		mav = new ModelAndView();
		mav.addObject("kakaoUrl", kakaoUrl);
		System.out.println(kakaoUrl);
		mav.setViewName("KakaoLogin");
		return mav;
	}
	
	//
	
	@RequestMapping(value="/yyskakaoLoginOK")
	public ModelAndView kakaoLoginOK
			(@RequestParam("code") String code, HttpSession session) {
		mav = new ModelAndView();
		JsonNode token = KakaoLoginApi.getAccessToken(code);
		
		JsonNode profile = KakaoLoginApi.getKakaoUserInfo(token.path("access_token"));
		
		System.out.println("profile값 "+profile);
		
		mav = kakaoService.kakaoLogin(profile);
		
		return mav;
	}
	
	@RequestMapping(value="/naverjoin")
	public ModelAndView naverJoin(HttpSession session) {
		String naverUrl = naverJoinApi.getAuthorizationUrl(session);
		mav = new ModelAndView();
		mav.addObject("naverUrl", naverUrl);
		mav.setViewName("NaverLogin");
		return mav;
	}
	
	@RequestMapping(value="/yysnaverJoinOK")
	public ModelAndView naverJoinOK
		(@RequestParam("code") String code, @RequestParam("state") String state, HttpSession session) throws IOException, ParseException {
		mav = new ModelAndView();
		OAuth2AccessToken oauthToken = naverJoinApi.getAccessToken(session, code, state);
		
		String profile = naverJoinApi.getUserProfile(oauthToken);
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(profile);
		
		JSONObject naverUser = (JSONObject) obj;
		JSONObject userInfo = (JSONObject) naverUser.get("response");
		
		String naverId = (String) userInfo.get("id");
		String email = (String) userInfo.get("email");
		String name = (String) userInfo.get("name");
		String gender = (String) userInfo.get("gender");
		String birthday = (String) userInfo.get("birthday");
		mav.addObject("naverId", naverId);
		mav.setViewName("SignUp");
		return mav;
	}
	
	@RequestMapping(value="/naverlogin")
	public ModelAndView naverLogin(HttpSession session) {
		String naverUrl = naverLoginApi.getAuthorizationUrl(session);
		mav = new ModelAndView();
		mav.addObject("naverUrl", naverUrl);
		mav.setViewName("NaverLogin");
		return mav;
	}
	
	@RequestMapping(value="/yysnaverLoginOK")
	public ModelAndView naverLoginOK
		(@RequestParam("code") String code, @RequestParam("state") String state, HttpSession session) throws IOException, ParseException {
		mav = new ModelAndView();
		OAuth2AccessToken oauthToken = naverLoginApi.getAccessToken(session, code, state);
		
		String profile = naverLoginApi.getUserProfile(oauthToken);
		
		mav = memberService.naverLogin(profile);
		
		return mav;
	}
	
}
