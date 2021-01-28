package co.micol.board.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.web.MainCommand;
import co.micol.board.web.SelectBoard;
import co.micol.board.web.UpdateBoard;
import co.micol.board.web.UpdateBoardForm;
import co.micol.board.web.BoardList;
import co.micol.board.web.BoardView;
import co.micol.board.web.DeleteBoard;
import co.micol.board.web.InsertBoard;
import co.micol.board.web.InsertBoardForm;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HashMap<String, Command> map = new HashMap<String, Command>(); //이거 꼭 써줘야함
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/boardList.do", new BoardList());
		map.put("/insertBoardForm.do", new InsertBoardForm());
		map.put("/insertBoard.do", new InsertBoard());
		map.put("/selectBoard.do", new SelectBoard()); //내가한 것 아직 미구현
		map.put("/boardView.do", new BoardView());
		map.put("/deleteBoard.do", new DeleteBoard());
		map.put("/updateBoardForm.do", new UpdateBoardForm());
		map.put("/updateBoard.do", new UpdateBoard());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length()); //실제 요청할 페이지
		
		Command command = map.get(path); //요청한 것을 처리하는 Command를 찾아줌
		String viewPage = command.execute(request, response); //처리한 후 결과를 돌려줄 page값을 받음
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); //RequestDispatcher를 사용해서 돌려줘야 서블릿에서 받은 값도 전달해줌 
		dispatcher.forward(request, response);
	}

}
