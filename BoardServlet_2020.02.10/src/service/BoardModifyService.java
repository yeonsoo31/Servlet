package service;

import static db.JdbcUtil.*;
import java.sql.*;
import dao.DAO;
import dto.BoardDTO;

public class BoardModifyService {

	public int boardModify(BoardDTO boardModify) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.boardModify(boardModify);
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
