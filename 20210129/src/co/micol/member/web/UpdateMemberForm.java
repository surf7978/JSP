package co.micol.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.MemberDao;
import co.micol.board.vo.MemberVo;

public class UpdateMemberForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(request.getParameter("mId1"));
		
		dao.select(vo);
		
		request.setAttribute("vo", vo);
		
		return "member/updateMemberForm";
	}

}
