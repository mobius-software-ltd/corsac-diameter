package com.mobius.software.telco.protocols.diameter.impl.commands.gi;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.gi.AARequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthGracePeriodImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPAllocateIPTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPCAMELChargingInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPCGAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPCGIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGPRSNegotiatedQoSProfileImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPIMSIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPIMSIMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPNSAPIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPNegotiatedDSCPImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPPDPTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPRATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSelectionModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUELocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUESourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TWANIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CHAPChallengeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallbackNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallingStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ConnectInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedCompressionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPNetmaskImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedInterfaceIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedMTUImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedProtocolImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginIPHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginIPv6HostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginLATGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginLATNodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginLATPortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginLATServiceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.OriginatingLineInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.PortLimitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ServiceTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.UserPasswordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4818.DelegatedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthGracePeriod;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPAllocateIPType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPCAMELChargingInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPCGAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPCGIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingId;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGPRSNegotiatedQoSProfile;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPIMSI;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPIMSIMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPNSAPI;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPNegotiatedDSCP;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPPDPType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPPDPTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPRATType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSelectionMode;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUESourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TWANIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CHAPAuth;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CHAPChallenge;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallbackNumber;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallingStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ConnectInfo;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedCompression;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedCompressionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPNetmask;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedInterfaceId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedMTU;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginIPHost;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginIPv6Host;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginLATGroup;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginLATNode;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginLATPort;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginLATService;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPort;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginatingLineInfo;
import com.mobius.software.telco.protocols.diameter.primitives.nas.PortLimit;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.Tunneling;
import com.mobius.software.telco.protocols.diameter.primitives.nas.UserPassword;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4818.DelegatedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;

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
@DiameterCommandImplementation(applicationId = 1, commandCode = 265, request = true)
public class AARequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationRequestImpl implements AARequest
{
	private AuthRequestType authRequestType;
	
	private NASPort nasPort;
	
	private NASPortId nasPortId;
	
	private NASPortType nasPortType;
	
	private PortLimit portLimit;
	
	private UserPassword userPassword;
	
	private ServiceType serviceType;
	
	private AuthorizationLifetime authorizationLifetime;
	
	private AuthGracePeriod authGracePeriod;
	
	private AuthSessionState authSessionState;
	
	private CallbackNumber callbackNumber;
	
	private CalledStationId calledStationId;
	
	private CallingStationId callingStationId;
	
	private OriginatingLineInfo originatingLineInfo;
	
	private ConnectInfo connectInfo;
	
	private CHAPAuth chapAuth;
	
	private CHAPChallenge chapChallenge;
	
	private List<FramedCompression> framedCompression;
	
	private FramedInterfaceId framedInterfaceId;
	
	private FramedIPAddress framedIPAddress;
	
	private List<FramedIPv6Prefix> framedIPv6Prefix;
	
	private List<DelegatedIPv6Prefix> delegatedIPv6Prefix;
	
	private FramedIPNetmask framedIPNetmask;
	
	private FramedMTU framedMTU;
	
	private FramedProtocol framedProtocol;
	
	private List<LoginIPHost> loginIPHost;
	
	private List<LoginIPv6Host> loginIPv6Host;
	
	private LoginLATGroup loginLATGroup;
	
	private LoginLATNode loginLATNode;
	
	private LoginLATPort loginLATPort;
	
	private LoginLATService loginLATService;
	
	private List<Tunneling> tunneling;
	
	private TGPPIMSI tgppIMSI;
	
	private ExternalIdentifier externalIdentifier;
    
	private TGPPChargingId tgppChargingID;
    
	private TGPPPDPType tgppPDPType;
    
	private TGPPCGAddress tgppCGAddress;
    
	private TGPPGPRSNegotiatedQoSProfile tgppGPRSNegotiatedQoSProfile;
    
	private TGPPSGSNAddress tgppSGSNAddress;
    
	private TGPPGGSNAddress tgppGGSNAddress;
    
	private TGPPIMSIMCCMNC tgppIMSIMCCMNC;
    
	private TGPPGGSNMCCMNC tgppGGSNMCCMNC;
    
	private TGPPNSAPI tgppNSAPI;
    
	private TGPPSelectionMode tgppSelectionMode;
    
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
    
	private TGPPCGIPv6Address tgppCGIPv6Address;
    
	private TGPPSGSNIPv6Address tgppSGSNIPv6Address;
    
