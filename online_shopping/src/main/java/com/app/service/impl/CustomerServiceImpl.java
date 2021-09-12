package com.app.service.impl;

import java.util.List;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	@Override
	public String getAllCustomers() throws BusinessException {
		String result = null;
		List<Customer> customerList = null;
		customerList = customerDAO.getAllCustomers();
		if (customerList != null && customerList.size() > 0) {
			result = "successfull";
		}	
		return result;
	}

}
