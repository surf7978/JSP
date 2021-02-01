package co.micol.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.MemberDao;
import co.micol.vo.MemberVo;
import co.micol.common.Command;

public class MemberList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		ArrayList<MemberVo> list = new ArrayList<>();
		
		list = dao.selectList();
		
		request.setAttribute("list", list);
		
		
		return "member/memberList";
	}

}
