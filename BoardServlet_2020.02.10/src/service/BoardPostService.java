package service;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.*;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DAO;
import dto.BoardDTO;

public class BoardPostService {

	public boolean boardPost(BoardDTO boardDTO) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int postResult = dao.boardPost(boardDTO);
		boolean boardPostResult = false;
		if(postResult > 0) {
			commit(con);
			boardPostResult = true;
		} else {
			rollback(con);
			boardPostResult = false;
		}
		close(con);
		return boardPostResult;
	}

	public int boardPostFile(BoardDTO boardDTO) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int postResult = dao.boardPostFile(boardDTO);
		
		if(postResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return postResult;
	}

}
