package com.app.authentication.service;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerAuthenticationService {
	
	public String signIn(String email, String password) throws BusinessException;
	public String signUp(Customer customer) throws BusinessException;

}
