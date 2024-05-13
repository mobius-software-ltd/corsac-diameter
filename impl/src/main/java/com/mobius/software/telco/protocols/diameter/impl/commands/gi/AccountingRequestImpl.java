package com.mobius.software.telco.protocols.diameter.impl.commands.gi;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.gi.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DiameterClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionTimeoutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPCAMELChargingInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPCGAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPCGIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGPRSNegotiatedQoSProfileImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPIMEISVImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPIMSIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPIMSIMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPMSTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPNSAPIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPNegotiatedDSCPImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPPDPTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPPacketFilterImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPRATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSecondaryRATUsageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSelectionModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUELocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUESourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TWANIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingAuthMethodImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingInputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingInputPacketsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingOutputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingOutputPacketsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AcctAuthenticImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AcctDelayTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AcctSessionTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AcctTunnelConnectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AcctTunnelPacketsLostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallbackIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallbackNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallingStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ConnectInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FilterIdImpl;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.OriginatingLineInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.PortLimitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ServiceTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4818.DelegatedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.common.DiameterClass;
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionTimeout;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPCAMELChargingInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPCGAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPCGIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingId;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGPRSNegotiatedQoSProfile;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPIMEISV;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPIMSI;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPIMSIMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPMSTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPNSAPI;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPNegotiatedDSCP;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPPDPType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPPDPTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPPacketFilter;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPRATType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSecondaryRATUsage;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSelectionMode;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUESourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfoTime;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TWANIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingAuthMethod;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingAuthMethodEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingInputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingInputPackets;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingOutputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingOutputPackets;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AcctAuthentic;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AcctAuthenticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AcctDelayTime;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AcctSessionTime;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AcctTunnelConnection;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AcctTunnelPacketsLost;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallbackId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallbackNumber;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallingStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ConnectInfo;
import com.mobius.software.telco.protocols.diameter.primitives.nas.DiameterQosFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FilterId;
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
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginatingLineInfo;
import com.mobius.software.telco.protocols.diameter.primitives.nas.PortLimit;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.Tunneling;
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
public class AccountingRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AccountingRequestImpl implements AccountingRequest
{
	private AcctDelayTime acctDelayTime;
	
	private NASIdentifier nasIdentifier;
	
	private NASIPAddress nasIPAddress;
	
	private NASIPv6Address nasIPv6Address;
	
	private NASPort nasPort;
	
	private NASPortId nasPortId;
	
	private NASPortType nasPortType;
	
	private List<DiameterClass> diameterClass;
	
	private ServiceType serviceType;
	
	private AccountingInputOctets accountingInputOctets;
	
	private AccountingInputPackets accountingInputPackets;
	
	private AccountingOutputOctets accountingOutputOctets;
	
	private AccountingOutputPackets accountingOutputPackets;
	
	private AcctAuthentic acctAuthentic;
	
	private AccountingAuthMethod accountingAuthMethod;
	
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
	
	private FramedCompression framedCompression;
	
	private FramedInterfaceId framedInterfaceId;
	
	private FramedIPAddress framedIPAddress;
	
	private FramedIPNetmask framedIPNetmask;
	
	private List<FramedIPv6Prefix> framedIPv6Prefix;
	
	private FramedIPv6Pool framedIPv6Pool;
	
	private List<FramedIPv6Route> framedIPv6Route;
	
	private List<DelegatedIPv6Prefix> delegatedIPv6Prefix;
	
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
    
	private TGPPIMEISV tgppIMEISV;
	
	private TGPPRATType tgppRATType;
    
	private TGPPUserLocationInfo tgppUserLocationInfo;
    
	private TGPPMSTimeZone tgppMSTimeZone;
	
	private TGPPCAMELChargingInfo tgppCAMELChargingInfo;
    
	private TGPPPacketFilter tgppPacketFilter;
    
	private TGPPNegotiatedDSCP tgppNegotiatedDSCP;
    
	private TWANIdentifier twanIdentifier;
    
  	private TGPPUserLocationInfoTime tgppUserLocationInfoTime;
  	
  	private List<TGPPSecondaryRATUsage> tgppSecondaryRATUsage;
		 
	private TGPPUELocalIPAddress tgppUELocalIPAddress;
    
	private TGPPUESourcePort tgppUESourcePort;
	
	protected AccountingRequestImpl() 
	{
		super();
		setVendorSpecificApplicationIdAllowed(false);		
		setAccountingRealtimeRequiredAllowed(true);	
		setAccountingSubSessionIdAllowed(false);
		setAcctMultiSessionIdAllowed(false);
		setAcctSessionIdAllowed(false);
	}
	
