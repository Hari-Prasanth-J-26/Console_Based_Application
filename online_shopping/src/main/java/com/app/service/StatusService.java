package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Status;

public interface StatusService {
	
	public String updateStatus(Status status) throws BusinessException;
	public String updateShippingStatus(int cId,String orderShipped) throws BusinessException;
	public String updateDeliveryStatus(int cId,String orderReceived) throws BusinessException;

}
