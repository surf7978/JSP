package co.micol.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.memberDAO;
import co.micol.VO.memberVO;

@WebServlet("/memberList")
public class memberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public memberListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
		
		memberDAO dao = new memberDAO();
		ArrayList<memberVO> list = dao.selectList();
		
		String jsonFile = "[";
		int i = 1;
		for(memberVO member:list) {
			jsonFile +="{";
        	jsonFile += "\"mId\":\""+ member.getmId()+"\"";
        	jsonFile += ",\"mPassword\":\""+ member.getmPassword()+"\"";
        	jsonFile += ",\"mName\":\""+ member.getmName()+"\"";
        	jsonFile += ",\"mBirth\":\""+ member.getmBirth()+"\"";
        	jsonFile += ",\"mAuth\":\""+ member.getmAuth()+"\"";
        	jsonFile += ",\"mNumber\":\""+ member.getmNumber()+"\"";
        	jsonFile += ",\"mAccount\":\""+ member.getmAccount()+"\"";
			jsonFile +="}";
			if(list.size() != i++) {
				jsonFile +=",";
			}
			
		}
		jsonFile += "]";
		
		response.getWriter().append(jsonFile);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
