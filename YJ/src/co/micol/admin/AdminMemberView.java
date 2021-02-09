package co.micol.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.memberDAO;
import co.micol.VO.memberVO;
import co.micol.common.Command;

public class AdminMemberView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 클릭한 맴버의 상세 페이지
		memberDAO dao = new memberDAO();
		memberVO vo = new memberVO();

		// JSP페이지에서 tr태그 눌렀을 때 가져올 name값 *수정 필요
		vo.setmId(request.getParameter("id"));
		vo = dao.adminSelect(vo);

		request.setAttribute("vo", vo);
		String viewPage = null;

		// 보여줄 상세페이지 만들고 경로 설정하기
		if (vo.getmId() != null) {
			viewPage = "";
		}

		return viewPage;
	}

}
