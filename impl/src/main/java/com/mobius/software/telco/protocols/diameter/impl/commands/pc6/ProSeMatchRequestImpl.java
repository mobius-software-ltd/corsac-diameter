package com.mobius.software.telco.protocols.diameter.impl.commands.pc6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeMatchRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.MatchRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public class ProSeMatchRequestImpl extends Pc6RequestImpl implements ProSeMatchRequest
{
	private MatchRequest matchRequest;
	
	private PMRFlags pmrFlags;
	
	protected ProSeMatchRequestImpl() 
	{
		super();
	}
	
	public ProSeMatchRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,MatchRequest matchRequest) throws MissingAvpException, AvpNotSupportedException
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
	public void setMatchRequest(MatchRequest value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Match-Request is required is required", Arrays.asList(new DiameterAvp[] { new MatchRequestImpl() }));
		
		this.matchRequest = value;
	}
	
	@Override	
	public PMRFlags getPMRFlags()
	{
		return pmrFlags;
	}
	
	@Override	
	public void setPMRFlags(PMRFlags value)
	{
		this.pmrFlags = value;
	}
		
	@DiameterValidate
	public DiameterException validate()
	{
		if(matchRequest == null)
			return new MissingAvpException("Match-Request is required is required", Arrays.asList(new DiameterAvp[] { new MatchRequestImpl() }));
		
		return super.validate();
	}	
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(ocSupportedFeatures);
		result.add(matchRequest);
		result.add(pmrFlags);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}	
}