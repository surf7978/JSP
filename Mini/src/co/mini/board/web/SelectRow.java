package co.mini.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;
import co.mini.board.dao.BookDAO;
import co.mini.board.vo.BookVo;

public class SelectRow implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// SelectRow.do 처리 메소드
		BookDAO dao = new BookDAO();
		BookVo vo = new BookVo();
		String row = request.getParameter("row"); 
		vo.setBookCode(row); 

		vo = dao.selectoneAdminList(vo); 
		request.setAttribute("vo", vo);
		
		return "bookManage/updateBook";
	}

}
