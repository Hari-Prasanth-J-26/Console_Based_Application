package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductSearchService {
	
	public Product getProductById(int productId) throws BusinessException;
	public List<Product> getProductsByName(String productName) throws BusinessException;
	public List<Product> getProductsByPrice(double price) throws BusinessException;
	public List<Product> getProductsByRatings(double ratings) throws BusinessException;

}
