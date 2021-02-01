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

import co.micol.book.BookList;
import co.micol.book.BookView;
import co.micol.book.DeleteBook;
import co.micol.book.InsertBook;
import co.micol.book.InsertBookForm;
import co.micol.book.UpdateBook;
import co.micol.book.UpdateBookForm;
import co.micol.bookRental.BookRentalList;
import co.micol.bookRental.BookRentalView;
import co.micol.bookRental.BookView1;
import co.micol.bookRental.BookView2;
import co.micol.bookRental.RentalBook;
import co.micol.bookRental.ReturnBook;
import co.micol.member.DeleteMember;
import co.micol.member.InsertMember;
import co.micol.member.InsertMemberForm;
import co.micol.member.MemberList;
import co.micol.member.MemberView;
import co.micol.member.UpdateMember;
import co.micol.member.UpdateMemberForm;

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
		map.put("/main.do", new Main());
		map.put("/logout.do", new Logout());
		
		map.put("/memberList.do", new MemberList());
		map.put("/memberView.do", new MemberView());
		map.put("/updateMemberForm.do", new UpdateMemberForm());
		map.put("/updateMember.do", new UpdateMember());
		map.put("/insertMemberForm.do", new InsertMemberForm());
		map.put("/insertMember.do", new InsertMember());
		map.put("/deleteMember.do", new DeleteMember());
		
		map.put("/bookList.do", new BookList());
		map.put("/bookView.do", new BookView());
		map.put("/updatebookForm.do", new UpdateBookForm());
		map.put("/updateBook.do", new UpdateBook());
		map.put("/insertBookForm.do", new InsertBookForm());
		map.put("/insertBook.do", new InsertBook());
		map.put("/deletebook.do", new DeleteBook());

		map.put("/bookRentalList.do", new BookRentalList());
		map.put("/bookRentalView.do", new BookRentalView());
		map.put("/bookView1.do", new BookView1());
		map.put("/rentalBook.do", new RentalBook());
		map.put("/bookView2.do", new BookView2());
		map.put("/returnBook.do", new ReturnBook());
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
