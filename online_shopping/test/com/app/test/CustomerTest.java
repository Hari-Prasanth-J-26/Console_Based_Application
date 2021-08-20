package com.app.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.Main;
import com.app.authentication.service.CustomerAuthenticationService;
import com.app.authentication.service.impl.CustomerAuthenticationServiceImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;

class CustomerTest {
	
	public static CustomerAuthenticationService customerAuthenticationService;
	public static Customer customer;
	public static Main main;
	
	@BeforeAll
	static void setUp() {
		customerAuthenticationService = new CustomerAuthenticationServiceImpl();
		customer = new Customer();
		main = new Main();
	}
	
	
	@Test
	void testSignIn() throws BusinessException{
		String expectedValue = "SignIn Successfull";
		
		String email = main.userEmail;
		String password = main.userPassword;
		String actualValue = customerAuthenticationService.signIn(email, password);
		
		assertEquals(expectedValue, actualValue);
	}
	
//	@Test
//	void testSignInNotValid() {
//		assertThrows(BusinessException.class, ()->customerAuthenticationService.signIn(120));
//	}
	
	@Test
	void testSignUp() throws BusinessException {
		String expectedValue = "SignUp Successfull";
		
		String actualValue = customerAuthenticationService.signUp(customer);
		
		assertEquals(expectedValue, actualValue);
	}

}
