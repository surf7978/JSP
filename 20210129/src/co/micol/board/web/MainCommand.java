package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;

public class MainCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 홈화면 출력
		//return "main/main.jsp";
		return "main/main";
		//return "main/mainSample"; //테스트용
	}

}
