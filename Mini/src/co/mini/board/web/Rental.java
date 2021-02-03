package co.mini.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mini.board.common.Command;
import co.mini.board.common.DAO;
import co.mini.board.dao.BookRentalDAO;
import co.mini.board.vo.BookRentalVo;

public class Rental extends DAO implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();

		BookRentalDAO dao = new BookRentalDAO();
		BookRentalVo vo = new BookRentalVo();
		HttpSession session = request.getSession();
		vo.setBookCode(request.getParameter("bookCode"));
		vo.setMemberId((String) session.getAttribute("MemberId"));
		System.out.println("rental.java 멤버아이디 세션값:" + vo.getMemberId());
		System.out.println("rental.java 북코드값:" + vo.getBookCode());
		int ar = dao.AlreadyRental(vo);

		if (session==null || !request.isRequestedSessionIdValid()) {
			request.setAttribute("lo", "logout");
			request.setAttribute("msg", "로그인해주세요");
		}
		else {
		if (ar == 0) {

			list = dao.Rental(vo);

			if (list.isEmpty()) {
				request.setAttribute("msg", "대출 실패");
			} else {
				System.out.println(list);
				session.setAttribute("rentalList", list);
				request.setAttribute("msg", "대출 성공");

			}

		}

		else if (ar != 0) {
			request.setAttribute("msg", "이미 대출한 책입니다.");
		}}
		return "viewbk/toViewbk";
	}

}
