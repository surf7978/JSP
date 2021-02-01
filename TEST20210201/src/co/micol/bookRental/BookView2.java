package co.micol.bookRental;

import co.micol.common.Command;
import co.micol.dao.BookRentalDao;
import co.micol.vo.BookRentalVo;

public class BookView2 implements Command {
	BookRentalDao dao = new BookRentalDao();
	BookRentalVo vo = new BookRentalVo();
	vo.setRentalDate(Date.valueOf(request.getParameter("rentalDate")));
	
	dao.select(vo);
	
	request.setAttribute("vo", vo);
	
	HttpSession session = request.getSession();
	session.getAttribute("memberId");
	
	return "bookRental/bookView2";
}
