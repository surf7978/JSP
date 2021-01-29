package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class InsertBoard implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//글쓰기 입력 처리
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo.setbName(request.getParameter("bName"));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		
		dao.insert(vo);
		
		return "boardList.do";
	}

}
