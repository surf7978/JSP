package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class SelectBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 해당 tr 클릭시 내용보여줌
		BoardDao dao = new BoardDao();
		BoardVo vo	= new BoardVo();
		vo.setbId(Integer.parseInt(request.getParameter("tr${vo.bId }.td${vo.bId }.value")));
		vo = dao.select(vo);
		
		request.setAttribute("vo", vo);
		
		return "views/board/selectBoard.jsp";
	}

}
