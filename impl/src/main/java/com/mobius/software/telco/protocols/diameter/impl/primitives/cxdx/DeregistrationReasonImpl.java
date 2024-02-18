package com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx;
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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ReasonCode;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ReasonCodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ReasonInfo;

/**
*
* @author yulian oifa
*
*/
public class DeregistrationReasonImpl extends DiameterGroupedAvpImpl implements DeregistrationReason
{
	private ReasonCode reasonCode;
	
	private ReasonInfo reasonInfo;
	
	public DeregistrationReasonImpl()
	{
		
	}
	
	public DeregistrationReasonImpl(ReasonCodeEnum reasonCode) throws MissingAvpException
	{
		setReasonCode(reasonCode);
	}
	
	public ReasonCodeEnum getReasonCode()
	{
		if(reasonCode==null)
			return null;
		
		return reasonCode.getEnumerated(ReasonCodeEnum.class);
	}
	
	public void setReasonCode(ReasonCodeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Reason-Code is required", Arrays.asList(new DiameterAvp[] { new ReasonCodeImpl() }));
			
		this.reasonCode = new ReasonCodeImpl(value, null, null);
	}
	
	public String getReasonInfo()
	{
		if(reasonInfo==null)
			return null;
		
		return reasonInfo.getString();
	}
	
	public void setReasonInfo(String value)
	{
		if(value == null)
			this.reasonInfo = null;
		else
			this.reasonInfo = new ReasonInfoImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(reasonInfo==null)
			return new MissingAvpException("Reason-Code is required", Arrays.asList(new DiameterAvp[] { new ReasonCodeImpl() }));
		
		return null;
	}	
}