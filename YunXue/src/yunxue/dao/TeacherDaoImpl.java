package yunxue.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import yunxue.dao.TeacherDao;
import yunxue.mo.TeacherMo;
import jdbc.util.jdbcUtil;


public class TeacherDaoImpl implements TeacherDao {

	@SuppressWarnings("unchecked")
	public List<TeacherMo> getBasicTeachersInfo(int pageCount, int pageSize) throws SQLException{
		
		List<TeacherMo> teacherlist=new ArrayList<TeacherMo>();
		if (pageCount < 1 || pageSize < 1) {
			return null;
		}
		
		String sql="select top " + pageSize + " teacherNo,tPicture,tName,tSex,tSchool,teacherSatisfaction"
				+ ",teacherStage,teacherClasses,tEducation" + " from teacher_info" + " where teacherNo not in"
				+ " (select top " + (pageCount - 1) * pageSize + " teacherNo from teacher_info)";
		try{
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		 teacherlist= (List<TeacherMo>) qr.query(sql,new BeanListHandler(TeacherMo.class));
	
		}catch(Exception e){
			 e.printStackTrace();
		}
		return teacherlist;
	}
	
	
	
	public int getTeacherCount() throws SQLException{
		int teacherNum=0;
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
	    String sql = "SELECT COUNT(*) FROM teacher_info";
	    Number count = (Number) qr.query(sql,new ScalarHandler());//必须这样写,然后再转换
	    teacherNum = count.intValue();
	    return teacherNum;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<TeacherMo> getTeacher()  throws SQLException{
		List<TeacherMo> teacherlist=new ArrayList<TeacherMo>();
		String sql="select top 4 teacherNo,tPicture,tName,tSchool,teacherClasses"+" from teacher_info"
			    +" order by NEWID()";
		try{
			QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
			 teacherlist= (List<TeacherMo>) qr.query(sql,new BeanListHandler(TeacherMo.class));
		
			}catch(Exception e){
				 e.printStackTrace();
			}
		return teacherlist;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<TeacherMo> getBasicTeachersInfo(int pageCount, int pageSize, String name) throws SQLException{
		
		List<TeacherMo> teacherlist=new ArrayList<TeacherMo>();
		
		String sql="select top " + pageSize + " teacherNo,tPicture,tName,tSex,tSchool,teacherSatisfaction"
				+",teacherStage,teacherClasses,tEducation" + " from teacher_info" + " where tName like "+"'%"+name+"%'"
				+" and teacherNo not in"
				+ " (select top " + (pageCount-1) * pageSize + " teacherNo from teacher_info)";
		try{
			QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
			 teacherlist= (List<TeacherMo>) qr.query(sql,new BeanListHandler(TeacherMo.class));
		
			}catch(Exception e){
				 e.printStackTrace();
			}
			return teacherlist;
	}
	
	
	//姓名查询下的教师人数
	public int getTeacherNameCount(String name)  throws SQLException{
		int teacherNum=0;
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql="select count(*) from teacher_info "
				+" where tName like '%"+name+"%'";
		Number count = (Number) qr.query(sql,new ScalarHandler());
		teacherNum = count.intValue();
		return teacherNum;
	}



	public TeacherMo getDetailTeachersInfo(int teacherNo) throws Exception {
		// TODO 自动生成的方法存根
		QueryRunner qr = new QueryRunner(jdbcUtil.getDataSource());
		String sql = "select * from teacher_info where teacherNo="+teacherNo;
		TeacherMo teaMo = (TeacherMo) qr.query(sql,new BeanHandler(TeacherMo.class));
		return teaMo;
	}
	
}
