package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.minipro.common.Service;

public class Logout implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃 절차
		// DB필요없이 세션만 제거하면 됨
		HttpSession session = request.getSession();
		//session.invalidate(); //이게 세션값 제거하는 명령문 
		//return "main.do"; //.jsp로 경로 설정안하고 바로 걍 .do로 처리해도됨 //있어보이게 로그아웃 페이지 만들 예정 
		
		String mid = (String) session.getAttribute("mid"); //걍 로그아웃페이지 출력용 값 넣어줌 +스트링타입으로 변환해서
		request.setAttribute("mid", mid);
		session.invalidate();
		return "views/member/logout.jsp";
	}

}
