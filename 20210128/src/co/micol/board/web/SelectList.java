package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;

public class SelectList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 목록 출력
		BoardDao dao = new BoardDao();
		
		dao.selectList();
		
		return "views/board/boardList.jsp";
	}

}
