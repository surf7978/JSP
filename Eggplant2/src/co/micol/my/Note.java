package co.micol.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;

public class Note implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String nMemberId = request.getParameter("nMemberId");
		
		request.setAttribute("nMemberId", nMemberId);
		return "customerCenter/noticeInsertForm";
	}

}
