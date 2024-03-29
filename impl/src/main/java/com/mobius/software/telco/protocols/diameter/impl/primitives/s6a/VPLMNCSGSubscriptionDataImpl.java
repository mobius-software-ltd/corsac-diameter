package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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
import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CSGId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ExpirationDate;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VPLMNCSGSubscriptionData;

/**
*
* @author yulian oifa
*
*/
public class VPLMNCSGSubscriptionDataImpl extends DiameterGroupedAvpImpl implements VPLMNCSGSubscriptionData
{
	private CSGId csgId;
	
	private ExpirationDate expirationDate;
	
	public VPLMNCSGSubscriptionDataImpl()
	{
		
	}
	
	public VPLMNCSGSubscriptionDataImpl(Long csgId) throws MissingAvpException
	{
		setCSGId(csgId);
	}
	
	public Long getCSGId()
	{
		if(csgId == null)
			return null;
		
		return csgId.getUnsigned();
	}
	
	public void setCSGId(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("CSG-Id is required", Arrays.asList(new DiameterAvp[] { new CSGIdImpl() }));
			
		this.csgId = new CSGIdImpl(value, null, null);
	}
	
	public Date getExpirationDate()
	{
		if(expirationDate == null)
			return null;
		
		return expirationDate.getDateTime();
	}
	
	public void setExpirationDate(Date value)
	{
		if(value == null)
			this.expirationDate = null;
		else
			this.expirationDate = new ExpirationDateImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(csgId==null)
			return new MissingAvpException("CSG-Id is required", Arrays.asList(new DiameterAvp[] { new CSGIdImpl() }));
		
		return null;
	}
}