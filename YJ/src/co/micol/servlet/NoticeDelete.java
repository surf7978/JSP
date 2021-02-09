package co.micol.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.noticeDAO;
import co.micol.VO.noticeVO;
import co.micol.common.Command;

public class NoticeDelete implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		noticeDAO dao = new noticeDAO();
		noticeVO vo = new noticeVO();
		
		vo.setnNumber(Integer.parseInt(request.getParameter("nNumber")));
		int n = dao.noticeDelete(vo);		
		String viewPage=null;
		
		if(n != 0) {
			viewPage = "notice.do";
		}
		
		
		return viewPage;
	}

}
