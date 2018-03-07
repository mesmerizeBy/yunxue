package jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class jdbcUtil {
	// 创建c3p0连接池，并加载配置文件

		private static ComboPooledDataSource cpds;
		static {
			cpds = new ComboPooledDataSource();
		}
		/**
		 * 从连接池中获取连接
		 * 
		 * @return conn（Connection对象）
		 */
		public synchronized  static  Connection getConnection() throws SQLException {
			Connection conn =  cpds.getConnection();

			return conn;
		}
		
		public static DataSource getDataSource() {
			        return cpds;
			    }

		// 关闭操作
		public static void closeConnection(Connection con) throws SQLException {
			if (con != null) {
				con.close();
			}
		}

		public static void closeStatement(Statement st) throws SQLException {
			if (st != null) {
				st.close();
			}
		}

		public static void closeResultSet(ResultSet rs) throws SQLException {
			if (rs != null) {
				rs.close();
			}
		}
}
