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
	
	public CustomerAuthenticationService customerAuthenticationService = new CustomerAuthenticationServiceImpl();
	public Customer customer = new Customer();
	public Main main = new Main();
	
	@Test
	void testSignIn() throws BusinessException{
		String expectedValue = "SignIn Successfull";
		
//		String email = main.userEmail;
//		String password = main.userPassword;
		String email = "arunraj123@gmail.com";
		String password = "arun@123";
		String actualValue = customerAuthenticationService.signIn(email, password);
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	void testSignInNotValid() {
		assertThrows(BusinessException.class, ()->customerAuthenticationService.signIn("abcdef123@gmail.com", "abcdef"));
	}
	
	@Test
	void testSignUp() throws BusinessException {
		String expectedValue = "SignUp Successfull";
		
		String actualValue = customerAuthenticationService.signUp(main.customerDetails);
		
		assertEquals(expectedValue, actualValue);
	}

}
