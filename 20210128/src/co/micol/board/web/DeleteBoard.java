package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class DeleteBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 상세보기에서 삭제 처리
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		
		int n = dao.delete(vo);
		
		String viewPage = null;
		if(n != 0) {
			viewPage = "views/board/deleteBoardSuccess.jsp";
		}else {
			viewPage = "views/board/deleteBoardFail.jsp";
		}
		return viewPage;
	}

}
