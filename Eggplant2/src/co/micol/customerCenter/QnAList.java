package co.micol.customerCenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;

public class QnAList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "customerCenter/QnAList";
	}

}
