package co.micol.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.sellDAO;
import co.micol.VO.sellVO;
import co.micol.common.Command;

public class UpdateTradeProcess implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		sellDAO dao = new sellDAO();
		sellVO vo =  new sellVO();
		vo.setTradeProcess(request.getParameter("tradeProcess"));
		vo.setBuyDate(request.getParameter("buyDate"));
		
		System.out.println(vo.toString());
		
		dao.updateTradeProcess(vo);
		
		return "noteNcommandList.do";
	}

}
