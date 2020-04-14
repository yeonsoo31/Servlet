package com.icia.member.dto;

public class MemberDTO {

	private String mid;
	private String mpassword;
	private String mname;
	private String mbirth;
	private String mgender;
	private String memail;
	
	private String kakaoId;
	private String naverId;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getKakaoId() {
		return kakaoId;
	}
	public void setKakaoId(String kakaoId) {
		this.kakaoId = kakaoId;
	}
	public String getNaverId() {
		return naverId;
	}
	public void setNaverId(String naverId) {
		this.naverId = naverId;
	}
	
}
