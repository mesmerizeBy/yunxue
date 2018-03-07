package yunxue.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yunxue.mo.UserMo;

/**
 * Servlet implementation class BuyclassFirst
 */
@WebServlet("/BuyclassFirst.do")
public class BuyclassFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyclassFirst() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
	    UserMo s=(UserMo) session.getAttribute("stuloginer");
		UserMo s1=(UserMo) session.getAttribute("tealoginer");

		if(s!=null){
			response.sendRedirect(request.getContextPath()+"/font/buyclass.jsp");
		}
		else if(s1!=null){
			boolean error=true;
			request.setAttribute("error", error);
			request.getRequestDispatcher("/font/index.jsp").forward(request, response);
		}
		else{
			response.sendRedirect(request.getContextPath()+"/font/buyclass.jsp");
		}
	}

}
