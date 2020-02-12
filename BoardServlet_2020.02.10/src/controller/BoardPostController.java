package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.BoardDTO;
import service.BoardPostService;

@WebServlet("/boardPost")
public class BoardPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BoardPostController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	String bWriter, bPassword, bTitle, bContents;
    	bWriter = request.getParameter("bWriter");
    	bPassword = request.getParameter("bPassword");
		bTitle = request.getParameter("bTitle");
		bContents = request.getParameter("bContents");
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setbWriter(bWriter);
		boardDTO.setbPassword(bPassword);
		boardDTO.setbTitle(bTitle);
		boardDTO.setbContents(bContents);
		
		BoardPostService boardPostService = new BoardPostService();
		
		
		boolean boardPostResult = boardPostService.boardPost(boardDTO);
		if(boardPostResult) {
    		response.sendRedirect("boardList");
    		
    	} else {
    		response.sendRedirect("PostFail.jsp");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}