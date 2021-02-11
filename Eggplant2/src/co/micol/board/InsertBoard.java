package co.micol.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.boardDAO;
import co.micol.VO.boardVO;
import co.micol.VO.productVO;
import co.micol.common.Command;

public class InsertBoard implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		boardDAO dao = new boardDAO();
		boardVO vo = new boardVO();
		vo.setBoardTitle(request.getParameter("boardTitle"));
		vo.setBoardContent(request.getParameter("boardContent"));
		vo.setProductName(request.getParameter("productName"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberSiAddress(request.getParameter("memberSiAddress"));
		vo.setMemberGuAddress(request.getParameter("memberGuAddress"));
		vo.setMemberPhoneNumber(request.getParameter("memberPhoneNumber"));
		
		vo.setCategory1(request.getParameter("category1"));
		vo.setCategory2(request.getParameter("category2"));
		
		vo.setProductImage(request.getParameter("productImage"));
		vo.setProductColor(request.getParameter("productColor"));
		vo.setProductVolume(Integer.parseInt(request.getParameter("productVolume")));
		
		System.out.println(vo.toString());
		
		productVO vo1 = new productVO();
		vo1.setProductName(request.getParameter("productName"));
		vo1.setCategory1(request.getParameter("category1"));
		vo1.setCategory2(request.getParameter("category2"));
		
		dao.insertBoard(vo);
		
		return "boardList.do";
	}

}
