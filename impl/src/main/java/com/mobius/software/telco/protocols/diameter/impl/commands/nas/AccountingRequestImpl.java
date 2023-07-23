package com.mobius.software.telco.protocols.diameter.impl.commands.nas;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.nas.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AccountingAuthMethodImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AccountingInputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AccountingInputPacketsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AccountingOutputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AccountingOutputPacketsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AcctAuthenticImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AcctDelayTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AcctLinkCountImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AcctSessionTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AcctTunnelConnectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AcctTunnelPacketsLostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DiameterClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionTimeoutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.TerminationCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallbackIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallbackNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallingStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ConnectInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FilterIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedAppletalkLinkImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedAppletalkNetworkImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedAppletalkZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedCompressionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPNetmaskImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPXNetworkImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PoolImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6RouteImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedInterfaceIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedMTUImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedPoolImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedProtocolImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedRouteImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedRoutingImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.IdleTimeoutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginIPHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginIPv6HostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginLATGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginLATNodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginLATPortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginLATServiceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginServiceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.LoginTCPPortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.OriginAAAProtocolImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.OriginatingLineInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.PortLimitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ServiceTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccountingAuthMethod;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccountingAuthMethodEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccountingInputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccountingInputPackets;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccountingOutputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccountingOutputPackets;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AcctAuthentic;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AcctAuthenticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AcctDelayTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AcctLinkCount;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AcctSessionTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AcctTunnelConnection;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AcctTunnelPacketsLost;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.common.DiameterClass;
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionTimeout;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallbackId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallbackNumber;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallingStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ConnectInfo;
import com.mobius.software.telco.protocols.diameter.primitives.nas.DiameterQosFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FilterId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedAppletalkLink;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedAppletalkNetwork;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedAppletalkZone;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedCompression;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedCompressionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPNetmask;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPXNetwork;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Pool;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Route;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedInterfaceId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedMTU;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedPool;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedRoute;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedRouting;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedRoutingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.IdleTimeout;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginIPHost;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginIPv6Host;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginLATGroup;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginLATNode;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginLATPort;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginLATService;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginService;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginServiceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginTCPPort;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPort;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginAAAProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginAAAProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginatingLineInfo;
import com.mobius.software.telco.protocols.diameter.primitives.nas.PortLimit;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.Tunneling;

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
@DiameterCommandImplementation(applicationId = 1, commandCode = 271, request = true)
public class AccountingRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AccountingRequestImpl implements AccountingRequest
{
	private OriginAAAProtocol originAAAProtocol;
	
	private AcctDelayTime acctDelayTime;
	
	private NASIdentifier nasIdentifier;
	
	private NASIPAddress nasIPAddress;
	
	private NASIPv6Address nasIPv6Address;
	
	private NASPort nasPort;
	
	private NASPortId nasPortId;
	
	private NASPortType nasPortType;
	
	private List<DiameterClass> diameterClass;
	
	private ServiceType serviceType;
	
	private TerminationCause terminationCause;
	
	private AccountingInputOctets accountingInputOctets;
	
	private AccountingInputPackets accountingInputPackets;
	
	private AccountingOutputOctets accountingOutputOctets;
	
	private AccountingOutputPackets accountingOutputPackets;
	
	private AcctAuthentic acctAuthentic;
	
	private AccountingAuthMethod accountingAuthMethod;
	
	private AcctLinkCount acctLinkCount;
	
	private AcctSessionTime acctSessionTime;
	
	private AcctTunnelConnection acctTunnelConnection;
	
	private AcctTunnelPacketsLost acctTunnelPacketsLost;
	
	private CallbackId callbackId;
	
	private CallbackNumber callbackNumber;
	
	private CalledStationId calledStationId;
	
	private CallingStationId callingStationId;
	
	private List<ConnectInfo> connectionInfo;
	
	private OriginatingLineInfo originatingLineInfo;
	
