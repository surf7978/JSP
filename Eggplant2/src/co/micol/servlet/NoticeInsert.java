package co.micol.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.noticeDAO;
import co.micol.VO.noticeVO;
import co.micol.common.Command;

public class NoticeInsert implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		noticeDAO dao = new noticeDAO();
		noticeVO vo = new noticeVO();
		vo.setnTitle(request.getParameter("nTitle"));
		vo.setnContent(request.getParameter("nContent"));
		vo.setnWriter(request.getParameter("nWriter"));
		vo.setMemberId(request.getParameter("memberId"));
		int n = dao.noticeInsert(vo);
		String viewPage = null;
		if(n != 0) {
			viewPage = "main/mainPage";
		}
		return viewPage;
	}

}
