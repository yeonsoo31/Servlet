package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.MemberModifyService;
import service.MemberService;

@WebServlet("/memberModify")
public class MemberModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberModifyController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id, password, email;
    	id = request.getParameter("id");
    	password = request.getParameter("password");
    	email = request.getParameter("email");
    	
		MemberModifyService memberModifyService = new MemberModifyService();
    	
		boolean memberModifyResult = memberModifyService.memberModify(id, password, email);
		if(memberModifyResult) {
    		response.sendRedirect("MemberModifySuccess.jsp");
    	} else {
    		response.sendRedirect("MemberModifyFail.jsp");
    	}
		
		
		
		
		
		
		
		
		
		
		
		
	}
    	
    	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}