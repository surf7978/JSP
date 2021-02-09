package co.micol.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;

public class InsertBoardForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "board/insertBoardForm";
	}

}
