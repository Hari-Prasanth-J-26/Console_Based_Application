package com.app.test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.app.model.Employee;

class EmployeeTest {

	public Employee employee = new Employee();
	
	@Test
	void testLogIn() {

		String expectedValue = "LogIn Successfull";
		
		String username = "hariprasanth";
		String password = "hari@369";
		String actualValue = employee.logIn(username, password);

		assertEquals(expectedValue, actualValue);

	}

}
