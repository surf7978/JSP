package co.micol.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.memberDAO;
import co.micol.VO.memberVO;
import co.micol.common.Command;

public class AdminMemberDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 관리자-삭제기능
		memberDAO dao = new memberDAO();
		memberVO vo = new memberVO();
		
		//삭제버튼을 눌렀을 때 받아올 name값 설정하기
		vo.setmId(request.getParameter("mId"));
		int n = dao.delete(vo);
		
		// 삭제하고 갈 페이지 설정하기
		return "";
	}

}
