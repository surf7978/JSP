package co.mini.board.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.web.IdCheck;
import co.mini.board.web.InsertBAdmin;
import co.mini.board.web.InsertExec;
import co.mini.board.web.Listadmin;
import co.mini.board.web.Login;
import co.mini.board.web.Logout;
import co.mini.board.web.MainCommand;
import co.mini.board.web.ManagebkCommand;
import co.mini.board.web.MemberDelete;
import co.mini.board.web.MemberJoin;
import co.mini.board.web.MemberJoinForm;
import co.mini.board.web.MemberUpdate;
import co.mini.board.web.MemberUpdateView;
import co.mini.board.web.MemberView;
import co.mini.board.web.Rental;
import co.mini.board.web.RentalView;
import co.mini.board.web.Return;
import co.mini.board.web.SelectRow;
import co.mini.board.web.SelectRowdelete;
import co.mini.board.web.UpdateBAdmin;
import co.mini.board.web.Updateexec;
import co.mini.board.web.Viewbk;


@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       

    public FrontController() {
        super();

    }
    
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/login.do",new Login());
		map.put("/logout.do", new Logout());
		map.put("/viewbk.do", new Viewbk());
		map.put("/memberJoinForm.do", new MemberJoinForm());
		map.put("/memberJoin.do", new MemberJoin());
		map.put("/rental.do",new Rental());
		map.put("/rentalView.do", new RentalView());
		map.put("/return.do", new Return());
		map.put("/managebook.do", new ManagebkCommand());
		map.put("/insertbAdmin.do", new InsertBAdmin());
		map.put("/insertexec.do", new InsertExec());
		map.put("/update.do", new UpdateBAdmin());
		map.put("/updateexec.do", new Updateexec());
		map.put("/listadmin.do", new Listadmin());
		map.put("/selectRow.do", new SelectRow());
		map.put("/selectRowdelete.do", new SelectRowdelete());
		map.put("/memberView.do", new MemberView());
		map.put("/memberUpdateView.do", new MemberUpdateView());
		map.put("/memberUpdate.do", new MemberUpdate());
		map.put("/memberDelete.do", new MemberDelete());
		map.put("/idCheck.do", new IdCheck());

	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());
		
		Command command = map.get(path);
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" +viewPage +".jsp"; 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		

	}

}
