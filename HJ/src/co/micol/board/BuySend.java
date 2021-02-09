package co.micol.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.buyDAO;
import co.micol.DAO.sellDAO;
import co.micol.VO.buyVO;
import co.micol.VO.sellVO;
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

		sellDAO dao1 = new sellDAO();
		sellVO vo1 = new sellVO();
		vo1.setBuyMemberId(request.getParameter("buyMemberId"));
		vo1.setPrice(Integer.parseInt(request.getParameter("price")));
		vo1.setMemberId(request.getParameter("memberId"));
		vo1.setProductName(request.getParameter("productName"));
		System.out.println(vo1.toString());
		dao1.insertSell(vo1);
		
		return "noteNcommandList.do";
	}

}