	private AuthorizationLifetime authorizationLifetime;
	
	private SessionTimeout sessionTimeout;
	
	private IdleTimeout idleTimeout;
	
	private PortLimit portLimit;
	
	private List<FilterId> filterId;
	
	private List<NASFilterRule> nasFilterRule;
	
	private List<DiameterQosFilterRule> qosFilterRule;
	
	private FramedAppletalkLink framedAppletalkLink;
	
	private FramedAppletalkNetwork framedAppletalkNetwork;
	
	private FramedAppletalkZone framedAppletalkZone;
	
	private FramedCompression framedCompression;
	
	private FramedInterfaceId framedInterfaceId;
	
	private FramedIPAddress framedIPAddress;
	
	private FramedIPNetmask framedIPNetmask;
	
	private List<FramedIPv6Prefix> framedIPv6Prefix;
	
	private FramedIPv6Pool framedIPv6Pool;
	
	private List<FramedIPv6Route> framedIPv6Route;
	
	private FramedIPXNetwork framedIPXNetwork;
	
	private FramedMTU framedMTU;
	
	private FramedPool framedPool;
	
	private FramedProtocol framedProtocol;
	
	private List<FramedRoute> framedRoute;
	
	private FramedRouting framedRouting;
	
	private List<LoginIPHost> loginIPHost;
	
	private List<LoginIPv6Host> loginIPv6Host;
	
	private LoginLATGroup loginLATGroup;
	
	private LoginLATNode loginLATNode;
	
	private LoginLATPort loginLATPort;
	
	private LoginLATService loginLATService;
	
	private LoginService loginService;
	
	private LoginTCPPort loginTCPPort;
	
	private List<Tunneling> tunneling;
	
	protected AccountingRequestImpl() 
	{
		super();
		setVendorSpecificApplicationIdAllowed(false);		
		setAccountingRealtimeRequiredAllowed(true);			
	}
	
