package com.mobius.software.telco.protocols.diameter.impl.commands.t6a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.t6a.MODataRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.BearerIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.UserIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.NonIPDataImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.NonIPData;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.RRCCauseCounter;

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
public class MODataRequestImpl extends T6aRequestImpl implements MODataRequest
{
	private UserIdentifier userIdentifier;
	
	private BearerIdentifier bearerIdentifier;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private NonIPData nonIPData;
	
	private RRCCauseCounter rrcCauseCounter;
	
	protected MODataRequestImpl() 
	{
		super();
	}
	
	public MODataRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,UserIdentifier userIdentifier,ByteBuf bearerIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setUserIdentifier(userIdentifier);
		
		setBearerIdentifier(bearerIdentifier);
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
	public ByteBuf getBearerIdentifier()
	{
		if(bearerIdentifier == null)
			return null;
		
		return bearerIdentifier.getValue();
	}
	
	@Override
	public void setBearerIdentifier(ByteBuf value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Bearer-Identifier is required", Arrays.asList(new DiameterAvp[] { new BearerIdentifierImpl() }));
		
		this.bearerIdentifier = new BearerIdentifierImpl(value, null, null);
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
	public ByteBuf getNonIPData()
	{
		if(nonIPData == null)
			return null;
		
		return nonIPData.getValue();
	}
	
	@Override
	public void setNonIPData(ByteBuf value)
	{
		if(value == null)
			this.nonIPData = null;
		else
			this.nonIPData = new NonIPDataImpl(value, null, null);
	}	
	
	@Override
	public RRCCauseCounter getRRCCauseCounter()
	{
		return this.rrcCauseCounter;
	}
	
	@Override
	public void setRRCCauseCounter(RRCCauseCounter value)
	{
		this.rrcCauseCounter = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(bearerIdentifier == null)
			return new MissingAvpException("Bearer-Identifier is required", Arrays.asList(new DiameterAvp[] { new BearerIdentifierImpl() }));
		
		if(userIdentifier == null)
			return new MissingAvpException("User-Identifier is required", Arrays.asList(new DiameterAvp[] { new UserIdentifierImpl() }));
		
		return super.validate();
	}	
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(userIdentifier);
		result.add(bearerIdentifier);
		result.add(drmp);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(ocSupportedFeatures);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(nonIPData);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		result.add(rrcCauseCounter);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}		
}