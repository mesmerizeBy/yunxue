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

import yunxue.dao.ClassIntervalDaoImpl;
import yunxue.dao.ClassPlanDaoImpl;
import yunxue.dao.PersonalinfoDao;
import yunxue.dao.PersonalinfoDaoImpl;
import yunxue.dao.StuUserOp;
import yunxue.dao.TeaUserOp;
import yunxue.dao.UserDao;
import yunxue.mo.ClassIntervalMo;
import yunxue.mo.StuUser;
import yunxue.mo.UserMo;

/**
 * Servlet implementation class PersonRegister
 */
@WebServlet("/Register.do")
public class PersonRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();//字符流必须在后方，
		String identity = request.getParameter("type");
		String uPhone = request.getParameter("userPhone");
		String pWord = request.getParameter("passWord");
		UserMo user = new StuUser();
		UserDao stu = new StuUserOp();
		UserDao tea = new TeaUserOp();
		user.setUserPhone(uPhone);
		user.setUserPwd(pWord);
		HttpSession session = request.getSession();
		
		if(identity.equals("S")) {
			//学生注册
		    try {
				stu.regietsrUser(user);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		    
		    UserMo stuUser = null;
			try {
				stuUser = stu.getUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int stuNo=stuUser.getUserNo();
			PersonalinfoDao person2=new PersonalinfoDaoImpl();
			try{
				person2.stuState(stuNo);//学生状态改为0
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		    
		    session.setAttribute("phone", uPhone);
		    out.print("success");
		    out.flush();
			out.close();
			return;   
		}else {
			//教师注册
			try {
				tea.regietsrUser(user);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}	

			session.setAttribute("phone", uPhone);
			UserMo teaUser = null;
			try {
				teaUser = tea.getUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int teacherNo = teaUser.getUserNo();
			ClassIntervalDaoImpl intervalClass=new ClassIntervalDaoImpl();
			ClassPlanDaoImpl plan=new ClassPlanDaoImpl();
			ClassIntervalMo datetime=null;
			int intervalNo=0;
			String classdate="";
			String classtime="";
			
			PersonalinfoDao person=new PersonalinfoDaoImpl();
			try{
				person.teacherState(teacherNo);//教师状态改为0
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			for(int i=101;i<136;i++){   //生成教师开课计划表。初始状态为0

				intervalNo=i;
				try {
					datetime=intervalClass.FindDateTime(intervalNo);
					classdate=datetime.getIntervalDate();
					classtime=datetime.getIntervalTime();
					plan.insetUpdate(teacherNo, classdate, classtime);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		    out.print("success");
		    out.flush();
			out.close();
			return;   
		}
	
	}
}
