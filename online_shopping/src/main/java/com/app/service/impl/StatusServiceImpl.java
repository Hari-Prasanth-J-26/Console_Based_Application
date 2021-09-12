package com.app.service.impl;

import com.app.dao.StatusDAO;
import com.app.dao.impl.StatusDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Status;
import com.app.service.StatusService;

public class StatusServiceImpl implements StatusService{
	
	private StatusDAO statusDAO = new StatusDAOImpl();

	@Override
	public String updateStatus(Status status) throws BusinessException {
		String actualValue = null;
		int value = 0;
		value = statusDAO.updateStatus(status);
		if(value > 0) {
			actualValue = "Successfull";
		}
		return actualValue;
	}

	@Override
	public String updateShippingStatus(int cId, String orderShipped) throws BusinessException {
		String actualValue = null;
		int value = 0;
		value = statusDAO.updateShippingStatus(cId,orderShipped);
		if(value > 0) {
			actualValue = "Shipping Successfull";
		}
		return actualValue;
	}

	@Override
	public String updateDeliveryStatus(int cId, String orderReceived) throws BusinessException {
		String actualValue = null;
		int value = 0;
		value = statusDAO.updateDeliveryStatus(cId, orderReceived);
		if(value > 0) {
			actualValue = "Received Successfull";
		}
		return actualValue;
	}

}
