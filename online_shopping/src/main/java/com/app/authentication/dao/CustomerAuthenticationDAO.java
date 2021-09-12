package com.app.authentication.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerAuthenticationDAO {
	
	public List<Customer> signIn(String email, String password) throws BusinessException;
	public Customer signUp(Customer customer) throws BusinessException;


}
