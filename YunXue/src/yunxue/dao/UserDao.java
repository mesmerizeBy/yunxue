package yunxue.dao;

import java.sql.SQLException;
import yunxue.mo.UserMo;

public interface UserDao {
	
	public int querryUser(UserMo userMo) throws SQLException;
	public void regietsrUser(UserMo userMo) throws SQLException;
	public int checkUser(UserMo userMo) throws Exception;
	public UserMo getUser(UserMo stu) throws Exception;
    public boolean resetPWD(String name,String oldPWD,String newPWD) throws SQLException ;
}