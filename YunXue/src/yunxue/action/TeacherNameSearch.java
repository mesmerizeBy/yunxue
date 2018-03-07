package yunxue.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.util.PageBean;
import yunxue.dao.TeacherDao;
import yunxue.dao.TeacherDaoImpl;
import yunxue.mo.TeacherMo;

/**
 * Servlet implementation class TeacherNameSearch
 */
@WebServlet("/font/teachernamequery.do")
public class TeacherNameSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherNameSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		        String name=request.getParameter("search1");
		//分页显示教师信息
		       
			    String curPage = request.getParameter("curPage"); // 当前页
				int intPage = 1;
				try {
					intPage = Integer.parseInt(curPage);
				} catch (NumberFormatException e) {
					intPage = 1;
					// e.printStackTrace();
				}
				PageBean<TeacherMo> pagebean=new PageBean<TeacherMo>();
				TeacherDao teacherdao=new TeacherDaoImpl();
				int rowCount = 0;
				List<TeacherMo> teacherlist=null;
				try{
					if(name==null){
					rowCount=teacherdao.getTeacherCount();
					pagebean.setPageSize(4); // 设置每页显示记录数量
					pagebean.setRowCount(rowCount);// 设置总记录数
					pagebean.setCurrentPage(intPage);// 设置当前页
					
						teacherlist=teacherdao.getBasicTeachersInfo(pagebean.getCurrentPage(),4);
					}
					else{
						rowCount=teacherdao.getTeacherNameCount(name);
						pagebean.setPageSize(4); 
						pagebean.setRowCount(rowCount);
						pagebean.setCurrentPage(intPage);
					teacherlist=teacherdao.getBasicTeachersInfo(pagebean.getCurrentPage(),4,name);
					}
					
					pagebean.setPageList(teacherlist);
					request.setAttribute("pagebean", pagebean);
					
				} catch (SQLException e) {
					 teacherlist= null;
					e.printStackTrace();
				}
				
				HttpSession session =request.getSession();
				session.setAttribute("name",name);
				
				//特色教师 信息	
				TeacherDao teacherdao2=new TeacherDaoImpl();
				List<TeacherMo> teacherList2=null;
				try{
					teacherList2=teacherdao2.getTeacher();
					
				}catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("teacherlist2", teacherList2);
				RequestDispatcher rd =request.getRequestDispatcher("/font/teacher_query.jsp");
				rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
