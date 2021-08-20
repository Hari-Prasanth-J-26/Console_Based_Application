package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.CartAddDAO;
import com.app.dao.impl.CartAddDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.service.CartAddService;

public class CartAddServiceImpl implements CartAddService{
	
	CartAddDAO cartAddDAO = new CartAddDAOImpl();

	@Override
	public String addToCart(int cId, int pId, int quantity) throws BusinessException {
		String actualValue = null;
		Cart cartAddCheck = cartAddDAO.addToCart(cId, pId, quantity);
		if(cartAddCheck == null) {
			throw new BusinessException("There is some error in adding the Products in the cart.. Please retry..");
		}
		else {
			
			actualValue = "Product added in cart";
		}
		return actualValue;
	}

	@Override
	public String getAllItemsInCart(int cId) throws BusinessException {
		String actualValue = null;
		List<Cart> cartList = new ArrayList<>();
		cartList = cartAddDAO.getAllItemsInCart(cId);
		if(cartList.isEmpty()) {
			throw new BusinessException("There is some error in getting all products in the cart.. Please retry..");
		}
		else {
			actualValue = "Cart List Shown";
		}
		return actualValue;
	}

}
