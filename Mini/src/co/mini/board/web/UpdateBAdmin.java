package co.mini.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;

public class UpdateBAdmin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// update.do ó�� �޼ҵ�
		return "bookManage/updateBook";
	}

}
