package yunxue.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yunxue.dao.PersonalinfoDao;
import yunxue.dao.PersonalinfoDaoImpl;
import yunxue.mo.TidentityMo;
import yunxue.mo.UserMo;

/**
 * Servlet implementation class Tidentity0
 */
@WebServlet("/tidentity0.do")
public class Tidentity0 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tidentity0() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession();
		UserMo s=(UserMo) session.getAttribute("tealoginer");
		int teacherNo=s.getUserNo();
		String tPicture=request.getParameter("imgurl");
		String tName=request.getParameter("tname");
		String year=request.getParameter("year");
		int tAge=2017-Integer.parseInt(year);
		String tSex=request.getParameter("sex");
		String tEducation=request.getParameter("tEducation");
		String tSchool=request.getParameter("tschool");
		String tMajor=request.getParameter("tmajor");
		String tArea=request.getParameter("tarea");
		String tDescription=request.getParameter("tDescription");
		String tExperience=request.getParameter("tExperience");
		PrintWriter out=response.getWriter();
		try{
			PersonalinfoDao personal=new PersonalinfoDaoImpl();
			TidentityMo tt=new TidentityMo();
			tt.setTeacherNo(teacherNo);
			tt.settPicture(tPicture);
			tt.settName(tName);
			tt.settAge(tAge);
			tt.settSex(tSex);
			tt.settEducation(tEducation);
			tt.settSchool(tSchool);
			tt.settMajor(tMajor);
			tt.settArea(tArea);
			tt.settDescription(tDescription);
			tt.settExperience(tExperience);
			boolean flag=personal.insertTeacher(tt);

			if(flag==true){

				out.print("ok");
			}
			
		}catch(SQLException e){  	   
		       e.printStackTrace();
	       }
		
		out.flush();
	    out.close();
		
	}

}
