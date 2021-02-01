package co.micol.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.BookDao;
import co.micol.vo.BookVo;

public class UpdateBook implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		vo.setBookCode(request.getParameter("bCode"));
		vo.setBookName(request.getParameter("bName"));
		vo.setQuantity(Integer.parseInt(request.getParameter("qnT")));
		vo.setbCount(Integer.parseInt(request.getParameter("bCt")));
		
		System.out.println(vo.toString());
		
		dao.update(vo);
		
		return "bookList.do";
	}

}
