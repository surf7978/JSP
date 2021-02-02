package co.micol.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.BookDao;


public class LoginForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BookDao dao = new BookDao();
		
		dao.startSetting();
		
		return "main/loginForm";
	}

}
