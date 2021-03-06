package co.micol.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.InsertBoardForm;
import co.micol.board.UpdateBoard;
import co.micol.board.UpdateTradeProcess;
import co.micol.board.BoardUpdateForm;
import co.micol.comment.InsertComment;
import co.micol.board.BoardDelete;
import co.micol.board.BoardList;
import co.micol.board.BoardView;
import co.micol.board.BuySend;
import co.micol.board.InsertBoard;
import co.micol.customerCenter.FrequentlyQuestion;
import co.micol.customerCenter.QnAList;
import co.micol.customerCenter.ReportList;
import co.micol.file.FileUpload;
import co.micol.file.FileUploadServlet;
import co.micol.member.AdminDashBoard;
import co.micol.member.DeleteMember;
import co.micol.member.InsertMemberForm;
import co.micol.member.MemberList;
import co.micol.member.UpdateProfile;
import co.micol.my.CartList;
import co.micol.my.Profile;
import co.micol.my.NoteList;
import co.micol.my.NoteNCommandList;
import co.micol.my.NoticeList;
import co.micol.user.join.IdCheck;


@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Command> map = new HashMap<>();
       
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new Login());
		map.put("/mainPage.do", new MainPage());
		map.put("/logout.do", new Logout());
		
		map.put("/memberList.do", new MemberList());
		map.put("/deleteMember.do", new DeleteMember());
				
		map.put("/boardList.do", new BoardList());
		map.put("/insertBoardForm.do", new InsertBoardForm());
		map.put("/fileUpload.do", new FileUpload());
		map.put("/insertBoard.do", new InsertBoard());
		map.put("/boardView.do", new BoardView());
		map.put("/boardUpdateForm.do", new BoardUpdateForm());
		map.put("/updateBoard.do", new UpdateBoard());
		map.put("/boardDelete.do", new BoardDelete());
		
		map.put("/insertComment.do", new InsertComment());
		
		map.put("/profile.do", new Profile());
		map.put("/updateProfile.do", new UpdateProfile());
		
		map.put("/buySend.do", new BuySend());
		map.put("/noteNcommandList.do", new NoteNCommandList());
		
		map.put("/updateTradeProcess.do", new UpdateTradeProcess());
		
		
		
		
		
		
		map.put("/insertMemberForm.do", new InsertMemberForm());
		map.put("/idCheck.do", new IdCheck());
		
		map.put("/BoardList.do", new BoardList());
		map.put("/BoardView.do", new BoardView());
			
		map.put("/adminDashBoard.do", new AdminDashBoard());
			
		map.put("/cartList.do", new CartList());
		map.put("/noteList.do", new NoteList());
		map.put("/noticeList.do", new NoticeList());
		
		map.put("/frequentlyQuestion.do", new FrequentlyQuestion());
		map.put("/QnAList.do", new QnAList());
		map.put("/reportList.do", new ReportList());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());
		
		Command command = map.get(path);
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) viewPage = "WEB-INF/jsp/"+viewPage+".jsp";
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
