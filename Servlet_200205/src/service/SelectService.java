package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;

public class SelectService {

	public List<String> selectDB() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<String> resultList = new ArrayList<String>();
		resultList = dao.selectDB();
		close(con);
		return resultList;
	}
}
