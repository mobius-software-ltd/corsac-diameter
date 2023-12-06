package com.mobius.software.telco.protocols.diameter.impl.commands.cxdx;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.LocationInfoRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.OriginatingRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.PublicIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SessionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.UserAuthorizationTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.OriginatingRequest;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.OriginatingRequestEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PublicIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SessionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SessionPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserAuthorizationType;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserAuthorizationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

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
@DiameterCommandImplementation(applicationId = 16777216, commandCode = 302, request = true)
public class LocationInfoRequestImpl extends CxDxRequestWithHostBase implements LocationInfoRequest
{
	private OriginatingRequest originatingRequest;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private PublicIdentity publicIdentity;
	
	private UserAuthorizationType userAuthorizationType;
	
	private SessionPriority sessionPriority;
	
	protected LocationInfoRequestImpl() 
	{
		super();
	}
	
	public LocationInfoRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,String publicIdentity)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setPublicIdentity(publicIdentity);
	}
	
	public OriginatingRequestEnum getOriginatingRequest()
	{
		if(originatingRequest == null)
			return null;
		
		return originatingRequest.getEnumerated(OriginatingRequestEnum.class);
	}
	
	public void setOriginatingRequest(OriginatingRequestEnum value)
	{
		if(value == null)
			this.originatingRequest = null;
		else
			this.originatingRequest = new OriginatingRequestImpl(value, null, null);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	public String getPublicIdentity()
	{
		if(publicIdentity == null)
			return null;
		
		return publicIdentity.getString();
	}
	 
	public void setPublicIdentity(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("Public-Identity is required");
		
		this.publicIdentity = new PublicIdentityImpl(value, null, null);
	}
		
	@Override
	public UserAuthorizationTypeEnum getUserAuthorizationType()
	{
		if(userAuthorizationType == null)
			return null;
		
		return userAuthorizationType.getEnumerated(UserAuthorizationTypeEnum.class);
	}
	
	@Override
	public void setUserAuthorizationType(UserAuthorizationTypeEnum value)
	{
		if(value == null)
			this.userAuthorizationType = null;
		else
			this.userAuthorizationType = new UserAuthorizationTypeImpl(value, null, null);
	}
	
	public SessionPriorityEnum getSessionPriority()
	{
		if(sessionPriority == null)
			return null;
		
		return sessionPriority.getEnumerated(SessionPriorityEnum.class);
	}
	
	public void setSessionPriority(SessionPriorityEnum value)
	{
		if(value == null)
			this.sessionPriority = null;
		else
			this.sessionPriority = new SessionPriorityImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(publicIdentity == null)
			return "Public-Identity is required";
		
		return super.validate();
	}	
}