package co.micol.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.BookDao;
import co.micol.vo.BookVo;

public class UpdateBookForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		vo.setBookCode(request.getParameter("bookCode1"));
		
		dao.select(vo);
		
		request.setAttribute("vo", vo);
		
		return "book/updateBookForm";
	}

}
