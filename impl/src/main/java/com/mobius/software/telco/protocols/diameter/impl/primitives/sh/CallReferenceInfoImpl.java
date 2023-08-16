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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.sh.ASNumber;
import com.mobius.software.telco.protocols.diameter.primitives.sh.CallReferenceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sh.CallReferenceNumber;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 720L, vendorId = KnownVendorIDs.TGPP_ID)
public class CallReferenceInfoImpl extends DiameterGroupedAvpImpl implements CallReferenceInfo
{
	private CallReferenceNumber callReferenceNumber;
	
	private ASNumber asNumber;
	
	protected CallReferenceInfoImpl() 
	{
		super();
	}
	
	public CallReferenceInfoImpl(ByteBuf callReferenceNumber, ByteBuf asNumber)
	{
		if(callReferenceNumber == null)
			throw new IllegalArgumentException("Call-Reference-Number is required");
		
		if(asNumber == null)
			throw new IllegalArgumentException("AS-Number is required");
		
		this.callReferenceNumber = new CallReferenceNumberImpl(callReferenceNumber, null, null);
		
		this.asNumber = new ASNumberImpl(asNumber, null, null);
	}
	
	public ByteBuf getCallReferenceNumber()
	{
		if(callReferenceNumber==null)
			return null;
		
		return callReferenceNumber.getValue();
	}
	
	public void setCallReferenceNumber(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Call-Reference-Number is required");
		
		this.callReferenceNumber = new CallReferenceNumberImpl(value, null, null);		
	}
	
	public ByteBuf getASNumber()
	{
		if(asNumber==null)
			return null;
		
		return asNumber.getValue();
	}
	
	public void setASNumber(ByteBuf value)
	{
		if(value == null)
			throw new IllegalArgumentException("AS-Number is required");
		
		this.asNumber = new ASNumberImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(callReferenceNumber == null)
			return "Call-Reference-Number is required";
		
		if(asNumber == null)
			return "AS-Number is required";
		
		return null;
	}
}