package yunxue.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yunxue.dao.PersonalinfoDaoImpl;
import yunxue.mo.StudentMo;
import yunxue.mo.UserMo;

/**
 * Servlet implementation class StuPersonal
 */
@WebServlet("/StuPersonal.do")
public class StuPersonal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuPersonal() {
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
		UserMo s=(UserMo) session.getAttribute("stuloginer");
		int stuNo=s.getUserNo();
		String stuImg=request.getParameter("imgurl");
		String stuName=request.getParameter("personName");
		String stuSex=request.getParameter("sex");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String stuStage=request.getParameter("stage");
		String stuSchool=request.getParameter("personSchool");
		String stuBirth=year+"-"+month;
		if(stuImg==null){
			stuImg="0";
		}
		if(stuName==null){
			stuName="0";
		}
		if(stuSex==null){
			stuSex="0";
		}
		if(stuSex.equals("1")){
			stuSex="男";
		}
		if(stuSex.equals("0")){
			stuSex="女";
		}
		if(year==null){
			year="0";
		}
		if(stuStage==null){
			stuStage="0";
		}
		if(stuSchool==null){
			stuSchool="0";
		}
		if(month==null){
			month="0";
		}
		try{
			StudentMo stu=new StudentMo();
			stu.setStuNo(stuNo);
			stu.setStuImg(stuImg);
			stu.setStuName(stuName);
			stu.setStuSex(stuSex);
			stu.setStuBirth(stuBirth);
			stu.setStuStage(stuStage);
			stu.setStuSchool(stuSchool);
			PersonalinfoDaoImpl personal=new PersonalinfoDaoImpl();
			boolean flag=personal.updatePersonal(stu);
			if(flag==true){
				response.sendRedirect(request.getContextPath()+"/stuPersonalFirst.do");
			}
			
		}catch(SQLException e){  	   
		       e.printStackTrace();
	       }
	}

}
