package com.icia.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public List<BoardDTO> boardList() {
		return sql.selectList("Board.boardList");
	}

	public int boardPost(BoardDTO board) {
		return sql.insert("Board.boardPost", board);
	}

	public BoardDTO boardView(int bnumber) {
		return sql.selectOne("Board.boardView", bnumber);
	}

	public int boardHits(int bnumber) {
		return sql.update("Board.boardHits", bnumber);
	}

	public BoardDTO modifyForm(int bnumber) {
		return sql.selectOne("Board.modifyForm", bnumber);
	}

	public int boardModify(BoardDTO boardDTO) {
		return sql.update("Board.boardModify", boardDTO);
	}

	public int boardDelete(int bnumber) {
		return sql.delete("Board.boardDelete", bnumber);
	}

	public List<BoardDTO> boardListPaging(PageDTO paging) {
		return sql.selectList("Board.boardListPaging", paging);
	}

	public int listCount() {
		return sql.selectOne("Board.listCount");
	}

	public int commentWrite(BoardDTO boardDTO) {
		return sql.insert("Board.commentWrite", boardDTO);
	}

	public int boardWriteFile(BoardDTO board) {
		return sql.insert("Board.boardWriteFile", board);
	}


}
