package com.mobius.software.telco.protocols.diameter.impl.primitives.sh;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.sh.ASNumber;
import com.mobius.software.telco.protocols.diameter.primitives.sh.CallReferenceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sh.CallReferenceNumber;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class CallReferenceInfoImpl extends DiameterGroupedAvpImpl implements CallReferenceInfo
{
	private CallReferenceNumber callReferenceNumber;
	
	private ASNumber asNumber;
	
	protected CallReferenceInfoImpl() 
	{
		super();
	}
	
	public CallReferenceInfoImpl(ByteBuf callReferenceNumber, ByteBuf asNumber) throws MissingAvpException
	{
		setCallReferenceNumber(asNumber);
		
		setASNumber(asNumber);
	}
	
	public ByteBuf getCallReferenceNumber()
	{
		if(callReferenceNumber==null)
			return null;
		
		return callReferenceNumber.getValue();
	}
	
	public void setCallReferenceNumber(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Call-Reference-Number is required", Arrays.asList(new DiameterAvp[] { new CallReferenceNumberImpl() }));
		
		this.callReferenceNumber = new CallReferenceNumberImpl(value, null, null);		
	}
	
	public ByteBuf getASNumber()
	{
		if(asNumber==null)
			return null;
		
		return asNumber.getValue();
	}
	
	public void setASNumber(ByteBuf value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("AS-Number is required", Arrays.asList(new DiameterAvp[] { new ASNumberImpl() }));
		
		this.asNumber = new ASNumberImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(callReferenceNumber == null)
			return new MissingAvpException("Call-Reference-Number is required", Arrays.asList(new DiameterAvp[] { new CallReferenceNumberImpl() }));
		
		if(asNumber == null)
			return new MissingAvpException("AS-Number is required", Arrays.asList(new DiameterAvp[] { new ASNumberImpl() }));
		
		return null;
	}
}