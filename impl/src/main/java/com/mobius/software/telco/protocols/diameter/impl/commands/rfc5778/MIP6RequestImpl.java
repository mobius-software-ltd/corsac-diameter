package com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778.MIP6Request;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallingStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMNAAASPIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMobileNodeAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ChargeableUserIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.MIP6AuthModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.MIPAuthenticatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.MIPCareofAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.MIPMACMobilityDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.MIPMNHASPIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.MIPTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallingStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNAAASPI;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMobileNodeAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ChargeableUserIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIP6AuthMode;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIP6AuthModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIPAuthenticator;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIPCareofAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIPMACMobilityData;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIPMNHASPI;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIPTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;

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
@DiameterCommandImplementation(applicationId = 8, commandCode = 325, request = true)
public class MIP6RequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationRequestImpl implements MIP6Request
{
	private AuthRequestType authRequestType;
	
	private NASIdentifier nasIdentifier;
	
	private NASIPAddress nasIPAddress;
	
	private NASIPv6Address nasIPv6Address;
	
	private NASPortType nasPortType;
	
	private CalledStationId calledStationId;
	
	private CallingStationId callingStationId;		
	
	private MIP6FeatureVector mip6FeatureVector;
	
	private MIP6AuthMode mip6AuthMode;
	
	private MIPMNAAASPI mipMNAAASPI;
	
	private MIPMNHASPI mipMNHASPI;
	
	private List<MIPMobileNodeAddress> mipMobileNodeAddress;
    
	private MIP6AgentInfo mip6AgentInfo;
	
	private MIPCareofAddress mipCareofAddress;
	
	private MIPAuthenticator mipAuthenticator;
	
	private MIPMACMobilityData mipMACMobilityData;
	
	private MIPTimestamp mipTimestamp;
	
	private QoSCapability qosCapability;
    
	private List<QoSResources> qosResources;
	
	private ChargeableUserIdentity chargeableUserIdentity;
    
	private ServiceSelection serviceSelection;
    	                    
	private AuthorizationLifetime authorizationLifetime;
	
	private AuthSessionState authSessionState;
	
	protected MIP6RequestImpl() 
	{
		super();
	}
	
