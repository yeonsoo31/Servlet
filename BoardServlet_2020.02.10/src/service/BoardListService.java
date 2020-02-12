package service;

import java.sql.*;
import java.util.*;
import controller.*;
import dao.DAO;
import dto.BoardDTO;
import static db.JdbcUtil.*;

public class BoardListService {

	public List<BoardDTO> boardList() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<BoardDTO> boardList = dao.boardList();
		
		close(con);
		
		return boardList;
	}



}
