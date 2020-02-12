package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardModifyService;

@WebServlet("/modifyProcess")
public class BoardModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardModifyProcessController() {
        super();
    }


    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	
    	int bNumber = Integer.parseInt(request.getParameter("bNumber"));
    	String bTitle = request.getParameter("bTitle");
    	String bWriter = request.getParameter("bWriter");
    	String bContents = request.getParameter("bContents");
    	BoardDTO boardModify = new BoardDTO();
    	boardModify.setbNumber(bNumber);
    	boardModify.setbTitle(bTitle);
    	boardModify.setbWriter(bWriter);
    	boardModify.setbContents(bContents);
    	
    	BoardModifyService boardModifyService = new BoardModifyService();
    	int result = 0;
    	result = boardModifyService.boardModify(boardModify);
    	if(result > 0) {
    		response.sendRedirect("boardList");
    	} else {
    		response.sendRedirect("BoardMain");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}