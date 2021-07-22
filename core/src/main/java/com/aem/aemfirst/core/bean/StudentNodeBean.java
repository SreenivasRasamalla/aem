package com.aem.aemfirst.core.bean;

public class StudentNodeBean {
	
	private String StudentId;
	private String StudentName;
	
	
	public String getStudentId() {
		return StudentId;
	}


	public void setStudentId(String studentId) {
		StudentId = studentId;
	}


	public String getStudentName() {
		return StudentName;
	}


	public void setStudentName(String studentName) {
		StudentName = studentName;
	}


	@Override
	public String toString() {
		return "StudentNodeBean [StudentId=" + StudentId + ", StudentName=" + StudentName + "]";
	}
	
	

}
