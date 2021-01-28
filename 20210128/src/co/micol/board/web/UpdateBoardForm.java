package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class UpdateBoardForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 수정 화면 출력
		
		//일단 글 내용 뿌려줘야함
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId1")));
		vo = dao.select(vo);
		
		request.setAttribute("vo", vo);
		
		return "views/board/updateBoardForm.jsp";
	}

}
