package com.app.authentication.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerAuthenticationDAO {
	
	public String signIn(int id) throws BusinessException;
	public String signIn(String username, String password) throws BusinessException;
	public int signUp(Customer customer) throws BusinessException;


}
