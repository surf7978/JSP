package co.micol.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.boardDAO;
import co.micol.VO.boardVO;
import co.micol.common.Command;

public class SearchCategory2 implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<boardVO> list = new ArrayList<>();
		boardDAO dao = new boardDAO();
		boardVO vo = new boardVO();
		vo.setCategory2(request.getParameter("searchCategory2"));
		
		System.out.println(vo.toString());
		
		list = dao.searchCategory2(vo);
		
		request.setAttribute("list1", list);
		
		return "board/boardList";
	}

}
