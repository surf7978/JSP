package co.micol.bookRental;

import co.micol.common.Command;
import co.micol.dao.BookRentalDao;
import co.micol.vo.BookRentalVo;

public class ReturnBook implements Command {
	BookRentalDao dao = new BookRentalDao();
	BookRentalVo vo =new BookRentalVo();
	vo.setBookCode(request.getParmeter("bookCode3"));
	vo.setMemberCode(request.getParmeter("memberId3"));
	vo.setRentalDate(Date.valueOf(request.getParameter("rentalDate3")));
	
	dao.return(vo);
	
	HttpSession session = request.getSession();
	session.getAttribute("memberId");
	
	return "bookRentalList.do";
}
