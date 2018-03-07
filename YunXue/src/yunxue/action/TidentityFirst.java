package yunxue.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
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
 * Servlet implementation class TidentityFirst
 */
@WebServlet("/tidentityFirst.do")
public class TidentityFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TidentityFirst() {
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
		
		HttpSession session =request.getSession();
		UserMo s=(UserMo) session.getAttribute("tealoginer");
		int teacherNo=s.getUserNo();
		TeacherTMo tea2=null;
		PersonalinfoDao personal=new PersonalinfoDaoImpl();
		String teacherState="";
		
		
		try{
			TeacherTMo tea1=new TeacherTMo();
			tea1.setTeacherNo(teacherNo);
			tea2=personal.getTeacher(tea1);
			teacherState=tea2.getTeacherState();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(teacherState.equals("1")){   //状态为1进入教师个人中心
			
			getClassMessage(request, response);
			request.getRequestDispatcher("/font/teacherCenter.jsp").forward(request, response);
		}
		else{   //状态为0进入教师认证信息页面
	     	request.getRequestDispatcher("/font/tIdentity.jsp").forward(request, response);
		}
	}
	
	/**
	 *获取教师信息到request域
	 */
	public void getClassMessage(HttpServletRequest request, ServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		UserMo s=(UserMo) session.getAttribute("tealoginer");
		int teacherNo=s.getUserNo();
		List<ClassPlanMo> classno =new ArrayList<ClassPlanMo>();
		ClassPlanDaoImpl classplan=new ClassPlanDaoImpl();
		TeacherDao tt2=new TeacherDaoImpl();
		TeacherMo tea=new TeacherMo();
		try{
		classno=classplan.classNo(teacherNo);
		tea=tt2.getDetailTeachersInfo(teacherNo);
		}catch(SQLException e){  	   
		       e.printStackTrace();
	       } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 request.setAttribute("teacher", tea); 
	    request.setAttribute("classno", classno); 
	}

}
