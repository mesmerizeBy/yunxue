package yunxue.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yunxue.dao.ClassPlanDaoImpl;
import yunxue.mo.ClassPlanMo;
import yunxue.mo.UserMo;

/**
 * Servlet implementation class TidentityStep3
 */
@WebServlet("/TidentityStep3.do")
public class TidentityStep3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TidentityStep3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		UserMo s=(UserMo) session.getAttribute("tealoginer");
		int teacherNo=s.getUserNo();
		List<ClassPlanMo> classno =new ArrayList<ClassPlanMo>();
		ClassPlanDaoImpl classplan=new ClassPlanDaoImpl();
		try{
		classno=classplan.classNo(teacherNo);
		
		}catch(SQLException e){  	   
		       e.printStackTrace();
	       }
	    request.setAttribute("classno", classno);
	    request.getRequestDispatcher("/font/tIdentityStep3.jsp").forward(request, response);
	}

}