	public AccountingRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber, Long acctApplicationId)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, accountingRecordType, accountingRecordNumber);
		setVendorSpecificApplicationIdAllowed(false);
		setAccountingRealtimeRequiredAllowed(true);		
		
		setAcctApplicationId(acctApplicationId);
	}

	@Override
	public void setAcctApplicationId(Long value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Acct-Application-Id is required");	
		
		super.setAcctApplicationId(value);
	}

	@Override
	public OriginAAAProtocolEnum getOriginAAAProtocol() 
	{
		if(originAAAProtocol == null)
			return null;
		
		return originAAAProtocol.getEnumerated(OriginAAAProtocolEnum.class);
	}

	@Override
	public void setOriginAAAProtocol(OriginAAAProtocolEnum originAAAProtocol) 
	{
		if(originAAAProtocol == null)
			this.originAAAProtocol = null;
		else
			this.originAAAProtocol = new OriginAAAProtocolImpl(originAAAProtocol, null, null);
	}

	@Override
	public Long getAcctDelayTime() 
	{
		if(acctDelayTime == null)
			return null;
		
		return acctDelayTime.getUnsigned();
	}

	@Override
	public void setAcctDelayTime(Long acctDelayTime) 
	{
		if(acctDelayTime == null)
			this.acctDelayTime = null;
		else
			this.acctDelayTime = new AcctDelayTimeImpl(acctDelayTime, null, null);
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
	public List<ByteBuf> getDiameterClass() 
	{
		if(diameterClass == null || diameterClass.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(DiameterClass curr: diameterClass)
			result.add(curr.getValue());
		
		return result;
	}

	@Override
	public void setDiameterClass(List<ByteBuf> diameterClass) 
	{
		if(diameterClass == null || diameterClass.size()==0)
			this.diameterClass = null;
		else
		{
			this.diameterClass = new ArrayList<DiameterClass>();
			for(ByteBuf curr:diameterClass)
				this.diameterClass.add(new DiameterClassImpl(curr, null, null));
		}
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
	public TerminationCauseEnum getTerminationCause() 
	{
		if(terminationCause == null)
			return null;
		
		return terminationCause.getEnumerated(TerminationCauseEnum.class);
	}

	@Override
	public void setTerminationCause(TerminationCauseEnum terminationCauseEnum) 
	{
		if(terminationCauseEnum == null)
			this.terminationCause = null;
		else
			this.terminationCause = new TerminationCauseImpl(terminationCauseEnum, null, null);
	}

	@Override
	public Long getAccountingInputOctets() 
	{
		if(accountingInputOctets == null)
			return null;
		
		return accountingInputOctets.getLong();
	}

	@Override
	public void setAccountingInputOctets(Long accountingInputOctets) 
	{
		if(accountingInputOctets == null)
			this.accountingInputOctets = null;
		else
			this.accountingInputOctets = new AccountingInputOctetsImpl(accountingInputOctets, null, null);
	}

	@Override
	public Long getAccountingInputPackets() 
	{
		if(accountingInputPackets == null)
			return null;
		
		return accountingInputPackets.getLong();
	}

	@Override
	public void setAccountingInputPackets(Long accountingInputPackets) 
	{
		if(accountingInputPackets == null)
			this.accountingInputPackets = null;
		else
			this.accountingInputPackets = new AccountingInputPacketsImpl(accountingInputPackets, null, null);
	}

	@Override
	public Long getAccountingOutputOctets() 
	{
		if(accountingOutputOctets == null)
			return null;
		
		return accountingOutputOctets.getLong();
	}

	@Override
	public void setAccountingOutputOctets(Long accountingOutputOctets) 
	{
		if(accountingOutputOctets == null)
			this.accountingOutputOctets = null;
		else
			this.accountingOutputOctets = new AccountingOutputOctetsImpl(accountingOutputOctets, null, null);
	}

	@Override
	public Long getAccountingOutputPackets() 
	{
		if(accountingOutputPackets == null)
			return null;
		
		return accountingOutputPackets.getLong();
	}

	@Override
	public void setAccountingOutputPackets(Long accountingOutputPackets) 
	{
		if(accountingOutputPackets == null)
			this.accountingOutputPackets = null;
		else
			this.accountingOutputPackets = new AccountingOutputPacketsImpl(accountingOutputPackets, null, null);
	}

	@Override
	public AcctAuthenticEnum getAcctAuthentic() 
	{
		if(acctAuthentic == null)
			return null;
		
		return acctAuthentic.getEnumerated(AcctAuthenticEnum.class);
	}

	@Override
	public void setAcctAuthentic(AcctAuthenticEnum acctAuthentic) 
	{
		if(acctAuthentic == null)
			this.acctAuthentic = null;
		else
			this.acctAuthentic = new AcctAuthenticImpl(acctAuthentic, null, null);
	}

	@Override
	public AccountingAuthMethodEnum getAccountingAuthMethod() 
	{
		if(accountingAuthMethod == null)
			return null;
		
		return accountingAuthMethod.getEnumerated(AccountingAuthMethodEnum.class);
	}

	@Override
	public void setAccountingAuthMethod(AccountingAuthMethodEnum accountingAuthMethod) 
	{
		if(accountingAuthMethod == null)
			this.accountingAuthMethod = null;
		else
			this.accountingAuthMethod = new AccountingAuthMethodImpl(accountingAuthMethod, null, null);
	}

	@Override
	public Long getAcctLinkCount() 
	{
		if(acctLinkCount == null)
			return null;
		
		return acctLinkCount.getUnsigned();
	}

	@Override
	public void setAcctLinkCount(Long acctLinkCount) 
	{
		if(acctLinkCount == null)
			this.acctLinkCount = null;
		else
			this.acctLinkCount = new AcctLinkCountImpl(acctLinkCount, null, null);
	}

	@Override
	public Long getAcctSessionTime() 
	{
		if(acctSessionTime == null)
			return null;
		
		return acctSessionTime.getUnsigned();
	}

	@Override
	public void setAcctSessionTime(Long acctSessionTime) 
	{
		if(acctSessionTime == null)
			this.acctSessionTime = null;
		else
			this.acctSessionTime = new AcctSessionTimeImpl(acctSessionTime, null, null);
	}

	@Override
	public ByteBuf getAcctTunnelConnection() 
	{
		if(acctTunnelConnection == null)
			return null;
		
		return acctTunnelConnection.getValue();
	}

	@Override
	public void setAcctTunnelConnection(ByteBuf tunnelConnection) 
	{
		if(tunnelConnection == null)
			this.acctTunnelConnection = null;
		else
			this.acctTunnelConnection = new AcctTunnelConnectionImpl(tunnelConnection, null, null);
	}

	@Override
	public Long getAcctTunnelPacketsLost() 
	{
		if(acctTunnelPacketsLost == null)
			return null;
		
		return acctTunnelPacketsLost.getUnsigned();
	}

	@Override
	public void setAcctTunnelPacketsLost(Long tunnelPacketsLost) 
	{
		if(tunnelPacketsLost == null)
			this.acctTunnelPacketsLost = null;
		else
			this.acctTunnelPacketsLost = new AcctTunnelPacketsLostImpl(tunnelPacketsLost, null, null);
	}

	@Override
	public String getCallbackId() 
	{
		if(callbackId == null)
			return null;
		
		return callbackId.getString();
	}

	@Override
	public void setCallbackId(String callbackId) 
	{
		if(callbackId == null)
			this.callbackId = null;
		else
			this.callbackId = new CallbackIdImpl(callbackId, null, null);
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
	public List<String> getConnectionInfo() 
	{
		if(connectionInfo == null || connectionInfo.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ConnectInfo curr:connectionInfo)
			result.add(curr.getString());
		
		return result;
	}

	@Override
	public void setConnectionInfo(List<String> connectionInfo) 
	{
		if(connectionInfo == null || connectionInfo.size()==0)
			this.connectionInfo = null;
		else
		{
			this.connectionInfo = new ArrayList<ConnectInfo>();
			for(String curr:connectionInfo)
				this.connectionInfo.add(new ConnectInfoImpl(curr, null, null));
		}
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
	public Long getSessionTimeout() 
	{
		if(sessionTimeout == null)
			return null;
		
		return sessionTimeout.getUnsigned();
	}

	@Override
	public void setSessionTimeout(Long sessionTimeout) 
	{
		if(sessionTimeout == null)
			this.sessionTimeout = null;
		else
			this.sessionTimeout = new SessionTimeoutImpl(sessionTimeout, null, null);
	}

	@Override
	public Long getIdleTimeout() 
	{
		if(idleTimeout == null)
			return null;
		
		return idleTimeout.getUnsigned();
	}

	@Override
	public void setIdleTimeout(Long idleTimeout) 
	{
		if(idleTimeout == null)
			this.idleTimeout = null;
		else
			this.idleTimeout = new IdleTimeoutImpl(idleTimeout, null, null);
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
	public List<String> getFilterId() 
	{
		if(filterId == null || filterId.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(FilterId curr:filterId)
			result.add(curr.getString());
		
		return result;
	}

	@Override
	public void setFilterId(List<String> filterId) 
	{
		if(filterId == null || filterId.size()==0)
			this.filterId = null;
		else
		{
			this.filterId = new ArrayList<FilterId>();
			for(String curr:filterId)
				this.filterId.add(new FilterIdImpl(curr, null, null));
		}
	}

	@Override
	public List<NASFilterRule> getNASFilterRule() 
	{
		return nasFilterRule;
	}

	@Override
	public void setNASFilterRule(List<NASFilterRule> nasFilterRule) 
	{
		this.nasFilterRule = nasFilterRule;
	}

	@Override
	public List<DiameterQosFilterRule> getQosFilterRule() 
	{
		return qosFilterRule;
	}

	@Override
	public void setQosFilterRule(List<DiameterQosFilterRule> qosFilterRule) 
	{
		this.qosFilterRule = qosFilterRule;
	}

	@Override
	public Long getFramedAppletalkLink() 
	{
		if(framedAppletalkLink==null)
			return null;
		
		return framedAppletalkLink.getUnsigned();
	}

	@Override
	public void setFramedAppletalkLink(Long framedAppletalkLink) 
	{
		if(framedAppletalkLink == null)
			this.framedAppletalkLink = null;
		else
			this.framedAppletalkLink = new FramedAppletalkLinkImpl(framedAppletalkLink, null, null);
	}

	@Override
	public Long getFramedAppletalkNetwork() 
	{
		if(framedAppletalkNetwork==null)
			return null;
		
		return framedAppletalkNetwork.getUnsigned();
	}

	@Override
	public void setFramedAppletalkNetwork(Long framedAppletalkNetwork) 
	{
		if(framedAppletalkNetwork == null)
			this.framedAppletalkNetwork = null;
		else
			this.framedAppletalkNetwork = new FramedAppletalkNetworkImpl(framedAppletalkNetwork, null, null);
	}

	@Override
	public ByteBuf getFramedAppletalkZone() 
	{
		if(framedAppletalkZone==null)
			return null;
		
		return framedAppletalkZone.getValue();
	}

	@Override
	public void setFramedAppletalkZone(ByteBuf framedAppletalkZone) 
	{
		if(framedAppletalkZone == null)
			this.framedAppletalkZone = null;
		else
			this.framedAppletalkZone = new FramedAppletalkZoneImpl(framedAppletalkZone, null, null);
	}

	@Override
	public FramedCompressionEnum getFramedCompression() 
	{
		if(framedCompression==null)
			return null;
		
		return framedCompression.getEnumerated(FramedCompressionEnum.class);
	}

	@Override
	public void setFramedCompression(FramedCompressionEnum framedCompression) 
	{
		if(framedCompression == null)
			this.framedCompression = null;
		else
			this.framedCompression = new FramedCompressionImpl(framedCompression, null, null);
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
	public ByteBuf getFramedIPv6Pool() 
	{
		if(framedIPv6Pool==null)
			return null;
		
		return framedIPv6Pool.getValue();
	}

	@Override
	public void setFramedIPv6Pool(ByteBuf framedIPv6Pool) 
	{
		if(framedIPv6Pool == null)
			this.framedIPv6Pool = null;
		else
			this.framedIPv6Pool = new FramedIPv6PoolImpl(framedIPv6Pool, null, null);
	}

	@Override
	public List<String> getFramedIPv6Route() 
	{
		if(framedIPv6Route==null || framedIPv6Route.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(FramedIPv6Route curr:framedIPv6Route)
			result.add(curr.getString());
		
		return result;
	}

	@Override
	public void setFramedIPv6Route(List<String> framedIPv6Route) 
	{
		if(framedIPv6Route == null || framedIPv6Route.size()==0)
			this.framedIPv6Route = null;
		else
		{
			this.framedIPv6Route = new ArrayList<FramedIPv6Route>();
			for(String curr:framedIPv6Route)
				this.framedIPv6Route.add(new FramedIPv6RouteImpl(curr, null, null));
		}
	}

	@Override
	public Long getFramedIPXNetwork() 
	{
		if(framedIPXNetwork==null)
			return null;
		
		return framedIPXNetwork.getUnsigned();
	}

	@Override
	public void setFramedIPXNetwork(Long framedIPXNetwork) 
	{
		if(framedIPXNetwork == null)
			this.framedIPXNetwork = null;
		else
			this.framedIPXNetwork = new FramedIPXNetworkImpl(framedIPXNetwork, null, null);
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
	public ByteBuf getFramedPool() 
	{
		if(framedPool==null)
			return null;
		
		return framedPool.getValue();
	}

	@Override
	public void setFramedPool(ByteBuf framedPool) 
	{
		if(framedPool == null)
			this.framedPool = null;
		else
			this.framedPool = new FramedPoolImpl(framedPool, null, null);
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
	public List<ByteBuf> getFramedRoute() 
	{
		if(framedRoute==null || framedRoute.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(FramedRoute curr:framedRoute)
			result.add(curr.getValue());
		
		return result;
	}

	@Override
	public void setFramedRoute(List<ByteBuf> framedRoute) 
	{
		if(framedRoute == null || framedRoute.size()==0)
			this.framedRoute = null;
		else
		{
			this.framedRoute = new ArrayList<FramedRoute>();
			for(ByteBuf curr:framedRoute)
				this.framedRoute.add(new FramedRouteImpl(curr, null, null));
		}
	}

	@Override
	public FramedRoutingEnum getFramedRouting() 
	{
		if(framedRouting==null)
			return null;
		
		return framedRouting.getEnumerated(FramedRoutingEnum.class);
	}

	@Override
	public void setFramedRouting(FramedRoutingEnum framedRouting) 
	{
		if(framedRouting == null)
			this.framedRouting = null;
		else
			this.framedRouting = new FramedRoutingImpl(framedRouting, null, null);
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
	public void setLoginIPHost(List<Inet4Address> loginIPHost) 
	{
		if(loginIPHost == null || loginIPHost.size()==0)
			this.loginIPHost = null;
		else
		{
			this.loginIPHost = new ArrayList<LoginIPHost>();
			for(Inet4Address curr:loginIPHost)
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
	public void setLoginIPv6Host(List<Inet6Address> loginIPv6Host) 
	{
		if(loginIPv6Host == null || loginIPv6Host.size()==0)
			this.loginIPv6Host = null;
		else
		{
			this.loginIPv6Host = new ArrayList<LoginIPv6Host>();
			for(Inet6Address curr:loginIPv6Host)
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
	public void setLoginLATGroup(ByteBuf loginLATGroup) 
	{
		if(loginLATGroup == null)
			this.loginLATGroup = null;
		else
			this.loginLATGroup = new LoginLATGroupImpl(loginLATGroup, null, null);
	}

	@Override
	public ByteBuf getLoginLATNode() 
	{
		if(loginLATNode==null)
			return null;
		
		return loginLATNode.getValue();
	}

	@Override
	public void setLoginLATNode(ByteBuf loginLATNode) 
	{
		if(loginLATNode == null)
			this.loginLATNode = null;
		else
			this.loginLATNode = new LoginLATNodeImpl(loginLATNode, null, null);
	}

	@Override
	public ByteBuf getLoginLATPort() 
	{
		if(loginLATPort==null)
			return null;
		
		return loginLATPort.getValue();
	}

	@Override
	public void setLoginLATPort(ByteBuf loginLATPort) 
	{
		if(loginLATPort == null)
			this.loginLATPort = null;
		else
			this.loginLATPort = new LoginLATPortImpl(loginLATPort, null, null);
	}

	@Override
	public ByteBuf getLoginLATService() 
	{
		if(loginLATService==null)
			return null;
		
		return loginLATService.getValue();
	}

	@Override
	public void setLoginLATService(ByteBuf loginLATService) 
	{
		if(loginLATService == null)
			this.loginLATService = null;
		else
			this.loginLATService = new LoginLATServiceImpl(loginLATService, null, null);
	}

	@Override
	public LoginServiceEnum getLoginService() 
	{
		if(loginService==null)
			return null;
		
		return loginService.getEnumerated(LoginServiceEnum.class);
	}

	@Override
	public void setLoginService(LoginServiceEnum loginService) 
	{
		if(loginService == null)
			this.loginService = null;
		else
			this.loginService = new LoginServiceImpl(loginService, null, null);
	}

	@Override
	public Long getLoginTCPPort() 
	{
		if(loginTCPPort==null)
			return null;
		
		return loginTCPPort.getUnsigned();
	}

	@Override
	public void setLoginTCPPort(Long loginTCPPort) 
	{
		if(loginTCPPort == null)
			this.loginTCPPort = null;
		else
			this.loginTCPPort = new LoginTCPPortImpl(loginTCPPort, null, null);
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