package com.mobius.software.telco.protocols.diameter.impl.commands.pc6;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeMatchRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.PMRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MatchRequest;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PMRFlags;

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
@DiameterCommandImplementation(applicationId = 16777340, commandCode = 8388670, request = true)
public class ProSeMatchRequestImpl extends Pc6RequestImpl implements ProSeMatchRequest
{
	private MatchRequest matchRequest;
	
	private PMRFlags pmrFlags;
	
	protected ProSeMatchRequestImpl() 
	{
		super();
	}
	
	public ProSeMatchRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,MatchRequest matchRequest)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setMatchRequest(matchRequest);
	}
	
	@Override	
	public MatchRequest getMatchRequest()
	{
		return matchRequest;
	}
	 
	@Override	
	public void setMatchRequest(MatchRequest value)
	{
		if(value == null)
			throw new IllegalArgumentException("Match-Request is required");
		
		this.matchRequest = value;
	}
	
	@Override	
	public Long getPMRFlags()
	{
		if(pmrFlags == null)
			return null;
		
		return pmrFlags.getUnsigned();
	}
	
	@Override	
	public void setPMRFlags(Long value)
	{
		if(value == null)
			this.pmrFlags = null;
		else
			this.pmrFlags = new PMRFlagsImpl(value, null, null);
	}
		
	@DiameterValidate
	public String validate()
	{
		if(matchRequest == null)
			return "Match-Request is required";
		
		return super.validate();
	}	
}