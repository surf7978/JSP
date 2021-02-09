package co.micol.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.boardDAO;
import co.micol.VO.boardVO;
import co.micol.common.Command;

public class BoardList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		boardDAO dao = new boardDAO();
		ArrayList<boardVO> list = new ArrayList<>();
		
		list = dao.selectBoardList();
		
		request.setAttribute("list1", list);
		
		return "board/boardList";
	}

}
