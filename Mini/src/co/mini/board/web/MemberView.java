package co.mini.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mini.board.common.Command;
import co.mini.board.dao.BookDAO;
import co.mini.board.dao.MemberDAO;
import co.mini.board.vo.BookVo;
import co.mini.board.vo.MemberVo;

public class MemberView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();

		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		HttpSession session = request.getSession();
		Object lo = session.getAttribute("MemberId");

		if (lo == null || !request.isRequestedSessionIdValid()) {
			request.setAttribute("lo", "logout");
			request.setAttribute("msg", "로그인해주세요");
		} else {
			list = dao.selectMember();

			request.setAttribute("list", list);
		}

		return "member/memberView";
		

	}

}
