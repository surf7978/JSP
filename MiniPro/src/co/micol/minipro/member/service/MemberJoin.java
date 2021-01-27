package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class MemberJoin implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입시 DB에 저장하는 메소드
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(request.getParameter("mId")); //loginForm.jsp 화면에 입력한 값
		vo.setmPassword(request.getParameter("mPassword"));
		vo.setmName(request.getParameter("mName"));
		
		int n = dao.insert(vo);
		
		//밑에는 걍 출력으로 보여줌, 기능적인건 위에서 끝남
		String viewPage = null;
		request.setAttribute("vo", vo);
		
		if(n != 0) {
			viewPage = "views/member/memberJoinSuccess.jsp";
		}else {
			viewPage = "views/member/memberJoinFail.jsp";
		}
		
		return viewPage;
	}

}
