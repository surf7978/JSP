package co.mini.board.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;
import co.mini.board.dao.BookDAO;
import co.mini.board.vo.BookVo;

public class InsertBAdmin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// insertbAdmin.do ó���ϴ� �޼ҵ�
		
		return "bookManage/InsertBookForm";
	}

}
