package co.micol.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.boardDAO;
import co.micol.VO.boardVO;
import co.micol.common.Command;

public class InsertBoard implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		boardDAO dao = new boardDAO();
		boardVO vo = new boardVO();
		vo.setBoardTitle(request.getParameter("boardTitle"));
		vo.setBoardContent(request.getParameter("boardContent"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setProductName(request.getParameter("productName"));
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberSiAddress(request.getParameter("memberSiAddress"));
		vo.setMemberGuAddress(request.getParameter("memberGuAddress"));
		vo.setMemberPhoneNumber(request.getParameter("memberPhoneNumber"));
		vo.setProductImage(request.getParameter("productImage"));
		vo.setProductVolume(Integer.parseInt(request.getParameter("productVolume")));
		vo.setProductColor(request.getParameter("productColor"));

		
		System.out.println(vo.toString());
		
		dao.insertBoard(vo);
		
		return "boardList.do";
	}

}
