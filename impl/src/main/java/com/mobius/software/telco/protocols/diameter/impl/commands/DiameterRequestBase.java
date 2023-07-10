package com.mobius.software.telco.protocols.diameter.impl.commands;

import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DestinationHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DestinationRealmImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.DestinationHost;
import com.mobius.software.telco.protocols.diameter.primitives.common.DestinationRealm;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
public abstract class DiameterRequestBase extends DiameterMessageBase implements DiameterRequest
{
	private DestinationHost destinationHost;
	
	private DestinationRealm destinationRealm;
	
	protected DiameterRequestBase()
	{
		
	}
	
	public DiameterRequestBase(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit)
	{
		super(originHost, originRealm, isRetransmit);
		if(destinationHost!=null)
			this.destinationHost = new DestinationHostImpl(destinationHost, null, null);
		else
			this.destinationHost = null;
		
		if(destinationRealm!=null)
			this.destinationRealm = new DestinationRealmImpl(destinationRealm, null, null);
		else
			this.destinationRealm = null;
	}

	@Override
	public String getDestinationHost() 
	{
		if(destinationHost == null)
			return null;
		
		return destinationHost.getIdentity();
	}

	@Override
	public void setDestinationHost(String destinationHost) 
	{
		if(destinationHost == null)
			this.destinationHost = null;
		else
			this.destinationHost = new DestinationHostImpl(destinationHost, null, null);
	}

	@Override
	public String getDestinationRealm() 
	{
		if(destinationRealm == null)
			return null;
		
		return destinationRealm.getIdentity();
	}

	@Override
	public void setDestinationRealm(String destinationRealm) 
	{
		if(destinationRealm == null)
			this.destinationRealm = null;
		else
			this.destinationRealm = new DestinationRealmImpl(destinationRealm, null, null);
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((destinationHost == null) ? 0 : destinationHost.hashCode());
		result = prime * result + ((destinationRealm == null) ? 0 : destinationRealm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		
		if (!super.equals(obj))
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		DiameterRequestBase other = (DiameterRequestBase) obj;
		if (destinationHost == null) 
		{
			if (other.destinationHost != null)
				return false;
		} 
		else if (!destinationHost.equals(other.destinationHost))
			return false;
		
		if (destinationRealm == null) 
		{
			if (other.destinationRealm != null)
				return false;
		} 
		else if (!destinationRealm.equals(other.destinationRealm))
			return false;
		
		return true;
	}
}