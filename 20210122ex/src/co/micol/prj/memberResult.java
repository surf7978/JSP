package co.micol.prj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class memberRegister
 */
@WebServlet("/memberResult")
public class memberResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String pwc = request.getParameter("pwc");
		String id = request.getParameter("id");
		String hobbys[] = request.getParameterValues("hobbys");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		
		String message = null;
		if(pw.equals(pwc)) {
			message = "회원가입 성공";
		}else {
			message = "패스워드가 틀려요.";
		}
		request.setAttribute("msg", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/member/memberResult.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
