package co.micol.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.dao.MemberDao;
import co.micol.vo.MemberVo;


public class Login implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("mId"));
		vo.setMemberPassword(request.getParameter("mPassword"));
		
		vo = dao.login(vo); 
		
		String viewPage = null;
		
		if(vo.getMemberAuth() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", vo.getMemberId());
			session.setAttribute("memberName", vo.getMemberName());
			session.setAttribute("memberPassword", vo.getMemberPassword());
			session.setAttribute("memberTel", vo.getMemberTel());
			session.setAttribute("memberAddress", vo.getMemberAddress());
			session.setAttribute("memberAuth", vo.getMemberAuth()); 
			request.setAttribute("vo", vo);
			viewPage = "main/loginSuccess";
		}else {
			viewPage = "main/loginFail";
		}
		return viewPage;
	}

}
