package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SelectService;

@WebServlet("/selectDB")
public class SelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//
    public SelectController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    	request.setCharacterEncoding("UTF-8");
    	SelectService selService = new SelectService();
    	List<String> resultList = new ArrayList<String>();
    	resultList = selService.selectDB();
    	request.setAttribute("selectResult", resultList);
    	RequestDispatcher dispatcher =
    			request.getRequestDispatcher("SelectResult.jsp");
    	dispatcher.forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}