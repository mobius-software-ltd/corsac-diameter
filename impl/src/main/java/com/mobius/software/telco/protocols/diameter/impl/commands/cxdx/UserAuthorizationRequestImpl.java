package com.mobius.software.telco.protocols.diameter.impl.commands.cxdx;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.PublicIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.UARFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.UserAuthorizationTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.VisitedNetworkIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PublicIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UARFlags;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserAuthorizationType;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserAuthorizationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.VisitedNetworkIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

import io.netty.buffer.ByteBuf;

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
@DiameterCommandImplementation(applicationId = 16777216, commandCode = 300, request = true)
public class UserAuthorizationRequestImpl extends CxDxRequestWithHostBase implements UserAuthorizationRequest
{
	private OCSupportedFeatures ocSupportedFeatures;
	
	private PublicIdentity publicIdentity;
	
	private VisitedNetworkIdentifier visitedNetworkId;
	
	private UserAuthorizationType userAuthorizationType;
	
	private UARFlags uarFlags;
	
	protected UserAuthorizationRequestImpl() 
	{
		super();
	}
	
	public UserAuthorizationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);		
	}
	
	@Override
	public void setUsername(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Username is required");
		
		try
		{
			super.setUsername(value);
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
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
	public ByteBuf getVisitedNetworkId()
	{
		if(visitedNetworkId == null)
			return null;
		
		return visitedNetworkId.getValue();
	}
	
	@Override
	public void setVisitedNetworkId(ByteBuf value)
	{
		if(value == null)
			throw new IllegalArgumentException("Visited-Network-Identifier is required");
		
		this.visitedNetworkId = new VisitedNetworkIdentifierImpl(value, null, null);
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
	
	public Long getUARFlags()
	{
		if(uarFlags == null)
			return null;
		
		return uarFlags.getUnsigned();
	}
	
	public void setUARFlags(Long value)
	{
		if(value == null)
			this.uarFlags = null;
		else
			this.uarFlags = new UARFlagsImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		try
		{
			if(getUsername() == null)
				return "Username is required";
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
		
		if(publicIdentity == null)
			return "Public-Identity is required";
		
		if(visitedNetworkId == null)
			return "Visited-Network-Identifier is required";
		
		return super.validate();
	}
}