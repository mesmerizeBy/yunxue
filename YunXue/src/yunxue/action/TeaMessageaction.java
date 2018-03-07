package yunxue.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yunxue.dao.TeacherDao;
import yunxue.dao.TeacherDaoImpl;
import yunxue.mo.TeacherMo;

/**
 * Servlet implementation class TeaMessageaction
 */
@WebServlet("/TeaMessage.do")
public class TeaMessageaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaMessageaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teaNo = request.getParameter("teacherNo");
		int teacherNo=Integer.parseInt(teaNo);
		TeacherDao teaOp = new TeacherDaoImpl();
		TeacherMo teaMo = new TeacherMo();
		try {
			teaMo = teaOp.getDetailTeachersInfo(teacherNo);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("teacherMes",teaMo);
		request.getRequestDispatcher("/font/teacherMessage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
