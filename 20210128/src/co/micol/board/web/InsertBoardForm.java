package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;

public class InsertBoardForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글쓰기 화면 출력
		return "views/board/insertBoardForm.jsp";
	}

}
