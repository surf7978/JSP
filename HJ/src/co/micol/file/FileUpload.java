package co.micol.file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;

public class FileUpload implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "board/fileUpload";
	}

}
