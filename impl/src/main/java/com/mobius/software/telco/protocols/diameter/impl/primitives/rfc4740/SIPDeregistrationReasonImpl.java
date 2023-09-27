package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740;
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
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPDeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPReasonCode;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPReasonCodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPReasonInfo;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 383L, vendorId = -1L)
public class SIPDeregistrationReasonImpl extends DiameterGroupedAvpImpl implements SIPDeregistrationReason
{
	private SIPReasonCode sipReasonCode;
	
	private SIPReasonInfo sipReasonInfo;
	
	protected SIPDeregistrationReasonImpl()
	{
		
	}
	
	public SIPDeregistrationReasonImpl(SIPReasonCodeEnum sipReasonCode) 
	{
		if(sipReasonCode == null)
			throw new IllegalArgumentException("SIP-Reason-Code is required");
		
		this.sipReasonCode = new SIPReasonCodeImpl(sipReasonCode, null, null);
	}
	
	public SIPReasonCodeEnum getSIPReasonCode()
	{
		if(sipReasonCode==null)
			return null;
		
		return sipReasonCode.getEnumerated(SIPReasonCodeEnum.class);
	}
	
	public void setSIPReasonCode(SIPReasonCodeEnum value)
	{
		if(value == null)
			throw new IllegalArgumentException("SIP-Reason-Code is required");
		
		this.sipReasonCode = new SIPReasonCodeImpl(value, null, null);
	}
	
	public String getSIPReasonInfo()
	{
		if(sipReasonInfo==null)
			return null;
		
		return sipReasonInfo.getString();
	}
	
	public void setSIPReasonInfo(String value)
	{
		if(value == null)
			this.sipReasonInfo = null;
		else
			this.sipReasonInfo = new SIPReasonInfoImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(sipReasonCode == null)
			return "SIP-Reason-Code is required";
		
		return null;
	}				
}