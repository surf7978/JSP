package co.micol.bookRental;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;
import co.micol.dao.BookDao;
import co.micol.dao.BookRentalDao;
import co.micol.vo.BookRentalVo;
import co.micol.vo.BookVo;

public class BookRentalListUSER implements Command {
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BookDao dao = new BookDao();
		ArrayList<BookVo> list = new ArrayList<>();
		
		list = dao.selectList();
		
		request.setAttribute("list", list);
		
		HttpSession session = request.getSession();
		session.getAttribute("memberId");
		
		BookRentalDao dao1 = new BookRentalDao();
		BookRentalVo vo1 = new BookRentalVo();
		ArrayList<BookRentalVo> list1 = new ArrayList<>();
		vo1.setMemberId(request.getParameter("memberId"));
		
		list1 = dao1.selectListUSER(vo1);
		
		
		request.setAttribute("list1", list1);
		
		
		return "bookRental/bookRentalListUSER";
	}
}
