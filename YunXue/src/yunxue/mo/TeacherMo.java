package yunxue.mo;


/*对应教师主要信息视图*/

public class TeacherMo {
	 
	 private int teacherNo;
     private String tPicture;
     private String tName;
     private String tSex;
     private int tAge;
     private String tSchool;
     private String teacherSatisfaction;
     private String teacherStyle;
     private String teacherStage;
     private String teacherClasses;
     private String tDescription;
     private String tMajor;
     private String tEducation;
     private String tExperience;
     
	public String gettExperience() {
		return tExperience;
	}
	public void settExperience(String tExperience) {
		this.tExperience = tExperience;
	}
	public String getTeacherStage() {
		return teacherStage;
	}
	public void setTeacherStage(String teacherStage) {
		this.teacherStage = teacherStage;
	}
	public int getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String gettPicture() {
		return tPicture;
	}
	public void settPicture(String tPicture) {
		this.tPicture = tPicture;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettSex() {
		return tSex;
	}
	public void settSex(String tSex) {
		this.tSex = tSex;
	}
	public int gettAge() {
		return tAge;
	}
	public void settAge(int tAge) {
		this.tAge = tAge;
	}
	public String gettSchool() {
		return tSchool;
	}
	public void settSchool(String tSchool) {
		this.tSchool = tSchool;
	}
	public String getTeacherSatisfaction() {
		return teacherSatisfaction;
	}
	public void setTeacherSatisfaction(String teacherSatisfaction) {
		this.teacherSatisfaction = teacherSatisfaction;
	}
	public String getTeacherStyle() {
		return teacherStyle;
	}
	public void setTeacherStyle(String teacherStyle) {
		this.teacherStyle = teacherStyle;
	}
	public String getTeacherClasses() {
		return teacherClasses;
	}
	public void setTeacherClasses(String teacherClasses) {
		this.teacherClasses = teacherClasses;
	}
	public String gettDescription() {
		return tDescription;
	}
	public void settDescription(String tDescription) {
		this.tDescription = tDescription;
	}
	public String gettMajor() {
		return tMajor;
	}
	public void settMajor(String tMajor) {
		this.tMajor = tMajor;
	}
	public String gettEducation() {
		return tEducation;
	}
	public void settEducation(String tEducation) {
		this.tEducation = tEducation;
	}
     
     
}
