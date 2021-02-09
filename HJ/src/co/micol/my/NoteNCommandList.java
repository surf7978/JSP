package co.micol.my;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.boardDAO;
import co.micol.DAO.buyDAO;
import co.micol.DAO.commentDAO;
import co.micol.DAO.sellDAO;
import co.micol.VO.boardVO;
import co.micol.VO.buyVO;
import co.micol.VO.commentVO;
import co.micol.VO.sellVO;
import co.micol.common.Command;

public class NoteNCommandList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		buyDAO dao = new buyDAO();
		ArrayList<buyVO> list1 = new ArrayList<>();
		
		list1 = dao.selectBuyList(); 
		
		request.setAttribute("list1", list1);
		
		
		
		boardDAO dao1 =  new boardDAO();
		ArrayList<boardVO> list = new ArrayList<>();
		
		list = dao1.selectBoardList();
		
		request.setAttribute("list", list);
		
		
		
		commentDAO dao2 = new commentDAO();
		ArrayList<commentVO> list2 = new ArrayList<>();
		
		list2 = dao2.selectCommentList();
		
		request.setAttribute("list2", list2);
		
		
		
		sellDAO dao3 = new sellDAO();
		ArrayList<sellVO> list3 = new ArrayList<>();
		
		list3 = dao3.selectSellList();
		
		request.setAttribute("list3", list3);
		
		return "my/noteNcommandList";
	}

}
