package co.micol.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Main implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.getAttribute("memberId");
		
		return "main/main";
	}

}
