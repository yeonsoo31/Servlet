package service;

import static db.JdbcUtil.getConnection;
import java.sql.Connection;
import java.util.*;
import dao.DAO;
import dto.MemberDTO;

public class MemberListService {
	
	public List<MemberDTO> memberList(){
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<MemberDTO> memberListResult = new ArrayList<MemberDTO>();
		memberListResult = dao.memberList();
		return memberListResult;
		
		
		
		
		
	}
}
