package co.micol.bookRental;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.BookRentalDao;
import co.micol.vo.BookRentalVo;

public class ReturnBookListDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BookRentalDao dao = new BookRentalDao();
		BookRentalVo vo	= new BookRentalVo();
		vo.setBookCode(request.getParameter("bookCode3"));
		vo.setMemberId(request.getParameter("memberId3"));
		vo.setRentalDate(request.getParameter("rentalDate3"));
		
		dao.returnBookListDelete(vo);
		
		return "bookRentalList.do";
	}

}
