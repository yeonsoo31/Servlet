package com.icia.oauth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.icia.oauth.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav;
	
	@RequestMapping(value="/")
	public String Main() {
		return "OauthMain";
	}
	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String LoginForm() {
		return "LoginForm";
	}
	
	@RequestMapping(value="/signUpForm")
	public ModelAndView SignUpForm(@RequestParam("Gid") String Gid){
		mav = new ModelAndView();
		mav.addObject("Gid", Gid);
		mav.setViewName("SignUpForm");
		return mav;
	}
	
	@RequestMapping(value="/signUpForm2")
	public ModelAndView SignUpForm2(@RequestParam("Fid") String Fid){
		mav = new ModelAndView();
		mav.addObject("Fid", Fid);
		mav.setViewName("SignUpForm");
		return mav;
	}
	
}
