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
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setMemberSiAddress(request.getParameter("memberSiAddress"));
		vo.setMemberGuAddress(request.getParameter("memberGuAddress"));
		vo.setTradeProcess(request.getParameter("tradeProcess"));
		vo.setProductImage(request.getParameter("productImage"));
		vo.setProductVolume(Integer.parseInt(request.getParameter("productVolume")));
		vo.setProductColor(request.getParameter("productColor"));
		
		int n = dao.updateBoard(vo);

		String viewPage = null;
		
		if(n != 0) {
			String msg = "정상적으로 수정되었습니다. ";
			request.setAttribute("msg", msg);
			viewPage = "boardList.do";
		} else {
			viewPage = "error1";
		}
		return viewPage;
	}

}
