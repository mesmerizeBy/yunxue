package yunxue.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yunxue.mo.BuyclassMo;
import yunxue.mo.UserMo;
import yunxue.dao.BuyclassDaoImpl;
/**
 * Servlet implementation class BuyclassOrder
 */
@WebServlet("/BuyclassOrder.do")
public class BuyclassOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyclassOrder() {
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
		String buyStuStage=request.getParameter("box1");
		String buyStuGrade=request.getParameter("box2");
		String Amount=request.getParameter("box3");
		String Money=request.getParameter("box4");
		String Amount2=request.getParameter("box8");
		String bi=request.getParameter("box5");
		String bi2=request.getParameter("box10");

		int buyMoney=Integer.parseInt(Money);
	 	int yunbi=Integer.parseInt(bi)+Integer.parseInt(bi2);
		int buyAmount=Integer.parseInt(Amount)+Integer.parseInt(Amount2);
	    try{
	    	
		    BuyclassMo buy=new BuyclassMo();
		    buy.setStuNo(stuNo);
		    buy.setBuyStuStage(buyStuStage);
		    buy.setBuyStuGrade(buyStuGrade);
		    buy.setBuyAmount(buyAmount);
		    buy.setBuyMoney(buyMoney);
		    buy.setBuyState("未支付");
		
		    BuyclassDaoImpl buyclass=new BuyclassDaoImpl();
		    int buyno=buyclass.orderClassNo(buy);
		    boolean flag=false;
		    if(buyno!=0){
		    	 flag=true;
		    }
		    request.setAttribute("buyNo", buyno);
		    request.setAttribute("flag", flag);
		    request.setAttribute("buymoney", buyMoney);
		    request.setAttribute("yunbi", yunbi);
	       }catch(SQLException e){  	   
		       e.printStackTrace();
	       }
	    
	    request.getRequestDispatcher("/font/buyclass.jsp").forward(request, response);
	 
	}

}
