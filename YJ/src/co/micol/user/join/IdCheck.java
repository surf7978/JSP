package co.micol.user.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.memberDAO;
import co.micol.common.Command;

public class IdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO ID채크
		memberDAO dao = new memberDAO();
		int cnt = 0;
		// 중복채크 눌렀을 때 받아오는 name값
		String id = request.getParameter("exampleFirstName");
		
		System.out.println(cnt);
		
		cnt = dao.isIdCheck(id);
		
		System.out.println(cnt);
		
		String msg = null;
		if (cnt == 1) {
			msg = "이미 사용중인 아이디입니다.";
		} else {
			msg = "사용할 수 있는 아이디 입니다.";
		}
		request.setAttribute("msg", msg);
		// 아이디 채크 후 보내줄 window 팝업 페이지
		return "user/idCheck";
	}

}
