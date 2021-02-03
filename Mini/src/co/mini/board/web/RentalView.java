package co.mini.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mini.board.common.Command;
import co.mini.board.dao.BookRentalDAO;
import co.mini.board.vo.BookRentalVo;

public class RentalView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		BookRentalDAO dao = new BookRentalDAO();
		BookRentalVo vo = new BookRentalVo();
		HttpSession session = request.getSession();
		Object lo = session.getAttribute("MemberId");

		if (lo == null || !request.isRequestedSessionIdValid()) {
			request.setAttribute("lo", "logout");
			request.setAttribute("msg", "로그인해주세요");
		} else {
			session = request.getSession();
			vo.setMemberId((String) session.getAttribute("MemberId"));

			list = dao.SelectUserRental(vo);

			if (list.isEmpty()) {
				request.setAttribute("msg", "대출 이력이 없습니다.");

			} else {
				request.setAttribute("RentalList", list);
			}
		}

		return "rental/rentalView";
	}

}
