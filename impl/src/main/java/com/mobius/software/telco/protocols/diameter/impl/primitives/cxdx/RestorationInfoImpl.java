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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.InitialCSeqSequenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PCSCFSubscriptionInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.Path;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.RestorationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SubscriptionInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 649L, vendorId = KnownVendorIDs.TGPP_ID)
public class RestorationInfoImpl extends DiameterGroupedAvpImpl implements RestorationInfo
{
	private Path path;
	
	private Contact contact;
	
	private InitialCSeqSequenceNumber initialCSeqSequenceNumber;
	
	private CallIDSIPHeader callIDSIPHeader;
	
	private SubscriptionInfo subscriptionInfo;
	
	private PCSCFSubscriptionInfo pcscfSubscriptionInfo;
	
	protected RestorationInfoImpl()
	{
		
	}
	
	public RestorationInfoImpl(ByteBuf path,ByteBuf contact)
	{
		if(path==null)
			throw new IllegalArgumentException("Path is required");
		
		if(contact==null)
			throw new IllegalArgumentException("Contact is required");
		
		this.path = new PathImpl(path, null, null);
		
		this.contact = new ContactImpl(contact, null, null);
	}
	
	public ByteBuf getPath()
	{
		if(path==null)
			return null;
		
		return path.getValue();
	}
	
	public void setPath(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Path is required");
		
		this.path = new PathImpl(value, null, null);
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
	
	public Long getInitialCSeqSequenceNumber()
	{
		if(initialCSeqSequenceNumber==null)
			return null;
		
		return initialCSeqSequenceNumber.getUnsigned();
	}
	
	public void setInitialCSeqSequenceNumber(Long value)
	{
		if(value == null)
			this.initialCSeqSequenceNumber = null;
		else
			this.initialCSeqSequenceNumber = new InitialCSeqSequenceNumberImpl(value, null, null);
	}
	
	public ByteBuf getCallIDSIPHeader()
	{
		if(callIDSIPHeader==null)
			return null;
		
		return callIDSIPHeader.getValue();
	}
	
	public void setCallIDSIPHeader(ByteBuf value)
	{
		if(value == null)
			this.callIDSIPHeader = null;
		else
			this.callIDSIPHeader = new CallIDSIPHeaderImpl(value, null, null);
	}
	
	public SubscriptionInfo getSubscriptionInfo()
	{
		return this.subscriptionInfo;
	}
	
	public void setSubscriptionInfo(SubscriptionInfo value)
	{
		this.subscriptionInfo = value;
	}
	
	public PCSCFSubscriptionInfo getPCSCFSubscriptionInfo()
	{
		return this.pcscfSubscriptionInfo;
	}
	
	public void setPCSCFSubscriptionInfo(PCSCFSubscriptionInfo value)
	{
		this.pcscfSubscriptionInfo = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(path==null)
			return "Path is required";
		
		if(contact==null)
			return "Contact is required";
		
		return null;
	}
}