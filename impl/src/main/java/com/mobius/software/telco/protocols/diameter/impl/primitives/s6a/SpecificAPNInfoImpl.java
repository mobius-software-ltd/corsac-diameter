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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.VisitedNetworkIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6AgentInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public class SpecificAPNInfoImpl extends DiameterGroupedAvpImpl implements SpecificAPNInfo
{
	private ServiceSelection serviceSelection;
	
	private MIP6AgentInfo mip6AgentInfo;
	
	private VisitedNetworkIdentifier visitedNetworkIdentifier;
	
	protected SpecificAPNInfoImpl() 
	{
	}
	
	public SpecificAPNInfoImpl(String serviceSelection,MIP6AgentInfo mip6AgentInfo) throws MissingAvpException
	{
		setServiceSelection(serviceSelection);
		
		setMIP6AgentInfo(mip6AgentInfo);
	}
	
	public String getServiceSelection()
	{
		if(serviceSelection==null)
			return null;
		
		return serviceSelection.getString();
	}
	
	public void setServiceSelection(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Service-Selection is required is required", Arrays.asList(new DiameterAvp[] { new ServiceSelectionImpl() }));
			
		this.serviceSelection = new ServiceSelectionImpl(value, null, null);			
	}
	
	public MIP6AgentInfo getMIP6AgentInfo()
	{
		return mip6AgentInfo;
	}
	
	public void setMIP6AgentInfo(MIP6AgentInfo value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MIP6-Agent-Info is required is required", Arrays.asList(new DiameterAvp[] { new MIP6AgentInfoImpl() }));
			
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
	public DiameterException validate()
	{
		if(serviceSelection==null)
			return new MissingAvpException("Service-Selection is required is required", Arrays.asList(new DiameterAvp[] { new ServiceSelectionImpl() }));
		
		if(mip6AgentInfo==null)
			return new MissingAvpException("MIP6-Agent-Info is required is required", Arrays.asList(new DiameterAvp[] { new MIP6AgentInfoImpl() }));
		
		return null;
	}
}