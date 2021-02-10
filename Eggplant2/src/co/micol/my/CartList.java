package co.micol.my;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.cartDAO;
import co.micol.VO.cartVO;
import co.micol.common.Command;

public class CartList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		cartDAO dao = new cartDAO();
		ArrayList<cartVO> list = new ArrayList<>();
		
		list = dao.selectCartList();
		
		request.setAttribute("list", list);
		
		
		return "my/cartList";
	}

}
