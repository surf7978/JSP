package co.micol.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;

public class Profile implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "my/profile";
	}

}
