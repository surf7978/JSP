package co.micol.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.MemberDao;
import co.micol.board.vo.MemberVo;

public class UpdateMember implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(request.getParameter("mId"));
		vo.setmPassword(request.getParameter("mPassword"));
		vo.setmName(request.getParameter("mName"));
		
		System.out.println(vo.toString());
		
		dao.update(vo);
		
		return "memberList.do";
	}

}
