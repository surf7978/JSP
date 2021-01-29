package co.micol.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;
import co.micol.board.vo.ReplyVo;

public class BoardView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 글 상세보기 +댓글까지 출력
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		ReplyVo rvo = new ReplyVo();
		ArrayList<ReplyVo> list = new ArrayList<>();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		rvo.setBid(Integer.parseInt(request.getParameter("bId")));
		
		vo = dao.select(vo);
		
		dao = new BoardDao(); //DAO에 close()해버려서 주글 출력 끝나고 다시 dao하나 열어주게함
		
		list = dao.replySelect(rvo);
		
		request.setAttribute("vo", vo);
		request.setAttribute("list", list);
		
		return "board/boardView";
	}

}
