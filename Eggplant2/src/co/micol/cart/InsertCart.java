package co.micol.cart;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.cartDAO;
import co.micol.VO.cartVO;
import co.micol.common.Command;

public class InsertCart implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		cartDAO dao = new cartDAO();
		cartVO vo = new cartVO();
		vo.setCartMemberId(request.getParameter("cartMemberId"));
		vo.setBoardDate(request.getParameter("boardDate"));
		vo.setProductName(request.getParameter("productName"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberSiAddress(request.getParameter("memberSiAddress"));
		vo.setMemberGuAddress(request.getParameter("memberGuAddress"));
		vo.setMemberPhoneNumber(request.getParameter("memberPhoneNumber"));
		vo.setTradeProcess(request.getParameter("tradeProcess"));
		
		System.out.println(vo.toString());
		
		dao.insertCart(vo);
		
		ArrayList<cartVO> list = new ArrayList<>();
		
		list = dao.selectCartList();
		
		request.setAttribute("list", list);
		
		
		return "cartList.do";
	}

}
