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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.CallIDSIPHeader;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.Contact;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.FromSIPHeader;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PCSCFSubscriptionInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ToSIPHeader;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class PCSCFSubscriptionInfoImpl extends DiameterGroupedAvpImpl implements PCSCFSubscriptionInfo
{
	private CallIDSIPHeader callIDSIPHeader;
	
	private FromSIPHeader fromSIPHeader;
	
	private ToSIPHeader toSIPHeader;
	
	private Contact contact;
	
	protected PCSCFSubscriptionInfoImpl()
	{
		
	}
	
	public PCSCFSubscriptionInfoImpl(ByteBuf callIDSIPHeader,ByteBuf fromSIPHeader,ByteBuf toSIPHeader,ByteBuf contact) throws MissingAvpException
	{
		setCallIDSIPHeader(contact);
		
		setFromSIPHeader(fromSIPHeader);
		
		setToSIPHeader(toSIPHeader);
		
		setContact(contact);
	}
	
	public ByteBuf getCallIDSIPHeader()
	{
		if(callIDSIPHeader==null)
			return null;
		
		return callIDSIPHeader.getValue();
	}
	
	public void setCallIDSIPHeader(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Call-ID-SIP-Header is required", Arrays.asList(new DiameterAvp[] { new CallIDSIPHeaderImpl() }));
		
		this.callIDSIPHeader = new CallIDSIPHeaderImpl(value, null, null);
	}
	
	public ByteBuf getFromSIPHeader()
	{
		if(fromSIPHeader==null)
			return null;
		
		return fromSIPHeader.getValue();
	}
	
	public void setFromSIPHeader(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("From-SIP-Header is required", Arrays.asList(new DiameterAvp[] { new FromSIPHeaderImpl() }));
		
		this.fromSIPHeader = new FromSIPHeaderImpl(value, null, null);
	}
	
	public ByteBuf getToSIPHeader()
	{
		if(toSIPHeader==null)
			return null;
		
		return toSIPHeader.getValue();
	}
	
	public void setToSIPHeader(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("To-SIP-Header is required", Arrays.asList(new DiameterAvp[] { new ToSIPHeaderImpl() }));
		
		this.toSIPHeader = new ToSIPHeaderImpl(value, null, null);
	}
	
	public ByteBuf getContact()
	{
		if(contact==null)
			return null;
		
		return contact.getValue();
	}
	
	public void setContact(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Contact is required", Arrays.asList(new DiameterAvp[] { new ContactImpl() }));
		
		this.contact = new ContactImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(callIDSIPHeader==null)
			return new MissingAvpException("Call-ID-SIP-Header is required", Arrays.asList(new DiameterAvp[] { new CallIDSIPHeaderImpl() }));
		
		if(fromSIPHeader==null)
			return new MissingAvpException("From-SIP-Header is required", Arrays.asList(new DiameterAvp[] { new FromSIPHeaderImpl() }));
		
		if(toSIPHeader==null)
			return new MissingAvpException("To-SIP-Header is required", Arrays.asList(new DiameterAvp[] { new ToSIPHeaderImpl() }));
		
		if(contact==null)
			return new MissingAvpException("Contact is required", Arrays.asList(new DiameterAvp[] { new ContactImpl() }));
		
		return null;
	}	
}