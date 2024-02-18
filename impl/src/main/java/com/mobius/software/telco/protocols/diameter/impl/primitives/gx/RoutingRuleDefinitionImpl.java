package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Precedence;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingFilter;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleIdentifier;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class RoutingRuleDefinitionImpl extends DiameterGroupedAvpImpl implements RoutingRuleDefinition
{
	private RoutingRuleIdentifier routingRuleIdentifier;
	private List<RoutingFilter> routingFilter;
	private Precedence precedence;
	private RoutingIPAddress routingIPAddress;
	private IPCANType ipcanType;
			
	protected RoutingRuleDefinitionImpl()
	{
		
	}
	
	public RoutingRuleDefinitionImpl(ByteBuf routingRuleIdentifier) throws MissingAvpException
	{
		setRoutingRuleIdentifier(routingRuleIdentifier);
	}
	
	public ByteBuf getRoutingRuleIdentifier()
	{
		if(routingRuleIdentifier==null)
			return null;
		
		return routingRuleIdentifier.getValue();
	}
	
	public void setRoutingRuleIdentifier(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Routing-Rule-Identifier is required is required", Arrays.asList(new DiameterAvp[] { new RoutingRuleIdentifierImpl() }));
		
		this.routingRuleIdentifier = new RoutingRuleIdentifierImpl(value, null, null);
	}
	
	public List<RoutingFilter> getRoutingFilter()
	{
		return routingFilter;
	}
	
	public void setRoutingFilter(List<RoutingFilter> value)
	{
		this.routingFilter = value;
	}
	
	public Long getPrecedence()
	{
		if(precedence==null)
			return null;
		
		return precedence.getUnsigned();
	}
	
	public void setPrecedence(Long value)
	{
		if(value==null)
			this.precedence = null;
		else
			this.precedence = new PrecedenceImpl(value, null, null);			
	}
	
	public InetAddress getRoutingIPAddress()
	{
		if(routingIPAddress==null)
			return null;
		
		return routingIPAddress.getAddress();
	}
	
	public void setRoutingIPAddress(InetAddress value)
	{
		if(value==null)
			this.routingIPAddress = null;
		else
			this.routingIPAddress = new RoutingIPAddressImpl(value, null, null);			
	}
	
	public IPCANTypeEnum getIPCANType()
	{
		if(ipcanType==null)
			return null;
		
		return ipcanType.getEnumerated(IPCANTypeEnum.class);
	}
	
	public void setIPCANType(IPCANTypeEnum value)
	{
		if(value==null)
			this.ipcanType = null;
		else
			this.ipcanType = new IPCANTypeImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(routingRuleIdentifier==null)
			return new MissingAvpException("Routing-Rule-Identifier is required is required", Arrays.asList(new DiameterAvp[] { new RoutingRuleIdentifierImpl() }));
		
		return null;
	}		  		  
}