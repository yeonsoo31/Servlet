package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.MemberDTO;
import service.MemberService;

@WebServlet("/signUp")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignUpController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id, password, name, birth, gender, email;
    	id = request.getParameter("id");
    	password = request.getParameter("password");
		name = request.getParameter("name");
		birth = request.getParameter("birth");
		gender = request.getParameter("gender");
		email = request.getParameter("email");
    	
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setBirth(birth);
		member.setGender(gender);
		member.setEmail(email);
		
		MemberService memberService = new MemberService();
		
		boolean signUpResult = memberService.memberJoin(member);
		if(signUpResult) {
    		response.sendRedirect("SignUpSuccess.jsp");
    	} else {
    		response.sendRedirect("SignUpFail.jsp");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}