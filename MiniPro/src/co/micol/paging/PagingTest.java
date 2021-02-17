package co.micol.paging;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.EmployeeVO;
import co.micol.minipro.common.Paging;
import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class PagingTest implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		
		String pageNo = request.getParameter("pageNo");
		int pg = Integer.parseInt(pageNo);
		Paging paging = new Paging();
		
		paging.setPageNo(pg);
		paging.setPageSize(10);
		paging.setTotalCount(dao.getTotalCnt());
		System.out.println(paging);
		
		dao = new MemberDao(); //마지막에 close() 해줘서 다시 변수 선언해야 됨
		List<EmployeeVO> list = dao.getPagingList(pg);
		request.setAttribute("list", list);
		request.setAttribute("params", paging);
		
		return "views/main/main.jsp";
	}

}
