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

import co.micol.board.web.BoardList;
import co.micol.board.web.BoardView;
import co.micol.board.web.DeleteBoard;
import co.micol.board.web.InsertBoard;
import co.micol.board.web.InsertBoardForm;
import co.micol.board.web.MainCommand;
import co.micol.board.web.UpdateBoard;
import co.micol.board.web.UpdateBoardForm;
import co.micol.member.web.InsertMember;
import co.micol.member.web.InsertMemberForm;
import co.micol.member.web.MemberList;
import co.micol.member.web.MemberView;
import co.micol.member.web.UpdateMember;
import co.micol.member.web.UpdateMemberForm;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Command> map = new HashMap<>();
       
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
		// TODO Auto-generated method stub
		map.put("/main.do", new MainCommand());
		map.put("/boardList.do", new BoardList());
		map.put("/boardView.do", new BoardView());
		map.put("/insertBoardForm.do", new InsertBoardForm());
		map.put("/insertBoard.do", new InsertBoard());
		map.put("/deleteBoard.do", new DeleteBoard());
		map.put("/updateBoardForm.do", new UpdateBoardForm());
		map.put("/updateBoard.do", new UpdateBoard());
		
		map.put("/memberList.do", new MemberList());
		map.put("/insertMemberForm.do", new InsertMemberForm());
		map.put("/insertMember.do", new InsertMember());
		map.put("/memberView.do", new MemberView());
		map.put("/updateMemberForm.do", new UpdateMemberForm());
		map.put("/updateMember.do", new UpdateMember());
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());
		
		Command command = map.get(path);
		String viewPage = command.exec(request, response);
		
		//보안을 위해 jsp파일 전부 WEB-INF폴더에 넣을경우 이거 안써주면 불러오기 안됨
		//if(viewPage.endsWith(".jsp")) viewPage = "WEB-INF/jsp/"+viewPage;
		//해석 = 끝에 .jsp라는 것이 있으면 viewPage에 "WEB-INF/jsp/" 문구 붙여줘라는 뜻
		//이걸 view resolve라고 함
		if(!viewPage.endsWith(".do")) viewPage = "WEB-INF/jsp/"+viewPage+".jsp";
		//이렇게 적어줘도됨(+이 경우 커맨드 파일에 .jsp 다 지워줘야함) 
		//예) MainCommand.java파일에 return "main/main.jsp"; >>>> main/main으로 해야 불러옴
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
