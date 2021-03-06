package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CartAddDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;

public class CartAddDAOImpl implements CartAddDAO{
	
	private static Logger log = Logger.getLogger(CartAddDAOImpl.class);

	@Override
	public Cart addToCart(int cId, int pId, int quantity) throws BusinessException {
		int c = 0;
		Cart cart = new Cart();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into cart (customerId, productId, quantity) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cId);
			preparedStatement.setInt(2, pId);
			preparedStatement.setInt(3, quantity);
			c = preparedStatement.executeUpdate();
//			if (c == 1) {
//				ResultSet resultSet = preparedStatement.getGeneratedKeys();
//				if(resultSet.next()) {
//					cart.setCartId(resultSet.getInt(1));
//					//log.info(c + " row created successfully");
//				}
				
			if(c != 1) {
				throw new BusinessException("Product is not added in Cart... kindly retry..");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return cart;
	}

	@Override
	public List<Cart> getAllItemsInCart(int cId) throws BusinessException {
		List<Cart> cartList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select c.customerId, p.productId, productName, price, ratings, quantity from product p join cart c on c.customerId = ? where p.productId=c.productId";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setProductId(resultSet.getInt("productId"));
				product.setProductName(resultSet.getString("productName"));
				product.setPrice(resultSet.getDouble("price"));
				product.setRatings(resultSet.getDouble("ratings"));
				Cart cart = new Cart();
				cart.setCustomerId(resultSet.getInt("customerId"));
				cart.setQuantity(resultSet.getInt("quantity"));
				cart.setProduct(product);
				cartList.add(cart);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		
		return cartList;
	}

}
