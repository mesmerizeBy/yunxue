package yunxue.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.util.jdbcUtil;
import jdbc.util.jdbcUtil2;
import yunxue.mo.StudentMo;
import yunxue.mo.TeacherTMo;
import yunxue.mo.TidentityMo;

public class PersonalinfoDaoImpl implements PersonalinfoDao{
	
	public boolean updatePersonal(StudentMo stu) throws SQLException{
		boolean flag=false;
		String sql="update studentT set stuName='"+stu.getStuName()
		+"', stuImg='"+stu.getStuImg().trim()+"', stuSex='"+stu.getStuSex()
		+"', stuBirth='"+stu.getStuBirth()+"', stuStage='"+stu.getStuStage()
		+"', stuSchool='"+stu.getStuSchool()+"' where stuNo='"+stu.getStuNo()+"'";
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		int rtn=qr.update(sql);
		if(rtn==1){
			flag=true;
		}
		else{
			flag=false;
		}
		return flag;
	}
	
	
	public boolean insertTeacher(TidentityMo tea) throws SQLException{
		boolean flag=false;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try{
			conn = jdbcUtil2.getConnection();
			
		String sql="insert into tIdentify (teacherNo,tPicture,tName,tAge,tArea,tSchool,"
		+"tExperience,tSex,tDescription,tMajor,tEducation) values(?,?,?,?,?,?,?,?,?,?,?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, tea.getTeacherNo());
		pstmt.setString(2, tea.gettPicture().trim());
		pstmt.setString(3, tea.gettName());
		pstmt.setInt(4, tea.gettAge());
		pstmt.setString(5, tea.gettArea());
		pstmt.setString(6, tea.gettSchool());
		pstmt.setString(7, tea.gettExperience());
		pstmt.setString(8, tea.gettSex());
		pstmt.setString(9, tea.gettDescription());
		pstmt.setString(10, tea.gettMajor());
		pstmt.setString(11, tea.gettEducation());
		int rtn=pstmt.executeUpdate();
		if(rtn==1){
			flag=true;
		}
		else{
			flag=false;
		}
		}finally {
			jdbcUtil2.closeStatement(pstmt);
			jdbcUtil2.closeConnection(conn);

		}
		return flag;
	}
	
	
	public boolean updateTeacherT(TeacherTMo tea) throws SQLException{
		boolean flag=false;
		PreparedStatement pstmt = null;
		Connection conn = null;
	try{
		conn = jdbcUtil2.getConnection();	
		String sql="update teacherT set teacherClasses=?,teacherStage=?,teacherState=? where teacherNo=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, tea.getTeacherClasses());
		pstmt.setString(2, tea.getTeacherStage());
		pstmt.setString(3, tea.getTeacherState());
		pstmt.setInt(4, tea.getTeacherNo());
		int rtn=pstmt.executeUpdate();
		if(rtn==1){
			flag=true;
		}
		else{
			flag=false;
		}
		}finally {
			jdbcUtil2.closeStatement(pstmt);
			jdbcUtil2.closeConnection(conn);
		}
		return flag;
	}
	
	
	
	public void updateTeacher2(TidentityMo tea) throws SQLException{
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="update tIdentify set tIdcard='"+tea.gettIdcard().trim()+"',tIdcardImg='"
		          +tea.gettIdcardImg().trim()+"',tStudentcardImg='"+tea.gettStudentcardImg().trim()+
		          "' where teacherNo="+tea.getTeacherNo();
		qr.update(sql);
	}
	
	
	public TeacherTMo getTeacher(TeacherTMo tea)throws SQLException{
		TeacherTMo teacher=new TeacherTMo();
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="select * from teacherT where teacherNo="+tea.getTeacherNo();
		teacher= (TeacherTMo) qr.query(sql,new BeanHandler(TeacherTMo.class));
		return teacher;
	}
	
	

	public StudentMo selectStuInfo(int stuno) throws SQLException{
		StudentMo stu=new StudentMo();
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="select * from studentT where stuNo="+stuno;
		stu=(StudentMo) qr.query(sql,new BeanHandler(StudentMo.class));
		return stu;
	}
	
	
	public void stuState(int stuno) throws SQLException{
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="update studentT set stuState='"+0+"' where stuNo="+stuno;
		qr.update(sql);
	}
	
	
	public void stuState2(int stuno) throws SQLException{
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="update studentT set stuState='"+1+"' where stuNo="+stuno;
		qr.update(sql);
	}
	
	
	public void teacherState(int teacherno) throws SQLException{
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="update teacherT set teacherState='"+0+"' where teacherNo="+teacherno;
		qr.update(sql);
	}
	
	
	public void teacherState2(int teacherno) throws SQLException{
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="update teacherT set teacherState='"+1+"' where teacherNo="+teacherno;
		qr.update(sql);
	}
	

}
