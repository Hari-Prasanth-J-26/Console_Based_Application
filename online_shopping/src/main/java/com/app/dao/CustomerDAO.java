package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerDAO {

	public List<Customer> getAllCustomers() throws BusinessException;
}
