package co.micol.bookRental;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;
import co.micol.dao.BookRentalDao;
import co.micol.vo.BookRentalVo;

public class ReturnBook implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		BookRentalDao dao = new BookRentalDao();
		BookRentalVo vo =new BookRentalVo();
		vo.setBookCode(request.getParameter("bookCode3"));
		vo.setMemberId(request.getParameter("memberId3"));
		vo.setRentalDate(request.getParameter("rentalDate3"));
		
		String filter = request.getParameter("memberId3");
		
		dao.returnBook(vo);
		
		HttpSession session = request.getSession();
		session.getAttribute("memberId");
		
		if(filter.equals("admin")) {
			return "bookRentalList.do";
		}else {
			return "bookRentalListUSER.do";
		}
	}
}
