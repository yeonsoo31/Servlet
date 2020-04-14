package com.icia.board.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	private ModelAndView mav;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String Main() {
		return "Main";
	}
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public ModelAndView BoardList() {
		mav = boardService.boardList();
		return mav;
	}
	
	@RequestMapping(value="/boardPostForm")
	public String BoardPostForm() {
		return "board/BoardPost";
	}
	
	@RequestMapping(value="/boardPost", method=RequestMethod.POST)
	public String BoardPost(@ModelAttribute BoardDTO boardDTO) {
		boardService.boardPost(boardDTO);
		return "redirect:/boardList";
	}
	
//	@RequestMapping(value="/boardPost", method=RequestMethod.POST)
//	public ModelAndView BoardPost(@ModelAttribute BoardDTO board) {
//		boardService.boardPost(board);
//		return mav;
//	}
	
	@RequestMapping(value="/boardView")
	public ModelAndView BoardView(@RequestParam int bnumber) {
		mav = boardService.boardView(bnumber);
		return mav;
	}
	
	@RequestMapping(value="/modifyForm")
	public ModelAndView ModifyForm(@RequestParam int bnumber) {
		mav = boardService.modifyForm(bnumber);
		return mav;
	} 

	@RequestMapping(value="/boardModify")
	public ModelAndView BoardModify(@ModelAttribute BoardDTO boardDTO) {
		mav = boardService.boardModify(boardDTO);
		return mav;
	}
	
	@RequestMapping(value="/boardDelete")
	public ModelAndView BoardDelete(@RequestParam int bnumber) {
		mav = boardService.boardDelete(bnumber);
		return mav;
	}
	
//	@RequestMapping(value="/boardlistpaging")
//	public ModelAndView BoardListPaging(@RequestParam("page") int page) {
//		mav = boardService.boardListPaging(page);
//		return mav;
//	}
	
	@RequestMapping(value="/boardlistpaging")
	public ModelAndView BoardListPaging
		(@RequestParam(value="page", required=false, defaultValue="1") int page) {
		mav = boardService.boardListPaging(page);
		return mav;
	}
	
	@RequestMapping(value="/commentWrite")
	public ModelAndView CommentWrite(@ModelAttribute BoardDTO boardDTO) {
		boardService.commentWrite(boardDTO);
		return mav;
	}
	
	@RequestMapping(value="/boardwritefile")
	public ModelAndView boardWriteFile(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		mav = boardService.boardWriteFile(board);
		return mav;
	}
}
