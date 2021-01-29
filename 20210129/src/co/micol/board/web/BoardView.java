package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class BoardView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 글 상세보기
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		
		vo = dao.select(vo);
		request.setAttribute("vo", vo);
		
		return "board/boardView";
	}

}
