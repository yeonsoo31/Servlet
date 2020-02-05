package service;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.DAO;

public class InsertService {
//
	public boolean insertDB(String name) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.insertDB(name); 
		boolean insertResult = false;
		if(result > 0) {
			commit(con);
			insertResult = true;
		} else {
			rollback(con);
			insertResult = false;
		}
		
		return insertResult;

	}

}
