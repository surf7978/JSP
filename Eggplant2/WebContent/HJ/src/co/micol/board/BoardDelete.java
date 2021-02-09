package co.micol.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.boardDAO;
import co.micol.DAO.commentDAO;
import co.micol.VO.boardVO;
import co.micol.VO.commentVO;
import co.micol.common.Command;

public class BoardDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		boardDAO dao = new boardDAO();
		boardVO vo = new boardVO();
		vo.setBoardDate(request.getParameter("boardDate"));
		dao.selectBoard(vo);
				
		commentDAO dao1 = new commentDAO();
		commentVO vo1 = new commentVO();
		vo1.setBoardDate(request.getParameter("boardDate"));
		
		int n = dao.deleteBoard(vo);
		String viewPage = null;
		
		if(n != 0) {
			viewPage = "boardList.do";
		}
		return "board/boardList";
	}

}
