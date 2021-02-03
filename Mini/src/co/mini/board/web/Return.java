package co.mini.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mini.board.common.Command;
import co.mini.board.common.DAO;
import co.mini.board.dao.BookRentalDAO;
import co.mini.board.vo.BookRentalVo;

public class Return extends DAO implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		BookRentalDAO dao = new BookRentalDAO();
		BookRentalVo vo = new BookRentalVo();
		HttpSession session = request.getSession();
		vo.setRentalCode(Integer.parseInt(request.getParameter("rentalCode")));
		vo.setMemberId((String) session.getAttribute("MemberId"));

		int rt = 0;
		rt = dao.Return(vo);

		if (rt == 2) {
			request.setAttribute("msg", "반납 성공");
		} else {
			request.setAttribute("msg", "반납 실패");
		}

		return "rental/toRentalView";
	}

}
