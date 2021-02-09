package co.micol.user.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;

public class AdminDashBoard implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "user/adminDashBoard";
	}

}
