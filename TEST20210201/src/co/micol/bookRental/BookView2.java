package co.micol.bookRental;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;
import co.micol.dao.BookRentalDao;
import co.micol.vo.BookRentalVo;

public class BookView2 implements Command {
	

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		BookRentalDao dao = new BookRentalDao();
		BookRentalVo vo = new BookRentalVo();
		vo.setRentalDate(request.getParameter("rentalDate"));
		
		dao.select(vo);
		
		request.setAttribute("vo", vo);
		
		HttpSession session = request.getSession();
		session.getAttribute("memberId");
		
		return "bookRental/bookView2";
	}
}
