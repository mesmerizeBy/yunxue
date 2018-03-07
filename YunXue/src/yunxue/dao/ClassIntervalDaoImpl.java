package yunxue.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.sql.SQLException;

import jdbc.util.jdbcUtil;
import yunxue.mo.ClassIntervalMo;

public class ClassIntervalDaoImpl {
	

	
	public ClassIntervalMo FindDateTime(int intervalNo) throws SQLException{
		ClassIntervalMo datetime=new ClassIntervalMo();
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="select * from ClassInterval where intervalNo="+intervalNo;
		datetime=(ClassIntervalMo) qr.query(sql, new BeanHandler(ClassIntervalMo.class));
		return datetime;
	}
	
}
