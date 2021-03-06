package yunxue.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yunxue.dao.ClassDao;
import yunxue.dao.ClassDaoImpl;
import yunxue.dao.PersonalinfoDao;
import yunxue.dao.PersonalinfoDaoImpl;
import yunxue.mo.ClassResume;
import yunxue.mo.StudentMo;
import yunxue.mo.UserMo;

/**
 * Servlet implementation class StuPersonalFirst
 */
@WebServlet("/stuPersonalFirst.do")
public class StuPersonalFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuPersonalFirst() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		UserMo s=(UserMo) session.getAttribute("stuloginer");
		int stuNo=s.getUserNo();
		System.out.println(stuNo);
		StudentMo stu=new StudentMo();
		PersonalinfoDao personal=new PersonalinfoDaoImpl();
		ClassDao stuClass=new ClassDaoImpl();
		List<ClassResume> classmo=new ArrayList<ClassResume>();
		List<ClassResume> classmo2=new ArrayList<ClassResume>();
		try{
			stu=personal.selectStuInfo(stuNo);
			classmo=stuClass.getStuFinishClass(stuNo);
			classmo2=stuClass.getStuTimetable(stuNo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("student", stu);
		request.setAttribute("classItem", classmo);
		request.setAttribute("timeTable", classmo2);
		request.getRequestDispatcher("/font/person_center.jsp").forward(request, response);
	}

}
