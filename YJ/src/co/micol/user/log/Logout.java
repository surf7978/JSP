package co.micol.user.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;

public class Logout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 세션객체 invalidate
		HttpSession session = request.getSession();
		session.invalidate();

		// 경로 main.do 만들고 적용하기
		return "main/main.do";
	}

}
