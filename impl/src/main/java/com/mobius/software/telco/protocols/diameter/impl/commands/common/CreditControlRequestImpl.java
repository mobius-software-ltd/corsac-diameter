package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedActionEnum;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
public abstract class CreditControlRequestImpl extends AuthenticationRequestWithHostBase implements CreditControlRequest
{
	protected CcRequestType ccRequestType;
	
	protected CcRequestNumber ccRequestNumber;
	
	protected CreditControlRequestImpl() 
	{
		super();
	}
	
	public CreditControlRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessonID, Long authApplicationId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws AvpNotSupportedException, MissingAvpException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessonID, authApplicationId);
		
		setCcRequestType(ccRequestType);
		
		setCcRequestNumber(ccRequestNumber);		
	}

	@Override
	public CcRequestTypeEnum getCcRequestType() 
	{
		if(ccRequestType==null)
			return null;
		
		return ccRequestType.getEnumerated(CcRequestTypeEnum.class);
	}

	@Override
	public void setCcRequestType(CcRequestTypeEnum value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("CC-Request-Type is required", Arrays.asList(new DiameterAvp[] { new CcRequestTypeImpl() } ));
		
		this.ccRequestType = new CcRequestTypeImpl(value, null, null);
	}

	@Override
	public Long getCcRequestNumber() 
	{
		if(ccRequestNumber==null)
			return null;
		
		return ccRequestNumber.getUnsigned();
	}

	@Override
	public void setCcRequestNumber(Long value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("CC-Request-Number is required", Arrays.asList(new DiameterAvp[] { new CcRequestNumberImpl() } ));
		
		this.ccRequestNumber = new CcRequestNumberImpl(value, null, null);
	}

	//lets return null by default, it would be overrotten by those that has the Requested Action
	@Override
	public RequestedActionEnum getRequestedAction()
	{
		return null;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(ccRequestType==null)
			return new MissingAvpException("CC-Request-Type is required", Arrays.asList(new DiameterAvp[] { new CcRequestTypeImpl() } ));
		
		if(ccRequestNumber==null)
			return new MissingAvpException("CC-Request-Number is required", Arrays.asList(new DiameterAvp[] { new CcRequestNumberImpl() } ));
		
		return super.validate();
	}
}