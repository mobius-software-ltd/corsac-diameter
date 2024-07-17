package com.mobius.software.telco.protocols.diameter.impl.commands;

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DestinationHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DestinationRealmImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
	protected DestinationHost destinationHost;
	
	protected DestinationRealm destinationRealm;
	
	private boolean destinationHostAllowed = true;
	
	protected DiameterRequestBase()
	{
		super();
	}
	
	public DiameterRequestBase(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit) throws MissingAvpException
	{
		super(originHost, originRealm, isRetransmit);
		
		if(destinationHost!=null)
			this.destinationHost = new DestinationHostImpl(destinationHost, null, null);
		else
			this.destinationHost = null;
		
		setDestinationRealm(destinationRealm);
	}

	protected void setDestinationHostAllowed(boolean allowed) 
	{
		this.destinationHostAllowed = allowed;
	}

	@Override
	public String getDestinationHost()
	{
		if(destinationHost == null)
			return null;
		
		return destinationHost.getIdentity();
	}

	@Override
	public void setDestinationHost(String value) throws AvpNotSupportedException, MissingAvpException 
	{
		if(!destinationHostAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new DestinationHostImpl(value, null, null) }));
		
		if(value == null)
			this.destinationHost = null;
		else
			this.destinationHost = new DestinationHostImpl(value, null, null);
	}

	@Override
	public String getDestinationRealm() 
	{
		if(destinationRealm == null)
			return null;
		
		return destinationRealm.getIdentity();
	}

	@Override
	public void setDestinationRealm(String value) throws MissingAvpException 
	{
		if(value == null)
			this.destinationRealm = null;
		else
			this.destinationRealm = new DestinationRealmImpl(value, null, null);
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(!destinationHostAllowed && destinationHost!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { destinationHost }));
		
		return super.validate();
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