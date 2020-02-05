package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.InsertService;


@WebServlet("/insertDB")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertController() {
        super();
    
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	String name;
    	name = request.getParameter("name");
    	InsertService insService = new InsertService();
    	boolean insertResult = insService.insertDB(name); 
    	if(insertResult) {
    		response.sendRedirect("InsertSuccess.jsp");
    	} else {
    		response.sendRedirect("InsertFail.jsp");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}