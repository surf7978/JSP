package co.micol.prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginResult
 */
@WebServlet("/LoginResult")
public class LoginResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String message = null;
		
		if(id.equals("hong") && pw.equals("1234")) {
			message = "님 환영합니다.";
		}else {
			message = "님 아이디 또는 패스워드가 틀려요.";
		}
		
//		response.setContentType("text/html; charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		
//		PrintWriter out = response.getWriter();
//		out.print("<h1>"+id+message+"</h1>");
//		out.print("<h3><a href='jsp/member/login.jsp'>돌아가기</a></h3>");
		
		request.setAttribute("msg", message);
		
//		response.sendRedirect("jsp/member/loginResult.jsp"); //이걸로하면 값을 전달안해줌 = RequestDispatcher써야함
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/member/loginResult.jsp"); //돌아갈 페이지 경로 설정
		dispatcher.forward(request, response); //이게 전달해줄 값도 싣고 가라는 명령문
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
