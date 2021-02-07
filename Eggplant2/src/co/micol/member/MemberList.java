package co.micol.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.DAO.memberDAO;
import co.micol.VO.memberVO;
import co.micol.common.Command;

public class MemberList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		memberDAO dao = new memberDAO();
		ArrayList<memberVO> list = new ArrayList<>();
		
		list = dao.selectList();
		
		request.setAttribute("list", list);
		
		HttpSession session = request.getSession();
		session.getAttribute("memberId");
		
		return "member/memberList";
	}

}
