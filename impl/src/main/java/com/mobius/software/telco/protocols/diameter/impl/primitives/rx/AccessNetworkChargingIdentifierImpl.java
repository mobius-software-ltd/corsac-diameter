package com.mobius.software.telco.protocols.diameter.impl.primitives.rx;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifierValue;
import com.mobius.software.telco.protocols.diameter.primitives.rx.Flows;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class AccessNetworkChargingIdentifierImpl implements AccessNetworkChargingIdentifier
{
	private AccessNetworkChargingIdentifierValue accessNetworkChargingIdentifierValue;
	private List<Flows> flows;
	
	protected AccessNetworkChargingIdentifierImpl()
	{
		
	}
	
	public AccessNetworkChargingIdentifierImpl(ByteBuf accessNetworkChargingIdentifierValue) throws MissingAvpException
	{
		setAccessNetworkChargingIdentifierValue(accessNetworkChargingIdentifierValue);
	}
	
	public ByteBuf getAccessNetworkChargingIdentifierValue()
	{
		if(accessNetworkChargingIdentifierValue == null)
			return null;
		
		return accessNetworkChargingIdentifierValue.getValue();
	}
	
	public void setAccessNetworkChargingIdentifierValue(ByteBuf value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Access-Network-Charging-Identifier-Value is required", Arrays.asList(new DiameterAvp[] { new AccessNetworkChargingIdentifierValueImpl() }));
		
		this.accessNetworkChargingIdentifierValue = new AccessNetworkChargingIdentifierValueImpl(value, null, null);
	}
	
	public List<Flows> getFlows()
	{
		return this.flows;
	}
	
	public void setFlows(List<Flows> value)
	{
		this.flows = value;
	}				
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(accessNetworkChargingIdentifierValue==null)
			return new MissingAvpException("Access-Network-Charging-Identifier-Value is required", Arrays.asList(new DiameterAvp[] { new AccessNetworkChargingIdentifierValueImpl() }));
		
		return null;
	}
}