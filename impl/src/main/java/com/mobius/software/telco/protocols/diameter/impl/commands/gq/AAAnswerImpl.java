package com.mobius.software.telco.protocols.diameter.impl.commands.gq;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.gq.AAAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.AuthorizationTokenImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AccessNetworkChargingAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gq.AuthorizationToken;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifier;

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
public class AAAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl implements AAAnswer
{
	protected AuthorizationToken authorizationToken;
	
	protected List<AccessNetworkChargingIdentifier> accessNetworkChargingIdentifier;	
	
	protected AccessNetworkChargingAddress accessNetworkChargingAddress;	
    
	protected AAAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public AAAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId) throws AvpNotSupportedException, MissingAvpException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		setExperimentalResultAllowed(false);
	}

	@Override
	public ByteBuf getAuthorizationToken()
	{
		if(authorizationToken==null)
			return null;
		
		return this.authorizationToken.getValue();
	}
	
	@Override
	public void setAuthorizationToken(ByteBuf value)
	{
		if(value == null)
			this.authorizationToken = null;
		else
			this.authorizationToken = new AuthorizationTokenImpl(value, null, null);
	}
	
	@Override
	public List<AccessNetworkChargingIdentifier> getAccessNetworkChargingIdentifier()
	{
		return this.accessNetworkChargingIdentifier;
	}
	
	@Override
	public void setAccessNetworkChargingIdentifier(List<AccessNetworkChargingIdentifier> value)
	{
		this.accessNetworkChargingIdentifier = value;
	}
	
	@Override
	public InetAddress getAccessNetworkChargingAddress()
	{
		if(accessNetworkChargingAddress==null)
			return null;
		
		return accessNetworkChargingAddress.getAddress();
	}
	
	@Override
	public void setAccessNetworkChargingAddress(InetAddress value)
	{
		if(value==null)
			this.accessNetworkChargingAddress = null;
		else
			this.accessNetworkChargingAddress = new AccessNetworkChargingAddressImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(authorizationToken);
		
		if(accessNetworkChargingIdentifier!=null)
			result.addAll(accessNetworkChargingIdentifier);

		result.add(accessNetworkChargingAddress);
		result.add(errorMessage);
        result.add(errorReportingHost);
        result.add(failedAvp);
        
        if(proxyInfo!=null)
			result.addAll(proxyInfo);

        if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}