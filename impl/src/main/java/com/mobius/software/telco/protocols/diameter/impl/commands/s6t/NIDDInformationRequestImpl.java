package com.mobius.software.telco.protocols.diameter.impl.commands.s6t;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6t.NIDDInformationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.UserIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupUserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MTCProviderInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIDDAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIDDAuthorizationUpdate;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UserIdentifier;

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
public class NIDDInformationRequestImpl extends S6tRequestImpl implements NIDDInformationRequest
{
	private UserIdentifier userIdentifier;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private NIDDAuthorizationRequest niddAuthorizationRequest;
	
	private NIDDAuthorizationUpdate niddAuthorizationUpdate;
	
	private NIRFlags nirFlags;
	
	private List<GroupUserIdentifier> groupUserIdentifier;
	
	private MTCProviderInfo mtcProviderInfo;
	
	protected NIDDInformationRequestImpl() 
	{
		super();
	}
	
	public NIDDInformationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,UserIdentifier userIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setUserIdentifier(userIdentifier);
	}
	
	@Override
	public UserIdentifier getUserIdentifier()
	{
		if(userIdentifier == null)
			return null;
		
		return userIdentifier;
	}
	
	@Override
	public void setUserIdentifier(UserIdentifier value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("User-Identifier is required", Arrays.asList(new DiameterAvp[] { new UserIdentifierImpl() }));
		
		this.userIdentifier = value;
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}	
	
	@Override
	public NIDDAuthorizationRequest getNIDDAuthorizationRequest()
	{
		return niddAuthorizationRequest;
	}
	
	@Override
	public void setNIDDAuthorizationRequest(NIDDAuthorizationRequest value)
	{
		this.niddAuthorizationRequest = value;
	}
	
	@Override
	public NIDDAuthorizationUpdate getNIDDAuthorizationUpdate()
	{
		return niddAuthorizationUpdate;
	}
	 
	@Override
	public void setNIDDAuthorizationUpdate(NIDDAuthorizationUpdate value)
	{
		this.niddAuthorizationUpdate = value;
	}
	
	@Override
	public NIRFlags getNIRFlags()
	{
		return nirFlags;
	}
	
	@Override
	public void setNIRFlags(NIRFlags value)
	{
		this.nirFlags = value;
	}	
	
	@Override
	public List<GroupUserIdentifier> getGroupUserIdentifier()
	{
		return this.groupUserIdentifier;
	}
	
	@Override
	public void setGroupUserIdentifier(List<GroupUserIdentifier> value)
	{
		this.groupUserIdentifier = value;
	}	
	
	@Override
	public MTCProviderInfo getMTCProviderInfo()
	{
		return this.mtcProviderInfo;
	}
	
	@Override
	public void setMTCProviderInfo(MTCProviderInfo value)
	{
		this.mtcProviderInfo = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(userIdentifier == null)
			return new MissingAvpException("User-Identifier is required", Arrays.asList(new DiameterAvp[] { new UserIdentifierImpl() }));
		
		return super.validate();
	}		
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(userIdentifier);
		result.add(ocSupportedFeatures);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(niddAuthorizationRequest);
		result.add(niddAuthorizationUpdate);
		result.add(nirFlags);
		
		if(groupUserIdentifier!=null)
			result.addAll(groupUserIdentifier);
		
		result.add(mtcProviderInfo);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}	
}