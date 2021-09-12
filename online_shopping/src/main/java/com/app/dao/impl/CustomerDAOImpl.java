package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	
	private static Logger log = Logger.getLogger(CustomerDAOImpl.class);

	@Override
	public List<Customer> getAllCustomers() throws BusinessException {
		List<Customer> customerList = new ArrayList<>();
		try(Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select customerId, firstName, lastName, email from revature_project_1.customer";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getInt("customerId"));
				customer.setFirstName(resultSet.getString("firstName"));
				customer.setLastName(resultSet.getString("lastName"));
				customer.setEmail(resultSet.getString("email"));
				customerList.add(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return customerList;
	}

	

}
