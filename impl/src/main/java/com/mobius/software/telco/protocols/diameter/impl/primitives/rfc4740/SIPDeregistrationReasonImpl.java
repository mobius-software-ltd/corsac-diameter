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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPDeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPReasonCode;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPReasonCodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPReasonInfo;

/**
*
* @author yulian oifa
*
*/
public class SIPDeregistrationReasonImpl extends DiameterGroupedAvpImpl implements SIPDeregistrationReason
{
	private SIPReasonCode sipReasonCode;
	
	private SIPReasonInfo sipReasonInfo;
	
	public SIPDeregistrationReasonImpl()
	{
		
	}
	
	public SIPDeregistrationReasonImpl(SIPReasonCodeEnum sipReasonCode) throws MissingAvpException 
	{
		setSIPReasonCode(sipReasonCode);
	}
	
	public SIPReasonCodeEnum getSIPReasonCode()
	{
		if(sipReasonCode==null)
			return null;
		
		return sipReasonCode.getEnumerated(SIPReasonCodeEnum.class);
	}
	
	public void setSIPReasonCode(SIPReasonCodeEnum value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("SIP-Reason-Code is required is required", Arrays.asList(new DiameterAvp[] { new SIPReasonCodeImpl() }));
		
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
	public DiameterException validate()
	{
		if(sipReasonCode == null)
			return new MissingAvpException("SIP-Reason-Code is required is required", Arrays.asList(new DiameterAvp[] { new SIPReasonCodeImpl() }));
		
		return null;
	}		
}