	private TGPPGGSNIPv6Address tgppGGSNIPv6Address;
    
	private TGPPSGSNMCCMNC tgppSGSNMCCMNC;
    
	private TGPPUserLocationInfo tgppUserLocationInfo;
    
	private TGPPRATType tgppRATType;
    
	private TGPPCAMELChargingInfo tgppCAMELChargingInfo;
    
	private TGPPNegotiatedDSCP tgppNegotiatedDSCP;
    
	private TGPPAllocateIPType tgppAllocateIPType;
    
	private TWANIdentifier twanIdentifier;
    
	private TGPPUELocalIPAddress tgppUELocalIPAddress;
    
	private TGPPUESourcePort tgppUESourcePort;
    
	protected AARequestImpl() 
	{
		super();
	}
	
	public AARequestImpl(String originHost,String originRealm,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId)
	{
		super(originHost, originRealm, destinationRealm, isRetransmit, sessionID, authApplicationId);
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
		if(value == null)
			this.authRequestType = null;
		else
			this.authRequestType = new AuthRequestTypeImpl(value, null, null);
	}

	@Override
	public Long getNASPort() 
	{
		if(nasPort == null)
			return null;
		
		return nasPort.getUnsigned();
	}

	@Override
	public void setNASPort(Long value) 
	{
		if(value == null)
			this.nasPort = null;
		else
			this.nasPort = new NASPortImpl(value, null, null);
	}

	@Override
	public String getNASPortId() 
	{
		if(nasPortId == null)
			return null;
		
		return nasPortId.getString();
	}

