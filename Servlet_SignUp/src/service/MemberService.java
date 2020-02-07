package service;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DAO;
import dto.MemberDTO;

public class MemberService {
	
	public boolean memberJoin(MemberDTO member) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.signUpDB(member);
		boolean signUpResult = false;
		if(result > 0) {
			commit(con);
			signUpResult = true;
		} else {
			rollback(con);
			signUpResult = false;
		}
		return signUpResult;
	}

	public boolean memberLogin(MemberDTO member) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int loginResult = dao.loginDB(member);
		if(loginResult > 0) {
			return true;
		} else {
			return false;
		}
	}
}
