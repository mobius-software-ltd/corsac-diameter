package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.CSGIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGAccessMode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGAccessModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGMembershipIndication;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGMembershipIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CSGId;

/**
*
* @author yulian oifa
*
*/
public class UserCSGInformationImpl implements UserCSGInformation
{
	private CSGId csgId;
	private CSGAccessMode csgAccessMode; 
	private CSGMembershipIndication csgMembershipIndication;
	
	protected UserCSGInformationImpl() 
	{
	}
	
	public UserCSGInformationImpl(Long csgId,CSGAccessModeEnum csgAccessMode) throws MissingAvpException
	{
		setCSGId(csgId);
		
		setCSGAccessMode(csgAccessMode);
	}
			
	public Long getCSGId()
	{
		if(csgId==null)
			return null;
		
		return csgId.getUnsigned();
	}
	
	public void setCSGId(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("CSG-Id is required is required", Arrays.asList(new DiameterAvp[] { new CSGIdImpl() }));
		
		this.csgId = new CSGIdImpl(value, null, null);		
	}
	
	public CSGAccessModeEnum getCSGAccessMode()
	{
		if(csgAccessMode==null)
			return null;
		
		return csgAccessMode.getEnumerated(CSGAccessModeEnum.class);
	}
	
	public void setCSGAccessMode(CSGAccessModeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("CSG-Access-Mode is required is required", Arrays.asList(new DiameterAvp[] { new CSGAccessModeImpl() }));
		
		this.csgAccessMode = new CSGAccessModeImpl(value, null, null);		
	}
	
	public CSGMembershipIndicationEnum getCSGMembershipIndication()
	{
		if(csgMembershipIndication==null)
			return null;
		
		return csgMembershipIndication.getEnumerated(CSGMembershipIndicationEnum.class);
	}
	
	public void setCSGMembershipIndication(CSGMembershipIndicationEnum value)
	{
		if(value==null)
			this.csgMembershipIndication = null;
		else
			this.csgMembershipIndication = new CSGMembershipIndicationImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(csgId==null)
			return new MissingAvpException("CSG-Id is required is required", Arrays.asList(new DiameterAvp[] { new CSGIdImpl() }));
		
		if(csgAccessMode==null)
			return new MissingAvpException("CSG-Access-Mode is required is required", Arrays.asList(new DiameterAvp[] { new CSGAccessModeImpl() }));
		
		return null;
	}
}