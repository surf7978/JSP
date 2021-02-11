package co.micol.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.noticeDAO;
import co.micol.VO.noticeVO;
import co.micol.common.Command;

public class NoticeView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		noticeDAO dao = new noticeDAO();
		noticeVO vo = new noticeVO();
		
		vo.setnDate(request.getParameter("nDate"));
		vo = dao.noticeSelect(vo);
		
		String viewPage = "customerCenter/noticeView";
		request.setAttribute("vo", vo);
		
		return viewPage;
	}

}
