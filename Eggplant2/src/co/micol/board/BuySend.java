package co.micol.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.buyDAO;
import co.micol.VO.buyVO;
import co.micol.common.Command;

public class BuySend implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		buyDAO dao = new buyDAO();
		buyVO vo = new buyVO();
		vo.setBuyMemberId(request.getParameter("buyMemberId"));
		vo.setBoardDate(request.getParameter("boardDate"));
		vo.setProductName(request.getParameter("productName"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberSiAddress(request.getParameter("memberSiAddress"));
		vo.setMemberGuAddress(request.getParameter("memberGuAddress"));
		vo.setMemberPhoneNumber(request.getParameter("memberPhoneNumber"));
		
		System.out.println(vo.toString());
		
		dao.insertBuy(vo);
		
		System.out.println(vo.toString());

		
		return "noteNcommandList.do";
	}

}
