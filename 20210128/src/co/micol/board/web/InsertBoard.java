package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class InsertBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글쓰기 처리
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo.setbName(request.getParameter("bName"));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		
		int n = dao.insert(vo);
		String viewPage = null;
		if(n != 0) {
			viewPage = "views/board/insertBoardSuccess.jsp";
		}else {
			viewPage = "views/board/insertBoardFail.jsp";
		}
		return viewPage;
	}

}
