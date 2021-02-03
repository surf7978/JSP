package co.mini.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;
import co.mini.board.dao.BookRentalDAO;
import co.mini.board.vo.BookRentalVo;
import co.mini.board.vo.MemberVo;

public class ManagebkCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// managebook.do 처리 메소드
		
		BookRentalDAO dao = new BookRentalDAO();
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		list = dao.SelectAdminRental();
		request.setAttribute("list", list);
		System.out.println(list);
		return "bookManage/ListRentalBooks";

	}

}
