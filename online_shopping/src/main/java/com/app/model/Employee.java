package com.app.model;

public class Employee {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + "]";
	}
	
	public String logIn(String employeeUsername, String employeePassword) {
		String actualValue="";
		String username = "hariprasanth";
		String password = "hari@369";
		if(employeeUsername.equals(username) && employeePassword.equals(password)) {
			actualValue = "LogIn Successfull";
		}
		return actualValue;
	}
	
	

}
