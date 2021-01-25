package co.micol.mvc.board.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mvc.board.dao.BoardsDAO;
import co.micol.mvc.board.service.BoardVO;

/**
 * Servlet implementation class BoardInput
 */
@WebServlet("/BoardInput.do")
public class BoardInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardsDAO dao = new BoardsDAO();
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWriter(request.getParameter("writer"));
		vo.setCreationDate(Date.valueOf(request.getParameter("creationDate"))); //Date타입으로 바꿈
		
		String viewPage=null;
		int n = dao.insert(vo);
		if(n != 0) { //n이 0이 아니면 성공
			viewPage="BoardList.do"; //redirect: == response.sendredirect 
		}else {//이 알고리즘 진행되기전에 에러뜨기 때문에 사실상 이건 작동안함
			String message = "입력한 내용을 DB에 저장하지 못했다.";
			request.setAttribute("msg", message);
			viewPage = "views/board/boardInputFail.jsp"; 
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
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
