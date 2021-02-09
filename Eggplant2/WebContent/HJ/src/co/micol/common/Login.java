package co.micol.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.DAO.memberDAO;
import co.micol.VO.memberVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Login 기능
		memberDAO dao = new memberDAO();
		memberVO vo = new memberVO();

		// JSP 로그인 페이지에서 설정한 name값 채크하기
		vo.setMemberId(request.getParameter("exampleInputEmail"));
		vo.setMemberPassword(request.getParameter("exampleInputPassword"));
		
		System.out.println(vo.toString());
		
		vo = dao.login(vo);

		System.out.println(vo.toString());

		
		String viewPage = null;

		HttpSession session = request.getSession();
		session.setAttribute("memberId", vo.getMemberId());
		session.setAttribute("memberPassword", vo.getMemberPassword());
		session.setAttribute("memberName", vo.getMemberName());
		session.setAttribute("memberAuth", vo.getMemberAuth());
		session.setAttribute("memberSiAddress", vo.getMemberSiAddress());
		session.setAttribute("memberGuAddress", vo.getMemberGuAddress());
		session.setAttribute("memberPhoneNumber", vo.getMemberPhoneNumber());

		// 유저 or 관리자로그인 실패 순서 설정하기 
		//비교연산자로 null대신에 == 하고 getmAuth값이 USER,ADMIN인 것만으로 바꾸고 싶음
		if (vo.getMemberAuth() != null) {
			viewPage = "main/loginSuccess";
		}else {
			viewPage = "main/loginFail";
		}

		return viewPage;
	}

}
