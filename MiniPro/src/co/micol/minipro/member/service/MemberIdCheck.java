package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class MemberIdCheck implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 아이디 중복 체크
		MemberDao dao = new MemberDao();
		String id = request.getParameter("mid"); //이거 자바스크립트에 쓴 idCheck.do?mid= 의 파라미터명 적어야함 mId아님
		boolean bool = dao.isIdCheck(id);
		String message = null;
		
		if(bool) {
			message = id + "는 사용할 수 있습니다.";
		}else {
			message = id + "는 중복되서 사용할 수 없습니다.";
		}
		request.setAttribute("msg", message);
		
		//중복체크창에 확인눌렀을 때 부모창으로 가게해서 값을 주려고 boolean값도 보냄
		request.setAttribute("check", bool);
		
		return "views/member/idCheck.jsp";
	}

}
