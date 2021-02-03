package co.mini.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;
import co.mini.board.dao.MemberDAO;
import co.mini.board.vo.MemberVo;

public class MemberDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		MemberVo vo = new MemberVo();
		
		vo.setMemberId(request.getParameter("memberId"));
		int n=dao.delete(vo);
		
		return "memberView.do";
	}

}
