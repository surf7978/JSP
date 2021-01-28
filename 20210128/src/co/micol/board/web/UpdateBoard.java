package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class UpdateBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 수정 처리
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		vo.setbContent(request.getParameter("bContent1"));
		vo.setbHit(0);
		
		dao.update(vo);
		
		return "boardList.do";
	}

}
