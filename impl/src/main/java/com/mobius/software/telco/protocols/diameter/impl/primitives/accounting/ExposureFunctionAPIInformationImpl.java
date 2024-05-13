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

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.APIContent;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.APIDirection;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.APIDirectionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.APIIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.APIInvocationTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.APINetworkServiceNode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.APINetworkServiceNodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.APIResultCode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.APISize;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ExposureFunctionAPIInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SCEFAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SCSASAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TLTRI;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class ExposureFunctionAPIInformationImpl extends DiameterAvpImpl implements ExposureFunctionAPIInformation
{
	private List<SupportedFeatures> supportedFeatures;
	private APIContent apiContent;
	private APIDirection apiDirection;
	private APIIdentifier apiIdentifier;
	private APIInvocationTimestamp apiInvocationTimestamp;
	private APINetworkServiceNode apiNetworkServiceNode;
	private APIResultCode apiResultCode;
	private APISize apiSize;
	private SCEFAddress scefAddress;
	private SCSASAddress scsASAddress;
	private TLTRI tltri;
				
	public ExposureFunctionAPIInformationImpl()
	{
		
	}
	
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return supportedFeatures;			
	}
	
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
	}
	
	public String getAPIContent()
	{
		if(apiContent==null)
			return null;
		
		return apiContent.getString();
	}
	
	public void setAPIContent(String value)
	{
		if(value==null)
			this.apiContent = null;
		else
			this.apiContent = new APIContentImpl(value, null, null);			
	}
	
	public APIDirectionEnum getAPIDirection()
	{
		if(apiDirection==null)
			return null;
		
		return apiDirection.getEnumerated(APIDirectionEnum.class);
	}
	
	public void setAPIDirection(APIDirectionEnum value)
	{
		if(value==null)
			this.apiDirection = null;
		else
			this.apiDirection = new APIDirectionImpl(value, null, null);			
	}
	
	public ByteBuf getAPIIdentifier()
	{
		if(apiIdentifier==null)
			return null;
		
		return apiIdentifier.getValue();
	}
	
	public void setAPIIdentifier(ByteBuf value)
	{
		if(value==null)
			this.apiIdentifier = null;
		else
			this.apiIdentifier = new APIIdentifierImpl(value, null, null);			
	}
	
	public Date getAPIInvocationTimestamp()
	{
		if(apiInvocationTimestamp==null)
			return null;
		
		return apiInvocationTimestamp.getDateTime();
	}
	
	public void setAPIInvocationTimestamp(Date value)
	{
		if(value==null)
			this.apiInvocationTimestamp = null;
		else
			this.apiInvocationTimestamp = new APIInvocationTimestampImpl(value, null, null);			
	}
	
	public APINetworkServiceNodeEnum getAPINetworkServiceNode()
	{
		if(apiNetworkServiceNode==null)
			return null;
		
		return apiNetworkServiceNode.getEnumerated(APINetworkServiceNodeEnum.class);
	}
	
	public void setAPINetworkServiceNode(APINetworkServiceNodeEnum value)
	{
		if(value==null)
			this.apiNetworkServiceNode = null;
		else
			this.apiNetworkServiceNode = new APINetworkServiceNodeImpl(value, null, null);			
	}
	
	public Long getAPIResultCode()
	{
		if(apiResultCode==null)
			return null;
		
		return apiResultCode.getUnsigned();
	}
	
	public void setAPIResultCode(Long value)
	{
		if(value==null)
			this.apiResultCode = null;
		else
			this.apiResultCode = new APIResultCodeImpl(value, null, null);			
	}
	
	public Long getAPISize()
	{
		if(apiSize==null)
			return null;
		
		return apiSize.getLong();
	}
	
	public void setAPISize(Long value)
	{
		if(value==null)
			this.apiSize = null;
		else
			this.apiSize = new APISizeImpl(value, null, null);			
	}
	
	public InetAddress getSCEFAddress()
	{
		if(scefAddress==null)
			return null;
		
		return scefAddress.getAddress();
	}
	
	public void setSCEFAddress(InetAddress value)
	{
		if(value==null)
			this.scefAddress = null;
		else
			this.scefAddress = new SCEFAddressImpl(value, null, null);			
	}
	
	public SCSASAddress getSCSASAddress()
	{
		return scsASAddress;
	}
	
	public void setSCSASAddress(SCSASAddress value)
	{
		this.scsASAddress = value;
	}
	
	public Long getTLTRI()
	{
		if(tltri==null)
			return null;
		
		return tltri.getUnsigned();
	}
	
	public void setTLTRI(Long value)
	{
		if(value==null)
			this.tltri = null;
		else
			this.tltri = new TLTRIImpl(value, null, null);			
	}
}