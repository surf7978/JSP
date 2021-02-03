package co.mini.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;
import co.mini.board.dao.MemberDAO;

public class IdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		String id =request.getParameter("memberId");
		
		boolean bool = dao.isIdCheck(id);
		String message = null;
		String viewPage = null;

		if(bool) {
			message= id + " 은 사용할 수 없는 아이디입니다.";
		}
		else
		{	

			message= id + " 은 사용할 수 있는 아이디입니다.";
		}
		request.setAttribute("msg", message);
		request.setAttribute("check", bool);
		viewPage = "join/idCheck";
		return viewPage;
	}

}
