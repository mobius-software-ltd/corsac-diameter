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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public class MessageBodyImpl implements MessageBody
{
	private ContentType contentType;
	private ContentLength contentLength;
	private ContentDisposition contentDisposition;
	private Originator originator;
		
	protected MessageBodyImpl()
	{
	}
	
	public MessageBodyImpl(String contentType,Long contentLength) throws MissingAvpException
	{
		setContentType(contentType);
		
		setContentLength(contentLength);
	}
	
	public String getContentType()
	{
		if(contentType==null)
			return null;
		
		return contentType.getString();
	}
	
	public void setContentType(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Content-Type is required", Arrays.asList(new DiameterAvp[] { new ContentTypeImpl() }));
		
		this.contentType = new ContentTypeImpl(value, null, null);		
	}
	
	public Long getContentLength()
	{
		if(contentLength==null)
			return null;
		
		return contentLength.getUnsigned();
	}
	
	public void setContentLength(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Content-Length is required", Arrays.asList(new DiameterAvp[] { new ContentLengthImpl() }));
		
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
	public DiameterException validate()
	{
		if(contentType==null)
			return new MissingAvpException("Content-Type is required", Arrays.asList(new DiameterAvp[] { new ContentTypeImpl() }));
		
		if(contentLength==null)
			return new MissingAvpException("Content-Length is required", Arrays.asList(new DiameterAvp[] { new ContentLengthImpl() }));
		
		return null;
	}
}