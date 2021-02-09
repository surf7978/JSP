package co.micol.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.boardDAO;
import co.micol.VO.boardVO;
import co.micol.common.Command;

public class BoardUpdateForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		boardDAO dao = new boardDAO();
		boardVO vo = new boardVO();
		
		vo.setBoardDate(request.getParameter("boardDate"));
		
		vo = dao.selectBoard(vo);
		
		System.out.println(vo.toString());
		
		request.setAttribute("vos", vo);
		
		
		return "board/boardUpdateForm";
	}

}
