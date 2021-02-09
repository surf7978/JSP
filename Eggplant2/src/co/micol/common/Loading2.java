package co.micol.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.memberDAO;


public class Loading2 implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		memberDAO dao = new memberDAO();
		dao.startSetting();
		
		return "loginForm.do";
	}

}
