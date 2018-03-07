package yunxue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import yunxue.mo.UserMo;
import jdbc.util.jdbcUtil2;
public class StuUserOp implements UserDao{
		
	/* （非 Javadoc）
	 * 学生密码验证
	 */
	public int checkUser(UserMo userMo) throws Exception {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		int flag = 0; // 用户名或者密码为空
		String stuPh = userMo.getUserPhone();
		String stuPw = userMo.getUserPwd();

		try{
		conn = jdbcUtil2.getConnection();
		String sql = "select stuPhone,stuPwd from studentT where stuPhone = '"+ stuPh +"'";
		st = conn.createStatement();
		rs = st.executeQuery(sql);

		if (rs.next() && stuPw.equals(rs.getString(2))) {
		    flag = 1;// 正确
		} else {
			flag = 2; // 用户名或者密码出错
		}

		return flag;
		}finally {
			jdbcUtil2.closeResultSet(rs);
			jdbcUtil2.closeStatement(st);
			jdbcUtil2.closeConnection(conn);

		}
	}

	
	/* （非 Javadoc）
	 * 获取登陆用户信息
	 */
	@Override
	public UserMo getUser(UserMo stu) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		UserMo uMo=null; // 用户名或者密码为空
		String stuPh = stu.getUserPhone();

		try{
		conn = jdbcUtil2.getConnection();
		String sql = "SELECT stuNo,stuName,stuPwd,stuPhone FROM studentT where stuPhone='" + stuPh + "'";
		st = conn.createStatement();
		rs = st.executeQuery(sql);

		if (rs.next()) {  //创建一个对象记住该用户的信息
			uMo=new UserMo(); 
			uMo.setUserNo(rs.getInt(1));
			uMo.setUserName(rs.getString(2));
			uMo.setUserPwd(rs.getString(3));
			uMo.setUserPhone(rs.getString(4));
		} else {
			uMo = null; // 没有找到该用户
		}

		return uMo;
		}finally {
			jdbcUtil2.closeResultSet(rs);
			jdbcUtil2.closeStatement(st);
			jdbcUtil2.closeConnection(conn);

		}
	}
	

	/* （非 Javadoc）
	 * @see yunxue.dao.UserDao#querryUser(yunxue.mo.StuUser)
	 * 查询号码是否存在
	 */
	public int querryUser(UserMo userMo) throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		int flag = 0; // 用户名或者密码为空h
		String stuPho = userMo.getUserPhone();

		try{
		conn = jdbcUtil2.getConnection();
		String sql = "SELECT * FROM studentT WHERE stuPhone='" + stuPho+"'"  ;//必须加上引号
		st = conn.createStatement();
		rs = st.executeQuery(sql);
        
		if (rs.next()) {
			flag = 1;// 存在
		} else {
			flag = 2; // 不存在该电话号码
		}	
		return flag;
		
		} 
		finally {
			jdbcUtil2.closeResultSet(rs);
			jdbcUtil2.closeStatement(st);
			jdbcUtil2.closeConnection(conn);
		}
	}
	
	
	/**
	 * 密码重置
	 */
	public boolean resetPWD(String name,String oldPWD,String newPWD) throws SQLException {
		boolean flag=false;
		//
		Connection conn=jdbcUtil2.getConnection();
		String sql="update customerT "+
				"set cust_pwd=? "+
				"where cust_no=? and cust_pwd=? ";
		
		PreparedStatement  st=conn.prepareStatement(sql);
		//参数赋值
		st.setString(1, newPWD);
		st.setString(2, name);	
		st.setString(3, oldPWD);
		
		int cnt=st.executeUpdate();
		if (cnt==1) flag=true; 
		
		return flag;	
		
	}
	

	/* （非 Javadoc）
	 * @see yunxue.dao.UserDao#regietsrUser(yunxue.mo.UserMo)
	 * 用户注册
	 */
	@Override
	public void regietsrUser(UserMo userMo) throws SQLException {
		// TODO 自动生成的方法存根
		Connection conn = null;
		Statement st = null;

		String stuPho = userMo.getUserPhone();
		String stuPw = userMo.getUserPwd();
		try{
		conn = jdbcUtil2.getConnection();
		String sql = "INSERT INTO studentT(stuPhone,stuPwd) VALUES('" + stuPho + "','" + stuPw + "')";
		st = conn.createStatement();
		st.executeUpdate(sql);
		}finally {
			jdbcUtil2.closeStatement(st);
			jdbcUtil2.closeConnection(conn);

		}
	}


}
