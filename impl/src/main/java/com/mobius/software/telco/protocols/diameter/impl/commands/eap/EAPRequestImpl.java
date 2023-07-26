package com.mobius.software.telco.protocols.diameter.impl.commands.eap;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.eap.EAPRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthGracePeriodImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPKeyNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPPayloadImpl;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.OriginatingLineInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.PortLimitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ServiceTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.StateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.UserPasswordImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthGracePeriod;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPKeyName;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPPayload;
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
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPort;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginatingLineInfo;
import com.mobius.software.telco.protocols.diameter.primitives.nas.PortLimit;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.State;
import com.mobius.software.telco.protocols.diameter.primitives.nas.Tunneling;
import com.mobius.software.telco.protocols.diameter.primitives.nas.UserPassword;

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
public class EAPRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationRequestmpl implements EAPRequest
{
	private AuthRequestType authRequestType;
	
	private NASIdentifier nasIdentifier;
	
	private NASIPAddress nasIPAddress;
	
	private NASIPv6Address nasIPv6Address;
	
	private NASPort nasPort;
	
	private NASPortId nasPortId;
	
	private NASPortType nasPortType;
	
	private PortLimit portLimit;
	
	private UserPassword userPassword;
	
	private EAPPayload eapPayload;
	
	private EAPKeyName eapKeyName;
	
	private ServiceType serviceType;
	
	private State state;
	
	private AuthorizationLifetime authorizationLifetime;
	
	private AuthGracePeriod authGracePeriod;
	
	private AuthSessionState authSessionState;
	
	private CallbackNumber callbackNumber;
	
	private CalledStationId calledStationId;
	
	private CallingStationId callingStationId;
	
	private OriginatingLineInfo originatingLineInfo;
	
	private ConnectInfo connectInfo;
	
	private List<FramedCompression> framedCompression;
	
	private FramedInterfaceId framedInterfaceId;
	
	private FramedIPAddress framedIPAddress;
	
	private List<FramedIPv6Prefix> framedIPv6Prefix;
	
	private FramedIPNetmask framedIPNetmask;
	
	private FramedMTU framedMTU;
	
	private FramedProtocol framedProtocol;
	
	private List<Tunneling> tunneling;
	
	protected EAPRequestImpl() 
	{
		super();
	}
	
