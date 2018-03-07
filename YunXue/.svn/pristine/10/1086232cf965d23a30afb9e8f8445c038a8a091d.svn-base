
package yunxue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import jdbc.util.jdbcUtil;
import jdbc.util.jdbcUtil2;
import yunxue.mo.ClassPlanMo;

public class ClassPlanDaoImpl {
	
	public void updateclassplan(int planNo) throws SQLException{
		String sql="update classPlan set planClassState='"+1+"' where planClassNo="+planNo;
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		qr.update(sql);
	}
	
	
	public void updateclassplan2(int planNo) throws SQLException{
		String sql="update classPlan set planClassState='"+0+"' where planClassNo="+planNo;
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		qr.update(sql);
	}
	
	
	public void insetUpdate(int teacherno,String classdate,String classtime) throws SQLException{
		
		Connection conn = null;	
		conn = jdbcUtil2.getConnection();
		PreparedStatement stmt = null;
		String sql="insert classPlan(teacherNo,planClassDate,planClassTime,planClassState)"
				+ " values(?,?,?,'0')";
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, teacherno);
			stmt.setString(2, classdate);
			stmt.setString(3, classtime);
			stmt.executeUpdate();
		}finally{
			jdbcUtil2.closeStatement(stmt);
			jdbcUtil2.closeConnection(conn);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ClassPlanMo> classNo(int teacherno) throws SQLException{
		List<ClassPlanMo> classno=new ArrayList<ClassPlanMo>();
     	QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
        String sql = "select * from classPlan where teacherNo="+teacherno;
        classno = (List<ClassPlanMo>) qr.query(sql, new BeanListHandler(ClassPlanMo.class));
	    return classno;
	}

}
