package yunxue.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import yunxue.mo.TeaUser;
import yunxue.mo.UserMo;
import jdbc.util.jdbcUtil2;

public class TeaUserOp  implements UserDao {

	/* （非 Javadoc）
	 * 查询是否存在号码
	 */
	@Override
	public int querryUser(UserMo userMo) throws SQLException {
		// TODO 自动生成的方法存根
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		int flag = 0; // 用户名或者密码为空h
		String teacherPho = userMo.getUserPhone();

		try{
		conn = jdbcUtil2.getConnection();
		String sql = "SELECT * FROM teacherT WHERE teacherPhone='" + teacherPho+"'"  ;//必须加上引号
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

	/* （非 Javadoc）
	 * 插入号码密码
	 */
	@Override
	public void regietsrUser(UserMo userMo) throws SQLException {
		// TODO 自动生成的方法存根
		Connection conn = null;
		Statement st = null;

		String teaPho = userMo.getUserPhone();
		String teaPw = userMo.getUserPwd();
		
		try{
		// 连接数据库服务器
		conn = jdbcUtil2.getConnection();
		// sql语句
		String sql = "INSERT INTO teacherT(teacherPhone,teacherPwd) VALUES('" + teaPho + "','" + teaPw + "')";
		// 创建statement对象
		st = conn.createStatement();
		// 发送查询语句
		st.executeUpdate(sql);
		}finally {
			// 释放资源
			jdbcUtil2.closeStatement(st);
			jdbcUtil2.closeConnection(conn);

		}
	}

	/* （非 Javadoc）
	 * 检查密码
	 */
	@Override
	public int checkUser(UserMo userMo) throws Exception {
		// TODO 自动生成的方法存根
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		int flag = 0; // 用户名或者密码为空
		String teacherPh = userMo.getUserPhone();
		String teacherPw = userMo.getUserPwd();

		try{
		conn = jdbcUtil2.getConnection();
		String sql = "select teacherPhone,teacherPwd from teacherT where teacherPhone = '"+ teacherPh +"'";
		st = conn.createStatement();
		rs = st.executeQuery(sql);

		if (rs.next() && teacherPw.equals(rs.getString(2))) {
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

	@Override
	public UserMo getUser(UserMo stu) throws Exception {
		// TODO 自动生成的方法存根
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		UserMo uMo=null; // 用户名或者密码为空
		String stuPh = stu.getUserPhone();

		try{
		conn = jdbcUtil2.getConnection();
		String sql = "SELECT teacherNo,teacherName,teacherPwd,teacherPhone FROM teacherT where teacherPhone='" + stuPh + "'";
		st = conn.createStatement();
		rs = st.executeQuery(sql);

		if (rs.next()) {  //创建一个对象记住该用户的信息
			uMo=new TeaUser(); 
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

	@Override
	public boolean resetPWD(String name, String oldPWD, String newPWD) throws SQLException {
		// TODO 自动生成的方法存根
		return false;
	}
	
}
