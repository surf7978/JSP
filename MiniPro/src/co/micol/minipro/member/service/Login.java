package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class Login implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 과정을 처리한다.
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(request.getParameter("mId")); //loginForm.jsp 화면에 입력한 값
		vo.setmPassword(request.getParameter("mPassword"));
		
		vo = dao.login(vo); //로그인 체크하기 dao호출
		
		String viewPage = null;
		
		if(vo.getmAuth() != null) { //vo.getmAuth()가 값이 있을경우
			HttpSession session = request.getSession(); //세션객체 호출
			session.setAttribute("mid", vo.getmId()); //세션에 아이디를 담음
			session.setAttribute("mauth", vo.getmAuth()); //세션에 권한을 담음
			//세션 객체에 담는 이유 = 로그아웃이나 새로운 브라우저에 가기전까지
			//                   세션에 일정기간 보관하기 때문에 아이디나 권한을 계속 쓰려고
			request.setAttribute("vo", vo);
			viewPage = "views/member/loginSuccess.jsp";
		}else {
			viewPage = "views/member/loginFail.jsp";
		}
		return viewPage;
	}

}
