package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CreditControlFailureHandlingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.DirectDebitingFailureHandlingEnum;

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
public abstract class CreditControlAnswerImpl extends AuthenticationAnswerImpl implements CreditControlAnswer
{
	protected CcRequestType ccRequestType;
	
	protected CcRequestNumber ccRequestNumber;
	
	protected CreditControlAnswerImpl() 
	{
		super();
	}
	
	public CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws AvpNotSupportedException, MissingAvpException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		
		setCcRequestType(ccRequestType);
		
		setCcRequestNumber(ccRequestNumber);
	}
	
	public CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws AvpNotSupportedException, MissingAvpException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		
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

	//lets return null by default, it would be overrotten by those that has the CCFH or DDFH
	@Override
	public CreditControlFailureHandlingEnum getCreditControlFailureHandling()
	{
		return null;
	}

	@Override
	public DirectDebitingFailureHandlingEnum getDirectDebitingFailureHandling()
	{
		return null;
	}	

	@Override
	public Long getValidityTime() throws AvpNotSupportedException
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