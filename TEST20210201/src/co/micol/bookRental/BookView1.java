package co.micol.bookRental;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;
import co.micol.dao.BookDao;
import co.micol.vo.BookVo;

public class BookView1 implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		vo.setBookCode(request.getParameter("bookCode"));
		
		dao.select(vo);
		
		request.setAttribute("vo", vo);
		
		HttpSession session = request.getSession();
		session.getAttribute("memberId");
		
		return "bookRental/bookView1";
	}

}
