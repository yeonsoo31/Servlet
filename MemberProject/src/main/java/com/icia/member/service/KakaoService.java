package com.icia.member.service;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class KakaoService {
	private ModelAndView mav;
	
	@Autowired
	private MemberDAO mdao;
	
	@Autowired
	private HttpSession session;
	
	public ModelAndView kakaoJoin(JsonNode profile) {
		mav = new ModelAndView();
		// profile에 담긴 정보 가져오기
		String kakaoId = profile.get("id").asText();
		System.out.println(kakaoId);
		mav.addObject("kakaoId", kakaoId);
		mav.setViewName("SignUp");
		
		return mav;
	}


	public ModelAndView kakaoLogin(JsonNode profile) {
		mav = new ModelAndView();
		String kakaoId = profile.get("id").asText();
		
		JsonNode kakaoAccount = profile.get("kakao_account");
		JsonNode kakaoProfile = kakaoAccount.get("profile");
		
		String nickName = kakaoProfile.path("nickname").asText();
		String email = kakaoProfile.path("email").asText();
		String thumbnail = kakaoProfile.path("thumbnail_image_url").asText();
		
		MemberDTO member = mdao.kakaoLogin(kakaoId);
		
		session.setAttribute("loginId", member.getMid());
		mav.addObject("kakaoId", kakaoId);
		mav.addObject("loginMember", member);
		mav.addObject("email", email);
		mav.addObject("nickName", nickName);
		mav.addObject("kakaoProfile", kakaoProfile);
		mav.addObject("thumbnail", thumbnail);
		mav.setViewName("MemberMain");
		
		return mav;
	}

}
