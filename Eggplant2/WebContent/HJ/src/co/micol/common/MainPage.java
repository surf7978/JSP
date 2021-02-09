package co.micol.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPage implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "main/mainPage";
	}

}
