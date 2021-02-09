package co.micol.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.memberDAO;
import co.micol.VO.memberVO;
import co.micol.common.Command;

public class AdminMemberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 관리자-회원등록 기능
		memberDAO dao = new memberDAO();
		memberVO vo = new memberVO();

		vo.setmId(request.getParameter("mId"));
		vo.setmPassword(request.getParameter("mPassword"));
		vo.setmName(request.getParameter("mName"));
		vo.setmBirth(request.getParameter("mBirth"));
		vo.setmNumber(request.getParameter("mNumber"));
		vo.setmAccount(request.getParameter("mAccount"));

		int n = dao.insert(vo);
		String viewPage = null;

		// 0이 아니면 추가된거니까 그때 등록되었습니다 alert박스?window박스?주고 관리페이지로 보내기
		if (n != 0) {
			viewPage = "";
		}

		return viewPage;
	}

}