	public EAPRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
	}

	@Override
	public AuthRequestTypeEnum getAuthRequestType() 
	{
		if(authRequestType == null)
			return null;
		
		return authRequestType.getEnumerated(AuthRequestTypeEnum.class);
	}

	@Override
	public void setAuthRequestType(AuthRequestTypeEnum authRequestType) 
	{
		if(authRequestType == null)
			this.authRequestType = null;
		else
			this.authRequestType = new AuthRequestTypeImpl(authRequestType, null, null);
	}

	@Override
	public String getNASIdentifier() 
	{
		if(nasIdentifier == null)
			return null;
		
		return nasIdentifier.getString();
	}

	@Override
	public void setNASIdentifier(String nasIdentifier) 
	{
		if(nasIdentifier == null)
			this.nasIdentifier = null;
		else
			this.nasIdentifier = new NASIdentifierImpl(nasIdentifier, null, null);
	}

	@Override
	public InetAddress getNASIPAddress() 
	{
		if(nasIPAddress == null)
			return null;
		
		return nasIPAddress.getAddress();
	}

	@Override
	public void setNASIPAddress(Inet4Address nasIPAddress) 
	{
		if(nasIPAddress == null)
			this.nasIPAddress = null;
		else
			this.nasIPAddress = new NASIPAddressImpl(nasIPAddress);
	}

	@Override
	public InetAddress getNASIPv6Address() 
	{
		if(nasIPv6Address == null)
			return null;
		
		return nasIPv6Address.getAddress();
	}

	@Override
	public void setNASIPv6Address(Inet6Address nasIPv6Address) 
	{
		if(nasIPv6Address == null)
			this.nasIPv6Address = null;
		else
			this.nasIPv6Address = new NASIPv6AddressImpl(nasIPv6Address);
	}

	@Override
	public Long getNASPort() 
	{
		if(nasPort == null)
			return null;
		
		return nasPort.getUnsigned();
	}

	@Override
	public void setNASPort(Long nasPort) 
	{
		if(nasPort == null)
			this.nasPort = null;
		else
			this.nasPort = new NASPortImpl(nasPort, null, null);
	}

	@Override
	public String getNASPortId() 
	{
		if(nasPortId == null)
			return null;
		
		return nasPortId.getString();
	}

	@Override
	public void setNASPortId(String nasPortId) 
	{
		if(nasPortId == null)
			this.nasPortId = null;
		else
			this.nasPortId = new NASPortIdImpl(nasPortId, null, null);
	}

	@Override
	public NASPortTypeEnum getNASPortType() 
	{
		if(nasPortType == null)
			return null;
		
		return nasPortType.getEnumerated(NASPortTypeEnum.class);
	}

	@Override
	public void setNASPortType(NASPortTypeEnum nasPortType) 
	{
		if(nasPortType == null)
			this.nasPortType = null;
		else
			this.nasPortType = new NASPortTypeImpl(nasPortType, null, null);
	}

	@Override
	public Long getPortLimit() 
	{
		if(portLimit == null)
			return null;
		
		return portLimit.getUnsigned();
	}

	@Override
	public void setPortLimit(Long portLimit) 
	{
		if(portLimit == null)
			this.portLimit = null;
		else
			this.portLimit = new PortLimitImpl(portLimit, null, null);
	}

	@Override
	public ByteBuf getUserPassword() 
	{
		if(userPassword == null)
			return null;
		
		return userPassword.getValue();
	}

	@Override
	public void setUserPassword(ByteBuf userPassword) 
	{
		if(userPassword == null)
			this.userPassword = null;
		else
			this.userPassword = new UserPasswordImpl(userPassword, null, null);
	}

	@Override
	public ByteBuf getEAPPayload() 
	{
		if(eapPayload == null)
			return null;
		
		return eapPayload.getValue();
	}

	@Override
	public void setEAPPayload(ByteBuf eapPayload) 
	{
		if(eapPayload == null)
			this.eapPayload = null;
		else
			this.eapPayload = new EAPPayloadImpl(eapPayload, null, null);
	}

	@Override
	public ByteBuf getEAPKeyName() 
	{
		if(eapKeyName == null)
			return null;
		
		return eapKeyName.getValue();
	}

	@Override
	public void setEAPKeyName(ByteBuf eapKeyName) 
	{
		if(eapKeyName == null)
			this.eapKeyName = null;
		else
			this.eapKeyName = new EAPKeyNameImpl(eapKeyName, null, null);
	}

	@Override
	public ServiceTypeEnum getServiceType() 
	{
		if(serviceType == null)
			return null;
		
		return serviceType.getEnumerated(ServiceTypeEnum.class);
	}

	@Override
	public void setServiceType(ServiceTypeEnum serviceType) 
	{
		if(serviceType == null)
			this.serviceType = null;
		else
			this.serviceType = new ServiceTypeImpl(serviceType, null, null);
	}

	@Override
	public ByteBuf getState() 
	{
		if(state == null)
			return null;
		
		return state.getValue();
	}

	@Override
	public void setState(ByteBuf state) 
	{
		if(state == null)
			this.state = null;
		else
			this.state = new StateImpl(state, null, null);
	}

	@Override
	public Long getAuthorizationLifetime() 
	{
		if(authorizationLifetime == null)
			return null;
		
		return authorizationLifetime.getUnsigned();
	}

	@Override
	public void setAuthorizationLifetime(Long authorizationLifetime) 
	{
		if(authorizationLifetime == null)
			this.authorizationLifetime = null;
		else
			this.authorizationLifetime = new AuthorizationLifetimeImpl(authorizationLifetime, null, null);
	}

	@Override
	public Long getAuthGracePeriod() 
	{
		if(authGracePeriod == null)
			return null;
		
		return authGracePeriod.getUnsigned();
	}

	@Override
	public void setAuthGracePeriod(Long authGracePeriod) 
	{
		if(authGracePeriod == null)
			this.authGracePeriod = null;
		else
			this.authGracePeriod = new AuthGracePeriodImpl(authGracePeriod, null, null);
	}

	@Override
	public AuthSessionStateEnum getAuthSessionState() 
	{
		if(authSessionState == null)
			return null;
		
		return authSessionState.getEnumerated(AuthSessionStateEnum.class);
	}

	@Override
	public void setAuthSessionState(AuthSessionStateEnum authSessionState) 
	{
		if(authSessionState == null)
			this.authSessionState = null;
		else
			this.authSessionState = new AuthSessionStateImpl(authSessionState, null, null);
	}

	@Override
	public String getCallbackNumber() 
	{
		if(callbackNumber == null)
			return null;
		
		return callbackNumber.getString();
	}

	@Override
	public void setCallbackNumber(String callbackNumber) 
	{
		if(callbackNumber == null)
			this.callbackNumber = null;
		else
			this.callbackNumber = new CallbackNumberImpl(callbackNumber, null, null);
	}

	@Override
	public String getCalledStationId() 
	{
		if(calledStationId == null)
			return null;
		
		return calledStationId.getString();
	}

	@Override
	public void setCalledStationId(String calledStationId) 
	{
		if(calledStationId == null)
			this.calledStationId = null;
		else
			this.calledStationId = new CalledStationIdImpl(calledStationId, null, null);
	}

	@Override
	public String getCallingStationId() 
	{
		if(callingStationId == null)
			return null;
		
		return callingStationId.getString();
	}

	@Override
	public void setCallingStationId(String callingStationId) 
	{
		if(callingStationId == null)
			this.callingStationId = null;
		else
			this.callingStationId = new CallingStationIdImpl(callingStationId, null, null);
	}

	@Override
	public ByteBuf getOriginatingLineInfo() 
	{
		if(originatingLineInfo == null)
			return null;
		
		return originatingLineInfo.getValue();
	}

	@Override
	public void setOriginatingLineInfo(ByteBuf originatingLineInfo) 
	{
		if(originatingLineInfo == null)
			this.originatingLineInfo = null;
		else
			this.originatingLineInfo = new OriginatingLineInfoImpl(originatingLineInfo, null, null);
	}

	@Override
	public String getConnectInfo() 
	{
		if(connectInfo == null)
			return null;
		
		return connectInfo.getString();
	}

	@Override
	public void setConnectInfo(String connectInfo) 
	{
		if(connectInfo == null)
			this.connectInfo = null;
		else
			this.connectInfo = new ConnectInfoImpl(connectInfo, null, null);
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
	public void setFramedCompression(List<FramedCompressionEnum> framedCompression) 
	{
		if(framedCompression == null || framedCompression.size()==0)
			this.framedCompression = null;
		else
		{
			this.framedCompression = new ArrayList<FramedCompression>();
			for(FramedCompressionEnum curr:framedCompression)
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
	public void setFramedInterfaceId(Long framedInterfaceId) 
	{
		if(framedInterfaceId == null)
			this.framedInterfaceId = null;
		else
			this.framedInterfaceId = new FramedInterfaceIdImpl(framedInterfaceId, null, null);
	}

	@Override
	public InetAddress getFramedIPAddress() 
	{
		if(framedIPAddress==null)
			return null;
		
		return framedIPAddress.getAddress();
	}

	@Override
	public void setFramedIPAddress(Inet4Address framedIPAddress) 
	{
		if(framedIPAddress == null)
			this.framedIPAddress = null;
		else
			this.framedIPAddress = new FramedIPAddressImpl(framedIPAddress);
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
	public void setFramedIPv6Prefix(List<ByteBuf> framedIPv6Prefix) 
	{
		if(framedIPv6Prefix == null || framedIPv6Prefix.size()==0)
			this.framedIPv6Prefix = null;
		else
		{
			this.framedIPv6Prefix = new ArrayList<FramedIPv6Prefix>();
			for(ByteBuf curr:framedIPv6Prefix)
				this.framedIPv6Prefix.add(new FramedIPv6PrefixImpl(curr, null, null));
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
	public void setFramedIPNetmask(ByteBuf framedIPNetmask) 
	{
		if(framedIPNetmask == null)
			this.framedIPNetmask = null;
		else
			this.framedIPNetmask = new FramedIPNetmaskImpl(framedIPNetmask, null, null);
	}

	@Override
	public Long getFramedMTU() 
	{
		if(framedMTU==null)
			return null;
		
		return framedMTU.getUnsigned();
	}

	@Override
	public void setFramedMTU(Long framedMTU) 
	{
		if(framedMTU == null)
			this.framedMTU = null;
		else
			this.framedMTU = new FramedMTUImpl(framedMTU, null, null);
	}

	@Override
	public FramedProtocolEnum getFramedProtocol() 
	{
		if(framedProtocol==null)
			return null;
		
		return framedProtocol.getEnumerated(FramedProtocolEnum.class);
	}

	@Override
	public void setFramedProtocol(FramedProtocolEnum framedProtocol) 
	{
		if(framedProtocol == null)
			this.framedProtocol = null;
		else
			this.framedProtocol = new FramedProtocolImpl(framedProtocol, null, null);
	}

	@Override
	public List<Tunneling> getTunneling() 
	{
		return tunneling;
	}

	@Override
	public void setTunneling(List<Tunneling> tunneling) 
	{
		this.tunneling = tunneling;
	}
}