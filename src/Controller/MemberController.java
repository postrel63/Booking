package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.MemberDTO;
import Service.MemberService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet({"/Members/memberJoin","/Members/CheakId","/Members/MemberLogin"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	MemberService memberservice = new MemberService();
    	HttpSession session = request.getSession();
    	
    	switch (request.getServletPath()) {
    	
    	//아이디 중복 확인 컨트롤러
    	case "/Members/CheakId":
    		System.out.println("/member/checkId");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			String uId = request.getParameter("uId");
			String resultMsg = memberservice.checkId(uId);
			System.out.println(resultMsg);
			out.print(resultMsg);
			break;
			
    		//회원가입 컨트롤러
    	case "/Members/memberJoin":
    	MemberDTO join = new MemberDTO();
    	join.setUserId(request.getParameter("userId"));
    	join.setUserPw(request.getParameter("userPw"));
    	join.setUserName(request.getParameter("userName"));
    	Date userBirth =Date.valueOf(request.getParameter("userBirth"));
    	join.setUserBirth(userBirth);
    	join.setUserGender(request.getParameter("userGender"));
    	join.setUserEmail(request.getParameter("userEmail"));
    	
    	
    	int result = memberservice.memberJoin(join);
    	if(result > 0) {
    		response.sendRedirect("Main.jsp");
    	}
    	break;
    	
    	//로그인 컨트롤러
    	case "/Members/MemberLogin":
    		String userId = request.getParameter("userId");
    		String userPw = request.getParameter("userPw");
    		System.out.println(userId);
    		String loginId = memberservice.memberlogin(userId,userPw);
    		if(loginId != null) {
    			session.setAttribute("loginId",loginId);
    			response.sendRedirect("Main.jsp");
    		}else {
    			System.out.println("실패");
    		}
    	
    	
    	
    	
    	
    	
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
