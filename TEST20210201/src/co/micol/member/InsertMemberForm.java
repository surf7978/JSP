package co.micol.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;

public class InsertMemberForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.getAttribute("memberId");
		
		return "member/insertMemberForm";
	}

}
