package com.app.authentication.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.authentication.dao.CustomerAuthenticationDAO;
import com.app.authentication.dao.impl.CustomerAuthenticationDAOImpl;
import com.app.authentication.service.CustomerAuthenticationService;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerAuthenticationServiceImpl implements CustomerAuthenticationService{
	
	CustomerAuthenticationDAO customerAuthenticationDAO = new CustomerAuthenticationDAOImpl();

	@Override
	public String signIn(String email, String password) throws BusinessException {
		String actualValue = "";
		List<Customer> customerList = new ArrayList<>();
		customerList = customerAuthenticationDAO.signIn(email, password); 
		//System.out.println(customerList);
//		if(email.equals(customerList.get(0).getEmail()) && password.equals(customerList.get(0).getPassword()) && customerList != null) {
//			//actualValue = customerAuthenticationDAO.signIn(email, password);
//			actualValue = "SignIn Successfull";
//		}
//		else {
//			//throw new BusinessException("Invalid Customer credentials... Kindly retry");
//			actualValue = "SignIn Unsuccessfull";
//		}
		
		Customer c1 = customerList.get(0);
		System.out.println(c1);
		if(customerList.isEmpty()) {
			actualValue = "SignIn Unsuccessfull";
		}
		else {
			actualValue = "SignIn Successfull";
		}
		
		
		return actualValue;
	}

	@Override
	public String signUp(Customer customer) throws BusinessException {
		String actualValue = null;
		Customer c = customerAuthenticationDAO.signUp(customer);
		if(c != null) {
			actualValue = "SignUp Successfull";
		}
		else {
			throw new BusinessException("Your Registration is Incomplete...");
			
		}
		return actualValue;
	}

}
