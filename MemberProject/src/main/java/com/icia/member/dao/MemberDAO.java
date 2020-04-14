package com.icia.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int signUp(MemberDTO member) {
		if(member.getKakaoId() != null) {
			return sql.insert("Member.kakaoMemberJoin", member);
		} else if(member.getNaverId() != null) {
			return sql.insert("Member.naverMemberJoin", member);
		} else {
		return sql.insert("Member.signUp", member);
		}
	}

	public String memberLogin(MemberDTO member) {
		return sql.selectOne("Member.memberLogin", member);
	}

	public List<MemberDTO> memberList() {
		return sql.selectList("Member.memberList");
	}

	public MemberDTO memberView(String mid) {
		return sql.selectOne("Member.memberView", mid);
	}

	public int memberDelete(String mid) {
		return sql.delete("Member.memberDelete", mid);
	}

	public MemberDTO memberModify(String mid) {
		return sql.selectOne("Member.memberModify", mid);
	}

	public int memberModify(MemberDTO member) {
		return sql.update("Member.memberModify", member);
	}

	public String idOverlap(String mid) {
		return sql.selectOne("Member.idOverlap", mid);
	}

	public MemberDTO kakaoLogin(String kakaoId) {
		return sql.selectOne("Member.kakaoLogin", kakaoId);
	}

	public MemberDTO naverLogin(String naverId) {
		return sql.selectOne("Member.naverLogin", naverId);
	}



	
	
	
}
