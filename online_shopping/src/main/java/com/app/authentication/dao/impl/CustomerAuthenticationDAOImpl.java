package com.app.authentication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.authentication.dao.CustomerAuthenticationDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerAuthenticationDAOImpl implements CustomerAuthenticationDAO {

	private static Logger log = Logger.getLogger(CustomerAuthenticationDAOImpl.class);

	@Override
	public String signIn(int id) throws BusinessException {
		String actualValue = null;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select id from customer where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Customer customer = new Customer();
				customer.setId(id);
				actualValue = "SignIn Successfull";
			} else {
				throw new BusinessException("SignIn Unsuccessfull, Kindly Register first....");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, Please contact admin");
		}
		return actualValue;
	}

	@Override
	public int signUp(Customer customer) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into customer (id, firstName, lastName, email, password) values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setString(3, customer.getLastName());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5, customer.getPassword());
			c = preparedStatement.executeUpdate();
			if (c == 1) {
				log.info(c + " row created successfully");
			} else {
				throw new BusinessException("SignUp Unsuccessfull, Kindly Register again...");
			}
		} catch (ClassNotFoundException | SQLException e) {
			//log.error(e);
		}
		return c;
	}

	@Override
	public String signIn(String username, String password) throws BusinessException {
		String actualValue = null;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select id, firstName, lastName, email, password from customer where email = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setEmail(resultSet.getString(username));
				customer.setPassword(resultSet.getString(password));
				actualValue = "SignIn Successfull";
		} 
//				else {
//				throw new BusinessException("SignIn Unsuccessfull, Kindly Register first....");
//			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, Please contact admin");
		}
		return actualValue;
	}

}
