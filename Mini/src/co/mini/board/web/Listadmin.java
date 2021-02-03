package co.mini.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;
import co.mini.board.dao.BookDAO;
import co.mini.board.vo.BookVo;

public class Listadmin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// Listadmin.do처리 메소드
		BookDAO dao = new BookDAO();
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		list=dao.selectAmList();
		request.setAttribute("list", list);
		System.out.println(list);
		
		return "bookManage/booklistAdminForm";
	}

}
