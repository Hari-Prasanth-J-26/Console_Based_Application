package com.app.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.Main;
import com.app.exception.BusinessException;
import com.app.service.OrderService;
import com.app.service.impl.OrderServiceImpl;

class OrderTest {

	public OrderService orderService = new OrderServiceImpl();
	public Main main = new Main();

	@Test
	void testGetOrderList() throws BusinessException {

		String expectedValue = "Order List Shown";

		String actualValue = orderService.getOrderList(main.cId);

		assertEquals(expectedValue, actualValue);

	}
	
}
