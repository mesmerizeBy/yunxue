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
import yunxue.dao.PersonalinfoDao;
import yunxue.dao.PersonalinfoDaoImpl;
import yunxue.dao.TeacherDao;
import yunxue.dao.TeacherDaoImpl;
import yunxue.mo.ClassPlanMo;
import yunxue.mo.TeacherMo;
import yunxue.mo.TeacherTMo;
import yunxue.mo.UserMo;

/**
 * Servlet implementation class Tidentity2
 */
@WebServlet("/Tidentity3.do")
public class Tidentity3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tidentity3() {
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
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session =request.getSession();
		UserMo s=(UserMo) session.getAttribute("tealoginer");
		int teacherNo=s.getUserNo();
		String []stage=request.getParameterValues("stage");
		String []subject=request.getParameterValues("subject");
		String teacherClasses="";
		String teacherStage="";
		List<ClassPlanMo> classno =new ArrayList<ClassPlanMo>();
		ClassPlanDaoImpl classplan=new ClassPlanDaoImpl();
		TeacherDao tt2=new TeacherDaoImpl();
		TeacherMo tea=new TeacherMo();
		for(int i=0;i<subject.length;i++){
			teacherClasses+=subject[i]+"&nbsp;&nbsp;";
		}
		for(int i=0;i<stage.length;i++){
			teacherStage+=stage[i]+"&nbsp;&nbsp;";
		}
		
		try{
		    TeacherTMo tt=new TeacherTMo();
		    PersonalinfoDao person=new PersonalinfoDaoImpl();
		    tt.setTeacherStage(teacherStage);
		    tt.setTeacherNo(teacherNo);
	     	tt.setTeacherClasses(teacherClasses);
		    person.updateTeacherT(tt);
		    classno=classplan.classNo(teacherNo);
			tea=tt2.getDetailTeachersInfo(teacherNo);
		}catch(SQLException e){  	   
		       e.printStackTrace();
	       } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PersonalinfoDao person=new PersonalinfoDaoImpl();
		try{
			person.teacherState2(teacherNo);//教师状态改为1
			
		}catch (SQLException e) {
			e.printStackTrace();
		}

			request.setAttribute("teacher", tea);
		    request.setAttribute("classno", classno);

		//重定向到教师个人中心
		request.getRequestDispatcher("/font/teacherCenter.jsp").forward(request, response);
	}
	
}
