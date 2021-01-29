package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class UpdateBoardForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo.setbId(Integer.parseInt(request.getParameter("bId1")));
		
		vo = dao.select(vo);
		request.setAttribute("vo", vo);
		
		return "board/updateBoardForm";
	}

}
