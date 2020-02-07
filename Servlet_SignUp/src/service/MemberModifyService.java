package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.DAO;


public class MemberModifyService {

	public boolean memberModify(String id, String password, String email) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		boolean memberModify = false; 
		
		int memberModifyResult = dao.memberModify(id, password, email);
		if(memberModifyResult > 0) {
			memberModify = true;
			commit(con);
		} else {
			memberModify = false;
			commit(con);
		}
		return memberModify;
	}

}
