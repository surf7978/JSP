package co.micol.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.boardDAO;
import co.micol.DAO.commentDAO;
import co.micol.DAO.sellDAO;
import co.micol.common.Command;

public class AdminDashBoard implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		boardDAO dao = new boardDAO();
		int n = 0;
		n = dao.countBoard(n);
		request.setAttribute("countBoard", n);
		
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
