package co.micol.bookRental;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;
import co.micol.dao.BookRentalDao;
import co.micol.vo.BookRentalVo;

public class Rentalbook implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BookRentalDao dao = new BookRentalDao();
		BookRentalVo vo = new BookRentalVo();
		vo.setBookCode(request.getParameter("bookCode2"));
		vo.setMemberId(request.getParameter("memberId2"));
		
		System.out.println(vo.toString());
		
		dao.rental(vo);
		
		HttpSession session = request.getSession();
		session.getAttribute("memberId");
		
		return "bookRentalList.do";
	}

}
