package co.mini.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mini.board.common.Command;
import co.mini.board.common.DAO;
import co.mini.board.dao.BookDAO;
import co.mini.board.dao.MemberDAO;
import co.mini.board.vo.BookVo;
import co.mini.board.vo.MemberVo;

public class MemberJoin extends DAO implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		MemberDAO dao = new MemberDAO();
		MemberVo vo = new MemberVo();
		BookDAO bdao = new BookDAO();
		int memberJoin = 0;
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAddress(request.getParameter("memberAddress"));
		
		System.out.println("request까진 됨");
		memberJoin = dao.insert(vo);
		list = bdao.selectList();

		if (memberJoin==1) {
			vo.setMemberAuth("user");
		HttpSession session = request.getSession();
		session.setAttribute("MemberVo", vo);
		session.setAttribute("MemberId", vo.getMemberId());
		session.setAttribute("MainList", list);
		session.setMaxInactiveInterval(10*60);
		}
		else {
			request.setAttribute("Ljoin", "fail");
					
		}

		
		return "main/main";
	}

}
