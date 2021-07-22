package com.aem.aemfirst.core.bean;

public class StudentDetails {

	private String stdId;
	private String stdName;
	private String stdDept;
	private String stdAddress;
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdDept() {
		return stdDept;
	}
	public void setStdDept(String stdDept) {
		this.stdDept = stdDept;
	}
	public String getStdAddress() {
		return stdAddress;
	}
	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}
	@Override
	public String toString() {
		return "StudentDetails [stdId=" + stdId + ", stdName=" + stdName + ", stdDept=" + stdDept + ", stdAddress="
				+ stdAddress + "]";
	}
	
	
	
}
