package co.micol.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.MemberDao;
import co.micol.vo.MemberVo;

public class InsertMember implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("mId"));		
		vo.setMemberPassword(request.getParameter("mPassword"));
		vo.setMemberName(request.getParameter("mName"));
		vo.setMemberTel(request.getParameter("mTel"));
		vo.setMemberAddress(request.getParameter("mAddress"));
		
		dao.insert(vo);
		
		return "memberList.do";
	}

}
