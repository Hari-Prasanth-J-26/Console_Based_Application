package com.app.authentication.service.impl;

import com.app.authentication.dao.CustomerAuthenticationDAO;
import com.app.authentication.dao.impl.CustomerAuthenticationDAOImpl;
import com.app.authentication.service.CustomerAuthenticationService;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerAuthenticationServiceImpl implements CustomerAuthenticationService{
	
	private CustomerAuthenticationDAO customerAuthenticationDAO = new CustomerAuthenticationDAOImpl();
	private Customer customer = new Customer();

	@Override
	public String signIn(int id) throws BusinessException{
		String actualValue = null;
		if(id <= 1 || id > 1000) {
			throw new BusinessException("Invalid Customer id "+id);
		}
		else {
			actualValue = customerAuthenticationDAO.signIn(id);
		}
		
		return actualValue;
	}

	@Override
	public String signUp(Customer customer) throws BusinessException {
		String actualValue = null;
		int c = customerAuthenticationDAO.signUp(customer);
		if(c != 0 && customer.getFirstName()!=null) {
			actualValue = "SignUp Successfull";
		}
		else {
			throw new BusinessException("Your Registration is Incomplete...");
			
		}
		
//		if(customer.getFirstName()!=null) {
//			actualValue = "SignUp Successfull";
//		}
		return actualValue;
	}

	@Override
	public String signIn(String username, String password) throws BusinessException {
		String actualValue = null;
		if(username == customer.getEmail() && password == customer.getPassword()) {
			actualValue = customerAuthenticationDAO.signIn(username, password);
			
		}
		else {
			throw new BusinessException("Invalid Customer credentials... Kindly Register first.. ");
		}
		
		return actualValue;

	}

}
