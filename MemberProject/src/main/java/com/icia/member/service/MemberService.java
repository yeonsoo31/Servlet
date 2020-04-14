package com.icia.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mdao;
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav;
	
	public ModelAndView signUp(MemberDTO member) {
		mav = new ModelAndView();
		int signUpResult = mdao.signUp(member);
		if(signUpResult > 0) {
			mav.setViewName("Login");
		} else {
			mav.setViewName("SignUpFail");
		}
		return mav;
	}

	public ModelAndView memberLogin(MemberDTO member) {
		mav = new ModelAndView();
		String loginId = mdao.memberLogin(member);
		if(loginId != null) {
			session.setAttribute("loginId", loginId);
			mav.setViewName("MemberMain");
		} else {
			mav.setViewName("LoginFail");
		}
		return mav;
	}

	public ModelAndView memberList() {
		mav = new ModelAndView();
		List<MemberDTO> memberList = mdao.memberList();
		mav.addObject("memberList", memberList);
		mav.setViewName("MemberList");
		return mav;
	}

	public ModelAndView memberView(String mid) {
		mav = new ModelAndView();
		MemberDTO memberView = mdao.memberView(mid);
		mav.addObject("memberView", memberView);
		mav.setViewName("MemberView");
		return mav;
	}

	public ModelAndView memberDelete(String mid) {
		mav = new ModelAndView();
		int memberDeleteResult = mdao.memberDelete(mid);
		if(memberDeleteResult > 0) {
			mav.setViewName("redirect:/memberList");
		} else {
			mav.setViewName("MemberDeleteFail");
		}
		return mav;
	}

	public ModelAndView modifyView(String mid) {
		mav = new ModelAndView();
		MemberDTO modifyView = mdao.memberView(mid);
		if(modifyView != null) {
			mav.addObject("modifyView", modifyView);
			mav.setViewName("MemberModify");
		} else {
			mav.setViewName("ModifyViewFail");
		}
		return mav;
	}

	public ModelAndView memberModify(MemberDTO member) {
		mav = new ModelAndView();
		int modifyResult = mdao.memberModify(member);
		if(modifyResult > 0) {
			mav.setViewName("MemberMain");
		} else {
			mav.setViewName("ModifyFail");
		}
		return mav;
	}

	public String idOverlap(String mid) {
		String checkResult = mdao.idOverlap(mid);
		String resultMsg = null;
		if(checkResult==null) {
			resultMsg = "OK";
		} else {
			resultMsg = "NO";
		}
		return resultMsg;
	}

	public MemberDTO memberViewAjax(String mid) {
		MemberDTO memberView = mdao.memberView(mid);
		return memberView;
	}

	public ModelAndView naverLogin(String profile) throws ParseException {
		mav = new ModelAndView();
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(profile);
		
		JSONObject naverUser = (JSONObject) obj;
		JSONObject userInfo = (JSONObject) naverUser.get("response");
		
		String naverId = (String) userInfo.get("id");
//		String email = (String) userInfo.get("email");
//		String name = (String) userInfo.get("name");
//		String gender = (String) userInfo.get("gender");
//		String birthday = (String) userInfo.get("birthday");
		MemberDTO naverMember = mdao.naverLogin(naverId);
		
		session.setAttribute("loginId", naverMember.getMid());
		mav.addObject("naverId", naverId);
		mav.setViewName("MemberMain");
		
		return mav;
	}

	

	

	
}
