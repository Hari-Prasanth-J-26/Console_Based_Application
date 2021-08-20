package com.app.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.service.ProductAddService;
import com.app.service.impl.ProductAddServiceImpl;

class ProductTest {

	public ProductAddService productAddService = new ProductAddServiceImpl();
	public Product product = new Product();
	
	@Test
	void testAddProduct() throws BusinessException {
		String expectedValue = "Product added successfully";

		String actualValue = productAddService.addProduct(product);

		assertEquals(expectedValue, actualValue);
	}

	@Test
	void testGetAllProducts() throws BusinessException{
		String expectedValue = "Product List is Shown";
		
		String actualValue = productAddService.getAllProducts();
		
		assertEquals(expectedValue, actualValue);
	}
}
