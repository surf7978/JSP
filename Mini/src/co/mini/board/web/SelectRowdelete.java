package co.mini.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;
import co.mini.board.dao.BookDAO;
import co.mini.board.vo.BookVo;

public class SelectRowdelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// SelectRowdelete.do 처리 메소드
		BookDAO dao = new BookDAO();
		BookVo vo = new BookVo();
		
		vo.setBookCode(request.getParameter("row"));
		int n=dao.delete(vo);

		return "listadmin.do";
	}

}
