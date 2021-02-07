package co.micol.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.commentDAO;
import co.micol.VO.commentVO;
import co.micol.common.Command;

public class InsertComment implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		commentDAO dao = new commentDAO();
		commentVO vo = new commentVO();
		vo.setBoardDate(request.getParameter("boardDate"));
		vo.setCommentContent(request.getParameter("commentContent"));
		vo.setMemberId(request.getParameter("commentMemberId"));
		
		dao.insertComment(vo);
		
		return "boardView.do";
	}

}
