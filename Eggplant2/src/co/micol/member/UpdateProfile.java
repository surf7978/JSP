package co.micol.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.memberDAO;
import co.micol.VO.memberVO;
import co.micol.common.Command;

public class UpdateProfile implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		memberDAO dao = new memberDAO();
		memberVO vo = new memberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberPhoneNumber(request.getParameter("memberPhoneNumber"));
		vo.setMemberSiAddress(request.getParameter("memberSiAddress"));
		vo.setMemberGuAddress(request.getParameter("memberGuAddress"));
		
		System.out.println(vo.toString());
		
		dao.updateProfile(vo);
		
		return "logout.do";
	}

}
