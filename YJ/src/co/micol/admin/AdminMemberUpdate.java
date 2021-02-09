package co.micol.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.memberDAO;
import co.micol.VO.memberVO;
import co.micol.common.Command;
import sun.java2d.d3d.D3DRenderQueue;

public class AdminMemberUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 관리자-수정기능
		memberDAO dao = new memberDAO();
		memberVO vo = new memberVO();

		vo.setmPassword(request.getParameter("mPassword"));
		vo.setmAuth(request.getParameter("mAuth"));
		vo.setmNumber(request.getParameter("mNumber"));
		vo.setmAccount(request.getParameter("mAccount"));
		vo.setmId(request.getParameter("mId"));

		int n = dao.update(vo);
		// 수정의 경우 관리자는 auth에 입력할 수 있지만 일반 유저는 그 칸을 readonly로 주면 될듯
		// 수정하고 난 후 갈 페이지 설정하기(회원관리로 가기)
		String viewPage = null;
		if (n != 0) {
			viewPage = "";
		}
		return viewPage;
	}

}
