package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Status;

public interface StatusDAO {
	
	public int updateStatus(Status status) throws BusinessException;
	public int updateShippingStatus(int cId, String orderShipped) throws BusinessException;
	public int updateDeliveryStatus(int cId, String orderReceived) throws BusinessException;

}
