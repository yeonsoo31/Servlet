package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.BoardDTO;
import service.BoardPostService;

@WebServlet("/boardPostFile")
public class BoardPostFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardPostFileController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	
    	int size = 10*1024*1024;
    	String savePath = "C:/Users/7/Desktop/Development/source/Servlet/BoardServlet_2020.02.10/WebContent/fileUpload";
    	
    	MultipartRequest multi = new MultipartRequest(
    			request,
    			savePath,
    			size,
    			"UTF-8",
    			new DefaultFileRenamePolicy()
    			);
    	BoardDTO boardDTO = new BoardDTO();
    	
    	boardDTO.setbWriter(multi.getParameter("bWriter"));
    	boardDTO.setbTitle(multi.getParameter("bTitle"));
    	boardDTO.setbPassword(multi.getParameter("bPassword"));
    	boardDTO.setbContents(multi.getParameter("bContents"));
    	boardDTO.setbFile(multi.getOriginalFileName(
    			(String)multi.getFileNames().nextElement()));
    	
    	BoardPostService boardPostService = new BoardPostService();
    	int postResult = boardPostService.boardPostFile(boardDTO);
    	
    	if(postResult > 0) {
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