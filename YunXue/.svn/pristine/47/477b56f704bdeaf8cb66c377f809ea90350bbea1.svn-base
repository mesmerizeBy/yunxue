package yunxue.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yunxue.dao.StuUserOp;
import yunxue.dao.TeaUserOp;
import yunxue.dao.UserDao;
import yunxue.mo.UserMo;

/**
 * Servlet implementation class CheckPhone
 */
@WebServlet("/CheckPhone.do")
public class CheckPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPhone() {
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
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		String regPhone=request.getParameter("userPhone");
		String identity=request.getParameter("type");
		UserMo user = new UserMo();
		UserDao stu = new StuUserOp();
		UserDao tea = new TeaUserOp();
		user.setUserPhone(regPhone);
		
		System.out.println(identity);
		System.out.println(regPhone);
		
		if(identity.equals("S")) {
			//学生判断
			int flag = 0;
			try {
				flag = stu.querryUser(user);//查询学生表
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(flag == 1) {
				out.print("yes");
				out.flush();
				out.close();
				return;
			}
			flag = 0;
			
			try {
				flag = tea.querryUser(user);//查询教师表
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(flag == 1) {
				out.print("yes1");
				out.flush();
				out.close();
				return;
			}
		}else {
			//教师判断
			int flag = 0;
			try {
				flag = stu.querryUser(user);//查询学生表
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(flag == 1) {
				out.print("yes1");
				out.flush();
				out.close();
				return;
			}
			flag = 0;
			
			try {
				flag = tea.querryUser(user);//查询教师表
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(flag == 1) {
				out.print("yes");
				out.flush();
				out.close();
				return;
			}
		}
		
	}

}
