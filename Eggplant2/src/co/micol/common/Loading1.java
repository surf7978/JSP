package co.micol.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.memberDAO;


public class Loading1 implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		memberDAO dao = new memberDAO();
		dao.endSetting();
		
		return "loading2.do";
	}

}
