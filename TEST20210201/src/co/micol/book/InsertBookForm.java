package co.micol.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;

public class InsertBookForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "book/insertBookForm";
	}

}
