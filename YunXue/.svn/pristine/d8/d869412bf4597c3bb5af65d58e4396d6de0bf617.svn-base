package yunxue.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yunxue.dao.ClassPlanDaoImpl;

/**
 * Servlet implementation class Tidentity2
 */
@WebServlet("/tidentity2.do")
public class Tidentity2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tidentity2() {
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
        
		String classno=request.getParameter("classno");
		String check=request.getParameter("check");
		int classNo=Integer.parseInt(classno);
		PrintWriter out =response.getWriter();
		ClassPlanDaoImpl classplan=new ClassPlanDaoImpl();
		try{
			if(check.equals("0")){
				classplan.updateclassplan(classNo);
				out.print("1");
			    out.flush();
				out.close();
			}
			else{
				classplan.updateclassplan2(classNo);
				out.print("0");
			    out.flush();
				out.close();
			}
			
		}catch(SQLException e){  	   
		       e.printStackTrace();
	       }
		
		
	}

}
