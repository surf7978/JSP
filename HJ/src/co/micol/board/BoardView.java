package co.micol.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.boardDAO;
import co.micol.DAO.commentDAO;
import co.micol.VO.boardVO;
import co.micol.VO.commentVO;
import co.micol.common.Command;

public class BoardView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		boardDAO dao = new boardDAO();
		boardVO vo = new boardVO();
		vo.setBoardDate(request.getParameter("boardDate"));
		
		vo = dao.selectBoard(vo);
		
		System.out.println(vo.toString());
		
		request.setAttribute("vo", vo);
		
		commentDAO dao1 = new commentDAO();
		commentVO vo1 = new commentVO();
		ArrayList<commentVO> list1 = new ArrayList<>();
		vo1.setBoardDate(request.getParameter("boardDate"));
		
		System.out.println(vo1.toString());
		list1 = dao1.selectComment(vo1);
		
		request.setAttribute("list1", list1);
		
		return "board/boardView";
	}

}
