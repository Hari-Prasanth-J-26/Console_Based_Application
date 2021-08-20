package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.StatusDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Status;

public class StatusDAOImpl implements StatusDAO{
	
	private static Logger log = Logger.getLogger(CartAddDAOImpl.class);


	@Override
	public int updateStatus(Status status) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into `revature_project_1`.`status`(orderId, customerId, orderShipped, orderReceived) values (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, status.getOrderId());
			preparedStatement.setInt(2, status.getCustomerId());
			preparedStatement.setString(3, status.getOrderShipped());
			preparedStatement.setString(4, status.getOrderReceived());
			c = preparedStatement.executeUpdate();
			if(c == 1) {
				log.info("Status updated");
			}
			else {
				throw new BusinessException("status not updated.. kindly retry..");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return c;
	}

	@Override
	public int updateShippingStatus(int cId, String orderShipped) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "update `revature_project_1`.`status` set orderShipped = ? where customerId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, orderShipped);
			preparedStatement.setInt(2, cId);
			c = preparedStatement.executeUpdate();
			log.info(c+"rows updated");
			if(c >= 1) {
				log.info("Products Shipped");
			}
			else {
				throw new BusinessException("Product is not shipped.. kindly retry..");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return c;
	}

	@Override
	public int updateDeliveryStatus(int cId, String orderReceived) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "update `revature_project_1`.`status` set orderReceived = ? where customerId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, orderReceived);
			preparedStatement.setInt(2, cId);
			c = preparedStatement.executeUpdate();
			log.info(c+"rows updated");
			if(c >= 1) {
				log.info("Products Received");
			}
			else {
				throw new BusinessException("Product is not Received");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return c;
	}

}
