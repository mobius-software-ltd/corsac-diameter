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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
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
@DiameterAvpImplementation(code = 660L, vendorId = KnownVendorIDs.TGPP_ID)
public class PCSCFSubscriptionInfoImpl extends DiameterGroupedAvpImpl implements PCSCFSubscriptionInfo
{
	private CallIDSIPHeader callIDSIPHeader;
	
	private FromSIPHeader fromSIPHeader;
	
	private ToSIPHeader toSIPHeader;
	
	private Contact contact;
	
	protected PCSCFSubscriptionInfoImpl()
	{
		
	}
	
	public PCSCFSubscriptionInfoImpl(ByteBuf callIDSIPHeader,ByteBuf fromSIPHeader,ByteBuf toSIPHeader,ByteBuf contact)
	{
		if(callIDSIPHeader==null)
			throw new IllegalArgumentException("Call-ID-SIP-Header is required");
		
		if(fromSIPHeader==null)
			throw new IllegalArgumentException("From-SIP-Header is required");
		
		if(toSIPHeader==null)
			throw new IllegalArgumentException("To-SIP-Header is required");
		
		if(contact==null)
			throw new IllegalArgumentException("Contact is required");
		
		this.callIDSIPHeader = new CallIDSIPHeaderImpl(callIDSIPHeader, null, null);
		
		this.fromSIPHeader = new FromSIPHeaderImpl(fromSIPHeader, null, null);
		
		this.toSIPHeader = new ToSIPHeaderImpl(toSIPHeader, null, null);
		
		this.contact = new ContactImpl(contact, null, null);
	}
	
	public ByteBuf getCallIDSIPHeader()
	{
		if(callIDSIPHeader==null)
			return null;
		
		return callIDSIPHeader.getValue();
	}
	
	public void setCallIDSIPHeader(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Call-ID-SIP-Header is required");
		
		this.callIDSIPHeader = new CallIDSIPHeaderImpl(value, null, null);
	}
	
	public ByteBuf getFromSIPHeader()
	{
		if(fromSIPHeader==null)
			return null;
		
		return fromSIPHeader.getValue();
	}
	
	public void setFromSIPHeader(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("From-SIP-Header is required");
		
		this.fromSIPHeader = new FromSIPHeaderImpl(value, null, null);
	}
	
	public ByteBuf getToSIPHeader()
	{
		if(toSIPHeader==null)
			return null;
		
		return toSIPHeader.getValue();
	}
	
	public void setToSIPHeader(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("To-SIP-Header is required");
		
		this.toSIPHeader = new ToSIPHeaderImpl(value, null, null);
	}
	
	public ByteBuf getContact()
	{
		if(contact==null)
			return null;
		
		return contact.getValue();
	}
	
	public void setContact(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Contact is required");
		
		this.contact = new ContactImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(callIDSIPHeader==null)
			return "Call-ID-SIP-Header is required";
		
		if(fromSIPHeader==null)
			return "From-SIP-Header is required";
		
		if(toSIPHeader==null)
			return "To-SIP-Header is required";
		
		if(contact==null)
			return "Contact is required";
		
		return null;
	}	
}