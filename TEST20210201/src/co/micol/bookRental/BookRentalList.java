package co.micol.bookRental;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;
import co.micol.dao.BookDao;
import co.micol.dao.BookRentalDao;
import co.micol.vo.BookRentalVo;
import co.micol.vo.BookVo;

public class BookRentalList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BookDao dao = new BookDao();
		ArrayList<BookVo> list = new ArrayList<>();
		
		list = dao.selectList();
		
		request.setAttribute("list", list);
		
		BookRentalDao dao1 = new BookRentalDao();
		ArrayList<BookRentalVo> list1 = new ArrayList<>();
		
		list1 = dao1.selectList();
		
		request.setAttribute("list1", list1);
		
		HttpSession session = request.getSession();
		session.getAttribute("memberId");
		
		return "bookRental/bookRentalList";
	}

}
