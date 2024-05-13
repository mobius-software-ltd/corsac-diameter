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
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserData;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserDataContents;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserDataType;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class SIPUserDataImpl extends DiameterGroupedAvpImpl implements SIPUserData
{
	private SIPUserDataType sipUserDataType;
	
	private SIPUserDataContents sipUserDataContents;
	
	protected SIPUserDataImpl()
	{
		
	}
	
	public SIPUserDataImpl(String sipUserDataType,ByteBuf sipUserDataContents) throws MissingAvpException 
	{
		setSIPUserDataType(sipUserDataType);
		
		setSIPUserDataContents(sipUserDataContents);
	}
	
	public String getSIPUserDataType()
	{
		if(sipUserDataType==null)
			return null;
		
		return sipUserDataType.getString();
	}
	
	public void setSIPUserDataType(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("SIP-User-Data-Type is required is required", Arrays.asList(new DiameterAvp[] { new SIPUserDataTypeImpl() }));
			
		this.sipUserDataType = new SIPUserDataTypeImpl(value, null, null);		
	}
	
	public ByteBuf getSIPUserDataContents()
	{
		if(sipUserDataContents==null)
			return null;
		
		return sipUserDataContents.getValue();
	}
	
	public void setSIPUserDataContents(ByteBuf value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("SIP-User-Data-Contents is required is required", Arrays.asList(new DiameterAvp[] { new SIPUserDataContentsImpl() }));
			
		this.sipUserDataContents = new SIPUserDataContentsImpl(value, null, null);		
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(sipUserDataType == null)
			return new MissingAvpException("SIP-User-Data-Type is required is required", Arrays.asList(new DiameterAvp[] { new SIPUserDataTypeImpl() }));
		
		if(sipUserDataContents == null)
			return new MissingAvpException("SIP-User-Data-Contents is required is required", Arrays.asList(new DiameterAvp[] { new SIPUserDataContentsImpl() }));
		
		return null;
	}		
}