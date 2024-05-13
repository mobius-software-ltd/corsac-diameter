package com.mobius.software.telco.protocols.diameter.impl.commands.s9;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s9.TriggerEstablishmentRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationRequestWithHostBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.HeNBLocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UDPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UELocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s9.DRABindingImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.gx.HeNBLocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UDPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s9.DRABinding;
import com.mobius.software.telco.protocols.diameter.primitives.s9.DRABindingEnum;

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
public class TriggerEstablishmentRequestImpl extends AuthenticationRequestWithHostBase implements TriggerEstablishmentRequest
{
	private DRMP drmp;
	
	private AuthSessionState authSessionState;
	
	private SubscriptionId subscriptionId;

	private OCSupportedFeatures ocSupportedFeatures;
	
	private CalledStationId calledStationId;
	
	private UELocalIPAddress ueLocalIPAddress;
	
	private HeNBLocalIPAddress heNBLocalIPAddress;
	
	private DRABinding draBinding;
	
	private UDPSourcePort udpSourcePort;
	
	protected TriggerEstablishmentRequestImpl() 
	{
		super();
	}

	public TriggerEstablishmentRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);		
		
		setAuthSessionState(authSessionState);
	}

	@Override
	public DRMPEnum getDRMP() 
	{
		if(drmp==null)
			return null;
		
		return drmp.getEnumerated(DRMPEnum.class);
	}

	@Override
	public void setDRMP(DRMPEnum value) 
	{
		if(value==null)
			this.drmp = null;
		else
			this.drmp = new DRMPImpl(value, null, null);
	}

	@Override
	public AuthSessionStateEnum getAuthSessionState() 
	{
		if(authSessionState==null)
			return null;
		
		return authSessionState.getEnumerated(AuthSessionStateEnum.class);
	}

	@Override
	public void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException 
	{
		if(value == null)
			throw new MissingAvpException("Auth-Session-State is required is required", Arrays.asList(new DiameterAvp[] { new AuthSessionStateImpl() }));
		
		this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}
	
	
	@Override
	public SubscriptionId getSubscriptionId() 
	{
		return subscriptionId;
	}

	@Override
	public void setSubscriptionId(SubscriptionId value) 
	{
		this.subscriptionId = value;
	}

	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return ocSupportedFeatures;
	}
	
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public String getCalledStationId() 
	{
		if(calledStationId == null)
			return null;
		
		return calledStationId.getString();
	}

	@Override
	public void setCalledStationId(String value) 
	{
		if(value == null)
			this.calledStationId = null;
		else
			this.calledStationId = new CalledStationIdImpl(value, null, null);
	}
	
	@Override
	public InetAddress getUELocalIPAddress()
	{
		if(ueLocalIPAddress==null)
			return null;
		
		return ueLocalIPAddress.getAddress();
	}
	
	@Override
	public void setUELocalIPAddress(InetAddress value)
	{
		if(value==null)
			this.ueLocalIPAddress = null;
		else
			this.ueLocalIPAddress = new UELocalIPAddressImpl(value, null, null);			
	}
	
	@Override
	public InetAddress getHeNBLocalIPAddress()
	{
		if(heNBLocalIPAddress==null)
			return null;
		
		return heNBLocalIPAddress.getAddress();
	}
	
	@Override
	public void setHeNBLocalIPAddress(InetAddress value)
	{
		if(value==null)
			this.heNBLocalIPAddress = null;
		else
			this.heNBLocalIPAddress = new HeNBLocalIPAddressImpl(value, null, null);			
	}
	
	@Override
	public DRABindingEnum getDRABinding()
	{
		if(draBinding==null)
			return null;
		
		return draBinding.getEnumerated(DRABindingEnum.class);
	}
	
	@Override
	public void setDRABinding(DRABindingEnum value)
	{
		if(value==null)
			this.draBinding = null;
		else
			this.draBinding = new DRABindingImpl(value, null, null);			
	}
	
	@Override
	public Long getUDPSourcePort()
	{
		if(udpSourcePort==null)
			return null;
		
		return udpSourcePort.getUnsigned();
	}
	
	@Override
	public void setUDPSourcePort(Long value)
	{
		if(value==null)
			this.udpSourcePort = null;
		else
			this.udpSourcePort = new UDPSourcePortImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(authSessionState == null)
			return new MissingAvpException("Auth-Session-State is required is required", Arrays.asList(new DiameterAvp[] { new AuthSessionStateImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(authSessionState);
		result.add(originStateId);
		result.add(subscriptionId);
		result.add(ocSupportedFeatures);
		result.add(calledStationId);
		result.add(ueLocalIPAddress);
		result.add(heNBLocalIPAddress);
		result.add(draBinding);
		result.add(udpSourcePort);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
				
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}