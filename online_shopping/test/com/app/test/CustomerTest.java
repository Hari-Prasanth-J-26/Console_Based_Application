package com.app.test;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.authentication.service.CustomerAuthenticationService;
import com.app.authentication.service.impl.CustomerAuthenticationServiceImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;

class CustomerTest {
	
	private static Logger log = Logger.getLogger(CustomerTest.class);
	public static CustomerAuthenticationService customerAuthenticationService;
	public static Customer customer;
	
	@BeforeAll
	static void setUp() {
		customerAuthenticationService = new CustomerAuthenticationServiceImpl();
		customer = new Customer();
	}
	
//	@Test
//	void testSignIn() throws BusinessException{
//		String expectedValue = "SignIn Successfull";
//
//		String actualValue = customerAuthenticationService.signIn(101);
//		
//		assertEquals(expectedValue, actualValue);
//	}
	
//	@Test
//	void testSignIn() throws BusinessException{
//		String expectedValue = "SignIn Successfull";
//		String email = "hariselvan123@gmail.com";
//		String password = "hari@123";
//		String actualValue = customerAuthenticationService.signIn(email, password);
//		
//		assertEquals(expectedValue, actualValue);
//	}
	
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
