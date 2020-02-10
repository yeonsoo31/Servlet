package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dto.MemberDTO;
import service.MemberService;


@WebServlet("/memberlogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	String id, password;
    	id = request.getParameter("id");
    	password = request.getParameter("password");
    	MemberDTO member = new MemberDTO();
    	member.setId(id);
		member.setPassword(password);
		 
    	MemberService memberService = new MemberService();
    	
    	boolean loginResult = memberService.memberLogin(member); 
    	if(loginResult) {
    		HttpSession session=request.getSession();
    		session.setAttribute("loginId", member.getId());
    		response.sendRedirect("MemberMain.jsp");
    	} else {
    		response.sendRedirect("LoginFail.jsp");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
