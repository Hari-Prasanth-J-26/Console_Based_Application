package com.app.authentication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.authentication.dao.CustomerAuthenticationDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerAuthenticationDAOImpl implements CustomerAuthenticationDAO {

	private static Logger log = Logger.getLogger(CustomerAuthenticationDAOImpl.class);

//	@Override
//	public String signIn(int id) throws BusinessException {
//		String actualValue = null;
//		try (Connection connection = MySqlDbConnection.getConnection()) {
//			String sql = "select id from customer where id = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, id);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				Customer customer = new Customer();
//				customer.setId(id);
//				actualValue = "SignIn Successfull";
//			} else {
//				throw new BusinessException("SignIn Unsuccessfull, Kindly Register first....");
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			log.error(e);
//			throw new BusinessException("Internal error occured, Please contact admin");
//		}
//		return actualValue;
//	}
	
	@Override
	public List<Customer> signIn(String email, String password) throws BusinessException {
		List<Customer> customerList = new ArrayList<>();
		Customer customer = null;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select customerId, firstName, lastName, email, password from customer where email = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				customer = new Customer();
				customer.setCustomerId(resultSet.getInt("customerId"));
				customer.setFirstName(resultSet.getString("firstName"));
				customer.setLastName(resultSet.getString("lastName"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, Please contact admin");
		}
		
		return customerList;
	}

	@Override
	public Customer signUp(Customer customer) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into customer (firstName, lastName, email, password) values (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPassword());
			c = preparedStatement.executeUpdate();
			if (c == 1) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if(resultSet.next()) {
					customer.setCustomerId(resultSet.getInt(1));
					//log.info(c + " row created successfully");
				}
				
			} else {
				throw new BusinessException("SignUp Unsuccessfull, Kindly Register again...");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return customer;
	}

	

}
