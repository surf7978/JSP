package co.micol.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.DAO.sellDAO;
import co.micol.VO.sellVO;

public class MainPage implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		//현재 미확인 알림 출력 메소드
		sellDAO dao1 = new sellDAO();
		sellVO vo1 = new sellVO();
		vo1.setMemberId(request.getParameter("memberId"));
		
		int n = 0;
		
		n = dao1.alertTrade(vo1);
		
		System.out.println(n);
		
		HttpSession session = request.getSession();
		session = request.getSession();
		session.setAttribute("alertTrade", n);
		
		
		return "main/mainPage";
	}
}