	public AccountingRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber, Long acctApplicationId) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, accountingRecordType, accountingRecordNumber);
		setVendorSpecificApplicationIdAllowed(false);
		setAccountingRealtimeRequiredAllowed(true);		
		setAccountingSubSessionIdAllowed(false);
		setAcctMultiSessionIdAllowed(false);
		setAcctSessionIdAllowed(false);
		
		setAcctApplicationId(acctApplicationId);
	}

	@Override
	public void setAcctApplicationId(Long value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Acct-Application-Id is required", Arrays.asList(new DiameterAvp[] { new AcctApplicationIdImpl() }));	
		
		super.setAcctApplicationId(value);
	}

	@Override
	public Long getAcctDelayTime() 
	{
		if(acctDelayTime == null)
			return null;
		
		return acctDelayTime.getUnsigned();
	}

	@Override
	public void setAcctDelayTime(Long value) 
	{
		if(value == null)
			this.acctDelayTime = null;
		else
			this.acctDelayTime = new AcctDelayTimeImpl(value, null, null);
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
	public void setDiameterClass(List<ByteBuf> value) 
	{
		if(value == null || value.size()==0)
			this.diameterClass = null;
		else
		{
			this.diameterClass = new ArrayList<DiameterClass>();
			for(ByteBuf curr:value)
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
	public void setServiceType(ServiceTypeEnum value) 
	{
		if(value == null)
			this.serviceType = null;
		else
			this.serviceType = new ServiceTypeImpl(value, null, null);
	}

	@Override
	public Long getAccountingInputOctets() 
	{
		if(accountingInputOctets == null)
			return null;
		
		return accountingInputOctets.getLong();
	}

	@Override
	public void setAccountingInputOctets(Long value) 
	{
		if(value == null)
			this.accountingInputOctets = null;
		else
			this.accountingInputOctets = new AccountingInputOctetsImpl(value, null, null);
	}

	@Override
	public Long getAccountingInputPackets() 
	{
		if(accountingInputPackets == null)
			return null;
		
		return accountingInputPackets.getLong();
	}

	@Override
	public void setAccountingInputPackets(Long value) 
	{
		if(value == null)
			this.accountingInputPackets = null;
		else
			this.accountingInputPackets = new AccountingInputPacketsImpl(value, null, null);
	}

	@Override
	public Long getAccountingOutputOctets() 
	{
		if(accountingOutputOctets == null)
			return null;
		
		return accountingOutputOctets.getLong();
	}

	@Override
	public void setAccountingOutputOctets(Long value) 
	{
		if(value == null)
			this.accountingOutputOctets = null;
		else
			this.accountingOutputOctets = new AccountingOutputOctetsImpl(value, null, null);
	}

	@Override
	public Long getAccountingOutputPackets() 
	{
		if(accountingOutputPackets == null)
			return null;
		
		return accountingOutputPackets.getLong();
	}

	@Override
	public void setAccountingOutputPackets(Long value) 
	{
		if(value == null)
			this.accountingOutputPackets = null;
		else
			this.accountingOutputPackets = new AccountingOutputPacketsImpl(value, null, null);
	}

	@Override
	public AcctAuthenticEnum getAcctAuthentic() 
	{
		if(acctAuthentic == null)
			return null;
		
		return acctAuthentic.getEnumerated(AcctAuthenticEnum.class);
	}

	@Override
	public void setAcctAuthentic(AcctAuthenticEnum value) 
	{
		if(value == null)
			this.acctAuthentic = null;
		else
			this.acctAuthentic = new AcctAuthenticImpl(value, null, null);
	}

	@Override
	public AccountingAuthMethodEnum getAccountingAuthMethod() 
	{
		if(accountingAuthMethod == null)
			return null;
		
		return accountingAuthMethod.getEnumerated(AccountingAuthMethodEnum.class);
	}

	@Override
	public void setAccountingAuthMethod(AccountingAuthMethodEnum value) 
	{
		if(value == null)
			this.accountingAuthMethod = null;
		else
			this.accountingAuthMethod = new AccountingAuthMethodImpl(value, null, null);
	}

	@Override
	public Long getAcctSessionTime() 
	{
		if(acctSessionTime == null)
			return null;
		
		return acctSessionTime.getUnsigned();
	}

	@Override
	public void setAcctSessionTime(Long value) 
	{
		if(value == null)
			this.acctSessionTime = null;
		else
			this.acctSessionTime = new AcctSessionTimeImpl(value, null, null);
	}

	@Override
	public ByteBuf getAcctTunnelConnection() 
	{
		if(acctTunnelConnection == null)
			return null;
		
		return acctTunnelConnection.getValue();
	}

	@Override
	public void setAcctTunnelConnection(ByteBuf value) 
	{
		if(value == null)
			this.acctTunnelConnection = null;
		else
			this.acctTunnelConnection = new AcctTunnelConnectionImpl(value, null, null);
	}

	@Override
	public Long getAcctTunnelPacketsLost() 
	{
		if(acctTunnelPacketsLost == null)
			return null;
		
		return acctTunnelPacketsLost.getUnsigned();
	}

	@Override
	public void setAcctTunnelPacketsLost(Long value) 
	{
		if(value == null)
			this.acctTunnelPacketsLost = null;
		else
			this.acctTunnelPacketsLost = new AcctTunnelPacketsLostImpl(value, null, null);
	}

	@Override
	public String getCallbackId() 
	{
		if(callbackId == null)
			return null;
		
		return callbackId.getString();
	}

	@Override
	public void setCallbackId(String value) 
	{
		if(value == null)
			this.callbackId = null;
		else
			this.callbackId = new CallbackIdImpl(value, null, null);
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
	public void setConnectionInfo(List<String> value) 
	{
		if(value == null || value.size()==0)
			this.connectionInfo = null;
		else
		{
			this.connectionInfo = new ArrayList<ConnectInfo>();
			for(String curr:value)
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
	public void setOriginatingLineInfo(ByteBuf value) 
	{
		if(value == null)
			this.originatingLineInfo = null;
		else
			this.originatingLineInfo = new OriginatingLineInfoImpl(value, null, null);
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
	public Long getSessionTimeout() 
	{
		if(sessionTimeout == null)
			return null;
		
		return sessionTimeout.getUnsigned();
	}

	@Override
	public void setSessionTimeout(Long value) 
	{
		if(value == null)
			this.sessionTimeout = null;
		else
			this.sessionTimeout = new SessionTimeoutImpl(value, null, null);
	}

	@Override
	public Long getIdleTimeout() 
	{
		if(idleTimeout == null)
			return null;
		
		return idleTimeout.getUnsigned();
	}

	@Override
	public void setIdleTimeout(Long value) 
	{
		if(value == null)
			this.idleTimeout = null;
		else
			this.idleTimeout = new IdleTimeoutImpl(value, null, null);
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
	public void setFilterId(List<String> value) 
	{
		if(value == null || value.size()==0)
			this.filterId = null;
		else
		{
			this.filterId = new ArrayList<FilterId>();
			for(String curr:value)
				this.filterId.add(new FilterIdImpl(curr, null, null));
		}
	}

	@Override
	public List<NASFilterRule> getNASFilterRule() 
	{
		return nasFilterRule;
	}

	@Override
	public void setNASFilterRule(List<NASFilterRule> value) 
	{
		this.nasFilterRule = value;
	}

	@Override
	public List<DiameterQosFilterRule> getQosFilterRule() 
	{
		return qosFilterRule;
	}

	@Override
	public void setQosFilterRule(List<DiameterQosFilterRule> value) 
	{
		this.qosFilterRule = value;
	}

	@Override
	public FramedCompressionEnum getFramedCompression() 
	{
		if(framedCompression==null)
			return null;
		
		return framedCompression.getEnumerated(FramedCompressionEnum.class);
	}

	@Override
	public void setFramedCompression(FramedCompressionEnum value) 
	{
		if(value == null)
			this.framedCompression = null;
		else
			this.framedCompression = new FramedCompressionImpl(value, null, null);
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
	public ByteBuf getFramedIPv6Pool() 
	{
		if(framedIPv6Pool==null)
			return null;
		
		return framedIPv6Pool.getValue();
	}

	@Override
	public void setFramedIPv6Pool(ByteBuf value) 
	{
		if(value == null)
			this.framedIPv6Pool = null;
		else
			this.framedIPv6Pool = new FramedIPv6PoolImpl(value, null, null);
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
	public void setFramedIPv6Route(List<String> value) 
	{
		if(value == null || value.size()==0)
			this.framedIPv6Route = null;
		else
		{
			this.framedIPv6Route = new ArrayList<FramedIPv6Route>();
			for(String curr:value)
				this.framedIPv6Route.add(new FramedIPv6RouteImpl(curr, null, null));
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
	public Long getFramedIPXNetwork() 
	{
		if(framedIPXNetwork==null)
			return null;
		
		return framedIPXNetwork.getUnsigned();
	}

	@Override
	public void setFramedIPXNetwork(Long value) 
	{
		if(value == null)
			this.framedIPXNetwork = null;
		else
			this.framedIPXNetwork = new FramedIPXNetworkImpl(value, null, null);
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
	public ByteBuf getFramedPool() 
	{
		if(framedPool==null)
			return null;
		
		return framedPool.getValue();
	}

	@Override
	public void setFramedPool(ByteBuf value) 
	{
		if(value == null)
			this.framedPool = null;
		else
			this.framedPool = new FramedPoolImpl(value, null, null);
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
	public void setFramedRoute(List<ByteBuf> value) 
	{
		if(value == null || value.size()==0)
			this.framedRoute = null;
		else
		{
			this.framedRoute = new ArrayList<FramedRoute>();
			for(ByteBuf curr:value)
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
	public void setFramedRouting(FramedRoutingEnum value) 
	{
		if(value == null)
			this.framedRouting = null;
		else
			this.framedRouting = new FramedRoutingImpl(value, null, null);
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
	public LoginServiceEnum getLoginService() 
	{
		if(loginService==null)
			return null;
		
		return loginService.getEnumerated(LoginServiceEnum.class);
	}

	@Override
	public void setLoginService(LoginServiceEnum value) 
	{
		if(value == null)
			this.loginService = null;
		else
			this.loginService = new LoginServiceImpl(value, null, null);
	}

	@Override
	public Long getLoginTCPPort() 
	{
		if(loginTCPPort==null)
			return null;
		
		return loginTCPPort.getUnsigned();
	}

	@Override
	public void setLoginTCPPort(Long value) 
	{
		if(value == null)
			this.loginTCPPort = null;
		else
			this.loginTCPPort = new LoginTCPPortImpl(value, null, null);
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
	public ByteBuf getTGPPIMEISV() 
	{
		if(tgppIMEISV==null)
			return null;
		
		return tgppIMEISV.getValue();
	}

	@Override
	public void setTGPPIMEISV(ByteBuf value) 
	{
		if(value == null)
			this.tgppIMEISV = null;
		else
			this.tgppIMEISV = new TGPPIMEISVImpl(value, null, null);
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
	public ByteBuf getTGPPMSTimeZone() 
	{
		if(tgppMSTimeZone==null)
			return null;
		
		return tgppMSTimeZone.getValue();
	}

	@Override
	public void setTGPPMSTimeZone(ByteBuf value) 
	{
		if(value == null)
			this.tgppMSTimeZone = null;
		else
			this.tgppMSTimeZone = new TGPPMSTimeZoneImpl(value, null, null);
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
	public ByteBuf getTGPPPacketFilter() 
	{
		if(tgppPacketFilter==null)
			return null;
		
		return tgppPacketFilter.getValue();
	}

	@Override
	public void setTGPPPacketFilter(ByteBuf value) 
	{
		if(value == null)
			this.tgppPacketFilter = null;
		else
			this.tgppPacketFilter = new TGPPPacketFilterImpl(value, null, null);
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
	public ByteBuf getTGPPUserLocationInfoTime() 
	{
		if(tgppUserLocationInfoTime==null)
			return null;
		
		return tgppUserLocationInfoTime.getValue();
	}

	@Override
	public void setTGPPUserLocationInfoTime(ByteBuf value) 
	{
		if(value == null)
			this.tgppUserLocationInfoTime = null;
		else
			this.tgppUserLocationInfoTime = new TGPPUserLocationInfoTimeImpl(value, null, null);
	}
	
	@Override
	public List<ByteBuf> getTGPPSecondaryRATUsage() 
	{
		if(tgppSecondaryRATUsage==null || tgppSecondaryRATUsage.size()==0)
			return null;
		
		List<ByteBuf> result=new ArrayList<ByteBuf>();
		for(TGPPSecondaryRATUsage curr:tgppSecondaryRATUsage)
			result.add(curr.getValue());
		
		return result;
	}

	@Override
	public void setTGPPSecondaryRATUsage(List<ByteBuf> value) 
	{
		if(value == null || value.size()==0)
			this.tgppSecondaryRATUsage = null;
		else
		{
			this.tgppSecondaryRATUsage = new ArrayList<TGPPSecondaryRATUsage>();
			for(ByteBuf curr:value)
				this.tgppSecondaryRATUsage.add(new TGPPSecondaryRATUsageImpl(curr, null, null));
		}
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
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(acctApplicationId==null)
			return new MissingAvpException("Acct-Application-Id is required", Arrays.asList(new DiameterAvp[] { new AcctApplicationIdImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
      	result.add(originHost);
      	result.add(originRealm);
      	result.add(destinationRealm);
      	result.add(accountingRecordType);
      	result.add(accountingRecordNumber);
      	result.add(acctApplicationId);
      	result.add(username);
      	result.add(originStateId);
      	result.add(destinationHost);
      	result.add(eventTimestamp);
      	result.add(acctDelayTime);
      	result.add(nasIdentifier);
      	result.add(nasIPAddress);
      	result.add(nasIPv6Address);
      	result.add(nasPort);
      	result.add(nasPortId);
      	result.add(nasPortType);
      	
      	if(diameterClass!=null)
      		result.addAll(diameterClass);
      	
      	result.add(serviceType);
      	result.add(accountingInputOctets);
      	result.add(accountingInputPackets);
      	result.add(accountingOutputOctets);
      	result.add(accountingOutputPackets);
      	result.add(acctAuthentic);
      	result.add(accountingAuthMethod);
      	result.add(acctSessionTime);
      	result.add(acctTunnelConnection);
      	result.add(acctTunnelPacketsLost);
      	result.add(callbackId);
      	result.add(callbackNumber);
      	result.add(calledStationId);
      	result.add(callingStationId);
      	
      	if(connectionInfo!=null)
      		result.addAll(connectionInfo);
      		
      	result.add(originatingLineInfo);
      	result.add(authorizationLifetime);
      	result.add(sessionTimeout);
      	result.add(idleTimeout);
      	result.add(portLimit);
      	result.add(accountingRealtimeRequired);
      	result.add(acctInterimInterval);
      	
      	if(filterId!=null)
      		result.addAll(filterId);
      	
      	if(nasFilterRule!=null)
      		result.addAll(nasFilterRule);
      	
      	if(qosFilterRule!=null)
      		result.addAll(qosFilterRule);
      	
      	result.add(framedCompression);
      	result.add(framedInterfaceId);
      	result.add(framedIPAddress);
      	result.add(framedIPNetmask);
      	
      	if(framedIPv6Prefix!=null)
      		result.addAll(framedIPv6Prefix);
      	
      	result.add(framedIPv6Pool);
      	
      	if(framedIPv6Route!=null)
      		result.addAll(framedIPv6Route);
      	
      	if(delegatedIPv6Prefix!=null)
      		result.addAll(delegatedIPv6Prefix);
      	
      	result.add(framedIPXNetwork);
      	result.add(framedMTU);
      	result.add(framedPool);
      	result.add(framedProtocol);
      	
      	if(framedRoute!=null)
      		result.addAll(framedRoute);
      	
      	result.add(framedRouting);
      	
      	if(loginIPHost!=null)
      		result.addAll(loginIPHost);
      	
      	if(loginIPv6Host!=null)
      		result.addAll(loginIPv6Host);
      	
      	result.add(loginLATGroup);
      	result.add(loginLATNode);
      	result.add(loginLATPort);
      	result.add(loginLATService);
      	result.add(loginService);
      	result.add(loginTCPPort);
      	
      	if(tunneling!=null)
      		result.addAll(tunneling);
      	
      	if(proxyInfo!=null)
      		result.addAll(proxyInfo);
      	
      	if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		result.add(tgppIMSI);
      	result.add(externalIdentifier);
      	result.add(tgppChargingID);
      	result.add(tgppPDPType);
      	result.add(tgppCGAddress);
      	result.add(tgppGPRSNegotiatedQoSProfile);
      	result.add(tgppSGSNAddress);
      	result.add(tgppGGSNAddress);
      	result.add(tgppIMSIMCCMNC);
      	result.add(tgppGGSNMCCMNC);
      	result.add(tgppNSAPI);
      	result.add(tgppSelectionMode);
      	result.add(tgppChargingCharacteristics);
      	result.add(tgppCGIPv6Address);
      	result.add(tgppSGSNIPv6Address);
      	result.add(tgppGGSNIPv6Address);
      	result.add(tgppSGSNMCCMNC);
      	result.add(tgppIMEISV);
      	result.add(tgppRATType);
      	result.add(tgppUserLocationInfo);
      	result.add(tgppMSTimeZone);
      	result.add(tgppCAMELChargingInfo);
      	result.add(tgppPacketFilter);
      	result.add(tgppNegotiatedDSCP);
      	result.add(twanIdentifier);
      	result.add(tgppUserLocationInfoTime);
      	
      	if(tgppSecondaryRATUsage!=null)
      		result.addAll(tgppSecondaryRATUsage);
      	
      	result.add(tgppUELocalIPAddress);
      	result.add(tgppUESourcePort);
      	if(optionalAvps!=null)
      	{
      		for(List<DiameterUnknownAvp> curr:optionalAvps.values())
      			result.addAll(curr);
      	}
    		 
		return result;
	}
}