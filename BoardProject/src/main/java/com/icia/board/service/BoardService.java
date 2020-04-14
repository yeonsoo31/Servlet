package com.icia.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dao.CommentDAO;
import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.CommentDTO;
import com.icia.board.dto.PageDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO bdao;
	
	@Autowired
	private CommentDAO cdao;
	
	private ModelAndView mav;
	
	public ModelAndView boardList() {
		mav = new ModelAndView();
		List<BoardDTO> boardList = bdao.boardList();
		mav.addObject("boardList", boardList);
		mav.setViewName("board/BoardList");
		return mav;
	}

	public ModelAndView boardPost(BoardDTO board) {
		mav = new ModelAndView();
		int boardPostResult = bdao.boardPost(board);
		if(boardPostResult > 0) {
			mav.setViewName("redirect:/boardList");
		} else {
			mav.setViewName("board/BoardPostFail");
		}
		return mav;
	}

	public ModelAndView boardView(int bnumber) {
		mav = new ModelAndView();
		bdao.boardHits(bnumber);
		BoardDTO boardView = bdao.boardView(bnumber);
		List<CommentDTO> commentList = cdao.commentList(bnumber);
		
		mav.addObject("commentList", commentList);
//		mav.addObject("page", page);
		mav.addObject("boardView", boardView);
		mav.setViewName("board/BoardView");
		return mav;
	}

	public ModelAndView modifyForm(int bnumber) {
		mav = new ModelAndView();
		BoardDTO modifyForm = bdao.modifyForm(bnumber);
		mav.addObject("modifyForm", modifyForm);
		mav.setViewName("board/BoardModify");
		return mav;
	}

	public ModelAndView boardModify(BoardDTO boardDTO) {
		mav = new ModelAndView();
		int boardModifyResult = bdao.boardModify(boardDTO);
		if(boardModifyResult>0) {
			mav.setViewName("redirect:/boardList");
		} else {
			mav.setViewName("board/BoardModifyFail");
		}
		return mav;
	}

	public ModelAndView boardDelete(int bnumber) {
		mav = new ModelAndView();
		int boardDelete = bdao.boardDelete(bnumber);
		if(boardDelete>0) {
			mav.setViewName("redirect:/boardList");
		} else {
			mav.setViewName("board/BoardDeleteFail");
		}
		return mav;
	}
	
	private static final int PAGE_LIMIT = 3;
	private static final int BLOCK_LIMIT = 5;
	
	public ModelAndView boardListPaging(int page) {
		mav = new ModelAndView();
		
		int startRow = (page-1) * PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT;
		
		PageDTO paging = new PageDTO();
		paging.setStartrow(startRow);
		paging.setEndrow(endRow);
		
		List<BoardDTO> boardList = bdao.boardListPaging(paging);
		
		int listCount = bdao.listCount();
		
//		int maxPage =
//				(int) ((double) listCount / PAGE_LIMIT + 0.9);
//		int startPage =
//				(((int) ((double) page / BLOCK_LIMIT + 0.9)) - 1) * BLOCK_LIMIT + 1;
		int maxPage =
				(int) (Math.ceil((double) listCount / PAGE_LIMIT));
		int startPage =
				(((int)(Math.ceil((double) page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		paging.setMaxpage(maxPage);
		paging.setStartpage(startPage);
		paging.setEndpage(endPage);
		paging.setPage(page);
		
		mav.addObject("paging", paging);
		mav.addObject("boardListPaging", boardList);
		mav.setViewName("board/BoardListPaging");
		return mav;
	}

	public ModelAndView commentWrite(BoardDTO boardDTO) {
		mav = new ModelAndView();
		int commentWriteResult = bdao.commentWrite(boardDTO);
		if(commentWriteResult > 0) {
			mav.setViewName("redirect:/boardView");
		} else {
			mav.setViewName("board/CommentWriteFail");
		}
		return mav;
	}

	public ModelAndView boardWriteFile(BoardDTO board) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		MultipartFile bFile = board.getBfile();
		String fileName = bFile.getOriginalFilename();
		String savePath = "C:\\Users\\7\\Desktop\\Development\\source\\Servlet\\BoardProject\\src\\main\\webapp\\resources\\fileUpload\\"+fileName;
		if(!bFile.isEmpty()) {
			bFile.transferTo(new File(savePath));
		}
		board.setBfilename(fileName);
		int writeResult = bdao.boardWriteFile(board);
		if(writeResult > 0) {
			mav.setViewName("redirect:/boardlistpaging");
		} else {
			mav.setViewName("board/WriteFail");
		}
		return mav;
	}
	
}
