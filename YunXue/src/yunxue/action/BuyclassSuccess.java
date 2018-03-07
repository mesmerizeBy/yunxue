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

import yunxue.mo.StudentMo;
import yunxue.mo.UserMo;
import yunxue.mo.BuyclassMo;
import yunxue.dao.BuyclassDaoImpl;

/**
 * Servlet implementation class BuyclassSuccess
 */
@WebServlet("/BuyclassSuccess.do")
public class BuyclassSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyclassSuccess() {
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
		String money=request.getParameter("bi");
		String no=request.getParameter("buyno");
		int stuMoney=Integer.parseInt(money);
		int buyNo=Integer.parseInt(no);

		PrintWriter out=response.getWriter();
		try{
			
			StudentMo stu=new StudentMo();
			stu.setStuNo(stuNo);
		    stu.setStuMoney(stuMoney);
		    BuyclassMo buy=new BuyclassMo();
		    buy.setBuyNo(buyNo);
		    BuyclassDaoImpl buyclass=new BuyclassDaoImpl();
		    boolean flag=buyclass.BuyClassSuccess(buy);
		    buyclass.updateStuMoney(stu);
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
