package co.micol.proc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.EmployeeVO;
import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class CursorType implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// cursor.do
		MemberDao dao = new MemberDao();
		int salary = Integer.parseInt(request.getParameter("salary"));
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		EmployeeVO resultVo = dao.getSalaryInfo(employeeId, salary);
		request.setAttribute("vo", resultVo); 
		return "views/main/main.jsp";
	}

}