	public MIP6RequestImpl(String originHost,String originRealm,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId,AuthRequestTypeEnum authRequestType,List<InetAddress> mipMobileNodeAddress,MIP6AgentInfo mip6AgentInfo,InetAddress mipCareofAddress)
	{
		super(originHost, originRealm, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
		setAuthRequestType(authRequestType);
		
		setMIP6AgentInfo(mip6AgentInfo);
		
		setMIPMobileNodeAddress(mipMobileNodeAddress);
		
		setMIPCareofAddress(mipCareofAddress);				
	}

	@Override
	public AuthRequestTypeEnum getAuthRequestType() 
	{
		if(authRequestType == null)
			return null;
		
		return authRequestType.getEnumerated(AuthRequestTypeEnum.class);
	}

	@Override
	public void setAuthRequestType(AuthRequestTypeEnum value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Auth-Request-Type is required");
		
		this.authRequestType = new AuthRequestTypeImpl(value, null, null);
	}

	@Override
	public String getNASIdentifier() 
	{
		if(nasIdentifier == null)
			return null;
		
		return nasIdentifier.getString();
	}

	@Override
	public void setNASIdentifier(String value) 
	{
		if(value == null)
			this.nasIdentifier = null;
		else
			this.nasIdentifier = new NASIdentifierImpl(value, null, null);
	}

	@Override
	public InetAddress getNASIPAddress() 
	{
		if(nasIPAddress == null)
			return null;
		
		return nasIPAddress.getAddress();
	}

	@Override
	public void setNASIPAddress(Inet4Address value) 
	{
		if(value == null)
			this.nasIPAddress = null;
		else
			this.nasIPAddress = new NASIPAddressImpl(value);
	}

	@Override
	public InetAddress getNASIPv6Address() 
	{
		if(nasIPv6Address == null)
			return null;
		
		return nasIPv6Address.getAddress();
	}

	@Override
	public void setNASIPv6Address(Inet6Address value) 
	{
		if(value == null)
			this.nasIPv6Address = null;
		else
			this.nasIPv6Address = new NASIPv6AddressImpl(value);
	}

	@Override
	public NASPortTypeEnum getNASPortType() 
	{
		if(nasPortType == null)
			return null;
		
		return nasPortType.getEnumerated(NASPortTypeEnum.class);
	}

	@Override
	public void setNASPortType(NASPortTypeEnum value) 
	{
		if(value == null)
			this.nasPortType = null;
		else
			this.nasPortType = new NASPortTypeImpl(value, null, null);
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
	public String getCallingStationId() 
	{
		if(callingStationId == null)
			return null;
		
		return callingStationId.getString();
	}

	@Override
	public void setCallingStationId(String value) 
	{
		if(value == null)
			this.callingStationId = null;
		else
			this.callingStationId = new CallingStationIdImpl(value, null, null);
	}

	@Override
	public Long getMIP6FeatureVector() 
	{
		if(mip6FeatureVector==null)
			return null;
		
		return mip6FeatureVector.getLong();
	}

	@Override
	public void setMIP6FeatureVector(Long value) 
	{
		if(value == null)
			this.mip6FeatureVector = null;
		else
			this.mip6FeatureVector = new MIP6FeatureVectorImpl(value, null, null);
	}

	@Override
	public MIP6AuthModeEnum getMIP6AuthMode()
	{
		if(mip6AuthMode == null)
			return null;
		
		return mip6AuthMode.getEnumerated(MIP6AuthModeEnum.class);
	}
	
	@Override
	public void setMIP6AuthMode(MIP6AuthModeEnum value)
	{
		if(value == null)
			this.mip6AuthMode = null;
		else
			this.mip6AuthMode = new MIP6AuthModeImpl(value, null, null);
	}
	
	@Override
	public Long getMIPMNAAASPI()
	{
		if(mipMNAAASPI == null)
			return null;
		
		return mipMNAAASPI.getUnsigned();
	}
	
	@Override
	public void setMIPMNAAASPI(Long value)
	{
		if(value == null)
			this.mipMNAAASPI = null;
		else
			this.mipMNAAASPI = new MIPMNAAASPIImpl(value, null, null);
	}
	
	@Override
	public Long getMIPMNHASPI()
	{
		if(mipMNHASPI == null)
			return null;
		
		return mipMNHASPI.getUnsigned();
	}
	
	@Override
	public void setMIPMNHASPI(Long value)
	{
		if(value == null)
			this.mipMNHASPI = null;
		else
			this.mipMNHASPI = new MIPMNHASPIImpl(value, null, null);
	}

	@Override
	public List<InetAddress> getMIPMobileNodeAddress() 
	{
		if(mipMobileNodeAddress==null || mipMobileNodeAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(MIPMobileNodeAddress curr:mipMobileNodeAddress)
			result.add(curr.getAddress());
		
		return result;
	}

	@Override
	public void setMIPMobileNodeAddress(List<InetAddress> value) 
	{
		if(value==null || value.size()<1 || value.size()>2)
			throw new IllegalArgumentException("MIP-Mobile-Node-Address is required and Up to 2 allowed");
		
		this.mipMobileNodeAddress = new ArrayList<MIPMobileNodeAddress>();
		for(InetAddress curr:value)
			this.mipMobileNodeAddress.add(new MIPMobileNodeAddressImpl(curr, null, null));
	}
	
	@Override
	public MIP6AgentInfo getMIP6AgentInfo() 
	{
		return mip6AgentInfo;
	}

	@Override
	public void setMIP6AgentInfo(MIP6AgentInfo value) 
	{
		if(value==null)
			throw new IllegalArgumentException("MIP6-Agent-Info is required");
		
		this.mip6AgentInfo = value;
	}

	@Override	
	public InetAddress getMIPCareofAddress()
	{
		if(mipCareofAddress == null)
			return null;
		
		return mipCareofAddress.getAddress();
	}
	
	@Override
	public void setMIPCareofAddress(InetAddress value)
	{
		if(value==null)
			throw new IllegalArgumentException("MIP-Careof-Address is required");
		
		this.mipCareofAddress = new MIPCareofAddressImpl(value, null, null);
	}

	@Override
	public ByteBuf getMIPAuthenticator()
	{
		if(mipAuthenticator == null)
			return null;
		
		return mipAuthenticator.getValue();
	}
	
	@Override
	public void setMIPAuthenticator(ByteBuf value)
	{
		if(value == null)
			this.mipAuthenticator = null;
		else
			this.mipAuthenticator = new MIPAuthenticatorImpl(value, null, null);
	}

	@Override
	public ByteBuf getMIPMACMobilityData()
	{
		if(mipMACMobilityData == null)
			return null;
		
		return mipMACMobilityData.getValue();
	}
	
	@Override
	public void setMIPMACMobilityData(ByteBuf value)
	{
		if(value == null)
			this.mipMACMobilityData = null;
		else
			this.mipMACMobilityData = new MIPMACMobilityDataImpl(value, null, null);
	}

	@Override
	public ByteBuf getMIPTimestamp()
	{
		if(mipTimestamp == null)
			return null;
		
		return mipTimestamp.getValue();
	}
	
	@Override
	public void setMIPTimestamp(ByteBuf value)
	{
		if(value == null)
			this.mipTimestamp = null;
		else
			this.mipTimestamp = new MIPTimestampImpl(value, null, null);
	}
	
	@Override
	public QoSCapability getQoSCapability() 
	{
		return qosCapability;
	}

	@Override
	public void setQoSCapability(QoSCapability value) 
	{
		this.qosCapability = value;
	}

	@Override
	public List<QoSResources> getQoSResources() 
	{
		return qosResources;
	}

	@Override
	public void setQoSResources(List<QoSResources> value) 
	{
		this.qosResources = value;
	}

	@Override
	public ByteBuf getChargeableUserIdentity() 
	{
		if(chargeableUserIdentity == null)
			return null;
		
		return chargeableUserIdentity.getValue();
	}

	@Override
	public void setChargeableUserIdentity(ByteBuf value) 
	{
		if(value == null)
			this.chargeableUserIdentity = null;
		else
			this.chargeableUserIdentity = new ChargeableUserIdentityImpl(value, null, null);
	}

	@Override
	public String getServiceSelection() 
	{
		if(serviceSelection == null)
			return null;
		
		return serviceSelection.getString();
	}

	@Override
	public void setServiceSelection(String value) 
	{
		if(value == null)
			this.serviceSelection = null;
		else
			this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}
	
	@Override
	public Long getAuthorizationLifetime() 
	{
		if(authorizationLifetime == null)
			return null;
		
		return authorizationLifetime.getUnsigned();
	}

	@Override
	public void setAuthorizationLifetime(Long value) 
	{
		if(value == null)
			this.authorizationLifetime = null;
		else
			this.authorizationLifetime = new AuthorizationLifetimeImpl(value, null, null);
	}

	@Override
	public AuthSessionStateEnum getAuthSessionState() 
	{
		if(authSessionState == null)
			return null;
		
		return authSessionState.getEnumerated(AuthSessionStateEnum.class);
	}

	@Override
	public void setAuthSessionState(AuthSessionStateEnum value) 
	{
		if(value == null)
			this.authSessionState = null;
		else
			this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authRequestType==null)
			return "Auth-Request-Type is required";
		
		if(mip6AgentInfo==null)
			throw new IllegalArgumentException("MIP6-Agent-Info is required");
		
		if(mipMobileNodeAddress==null || mipMobileNodeAddress.size()<1 || mipMobileNodeAddress.size()>2)
			throw new IllegalArgumentException("MIP-Mobile-Node-Address is required and Up to 2 allowed");
		
		if(mipCareofAddress==null)
			throw new IllegalArgumentException("MIP-Careof-Address is required");
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
		result.add(username);
		result.add(destinationRealm);
		result.add(originHost);
		result.add(originRealm);
		result.add(authRequestType);
		result.add(destinationHost);
		result.add(originStateId);
		result.add(nasIdentifier);
		result.add(nasIPAddress);
		result.add(nasIPv6Address);
		result.add(nasPortType);
		result.add(calledStationId);
		result.add(callingStationId);
		result.add(mip6FeatureVector);
		result.add(mip6AuthMode);
		result.add(mipMNAAASPI);
		result.add(mipMNHASPI);
		
		if(mipMobileNodeAddress!=null)
			result.addAll(mipMobileNodeAddress);
		
		result.add(mip6AgentInfo);
		result.add(mipCareofAddress);
		result.add(mipAuthenticator);
		result.add(mipMACMobilityData);
		result.add(mipTimestamp);
		result.add(qosCapability);
		
		if(qosResources!=null)
			result.addAll(qosResources);
		
		result.add(chargeableUserIdentity);
		result.add(serviceSelection);
		result.add(authorizationLifetime);
		result.add(authSessionState);
		
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