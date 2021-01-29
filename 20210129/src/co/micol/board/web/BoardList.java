package co.micol.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class BoardList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시판 리스트 출력
		BoardDao dao = new BoardDao();
		ArrayList<BoardVo> list = new ArrayList<>();
		
		list = dao.selectList();
		
		request.setAttribute("list", list);
		
		return "board/boardList";
	}

}
