package co.micol.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
@MultipartConfig(
location = "C:/Users/admin/git/JSP/Eggplant2/WebContent/image",
maxFileSize = -1,
maxRequestSize = -1,
fileSizeThreshold = 1024)

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String ATTACHES_DIR = "C:/attaches";        //밑에 request 객체에 적
	private static final String CHARSET = "utf-8";

  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       response.setContentType("text/html; charset=UTF-8");
	        request.setCharacterEncoding(CHARSET);
	        String ATTACHES_DIR = "C:/Users/admin/git/JSP/Eggplant2/WebContent/image";				//저장될 경로 
	        PrintWriter out = response.getWriter();
	        String contentType = request.getContentType();
	        String fname = "";
	        
	        if (contentType != null &&  contentType.toLowerCase().startsWith("multipart/")) {
	            // getParts()를 통해 Body에 넘어온 데이터들을 각각의  Part로 쪼개어 리턴
	            Collection<Part> parts = request.getParts();
	 
	 
	            for (Part part : parts) {
	 
	 
	                if  (part.getHeader("Content-Disposition").contains("filename=")) {
	                    String fileName =  extractFileName(part.getHeader("Content-Disposition"));
	                    
	                    if (part.getSize() > 0) {
	                        part.write(ATTACHES_DIR + File.separator  + fileName);
	                        part.delete();
	                        fname = fileName;
	                    }
	                } else {
	                    String formValue =  request.getParameter(part.getName());
	                }
	            }
				out.println("<script>");
				out.println("opener.frm.productImage.value='" + fname + "';");
				out.println("window.close();");
				out.println("</script>");
	        } else {
	            out.println("<h1>enctype이 multipart/form-data가  아님</h1>");
	        }
	    }	      
	 private String extractFileName(String partHeader) {
	        for (String cd : partHeader.split(";")) {
	            if (cd.trim().startsWith("filename")) {
	                String fileName = cd.substring(cd.indexOf("=") +  1).trim().replace("\"", "");;
	                int index = fileName.lastIndexOf(File.separator);
	                return fileName.substring(index + 1);
	            }
	        }
	        return null;
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
