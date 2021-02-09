package co.micol.user.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.DAO.memberDAO;
import co.micol.VO.memberVO;
import co.micol.common.Command;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Login 기능
		memberDAO dao = new memberDAO();
		memberVO vo = new memberVO();

		// JSP 로그인 페이지에서 설정한 name값 채크하기
		vo.setmId(request.getParameter("exampleInputEmail"));
		vo.setmPassword(request.getParameter("exampleInputPassword"));
		
		System.out.println(vo.toString());
		
		vo = dao.select(vo);

		System.out.println(vo.toString());

		
		String viewPage = null;
		// 세션객체에 id,pw,auth넘겨줌(변수명 변경가능)
		HttpSession session = request.getSession();
		session.setAttribute("mId", vo.getmId());
		session.setAttribute("mPassword", vo.getmPassword());
		session.setAttribute("mAuth", vo.getmAuth());

		// 유저 or 관리자로그인 실패 순서 설정하기 
		//비교연산자로 null대신에 == 하고 getmAuth값이 USER,ADMIN인 것만으로 바꾸고 싶음
		if (vo.getmAuth() != null) {
			viewPage = "main/loginSuccess";
		}else {
			viewPage = "main/loginFail";
		}

		return viewPage;
	}

}
