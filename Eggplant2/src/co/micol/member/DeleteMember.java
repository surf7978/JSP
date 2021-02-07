package co.micol.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.memberDAO;
import co.micol.VO.memberVO;
import co.micol.common.Command;

public class DeleteMember implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		memberDAO dao = new memberDAO();
		memberVO vo = new memberVO();
		vo.setMemberId(request.getParameter("memberId"));
		
		dao.deleteMember(vo);
		
		return "memberList.do";
	}

}
