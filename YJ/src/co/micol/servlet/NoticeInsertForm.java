package co.micol.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.noticeDAO;
import co.micol.VO.noticeVO;
import co.micol.common.Command;

public class NoticeInsertForm implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return  "customerCenter/noticeInsertForm";
	}

}
