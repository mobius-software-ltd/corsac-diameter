package com.mobius.software.telco.protocols.diameter.impl.commands.s6b;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6b.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ReAuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6b.RARFlagsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6b.RARFlags;

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
@DiameterCommandImplementation(applicationId = 16777250, commandCode = 258, request = true)
public class ReAuthRequestImpl extends S6bRequestImpl implements ReAuthRequest
{
	private ReAuthRequestType reAuthRequestType;
	
	private RARFlags rarFlags;
	
	protected ReAuthRequestImpl() 
	{
		super();
	}
		
	public ReAuthRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID, ReAuthRequestTypeEnum reAuthRequestType)
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID);
		
		setReAuthRequestType(reAuthRequestType);
	}
	
	@Override
	public ReAuthRequestTypeEnum getReAuthRequestType()
	{
		if(reAuthRequestType==null)
			return null;
		
		return reAuthRequestType.getEnumerated(ReAuthRequestTypeEnum.class);
	}
	
	@Override
	public void setReAuthRequestType(ReAuthRequestTypeEnum value)
	{
		if(value == null)
			throw new IllegalArgumentException("Re-Auth-Request-Type is required");	
		
		this.reAuthRequestType = new ReAuthRequestTypeImpl(value, null, null);
	}
	
	@Override
	public Long getRARFlags()
	{
		if(rarFlags==null)
			return null;
		
		return rarFlags.getUnsigned();
	}
	
	@Override
	public void setRARFlags(Long value)
	{
		if(value == null)
			this.rarFlags = null;
		else
			this.rarFlags = new RARFlagsImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(reAuthRequestType==null)
			return "Re-Auth-Request-Type is required";
		
		return super.validate();
	}
}