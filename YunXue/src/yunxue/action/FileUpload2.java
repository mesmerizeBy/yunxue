package yunxue.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.util.UploadUtil;

/**
 * Servlet implementation class FileUpload2
 */
@WebServlet("/admin/fileUpload2.do")
public class FileUpload2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UploadUtil util=new UploadUtil(this, request);
		
		String fosPath="";
		try{
			fosPath="IMG/teacherIMG/"+util.processUploadedFile("userlogo", "IMG/teacherIMG");
			
		}catch(Exception e){
			e.printStackTrace();
			return;
		}
		String basePath = request.getContextPath()+"/";
	    PrintWriter out=response.getWriter();
		    out.print(basePath+fosPath);
	}

}
