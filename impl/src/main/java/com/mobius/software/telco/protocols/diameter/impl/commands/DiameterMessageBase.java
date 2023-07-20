package com.mobius.software.telco.protocols.diameter.impl.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginRealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvpKey;
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginHost;
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginRealm;
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionId;

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
public abstract class DiameterMessageBase extends DiameterGroupedAvpImpl implements DiameterMessage
{
	private Boolean isRetransmit;
	private Long hopByHopIdentifier;
	private Long endToEndIdentifier;
	
	private SessionId sessionId;
	
	private OriginHost originHost;
	
	private OriginRealm originRealm;
	
	private boolean sessionIdAllowed = true;
	
	protected DiameterMessageBase() 
	{
	}
	
	public DiameterMessageBase(String originHost,String originRealm,Boolean isRetransmit)
	{
		this.isRetransmit=isRetransmit;
		
		if(originHost==null)
			throw new IllegalArgumentException("Origin-Host is required");
		
		if(originRealm==null)
			throw new IllegalArgumentException("Origin-Realm is required");
		
		this.originHost=new OriginHostImpl(originHost, null, null);	
		
		this.originRealm=new OriginRealmImpl(originRealm, null, null);			
	}

	protected void setSessionIdAllowed(boolean allowed) 
	{
		this.sessionIdAllowed = allowed;
	}
	
	@Override
	public Map<DiameterAvpKey, List<DiameterAvp>> getOptionalAvps() 
	{
		return optionalAvps;
	}

	@Override
	public List<DiameterAvp> getOptionalAvps(DiameterAvpKey avpKey) 
	{
		return optionalAvps.get(avpKey);
	}

	@Override
	public void addOptionalAvp(DiameterAvpKey avpKey, DiameterAvp avp) 
	{
		List<DiameterAvp> currList = optionalAvps.get(avpKey);
		if(currList==null)
		{
			currList=new ArrayList<DiameterAvp>();
			List<DiameterAvp> oldAvps=optionalAvps.putIfAbsent(avpKey, currList);
			if(oldAvps!=null)
				currList = oldAvps;
		}
		
		currList.add(avp);
	}

	@Override
	public Boolean getIsRetransmit() 
	{
		return isRetransmit;
	}

	@Override
	public Long getHopByHopIdentifier() 
	{
		return hopByHopIdentifier;
	}

	@Override
	public Long getEndToEndIdentifier() 
	{
		return endToEndIdentifier;
	}

	@Override
	public void setIsRetransmit(Boolean value) 
	{
		this.isRetransmit = value;
	}

	@Override
	public void setHopByHopIdentifier(Long value) 
	{
		this.hopByHopIdentifier = value;
	}

	@Override
	public void setEndToEndIdentifier(Long value) 
	{
		this.endToEndIdentifier = value;
	}

	@Override
	public String getOriginHost() 
	{
		if(originHost == null)
			return null;
		
		return originHost.getIdentity();
	}

	@Override
	public void setOriginHost(String originHost) 
	{
		if(originHost==null)
			throw new IllegalArgumentException("Origin-Host is required");
		
		this.originHost = new OriginHostImpl(originHost, null, null);
	}

	@Override
	public String getOriginRealm() 
	{
		if(originRealm == null)
			return null;
		
		return originRealm.getIdentity();
	}

	@Override
	public void setOriginRealm(String originRealm) 
	{
		if(originRealm==null)
			throw new IllegalArgumentException("Origin-Realm is required");
		
		this.originRealm = new OriginRealmImpl(originRealm, null, null);
	}
	
	@Override
	public String getSessionId() throws AvpNotSupportedException
	{
		if(!sessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(sessionId == null)
			return null;
		
		return sessionId.getString();
	}
	
	@Override
	public void setSessionId(String value) throws AvpNotSupportedException
	{
		if(!sessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value == null)
			this.sessionId = null;
		else
			this.sessionId = new SessionIdImpl(value, null, null);
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endToEndIdentifier == null) ? 0 : endToEndIdentifier.hashCode());
		result = prime * result + ((hopByHopIdentifier == null) ? 0 : hopByHopIdentifier.hashCode());
		result = prime * result + ((isRetransmit == null) ? 0 : isRetransmit.hashCode());
		result = prime * result + ((optionalAvps == null) ? 0 : optionalAvps.hashCode());
		result = prime * result + ((originHost == null) ? 0 : originHost.hashCode());
		result = prime * result + ((originRealm == null) ? 0 : originRealm.hashCode());
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		DiameterMessageBase other = (DiameterMessageBase) obj;
		if (endToEndIdentifier == null) 
		{
			if (other.endToEndIdentifier != null)
				return false;
		} 
		else if (!endToEndIdentifier.equals(other.endToEndIdentifier))
			return false;
		
		if (hopByHopIdentifier == null) 
		{
			if (other.hopByHopIdentifier != null)
				return false;
		} 
		else if (!hopByHopIdentifier.equals(other.hopByHopIdentifier))
			return false;
		
		if (isRetransmit == null) 
		{
			if (other.isRetransmit != null)
				return false;
		} 
		else if (!isRetransmit.equals(other.isRetransmit))
			return false;
		
		if (optionalAvps == null) 
		{
			if (other.optionalAvps != null)
				return false;
		} 
		else if (!optionalAvps.equals(other.optionalAvps))
			return false;
		
		if (originHost == null) 
		{
			if (other.originHost != null)
				return false;
		} 
		else if (!originHost.equals(other.originHost))
			return false;
		
		if (originRealm == null) 
		{
			if (other.originRealm != null)
				return false;
		} 
		else if (!originRealm.equals(other.originRealm))
			return false;
		
		if (sessionId == null) 
		{
			if (other.sessionId != null)
				return false;
		} 
		else if (!sessionId.equals(other.sessionId))
			return false;
		
		return true;
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(originHost==null)
			return "Origin-Host is required";
		
		if(originRealm==null)
			return "Origin-Realm is required";
		
		return null;
	}
}