package co.micol.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.imageDAO;
import co.micol.VO.imageVO;
import co.micol.common.Command;

public class ImageInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		imageDAO dao = new imageDAO();
		imageVO vo = new imageVO();
		
		String src = request.getParameter("imagesrc");
		vo.setImagetest(src);
		int n = dao.insert(vo);
		String viewPage = null;
		if(n != 0) {
			viewPage = "notice.do";
		}else {
			viewPage ="main.do";
		}
		return viewPage;
	}

}
