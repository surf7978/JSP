package co.mini.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;
import co.mini.board.dao.MemberDAO;
import co.mini.board.vo.MemberVo;

public class MemberUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// memberUpdate.do �޼ҵ� ó��
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		MemberDAO dao = new MemberDAO();
		MemberVo vo = new MemberVo();
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAddress(request.getParameter("memberAddress"));
		vo.setMemberAuth(request.getParameter("memberAuth"));
		vo.setMemberId(request.getParameter("memberId"));
		
		int n = dao.update(vo);
		
		request.setAttribute("list", list);
		
		return "member/toMemberView";
	}

}
