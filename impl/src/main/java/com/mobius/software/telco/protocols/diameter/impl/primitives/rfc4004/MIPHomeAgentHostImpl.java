package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DestinationHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DestinationRealmImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.DestinationHost;
import com.mobius.software.telco.protocols.diameter.primitives.common.DestinationRealm;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentHost;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 348L, vendorId = -1L)
public class MIPHomeAgentHostImpl extends DiameterGroupedAvpImpl implements MIPHomeAgentHost
{
	private DestinationHost destinationHost;
	
	private DestinationRealm destinationRealm;
	
	protected MIPHomeAgentHostImpl()
	{
		
	}
	
	public MIPHomeAgentHostImpl(String destinationHost,String destinationRealm)
	{
		if(destinationHost==null)
			throw new IllegalArgumentException("Destination-Host is required");
		
		if(destinationRealm==null)
			throw new IllegalArgumentException("Destination-Realm is required");
		
		this.destinationHost = new DestinationHostImpl(destinationHost, null, null);		
		
		this.destinationRealm = new DestinationRealmImpl(destinationHost, null, null);
	}
	
	public String getDestinationHost()
	{
		if(destinationHost == null)
			return null;
		
		return destinationHost.getIdentity();
	}
	
	public void setDestinationHost(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Destination-Host is required");
		
		this.destinationHost = new DestinationHostImpl(value, null, null);		
	}
	
	public String getDestinationRealm()
	{
		if(destinationRealm == null)
			return null;
		
		return destinationRealm.getIdentity();
	}
	
	public void setDestinationRealm(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Destination-Realm is required");
		
		this.destinationRealm = new DestinationRealmImpl(value, null, null);
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(destinationHost==null)
			return "Destination-Host is required";
		
		if(destinationRealm==null)
			return "Destination-Realm is required";
		
		return null;
	}
}