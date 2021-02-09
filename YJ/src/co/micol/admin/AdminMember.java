package co.micol.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.memberDAO;
import co.micol.VO.memberVO;
import co.micol.common.Command;

public class AdminMember implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 맴버리스트를 가져와야함
		memberDAO dao = new memberDAO();
		ArrayList<memberVO> list = new ArrayList<memberVO>();

		list = dao.selectList();

		// request객체로 return할 페이지에 list값을 넘겨줌
		request.setAttribute("list", list);
		// 리턴할 JSP페이지 설정
		return "";
	}

}
