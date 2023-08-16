package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdData;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 443L, vendorId = -1)
public class SubscriptionIdImpl implements SubscriptionId 
{
	private SubscriptionIdType subscriptionIdType;
	
	private SubscriptionIdData subscriptionIdData;
	
	protected SubscriptionIdImpl()
	{
		
	}
	
	public SubscriptionIdImpl(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData)	
	{
		if(subscriptionIdType==null)
			throw new IllegalArgumentException("Subscription-id-Type is required");
		
		if(subscriptionIdData==null)
			throw new IllegalArgumentException("Subscription-Id-Data is required");
		
		this.subscriptionIdType = new SubscriptionIdTypeImpl(subscriptionIdType, null, null);
		
		this.subscriptionIdData = new SubscriptionIdDataImpl(subscriptionIdData, null, null);
	}
	
	public SubscriptionIdTypeEnum getSubscriptionIdType()
	{
		if(subscriptionIdType==null)
			return null;
		
		return subscriptionIdType.getEnumerated(SubscriptionIdTypeEnum.class);
	}
	
	public void setSubscriptionIdType(SubscriptionIdTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Subscription-id-Type is required");
		
		this.subscriptionIdType = new SubscriptionIdTypeImpl(value, null, null);		
	}
	
	public String getSubscriptionIdData()
	{
		if(subscriptionIdData==null)
			return null;
		
		return subscriptionIdData.getString();
	}
	
	public void setSubscriptionIdData(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Subscription-Id-Data is required");
		
		this.subscriptionIdData = new SubscriptionIdDataImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(subscriptionIdType==null)
			return "Subscription-id-Type is required";
		
		if(subscriptionIdData==null)
			return "Subscription-Id-Data is required";
		
		return null;
	}
}