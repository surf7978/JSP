package co.mini.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;
import co.mini.board.dao.BookDAO;
import co.mini.board.vo.BookVo;

public class Updateexec implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// Updateexec.do 처리 메소드
		BookDAO dao = new BookDAO();
		BookVo vo = new BookVo();
		
		vo.setBookCode(request.getParameter("bookCode"));
		vo.setBookName(request.getParameter("bookName"));
		vo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		vo.setbCount(Integer.parseInt(request.getParameter("bCount")));
		int n=dao.update(vo);
		
		return "listadmin.do";
	}

}
