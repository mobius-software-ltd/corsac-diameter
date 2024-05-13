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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdData;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;

/**
*
* @author yulian oifa
*
*/
public class SubscriptionIdImpl extends DiameterAvpImpl implements SubscriptionId 
{
	private SubscriptionIdType subscriptionIdType;
	
	private SubscriptionIdData subscriptionIdData;
	
	protected SubscriptionIdImpl()
	{
		
	}
	
	public SubscriptionIdImpl(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException	
	{
		setSubscriptionIdType(subscriptionIdType);
		
		setSubscriptionIdData(subscriptionIdData);
	}
	
	public SubscriptionIdTypeEnum getSubscriptionIdType()
	{
		if(subscriptionIdType==null)
			return null;
		
		return subscriptionIdType.getEnumerated(SubscriptionIdTypeEnum.class);
	}
	
	public void setSubscriptionIdType(SubscriptionIdTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Subscription-id-Type is required is required", Arrays.asList(new DiameterAvp[] { new SubscriptionIdTypeImpl() }));
			
		this.subscriptionIdType = new SubscriptionIdTypeImpl(value, null, null);		
	}
	
	public String getSubscriptionIdData()
	{
		if(subscriptionIdData==null)
			return null;
		
		return subscriptionIdData.getString();
	}
	
	public void setSubscriptionIdData(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Subscription-Id-Data is required is required", Arrays.asList(new DiameterAvp[] { new SubscriptionIdDataImpl() }));
		
		this.subscriptionIdData = new SubscriptionIdDataImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(subscriptionIdType==null)
			return new MissingAvpException("Subscription-id-Type is required is required", Arrays.asList(new DiameterAvp[] { new SubscriptionIdTypeImpl() }));
		
		if(subscriptionIdData==null)
			return new MissingAvpException("Subscription-Id-Data is required is required", Arrays.asList(new DiameterAvp[] { new SubscriptionIdDataImpl() }));
		
		return null;
	}
}