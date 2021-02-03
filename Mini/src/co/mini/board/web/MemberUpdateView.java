package co.mini.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mini.board.common.Command;
import co.mini.board.dao.MemberDAO;
import co.mini.board.vo.MemberVo;

public class MemberUpdateView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		MemberDAO dao = new MemberDAO();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("memberId"));

		list = dao.selectMemberU(vo);
		
		request.setAttribute("list", list);
		
		return "member/memberUpdate";
	}

}
