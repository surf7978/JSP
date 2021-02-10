package co.micol.my;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.sellDAO;
import co.micol.VO.sellVO;
import co.micol.common.Command;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		sellDAO dao3 = new sellDAO();
		ArrayList<sellVO> list3 = new ArrayList<>();
		
		list3 = dao3.selectSellList();
		
		request.setAttribute("list3", list3);
		return "my/noticeList";
	}

}
