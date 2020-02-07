package service;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dto.MemberDTO;

public class MemberViewService {

	public static MemberDTO memberView(String id) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		MemberDTO memberViewResult = new MemberDTO();
		memberViewResult = dao.memberView(id);
		return memberViewResult;
	}

}
