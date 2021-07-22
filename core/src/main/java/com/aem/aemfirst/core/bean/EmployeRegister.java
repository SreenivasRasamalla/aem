package com.aem.aemfirst.core.bean;
//This class belongs to Node Creation 
public class EmployeRegister {
	String firstName;
	String LastName;
	String userName;
	String password;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmployeRegister [firstName=" + firstName + ", LastName=" + LastName + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	

}
