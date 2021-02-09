package co.micol.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.boardDAO;
import co.micol.VO.boardVO;
import co.micol.common.Command;

public class UpdateBoard implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		boardDAO dao = new boardDAO();
		boardVO vo = new boardVO();
		vo.setBoardDate(request.getParameter("boardDate"));
		vo.setBoardTitle(request.getParameter("boardTitle"));
		vo.setBoardContent(request.getParameter("boardContent"));
		vo.setPrice(Integer.parseInt(request.getParameter("updatePrice")));
		vo.setTradeProcess(request.getParameter("tradeProcess"));
		vo.setProductImage(request.getParameter("productImage"));
		
		System.out.println(vo.toString());
		
		dao.updateBoard(vo);
		
		return "boardView.do";
	}

}
