package co.micol.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.dao.BookRentalDao;
import co.micol.vo.BookRentalVo;


public class Main implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		BookRentalDao dao1 = new BookRentalDao();
		ArrayList<BookRentalVo> list1 = new ArrayList<>();
		
		list1 = dao1.selectListNotReturn();
		
		request.setAttribute("list1", list1);
		
		HttpSession session = request.getSession();
		session.getAttribute("memberId");
		
		return "main/main";
	}

}
