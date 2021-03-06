package yunxue.dao;

import java.sql.SQLException;
import java.util.List;
import yunxue.mo.TeacherMo;

public interface TeacherDao {

	public List<TeacherMo> getBasicTeachersInfo(int pageCount, int pageSize) throws SQLException;//基本教师信息
	public TeacherMo getDetailTeachersInfo(int teacherNo) throws Exception;//详细教师信息
	public int getTeacherCount()  throws SQLException;
	public List<TeacherMo> getTeacher()  throws SQLException;
	public List<TeacherMo> getBasicTeachersInfo(int pageCount, int pageSize, String name) throws SQLException;
	public int getTeacherNameCount(String name)  throws SQLException;

}
