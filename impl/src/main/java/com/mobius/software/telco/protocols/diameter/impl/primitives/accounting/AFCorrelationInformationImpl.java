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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AFChargingIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AFCorrelationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.Flows;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class AFCorrelationInformationImpl implements AFCorrelationInformation
{
	private AFChargingIdentifier afChargingIdentifier;
	private List<Flows> flows;
		
	protected AFCorrelationInformationImpl() 
	{
	}
	
	public AFCorrelationInformationImpl(ByteBuf afChargingIdentifier) throws MissingAvpException
	{
		setAFChargingIdentifier(afChargingIdentifier);
	}
	
	public ByteBuf getAFChargingIdentifier()
	{
		if(afChargingIdentifier==null)
			return null;
		
		return afChargingIdentifier.getValue();
	}
	
	public void setAFChargingIdentifier(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("AF-Charging-Identifier is required", Arrays.asList(new DiameterAvp[] { new AFChargingIdentifierImpl() }));
			
		this.afChargingIdentifier = new AFChargingIdentifierImpl(value, null, null);				
	}
	
	public List<Flows> getFlows()
	{
		return flows;
	}
	
	public void setFlows(List<Flows> value)
	{
		this.flows = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(afChargingIdentifier==null)
			return new MissingAvpException("AF-Charging-Identifier is required", Arrays.asList(new DiameterAvp[] { new AFChargingIdentifierImpl() }));
		
		return null;
	}
}