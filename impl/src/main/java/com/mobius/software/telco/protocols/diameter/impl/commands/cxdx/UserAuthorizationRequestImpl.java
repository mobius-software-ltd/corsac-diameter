package com.mobius.software.telco.protocols.diameter.impl.commands.cxdx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.UserNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.PublicIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.UserAuthorizationTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.VisitedNetworkIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
	
	public UserAuthorizationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);		
	}
	
	@Override
	public void setUsername(String value) throws MissingAvpException, AvpNotSupportedException
	{
		if(value==null)
			throw new MissingAvpException("Username is required is required", Arrays.asList(new DiameterAvp[] { new UserNameImpl() }));
		
		super.setUsername(value);		
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
	 
	public void setPublicIdentity(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Public-Identity is required is required", Arrays.asList(new DiameterAvp[] { new PublicIdentityImpl() }));
		
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
	public void setVisitedNetworkId(ByteBuf value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Visited-Network-Identifier is required is required", Arrays.asList(new DiameterAvp[] { new VisitedNetworkIdentifierImpl() }));
		
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
	
	public UARFlags getUARFlags()
	{
		return uarFlags;
	}
	
	public void setUARFlags(UARFlags value)
	{
		this.uarFlags = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(username == null)
			return new MissingAvpException("Username is required is required", Arrays.asList(new DiameterAvp[] { new UserNameImpl() }));
		
		if(publicIdentity == null)
			return new MissingAvpException("Public-Identity is required is required", Arrays.asList(new DiameterAvp[] { new PublicIdentityImpl() }));
		
		if(visitedNetworkId == null)
			return new MissingAvpException("Visited-Network-Identifier is required is required", Arrays.asList(new DiameterAvp[] { new VisitedNetworkIdentifierImpl() }));
		
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
		result.add(username);
		result.add(ocSupportedFeatures);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(publicIdentity);
		result.add(visitedNetworkId);
		result.add(userAuthorizationType);
		result.add(uarFlags);
		
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