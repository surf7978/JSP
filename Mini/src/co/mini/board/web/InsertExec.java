package co.mini.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;
import co.mini.board.dao.BookDAO;
import co.mini.board.vo.BookVo;

public class InsertExec implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BookDAO dao = new BookDAO();
		BookVo vo = new BookVo();
		
		vo.setBookName(request.getParameter("bookname"));
		vo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		vo.setbCount(Integer.parseInt(request.getParameter("bcount")));
		
		int n=dao.insertAdmin(vo);
		
		return "listadmin.do";
	}

}
