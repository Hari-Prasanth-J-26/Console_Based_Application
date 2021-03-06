package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ProductSearchDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class ProductSearchDAOImpl implements ProductSearchDAO{
	
	private static Logger log = Logger.getLogger(ProductSearchDAOImpl.class);

	@Override
	public Product getProductById(int productId) throws BusinessException {
		Product product = null;
		try(Connection connection = MySqlDbConnection.getConnection()){
			String sql = "select productId, productName, price, ratings from product where productId=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				product = new Product();
				product.setProductId(productId);
				product.setProductName(resultSet.getString("productName"));
				product.setPrice(resultSet.getDouble("price"));
				product.setRatings(resultSet.getDouble("ratings"));
			}
			else {
				throw new BusinessException("Entered Product ID "+productId+" doesn't exist");
			}
		} catch (ClassNotFoundException | SQLException e) {

			log.error(e);
		} 
		return product;
	}

	@Override
	public List<Product> getProductsByName(String productName) throws BusinessException {
		List<Product> productList = new ArrayList<>();
		Product product = null;
		try(Connection connection = MySqlDbConnection.getConnection()){
			String sql = "select productId, productName, price, ratings from product where productName=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				product = new Product();
				product.setProductId(resultSet.getInt("productId"));
				product.setProductName(resultSet.getString("productName"));
				product.setPrice(resultSet.getDouble("price"));
				product.setRatings(resultSet.getDouble("ratings"));
				productList.add(product);
			}
			if(productList.size()==0) {
			throw new BusinessException("No Product under this name "+productName);
		}
		} catch (ClassNotFoundException | SQLException e) {

			log.error(e);
		} 
		return productList;
	}

	@Override
	public List<Product> getProductsByPrice(double price) throws BusinessException {
		List<Product> productList = new ArrayList<>();
		Product product = null;
		try(Connection connection = MySqlDbConnection.getConnection()){
			String sql = "select productId, productName, price, ratings from product where price=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, price);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				product = new Product();
				product.setProductId(resultSet.getInt("productId"));
				product.setProductName(resultSet.getString("productName"));
				product.setPrice(resultSet.getDouble("price"));
				product.setRatings(resultSet.getDouble("ratings"));
				productList.add(product);
			}
			if(productList.size()==0) {
			throw new BusinessException("No Product under this price "+price);
		}
		} catch (ClassNotFoundException | SQLException e) {

			log.error(e);
		} 
		return productList;
	}

	@Override
	public List<Product> getProductsByRatings(double ratings) throws BusinessException {
		List<Product> productList = new ArrayList<>();
		Product product = null;
		try(Connection connection = MySqlDbConnection.getConnection()){
			String sql = "select productId, productName, price, ratings from product where ratings=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, ratings);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				product = new Product();
				product.setProductId(resultSet.getInt("productId"));
				product.setProductName(resultSet.getString("productName"));
				product.setPrice(resultSet.getDouble("price"));
				product.setRatings(resultSet.getDouble("ratings"));
				productList.add(product);
			}
			if(productList.size()==0) {
			throw new BusinessException("No Product under this ratings "+ratings);
		}
		} catch (ClassNotFoundException | SQLException e) {

			log.error(e);
		} 
		return productList;
	}

}
