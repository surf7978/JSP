package co.micol.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.DAO.productDAO;
import co.micol.VO.productVO;

@WebServlet("/productServlet")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public productServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        
        productDAO dao = new productDAO();
        ArrayList<productVO> list =dao.selectList();
        
        String jsonFile = "[";
        int i=1;
        for(productVO pro:list) {
        	jsonFile +="{";
        	jsonFile += "\"productName\":\""+ pro.getProductName()+"\"";
			jsonFile +=",\"productImage\":\""+pro.getProductImage()+"\"";
			jsonFile +=",\"category1\":\""+pro.getCategory1()+"\"";
			jsonFile +=",\"category2\":\""+pro.getCategory2()+"\"";
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
