package co.micol.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.boardDAO;
import co.micol.DAO.commentDAO;
import co.micol.DAO.sellDAO;
import co.micol.VO.boardVO;
import co.micol.common.Command;

public class AdminDashBoard implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		boardDAO dao = new boardDAO();
		int n = 0;
		n = dao.countBoard(n);
		request.setAttribute("countBoard", n);
		
		boardVO vo = new boardVO();
		vo.setCategory2("상의");
		n=dao.averageCategory2(vo);
		System.out.println("---------------");
		System.out.println("상의"+n);
		request.setAttribute("shirt", n);
		vo.setCategory2("하의");
		n=dao.averageCategory2(vo);
		System.out.println("하의"+n);
		request.setAttribute("pants", n);
		vo.setCategory2("신발");
		n=dao.averageCategory2(vo);
		System.out.println("신발"+n);
		request.setAttribute("shoes", n);
		vo.setCategory2("모자");
		n=dao.averageCategory2(vo);
		System.out.println("모자"+n);
		request.setAttribute("cap", n);
		vo.setCategory2("스마트폰");
		n=dao.averageCategory2(vo);
		System.out.println("스마트폰"+n);
		request.setAttribute("phone", n);
		vo.setCategory2("컴퓨터");
		n=dao.averageCategory2(vo);
		System.out.println("컴퓨터"+n);
		request.setAttribute("pc", n);
		System.out.println("---------------");
		
		n = 0;
		n = dao.sumPrice(n);
		System.out.println(n);
		request.setAttribute("sumPrice", n);
		
		sellDAO dao1 = new sellDAO();
		n = 0;
		n = dao1.averageTradeComplete(n);
		System.out.println(n);
		request.setAttribute("averageTradeComplete", n);
		
		commentDAO dao2 = new commentDAO();
		n = 0;
		n = dao2.countComment(n);
		System.out.println(n);
		request.setAttribute("countComment", n);
		
		
		return "member/adminDashBoard";
	}

}
