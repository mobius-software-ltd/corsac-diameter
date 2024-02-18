package com.mobius.software.telco.protocols.diameter.impl.primitives.oma;
/*
 * Mobius Software LTD
 * Copyright 2023, Mobius Software LTD and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

import com.mobius.software.telco.protocols.diameter.primitives.oma.ApplicationServerId;
import com.mobius.software.telco.protocols.diameter.primitives.oma.ApplicationServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.oma.ApplicationServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.oma.ApplicationSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.oma.DeliveryStatus;
import com.mobius.software.telco.protocols.diameter.primitives.oma.ServiceGenericInformation;

/**
*
* @author yulian oifa
*
*/
public class ServiceGenericInformationImpl implements ServiceGenericInformation
{
	private ApplicationServerId applicationServerID;
	private ApplicationServiceType applicationServiceType;
	private ApplicationSessionId applicationSessionID;
	private DeliveryStatus deliveryStatus; 
					
	public ServiceGenericInformationImpl()
	{
		
	}
	
	public String getApplicationServerID()
	{
		if(applicationServerID == null)
			return null;
		
		return applicationServerID.getString();
	}
	
	public void setApplicationServerID(String value)
	{
		if(value==null)
			this.applicationServerID = null;
		else
			this.applicationServerID = new ApplicationServerIdImpl(value, null, null);			
	}
	
	public ApplicationServiceTypeEnum getApplicationServiceType()
	{
		if(applicationServiceType == null)
			return null;
		
		return applicationServiceType.getEnumerated(ApplicationServiceTypeEnum.class);
	}
	
	public void setApplicationServiceType(ApplicationServiceTypeEnum value)
	{
		if(value==null)
			this.applicationServiceType = null;
		else
			this.applicationServiceType = new ApplicationServiceTypeImpl(value, null, null);			
	}
	
	public Long getApplicationSessionID()
	{
		if(applicationSessionID == null)
			return null;
		
		return applicationSessionID.getUnsigned();
	}
	
	public void setApplicationSessionID(Long value)
	{
		if(value==null)
			this.applicationSessionID = null;
		else
			this.applicationSessionID = new ApplicationSessionIdImpl(value, null, null);			
	}
	
	public String getDeliveryStatus()
	{
		if(deliveryStatus == null)
			return null;
		
		return deliveryStatus.getString();
	}
	
	public void setDeliveryStatus(String value)
	{
		if(value==null)
			this.deliveryStatus = null;
		else
			this.deliveryStatus = new DeliveryStatusImpl(value, null, null);			
	}
}