package co.micol.text;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;

public class InsertText implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "text/textForm";
	}

}
