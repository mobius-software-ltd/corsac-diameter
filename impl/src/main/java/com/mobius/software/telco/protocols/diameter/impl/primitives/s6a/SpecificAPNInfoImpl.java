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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.VisitedNetworkIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.VisitedNetworkIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SpecificAPNInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1472L, vendorId = KnownVendorIDs.TGPP_ID)
public class SpecificAPNInfoImpl extends DiameterGroupedAvpImpl implements SpecificAPNInfo
{
	private ServiceSelection serviceSelection;
	
	private MIP6AgentInfo mip6AgentInfo;
	
	private VisitedNetworkIdentifier visitedNetworkIdentifier;
	
	protected SpecificAPNInfoImpl() 
	{
	}
	
	public SpecificAPNInfoImpl(String serviceSelection,MIP6AgentInfo mip6AgentInfo)
	{
		if(serviceSelection==null)
			throw new IllegalArgumentException("Service-Selection is required");
		
		if(mip6AgentInfo==null)
			throw new IllegalArgumentException("MIP6-Agent-Info is required");
		
		this.serviceSelection = new ServiceSelectionImpl(serviceSelection, null, null);
		
		this.mip6AgentInfo = mip6AgentInfo;
	}
	
	public String getServiceSelection()
	{
		if(serviceSelection==null)
			return null;
		
		return serviceSelection.getString();
	}
	
	public void setServiceSelection(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Service-Selection is required");
		
		this.serviceSelection = new ServiceSelectionImpl(value, null, null);			
	}
	
	public MIP6AgentInfo getMIP6AgentInfo()
	{
		return mip6AgentInfo;
	}
	
	public void setMIP6AgentInfo(MIP6AgentInfo value)
	{
		if(value==null)
			throw new IllegalArgumentException("MIP6-Agent-Info is required");
		
		this.mip6AgentInfo = value;			
	}
	
	public ByteBuf getVisitedNetworkIdentifier()
	{
		if(visitedNetworkIdentifier==null)
			return null;
		
		return visitedNetworkIdentifier.getValue();
	}
	
	public void setVisitedNetworkIdentifier(ByteBuf value)
	{
		if(value==null)
			this.visitedNetworkIdentifier = null;
		else
			this.visitedNetworkIdentifier = new VisitedNetworkIdentifierImpl(value, null, null);			
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(serviceSelection==null)
			return "Service-Selection is required";
		
		if(mip6AgentInfo==null)
			return "MIP6-Agent-Info is required is required";
		
		return null;
	}
}