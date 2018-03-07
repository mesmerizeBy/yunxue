package yunxue.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import org.apache.commons.dbutils.handlers.BeanHandler;
import java.sql.SQLException;

import yunxue.dao.BuyclassDao;
import yunxue.mo.BuyclassMo;
import yunxue.mo.StudentMo;
import jdbc.util.jdbcUtil;
import jdbc.util.jdbcUtil2;

public class BuyclassDaoImpl implements BuyclassDao {
	
	@SuppressWarnings("unchecked")
	public List<BuyclassMo> getBuyclassInfo(StudentMo stu,BuyclassMo buy)  throws SQLException{
		List<BuyclassMo> buyclasslist=new ArrayList<BuyclassMo>();
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="select * from buyclass where stuNo="+stu.getStuNo()+" and buyState="+buy.getBuyState();
		buyclasslist= (List<BuyclassMo>) qr.query(sql,new BeanListHandler(BuyclassMo.class));
		return buyclasslist;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<BuyclassMo> getBuyclassSingleInfo(StudentMo stu,BuyclassMo buy)  throws SQLException{
		List<BuyclassMo> buyclasslist=new ArrayList<BuyclassMo>();
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="select * from buyclass where stuNo="+stu.getStuNo()+" and buyNo="+buy.getBuyNo()
		            +" and buyState="+buy.getBuyState();
		buyclasslist = (List<BuyclassMo>) qr.query(sql,new BeanHandler(BuyclassMo.class));
		return buyclasslist;
	}
	
	
	public int selectStuMoney(StudentMo stu) throws SQLException{
		int stuMoney=0;
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="select isnull(stuMoney,0) from studentT where stuNo="+stu.getStuNo();
		StudentMo stu1 = (StudentMo) qr.query(sql,new BeanHandler(StudentMo.class));
	    stuMoney=stu1.getStuMoney();
		return stuMoney;
	}
	
	
	public void deleteInfo(BuyclassMo buy) throws SQLException{
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="delete from buyclass where buyNo=?";
		qr.update(sql, buy.getBuyNo());
	}
	
	
	public void insertInfo(BuyclassMo buy,Connection conn) throws SQLException{
		PreparedStatement stmt = null;
		String sql="insert into buyclass(stuNo,buyStuStage,buyStuGrade,buyAmount,buyMoney,buyState)"
		+" values(?,?,?,?,?,?)";
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, buy.getStuNo());
			stmt.setString(2, buy.getBuyStuStage());
			stmt.setString(3, buy.getBuyStuGrade());
			stmt.setInt(4, buy.getBuyAmount());
			stmt.setInt(5, buy.getBuyMoney());
			stmt.setString(6,buy.getBuyState());
			stmt.executeUpdate();
		}finally{
			jdbcUtil2.closeStatement(stmt);
		}
	}
	
	
	public int orderClassNo(BuyclassMo buy)throws SQLException{
		Connection conn = null;	
		conn = jdbcUtil2.getConnection();
		conn.setAutoCommit(false);
		int buyNo=0;
		try{
			insertInfo(buy,conn);
			buyNo=selectBuyNo(buy,conn);
			conn.commit();
		}finally{
			jdbcUtil2.closeConnection(conn);
		}
		return buyNo;
	}
	
	
	public int selectBuyNo(BuyclassMo buy,Connection conn) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql="select top 1 buyNo from buyclass where stuNo="+buy.getStuNo()+" order by buyNo desc";
		int buyno=0;
		try{
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		if(rs.next()){
			buyno=rs.getInt(1);
		}	
		return buyno;
		}finally{
			jdbcUtil2.closeResultSet(rs);
			jdbcUtil2.closeStatement(stmt);
		}		
		
	}
	
	
	public boolean BuyClassSuccess(BuyclassMo buy) throws SQLException{
		boolean flag=false;
		String sql="update buyclass set buyState=? where buyNo="+buy.getBuyNo();
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		int rtn=qr.update(sql,"已支付");
		if(rtn==1){
			flag=true;
		}
		else{
			flag=false;
		}
		return flag;
	}
	
	
	public void updateStuMoney(StudentMo stu) throws SQLException{
		int money=selectStuMoney(stu)+stu.getStuMoney();
		String sql="update studentT set stuMoney="+money+" where stuNo="+stu.getStuNo();
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		qr.update(sql);
	}

}
