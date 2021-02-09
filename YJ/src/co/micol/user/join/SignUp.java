package co.micol.user.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.memberDAO;
import co.micol.VO.memberVO;
import co.micol.common.Command;

public class SignUp implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 확인
		memberDAO dao = new memberDAO();
		memberVO vo = new memberVO();

		// 회원가입 폼에서 submit시 오는 페이지
		// 회원가입 폼의 name값을 참고하여 고칠부분 고치기
		vo.setmId(request.getParameter("id"));
		vo.setmPassword(request.getParameter("password"));
		vo.setmName(request.getParameter("name"));
		vo.setmBirth(request.getParameter("birth"));
		vo.setmNumber(request.getParameter("number"));
		vo.setmAccount(request.getParameter("mAccount"));

		int n = dao.insert(vo);
		String viewPage = null;
		//회원가입 성공시 페이지 설정하기
		if (n != 0) {
			viewPage = "";
		}
		request.setAttribute("vo", vo);
		return viewPage;
	}

}
