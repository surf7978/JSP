package co.micol.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.noticeDAO;
import co.micol.VO.noticeVO;

@WebServlet("/NoticeContentServlet")
public class NoticeContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeContentServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        
        noticeDAO dao = new noticeDAO();
        ArrayList<noticeVO> list = dao.selectList();
        
        String jsonFile = "[";
        int i=1;
        for(noticeVO notice:list) {
        	jsonFile +="{";
        	jsonFile += "\"nNumber\":\""+ notice.getnNumber()+"\"";
			jsonFile +=",\"nTitle\":\""+notice.getnTitle()+"\"";
			jsonFile +=",\"nContent\":\""+notice.getnContent()+"\"";
			jsonFile +=",\"nWriter\":\""+notice.getnWriter()+"\"";
			jsonFile +=",\"memberId\":\""+notice.getMemberId()+"\"";
			jsonFile +=",\"nDate\":\""+notice.getnDate()+"\"";
			jsonFile += "}";
			if(list.size() != i++) {
				jsonFile += ",";
			}
        }
        jsonFile += "]";
        response.getWriter().append(jsonFile);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
