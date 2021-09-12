package com.app.authentication.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.authentication.dao.CustomerAuthenticationDAO;
import com.app.authentication.dao.impl.CustomerAuthenticationDAOImpl;
import com.app.authentication.service.CustomerAuthenticationService;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerAuthenticationServiceImpl implements CustomerAuthenticationService{
	
	private CustomerAuthenticationDAO customerAuthenticationDAO = new CustomerAuthenticationDAOImpl();

	@Override
	public String signIn(String email, String password) throws BusinessException {
		String actualValue = "";
		List<Customer> customerList = new ArrayList<>();
		customerList = customerAuthenticationDAO.signIn(email, password); 
		if(customerList.isEmpty()) {
			throw new BusinessException("You are not an existing cutomer.. kindly register first..");
		}
		else {
			actualValue = "SignIn Successfull";
		}
		return actualValue;
	}

	@Override
	public String signUp(Customer customer) throws BusinessException {
		String actualValue = null;
		Customer customerCheck = customerAuthenticationDAO.signUp(customer);
		if(customerCheck != null) {
			actualValue = "SignUp Successfull";
		}
		else {
			throw new BusinessException("Your Registration is Incomplete...");
		
		}
		return actualValue;
	}

}