	@Override
	public void setNASPortId(String value) 
	{
		if(value == null)
			this.nasPortId = null;
		else
			this.nasPortId = new NASPortIdImpl(value, null, null);
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
	public Long getPortLimit() 
	{
		if(portLimit == null)
			return null;
		
		return portLimit.getUnsigned();
	}

	@Override
	public void setPortLimit(Long value) 
	{
		if(value == null)
			this.portLimit = null;
		else
			this.portLimit = new PortLimitImpl(value, null, null);
	}

	@Override
	public ByteBuf getUserPassword() 
	{
		if(userPassword == null)
			return null;
		
		return userPassword.getValue();
	}

	@Override
	public void setUserPassword(ByteBuf value) 
	{
		if(value == null)
			this.userPassword = null;
		else
			this.userPassword = new UserPasswordImpl(value, null, null);
	}

	@Override
	public ServiceTypeEnum getServiceType() 
	{
		if(serviceType == null)
			return null;
		
		return serviceType.getEnumerated(ServiceTypeEnum.class);
	}

	@Override
	public void setServiceType(ServiceTypeEnum value) 
	{
		if(value == null)
			this.serviceType = null;
		else
			this.serviceType = new ServiceTypeImpl(value, null, null);
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
	public Long getAuthGracePeriod() 
	{
		if(authGracePeriod == null)
			return null;
		
		return authGracePeriod.getUnsigned();
	}

	@Override
	public void setAuthGracePeriod(Long value) 
	{
		if(value == null)
			this.authGracePeriod = null;
		else
			this.authGracePeriod = new AuthGracePeriodImpl(value, null, null);
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

	@Override
	public String getCallbackNumber() 
	{
		if(callbackNumber == null)
			return null;
		
		return callbackNumber.getString();
	}

	@Override
	public void setCallbackNumber(String value) 
	{
		if(value == null)
			this.callbackNumber = null;
		else
			this.callbackNumber = new CallbackNumberImpl(value, null, null);
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
	public ByteBuf getOriginatingLineInfo() 
	{
		if(originatingLineInfo == null)
			return null;
		
		return originatingLineInfo.getValue();
	}

	@Override
	public void setOriginatingLineInfo(ByteBuf value) 
	{
		if(value == null)
			this.originatingLineInfo = null;
		else
			this.originatingLineInfo = new OriginatingLineInfoImpl(value, null, null);
	}

	@Override
	public String getConnectInfo() 
	{
		if(connectInfo == null)
			return null;
		
		return connectInfo.getString();
	}

	@Override
	public void setConnectInfo(String value) 
	{
		if(value == null)
			this.connectInfo = null;
		else
			this.connectInfo = new ConnectInfoImpl(value, null, null);
	}
	
	@Override
	public CHAPAuth getCHAPAuth() 
	{
		return chapAuth;
	}

	@Override
	public void setCHAPAuth(CHAPAuth value) 
	{
		this.chapAuth = value;
	}

	@Override
	public ByteBuf getCHAPChallenge() 
	{
		if(chapChallenge == null)
			return null;
		
		return chapChallenge.getValue();
	}

	@Override
	public void setCHAPChallenge(ByteBuf value) 
	{
		if(value == null)
			this.chapChallenge = null;
		else
			this.chapChallenge = new CHAPChallengeImpl(value, null, null);
	}

	@Override
	public List<FramedCompressionEnum> getFramedCompression() 
	{
		if(framedCompression==null || framedCompression.size()==0)
			return null;
		
		List<FramedCompressionEnum> result=new ArrayList<FramedCompressionEnum>();
		for(FramedCompression curr:framedCompression)
			result.add(curr.getEnumerated(FramedCompressionEnum.class));
		
		return result;
	}

	@Override
	public void setFramedCompression(List<FramedCompressionEnum> value) 
	{
		if(value == null || value.size()==0)
			this.framedCompression = null;
		else
		{
			this.framedCompression = new ArrayList<FramedCompression>();
			for(FramedCompressionEnum curr:value)
				this.framedCompression.add(new FramedCompressionImpl(curr, null, null));
		}
	}

	@Override
	public Long getFramedInterfaceId() 
	{
		if(framedInterfaceId==null)
			return null;
		
		return framedInterfaceId.getLong();
	}

	@Override
	public void setFramedInterfaceId(Long value) 
	{
		if(value == null)
			this.framedInterfaceId = null;
		else
			this.framedInterfaceId = new FramedInterfaceIdImpl(value, null, null);
	}

	@Override
	public InetAddress getFramedIPAddress() 
	{
		if(framedIPAddress==null)
			return null;
		
		return framedIPAddress.getAddress();
	}

	@Override
	public void setFramedIPAddress(Inet4Address value) 
	{
		if(value == null)
			this.framedIPAddress = null;
		else
			this.framedIPAddress = new FramedIPAddressImpl(value);
	}

	@Override
	public List<ByteBuf> getFramedIPv6Prefix() 
	{
		if(framedIPv6Prefix==null || framedIPv6Prefix.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(FramedIPv6Prefix curr:framedIPv6Prefix)
			result.add(curr.getValue());
		
		return result;
	}

	@Override
	public void setFramedIPv6Prefix(List<ByteBuf> value) 
	{
		if(value == null || value.size()==0)
			this.framedIPv6Prefix = null;
		else
		{
			this.framedIPv6Prefix = new ArrayList<FramedIPv6Prefix>();
			for(ByteBuf curr:value)
				this.framedIPv6Prefix.add(new FramedIPv6PrefixImpl(curr, null, null));
		}
	}

	@Override
	public List<ByteBuf> getDelegatedIPv6Prefix() 
	{
		if(delegatedIPv6Prefix==null || delegatedIPv6Prefix.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(DelegatedIPv6Prefix curr:delegatedIPv6Prefix)
			result.add(curr.getValue());
		
		return result;
	}

	@Override
	public void setDelegatedIPv6Prefix(List<ByteBuf> value) 
	{
		if(value == null || value.size()==0)
			this.delegatedIPv6Prefix = null;
		else
		{
			this.delegatedIPv6Prefix = new ArrayList<DelegatedIPv6Prefix>();
			for(ByteBuf curr:value)
				this.delegatedIPv6Prefix.add(new DelegatedIPv6PrefixImpl(curr, null, null));
		}
	}

	@Override
	public ByteBuf getFramedIPNetmask() 
	{
		if(framedIPNetmask==null)
			return null;
		
		return framedIPNetmask.getValue();
	}

	@Override
	public void setFramedIPNetmask(ByteBuf value) 
	{
		if(value == null)
			this.framedIPNetmask = null;
		else
			this.framedIPNetmask = new FramedIPNetmaskImpl(value, null, null);
	}

	@Override
	public Long getFramedMTU() 
	{
		if(framedMTU==null)
			return null;
		
		return framedMTU.getUnsigned();
	}

	@Override
	public void setFramedMTU(Long value) 
	{
		if(value == null)
			this.framedMTU = null;
		else
			this.framedMTU = new FramedMTUImpl(value, null, null);
	}

	@Override
	public FramedProtocolEnum getFramedProtocol() 
	{
		if(framedProtocol==null)
			return null;
		
		return framedProtocol.getEnumerated(FramedProtocolEnum.class);
	}

	@Override
	public void setFramedProtocol(FramedProtocolEnum value) 
	{
		if(value == null)
			this.framedProtocol = null;
		else
			this.framedProtocol = new FramedProtocolImpl(value, null, null);
	}

	@Override
	public List<InetAddress> getLoginIPHost() 
	{
		if(loginIPHost==null || loginIPHost.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(LoginIPHost curr:loginIPHost)
			result.add(curr.getAddress());
		
		return result;
	}

	@Override
	public void setLoginIPHost(List<Inet4Address> value) 
	{
		if(value == null || value.size()==0)
			this.loginIPHost = null;
		else
		{
			this.loginIPHost = new ArrayList<LoginIPHost>();
			for(Inet4Address curr:value)
				this.loginIPHost.add(new LoginIPHostImpl(curr));
		}
	}

	@Override
	public List<InetAddress> getLoginIPv6Host() 
	{
		if(loginIPv6Host==null || loginIPv6Host.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(LoginIPv6Host curr:loginIPv6Host)
			result.add(curr.getAddress());
		
		return result;
	}

	@Override
	public void setLoginIPv6Host(List<Inet6Address> value) 
	{
		if(value == null || value.size()==0)
			this.loginIPv6Host = null;
		else
		{
			this.loginIPv6Host = new ArrayList<LoginIPv6Host>();
			for(Inet6Address curr:value)
				this.loginIPv6Host.add(new LoginIPv6HostImpl(curr));
		}
	}

	@Override
	public ByteBuf getLoginLATGroup() 
	{
		if(loginLATGroup==null)
			return null;
		
		return loginLATGroup.getValue();
	}

	@Override
	public void setLoginLATGroup(ByteBuf value) 
	{
		if(value == null)
			this.loginLATGroup = null;
		else
			this.loginLATGroup = new LoginLATGroupImpl(value, null, null);
	}

	@Override
	public ByteBuf getLoginLATNode() 
	{
		if(loginLATNode==null)
			return null;
		
		return loginLATNode.getValue();
	}

	@Override
	public void setLoginLATNode(ByteBuf value) 
	{
		if(value == null)
			this.loginLATNode = null;
		else
			this.loginLATNode = new LoginLATNodeImpl(value, null, null);
	}

	@Override
	public ByteBuf getLoginLATPort() 
	{
		if(loginLATPort==null)
			return null;
		
		return loginLATPort.getValue();
	}

	@Override
	public void setLoginLATPort(ByteBuf value) 
	{
		if(value == null)
			this.loginLATPort = null;
		else
			this.loginLATPort = new LoginLATPortImpl(value, null, null);
	}

	@Override
	public ByteBuf getLoginLATService() 
	{
		if(loginLATService==null)
			return null;
		
		return loginLATService.getValue();
	}

	@Override
	public void setLoginLATService(ByteBuf value) 
	{
		if(value == null)
			this.loginLATService = null;
		else
			this.loginLATService = new LoginLATServiceImpl(value, null, null);
	}

	@Override
	public List<Tunneling> getTunneling() 
	{
		return tunneling;
	}

	@Override
	public void setTunneling(List<Tunneling> value) 
	{
		this.tunneling = value;
	}
	
	@Override
	public String getTGPPIMSI() 
	{
		if(tgppIMSI==null)
			return null;
		
		return tgppIMSI.getString();
	}

	@Override
	public void setTGPPIMSI(String value) 
	{
		if(value == null)
			this.tgppIMSI = null;
		else
			this.tgppIMSI = new TGPPIMSIImpl(value, null, null);
	}
	
	@Override
	public String getExternalIdentifier() 
	{
		if(externalIdentifier==null)
			return null;
		
		return externalIdentifier.getString();
	}

	@Override
	public void setExternalIdentifier(String value) 
	{
		if(value == null)
			this.externalIdentifier = null;
		else
			this.externalIdentifier = new ExternalIdentifierImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPChargingId() 
	{
		if(tgppChargingID==null)
			return null;
		
		return tgppChargingID.getValue();
	}

	@Override
	public void setTGPPChargingId(ByteBuf value) 
	{
		if(value == null)
			this.tgppChargingID = null;
		else
			this.tgppChargingID = new TGPPChargingIdImpl(value, null, null);
	}
	
	@Override
	public TGPPPDPTypeEnum getTGPPPDPType() 
	{
		if(tgppPDPType==null)
			return null;
		
		return tgppPDPType.getEnumerated(TGPPPDPTypeEnum.class);
	}

	@Override
	public void setTGPPPDPType(TGPPPDPTypeEnum value) 
	{
		if(value == null)
			this.tgppPDPType = null;
		else
			this.tgppPDPType = new TGPPPDPTypeImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPCGAddress() 
	{
		if(tgppCGAddress==null)
			return null;
		
		return tgppCGAddress.getValue();
	}

	@Override
	public void setTGPPCGAddress(ByteBuf value) 
	{
		if(value == null)
			this.tgppCGAddress = null;
		else
			this.tgppCGAddress = new TGPPCGAddressImpl(value, null, null);
	}
	
	@Override
	public String getTGPPGPRSNegotiatedQoSProfile() 
	{
		if(tgppGPRSNegotiatedQoSProfile==null)
			return null;
		
		return tgppGPRSNegotiatedQoSProfile.getString();
	}

	@Override
	public void setTGPPGPRSNegotiatedQoSProfile(String value) 
	{
		if(value == null)
			this.tgppGPRSNegotiatedQoSProfile = null;
		else
			this.tgppGPRSNegotiatedQoSProfile = new TGPPGPRSNegotiatedQoSProfileImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPSGSNAddress() 
	{
		if(tgppSGSNAddress==null)
			return null;
		
		return tgppSGSNAddress.getValue();
	}

	@Override
	public void setTGPPSGSNAddress(ByteBuf value) 
	{
		if(value == null)
			this.tgppSGSNAddress = null;
		else
			this.tgppSGSNAddress = new TGPPSGSNAddressImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPGGSNAddress() 
	{
		if(tgppGGSNAddress==null)
			return null;
		
		return tgppGGSNAddress.getValue();
	}

	@Override
	public void setTGPPGGSNAddress(ByteBuf value) 
	{
		if(value == null)
			this.tgppGGSNAddress = null;
		else
			this.tgppGGSNAddress = new TGPPGGSNAddressImpl(value, null, null);
	}
	
	@Override
	public String getTGPPIMSIMCCMNC() 
	{
		if(tgppIMSIMCCMNC==null)
			return null;
		
		return tgppIMSIMCCMNC.getString();
	}

	@Override
	public void setTGPPIMSIMCCMNC(String value) 
	{
		if(value == null)
			this.tgppIMSIMCCMNC = null;
		else
			this.tgppIMSIMCCMNC = new TGPPIMSIMCCMNCImpl(value, null, null);
	}
	
	@Override
	public String getTGPPGGSNMCCMNC() 
	{
		if(tgppGGSNMCCMNC==null)
			return null;
		
		return tgppGGSNMCCMNC.getString();
	}

	@Override
	public void setTGPPGGSNMCCMNC(String value) 
	{
		if(value == null)
			this.tgppGGSNMCCMNC = null;
		else
			this.tgppGGSNMCCMNC = new TGPPGGSNMCCMNCImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPNSAPI() 
	{
		if(tgppNSAPI==null)
			return null;
		
		return tgppNSAPI.getValue();
	}

	@Override
	public void setTGPPNSAPI(ByteBuf value) 
	{
		if(value == null)
			this.tgppNSAPI = null;
		else
			this.tgppNSAPI = new TGPPNSAPIImpl(value, null, null);
	}
	
	@Override
	public String getTGPPSelectionMode() 
	{
		if(tgppSelectionMode==null)
			return null;
		
		return tgppSelectionMode.getString();
	}

	@Override
	public void setTGPPSelectionMode(String value) 
	{
		if(value == null)
			this.tgppSelectionMode = null;
		else
			this.tgppSelectionMode = new TGPPSelectionModeImpl(value, null, null);
	}
	
	@Override
	public String getTGPPChargingCharacteristics() 
	{
		if(tgppChargingCharacteristics==null)
			return null;
		
		return tgppChargingCharacteristics.getString();
	}

	@Override
	public void setTGPPChargingCharacteristics(String value) 
	{
		if(value == null)
			this.tgppChargingCharacteristics = null;
		else
			this.tgppChargingCharacteristics = new TGPPChargingCharacteristicsImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPCGIPv6Address() 
	{
		if(tgppCGIPv6Address==null)
			return null;
		
		return tgppCGIPv6Address.getValue();
	}

	@Override
	public void setTGPPCGIPv6Address(ByteBuf value) 
	{
		if(value == null)
			this.tgppCGIPv6Address = null;
		else
			this.tgppCGIPv6Address = new TGPPCGIPv6AddressImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPSGSNIPv6Address() 
	{
		if(tgppSGSNIPv6Address==null)
			return null;
		
		return tgppSGSNIPv6Address.getValue();
	}

	@Override
	public void setTGPPSGSNIPv6Address(ByteBuf value) 
	{
		if(value == null)
			this.tgppSGSNIPv6Address = null;
		else
			this.tgppSGSNIPv6Address = new TGPPSGSNIPv6AddressImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPGGSNIPv6Address() 
	{
		if(tgppGGSNIPv6Address==null)
			return null;
		
		return tgppGGSNIPv6Address.getValue();
	}

	@Override
	public void setTGPPGGSNIPv6Address(ByteBuf value) 
	{
		if(value == null)
			this.tgppGGSNIPv6Address = null;
		else
			this.tgppGGSNIPv6Address = new TGPPGGSNIPv6AddressImpl(value, null, null);
	}
	
	@Override
	public String getTGPPSGSNMCCMNC() 
	{
		if(tgppSGSNMCCMNC==null)
			return null;
		
		return tgppSGSNMCCMNC.getString();
	}

	@Override
	public void setTGPPSGSNMCCMNC(String value) 
	{
		if(value == null)
			this.tgppSGSNMCCMNC = null;
		else
			this.tgppSGSNMCCMNC = new TGPPSGSNMCCMNCImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPUserLocationInfo() 
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return tgppUserLocationInfo.getValue();
	}

	@Override
	public void setTGPPUserLocationInfo(ByteBuf value) 
	{
		if(value == null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPRATType() 
	{
		if(tgppRATType==null)
			return null;
		
		return tgppRATType.getValue();
	}

	@Override
	public void setTGPPRATType(ByteBuf value) 
	{
		if(value == null)
			this.tgppRATType = null;
		else
			this.tgppRATType = new TGPPRATTypeImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPCAMELChargingInfo() 
	{
		if(tgppCAMELChargingInfo==null)
			return null;
		
		return tgppCAMELChargingInfo.getValue();
	}

	@Override
	public void setTGPPCAMELChargingInfo(ByteBuf value) 
	{
		if(value == null)
			this.tgppCAMELChargingInfo = null;
		else
			this.tgppCAMELChargingInfo = new TGPPCAMELChargingInfoImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPNegotiatedDSCP() 
	{
		if(tgppNegotiatedDSCP==null)
			return null;
		
		return tgppNegotiatedDSCP.getValue();
	}

	@Override
	public void setTGPPNegotiatedDSCP(ByteBuf value) 
	{
		if(value == null)
			this.tgppNegotiatedDSCP = null;
		else
			this.tgppNegotiatedDSCP = new TGPPNegotiatedDSCPImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPAllocateIPType() 
	{
		if(tgppAllocateIPType==null)
			return null;
		
		return tgppAllocateIPType.getValue();
	}

	@Override
	public void setTGPPAllocateIPType(ByteBuf value) 
	{
		if(value == null)
			this.tgppAllocateIPType = null;
		else
			this.tgppAllocateIPType = new TGPPAllocateIPTypeImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTWANIdentifier() 
	{
		if(twanIdentifier==null)
			return null;
		
		return twanIdentifier.getValue();
	}

	@Override
	public void setTWANIdentifier(ByteBuf value) 
	{
		if(value == null)
			this.twanIdentifier = null;
		else
			this.twanIdentifier = new TWANIdentifierImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPUELocalIPAddress() 
	{
		if(tgppUELocalIPAddress==null)
			return null;
		
		return tgppUELocalIPAddress.getValue();
	}

	@Override
	public void setTGPPUELocalIPAddress(ByteBuf value) 
	{
		if(value == null)
			this.tgppUELocalIPAddress = null;
		else
			this.tgppUELocalIPAddress = new TGPPUELocalIPAddressImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPUESourcePort() 
	{
		if(tgppUESourcePort==null)
			return null;
		
		return tgppUESourcePort.getValue();
	}

	@Override
	public void setTGPPUESourcePort(ByteBuf value) 
	{
		if(value == null)
			this.tgppUESourcePort = null;
		else
			this.tgppUESourcePort = new TGPPUESourcePortImpl(value, null, null);
	}
}