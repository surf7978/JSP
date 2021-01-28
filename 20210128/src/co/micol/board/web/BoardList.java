package co.micol.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class BoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 목록 출력
		BoardDao dao = new BoardDao();
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		list = dao.selectList();
		
		request.setAttribute("list", list); //많은양 가져올 때 사용
		
		return "views/board/boardList.jsp";
	}

}
