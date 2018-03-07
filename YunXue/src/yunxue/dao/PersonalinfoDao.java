package yunxue.dao;

import java.sql.SQLException;
import java.util.List;

import yunxue.mo.StudentMo;
import yunxue.mo.TeacherTMo;
import yunxue.mo.TidentityMo;

public interface PersonalinfoDao {
	
	public boolean updatePersonal(StudentMo stu) throws SQLException;//更改学生信息
	
	public boolean insertTeacher(TidentityMo tea) throws SQLException;//更改教师认证信息
	
	public boolean updateTeacherT(TeacherTMo tea) throws SQLException;//更改教师信息
	
	public void updateTeacher2(TidentityMo tea) throws SQLException;//更改教师上课信息
	
	public TeacherTMo getTeacher(TeacherTMo tea)throws SQLException;//查询教师
	
	public StudentMo selectStuInfo(int stuno) throws SQLException;//查询学生信息
	
	public void stuState(int stuno) throws SQLException;//更改学生状态为0
	
	public void stuState2(int stuno) throws SQLException;//更改学生状态为1
	
    public void teacherState(int teacherno) throws SQLException;//更改教师状态为0
	
	public void teacherState2(int teacherno) throws SQLException;//更改教师状态为1

}
