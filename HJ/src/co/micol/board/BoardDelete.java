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
		boardDAO rdao = new boardDAO();
		boardVO rvo = new boardVO();
		rvo.setBoardDate(request.getParameter("boardDate"));
		rdao.deleteBoard(rvo);
				
		commentDAO dao = new commentDAO();
		commentVO vo = new commentVO();
		vo.setBoardDate(request.getParameter("boardDate"));
		
		int n = dao.delete(vo);
		String viewPage = null;
		
		if(n != 0) {
			viewPage = "boardList.do";
		}
		return "board/boardList";
	}

}
