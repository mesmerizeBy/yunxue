package yunxue.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import yunxue.mo.BuyclassMo;
import yunxue.mo.StudentMo;


public interface BuyclassDao {
	
	public List<BuyclassMo> getBuyclassInfo(StudentMo stu,BuyclassMo buy)  throws Exception;//查询用户的所有购买课时订单信息
	
	public List<BuyclassMo> getBuyclassSingleInfo(StudentMo stu,BuyclassMo buy)  throws SQLException;//查询单笔订单信息
	
	public void insertInfo(BuyclassMo buy,Connection conn) throws Exception;//生成购买课时订单
	
	public int orderClassNo(BuyclassMo buy)throws SQLException;
	
	public void deleteInfo(BuyclassMo buy) throws Exception;//由购买课时订单号删除订单
	
	public int selectStuMoney(StudentMo stu) throws Exception;//由学生号查询学生虚拟币数额
	
	public int selectBuyNo(BuyclassMo buy,Connection conn) throws Exception;//查询订单号
	
	public boolean BuyClassSuccess(BuyclassMo buy) throws Exception;//购买成功修改订单状态为已支付
	
	public void updateStuMoney(StudentMo stu) throws Exception;//修改学生虚拟币数额

}
