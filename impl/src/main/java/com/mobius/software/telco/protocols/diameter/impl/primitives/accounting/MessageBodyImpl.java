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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ContentDisposition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ContentLength;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ContentType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MessageBody;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Originator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 889L, vendorId = KnownVendorIDs.TGPP_ID)
public class MessageBodyImpl implements MessageBody
{
	private ContentType contentType;
	private ContentLength contentLength;
	private ContentDisposition contentDisposition;
	private Originator originator;
		
	protected MessageBodyImpl()
	{
	}
	
	public MessageBodyImpl(String contentType,Long contentLength)
	{
		if(contentType==null)
			throw new IllegalArgumentException("Content-Type is required");
		
		if(contentLength==null)
			throw new IllegalArgumentException("Content-Length is required");
		
		this.contentType = new ContentTypeImpl(contentType, null, null);				
		
		this.contentLength = new ContentLengthImpl(contentLength, null, null);
	}
	
	public String getContentType()
	{
		if(contentType==null)
			return null;
		
		return contentType.getString();
	}
	
	public void setContentType(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Content-Type is required");
		
		this.contentType = new ContentTypeImpl(value, null, null);		
	}
	
	public Long getContentLength()
	{
		if(contentLength==null)
			return null;
		
		return contentLength.getUnsigned();
	}
	
	public void setContentLength(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Content-Length is required");
		
		this.contentLength = new ContentLengthImpl(value, null, null);
	}
	
	public String getContentDisposition()
	{
		if(contentDisposition==null)
			return null;
		
		return contentDisposition.getString();
	}
	
	public void setContentDisposition(String value)
	{
		if(value==null)
			this.contentDisposition = null;
		else
			this.contentDisposition = new ContentDispositionImpl(value, null, null);			
	}
	
	public OriginatorEnum getOriginator()
	{
		if(originator==null)
			return null;
		
		return originator.getEnumerated(OriginatorEnum.class);
	}
	
	public void setOriginator(OriginatorEnum value)
	{
		if(value==null)
			this.originator = null;
		else
			this.originator = new OriginatorImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(contentType==null)
			return "Content-Type is required";
		
		if(contentLength==null)
			return "Content-Length is required";
		
		return null;
	}
}