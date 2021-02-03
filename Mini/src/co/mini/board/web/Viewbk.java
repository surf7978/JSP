package co.mini.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mini.board.common.Command;
import co.mini.board.common.DAO;
import co.mini.board.dao.BookDAO;
import co.mini.board.vo.BookVo;

public class Viewbk extends DAO implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BookDAO dao = new BookDAO();
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		HttpSession session = request.getSession();
		Object lo = session.getAttribute("MemberId");

		if (lo == null || !request.isRequestedSessionIdValid()) {
			request.setAttribute("lo", "logout");
			request.setAttribute("msg", "로그인해주세요");
		} else {
			list = dao.selectList();

			request.setAttribute("list", list);
		}

		return "viewbk/viewbk";
	}

}
