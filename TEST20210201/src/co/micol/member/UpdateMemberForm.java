package co.micol.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.MemberDao;
import co.micol.vo.MemberVo;

public class UpdateMemberForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("memberId1"));
		
		dao.select(vo);
		
		request.setAttribute("vo", vo);
		
		return "member/updateMemberForm";
	}

}
