package com.mobius.software.telco.protocols.diameter.impl.commands.eap;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.eap.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctInterimIntervalImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthGracePeriodImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DiameterClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.MultiRoundTimeOutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ReAuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionTimeoutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.AccountingEAPAuthMethodImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPKeyNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPMasterSessionKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPPayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPReissuedPayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallbackIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallbackNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ConfigurationTokenImpl;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.PortLimitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ReplyMessageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ServiceTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.StateImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctInterimInterval;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthGracePeriod;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.common.DiameterClass;
import com.mobius.software.telco.protocols.diameter.primitives.common.MultiRoundTimeOut;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionTimeout;
import com.mobius.software.telco.protocols.diameter.primitives.eap.AccountingEAPAuthMethod;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPKeyName;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPMasterSessionKey;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPPayload;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPReissuedPayload;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallbackId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallbackNumber;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ConfigurationToken;
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
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.PortLimit;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ReplyMessage;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.State;
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
@DiameterCommandImplementation(applicationId = 5, commandCode = 268, request = false)
public class EAPAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl implements EAPAnswer
{
	private AuthRequestType authRequestType;
	
	private EAPPayload eapPayload;
	
	private EAPReissuedPayload eapReissuedPayload;
	
	private EAPMasterSessionKey eapMasterSessionKey;
	
	private EAPKeyName eapKeyName;
	
	private MultiRoundTimeOut multiRoundTimeOut;

	private AccountingEAPAuthMethod accountingEAPAuthMethod;

	private ServiceType serviceType;
	
	private List<DiameterClass> diameterClass;
	
	private List<ConfigurationToken> configurationToken;
	
	private AcctInterimInterval acctInterimInterval;
	
	private IdleTimeout idleTimeout;
	
	private AuthorizationLifetime authorizationLifetime;
	
	private AuthGracePeriod authGracePeriod;
	
	private AuthSessionState authSessionState;
	
	private ReAuthRequestType reAuthRequestType;
	
	private SessionTimeout sessionTimeout;
	
	private State state;
	
	private List<ReplyMessage> replyMessage;
	
	private List<FilterId> filterId;
	
	private PortLimit portLimit;
	
	private CallbackId callbackId;
	
	private CallbackNumber callbackNumber;
	
	private FramedAppletalkLink framedAppletalkLink;
	
	private List<FramedAppletalkNetwork> framedAppletalkNetwork;
	
	private FramedAppletalkZone framedAppletalkZone;
	
	private List<FramedCompression> framedCompression;
	
	private FramedInterfaceId framedInterfaceId;
	
	private FramedIPAddress framedIPAddress;
	
	private List<FramedIPv6Prefix> framedIPv6Prefix;
	
	private FramedIPv6Pool framedIPv6Pool;
	
	private List<FramedIPv6Route> framedIPv6Route;
	
	private FramedIPNetmask framedIPNetmask;
	
	private List<FramedRoute> framedRoute;
	
	private FramedPool framedPool;
	
	private FramedIPXNetwork framedIPXNetwork;
	
	private FramedMTU framedMTU;
	
	private FramedProtocol framedProtocol;
	
	private FramedRouting framedRouting;
	
	private List<NASFilterRule> nasFilterRule;
	
	private List<DiameterQosFilterRule> qosFilterRule;
	
	private List<Tunneling> tunneling;
	
	protected EAPAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public EAPAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		setExperimentalResultAllowed(false);
		
		setAuthRequestType(authRequestType);
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
	public ByteBuf getEAPPayload() 
	{
		if(eapPayload==null)
			return null;
		
		return eapPayload.getValue();
	}

	@Override
	public void setEAPPayload(ByteBuf value) 
	{
		if(value == null)
			this.eapPayload = null;
		else
			this.eapPayload = new EAPPayloadImpl(value, null, null);
	}

	@Override
	public ByteBuf getEAPReissuedPayload() 
	{
		if(eapReissuedPayload==null)
			return null;
		
		return eapReissuedPayload.getValue();
	}

	@Override
	public void setEAPReissuedPayload(ByteBuf value) 
	{
		if(value == null)
			this.eapReissuedPayload = null;
		else
			this.eapReissuedPayload = new EAPReissuedPayloadImpl(value, null, null);
	}

	@Override
	public ByteBuf getEAPMasterSessionKey() 
	{
		if(eapMasterSessionKey==null)
			return null;
		
		return eapMasterSessionKey.getValue();
	}

	@Override
	public void setEAPMasterSessionKey(ByteBuf value) 
	{
		if(value == null)
			this.eapMasterSessionKey = null;
		else
			this.eapMasterSessionKey = new EAPMasterSessionKeyImpl(value, null, null);
	}

	@Override
	public ByteBuf getEAPKeyName() 
	{
		if(eapKeyName==null)
			return null;
		
		return eapKeyName.getValue();
	}

	@Override
	public void setEAPKeyName(ByteBuf value) 
	{
		if(value == null)
			this.eapKeyName = null;
		else
			this.eapKeyName = new EAPKeyNameImpl(value, null, null);
	}
	
	@Override
	public Long getAccountingEAPAuthMethod() 
	{
		if(accountingEAPAuthMethod == null)
			return null;
		
		return accountingEAPAuthMethod.getLong();
	}

	@Override
	public void setAccountingEAPAuthMethod(Long value) 
	{
		if(value == null)
			this.accountingEAPAuthMethod = null;
		else
			this.accountingEAPAuthMethod = new AccountingEAPAuthMethodImpl(value, null, null);
	}
	
	@Override
	public Long getMultiRoundTimeOut() 
	{
		if(multiRoundTimeOut == null)
			return null;
		
		return multiRoundTimeOut.getUnsigned();
	}

	@Override
	public void setMultiRoundTimeOut(Long value) 
	{
		if(value == null)
			this.multiRoundTimeOut = null;
		else
			this.multiRoundTimeOut = new MultiRoundTimeOutImpl(value, null, null);
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
	public List<ByteBuf> getConfigurationToken() 
	{
		if(configurationToken == null || configurationToken.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(ConfigurationToken curr: configurationToken)
			result.add(curr.getValue());
		
		return result;
	}

	@Override
	public void setConfigurationToken(List<ByteBuf> value) 
	{
		if(value == null || value.size()==0)
			this.configurationToken = null;
		else
		{
			this.configurationToken = new ArrayList<ConfigurationToken>();
			for(ByteBuf curr:value)
				this.configurationToken.add(new ConfigurationTokenImpl(curr, null, null));
		}	
	}

	@Override
	public Long getAcctInterimInterval() 
	{
		if(this.acctInterimInterval==null)
			return null;
		
		return this.acctInterimInterval.getUnsigned();
	}

	@Override
	public void setAcctInterimInterval(Long value) 
	{
		if(value == null)
			this.acctInterimInterval = null;
		else
			this.acctInterimInterval = new AcctInterimIntervalImpl(value, null, null);
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
	public ReAuthRequestTypeEnum getReAuthRequestType() 
	{
		if(reAuthRequestType == null)
			return null;
		
		return reAuthRequestType.getEnumerated(ReAuthRequestTypeEnum.class);
	}

	@Override
	public void setReAuthRequestType(ReAuthRequestTypeEnum value) 
	{
		if(value == null)
			this.reAuthRequestType = null;
		else
			this.reAuthRequestType = new ReAuthRequestTypeImpl(value, null, null);
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
	public ByteBuf getState() 
	{
		if(state == null)
			return null;
		
		return state.getValue();
	}

	@Override
	public void setState(ByteBuf value) 
	{
		if(value == null)
			this.state = null;
		else
			this.state = new StateImpl(value, null, null);
	}

	@Override
	public List<String> getReplyMessage() 
	{
		if(replyMessage == null || replyMessage.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ReplyMessage curr: replyMessage)
			result.add(curr.getString());
		
		return result;
	}

	@Override
	public void setReplyMessage(List<String> value) 
	{
		if(value == null || value.size()==0)
			this.replyMessage = null;
		else
		{
			this.replyMessage = new ArrayList<ReplyMessage>();
			for(String curr:value)
				this.replyMessage.add(new ReplyMessageImpl(curr, null, null));
		}
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
	public Long getFramedAppletalkLink() 
	{
		if(framedAppletalkLink==null)
			return null;
		
		return framedAppletalkLink.getUnsigned();
	}

	@Override
	public void setFramedAppletalkLink(Long value) 
	{
		if(value == null)
			this.framedAppletalkLink = null;
		else
			this.framedAppletalkLink = new FramedAppletalkLinkImpl(value, null, null);
	}

	@Override
	public List<Long> getFramedAppletalkNetwork() 
	{
		if(framedAppletalkNetwork==null || framedAppletalkNetwork.size()==0)
			return null;
		
		List<Long> result=new ArrayList<Long>();
		for(FramedAppletalkNetwork curr:framedAppletalkNetwork)
			result.add(curr.getUnsigned());
		
		return result;
	}

	@Override
	public void setFramedAppletalkNetwork(List<Long> value) 
	{
		if(value == null || value.size()==0)
			this.framedAppletalkNetwork = null;
		else
		{
			this.framedAppletalkNetwork = new ArrayList<FramedAppletalkNetwork>(); 
			for(Long curr:value)
				this.framedAppletalkNetwork.add(new FramedAppletalkNetworkImpl(curr, null, null));
		}
	}

	@Override
	public ByteBuf getFramedAppletalkZone() 
	{
		if(framedAppletalkZone==null)
			return null;
		
		return framedAppletalkZone.getValue();
	}

	@Override
	public void setFramedAppletalkZone(ByteBuf value) 
	{
		if(value == null)
			this.framedAppletalkZone = null;
		else
			this.framedAppletalkZone = new FramedAppletalkZoneImpl(value, null, null);
	}

	@Override
	public List<FramedCompressionEnum> getFramedCompression() 
	{
		if(framedCompression==null || framedCompression.size()==0)
			return null;
		
		List<FramedCompressionEnum> result = new ArrayList<FramedCompressionEnum>();
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
	public List<Tunneling> getTunneling() 
	{
		return tunneling;
	}

	@Override
	public void setTunneling(List<Tunneling> value) 
	{
		this.tunneling = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authRequestType==null)
			return "Auth-Request-Type is required";
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
		result.add(authRequestType);
		result.add(resultCode);
		result.add(originHost);
		result.add(originRealm);
        result.add(username);
        result.add(eapPayload);
        result.add(eapReissuedPayload);
        result.add(eapMasterSessionKey);
        result.add(eapKeyName);
        result.add(multiRoundTimeOut);
        result.add(accountingEAPAuthMethod);
        result.add(serviceType);
        
        if(diameterClass!=null)
        	result.addAll(diameterClass);
        
        if(configurationToken!=null)
        	result.addAll(configurationToken);
        
        result.add(acctInterimInterval);
        result.add(errorMessage);
        result.add(errorReportingHost);
        result.add(failedAvp);
        result.add(idleTimeout);
        result.add(authorizationLifetime);
        result.add(authGracePeriod);
        result.add(authSessionState);
        result.add(reAuthRequestType);
        result.add(sessionTimeout);
        result.add(state);
        
        if(replyMessage!=null)
        	result.addAll(replyMessage);
        
        result.add(originStateId);
        
        if(filterId!=null)
        	result.addAll(filterId);
        
        result.add(portLimit);
        result.add(callbackId);
        result.add(callbackNumber);
        result.add(framedAppletalkLink);
        
        if(framedAppletalkNetwork!=null)
        	result.addAll(framedAppletalkNetwork);
        
        result.add(framedAppletalkZone);
        
        if(framedCompression!=null)
        	result.addAll(framedCompression);
        
        result.add(framedInterfaceId);
        result.add(framedIPAddress);
        
        if(framedIPv6Prefix!=null)
        	result.addAll(framedIPv6Prefix);
        
        result.add(framedIPv6Pool);
        
        if(framedIPv6Route!=null)
        	result.addAll(framedIPv6Route);
        
        result.add(framedIPNetmask);
        
        if(framedRoute!=null)
        	result.addAll(framedRoute);
        
        result.add(framedPool);
        result.add(framedIPXNetwork);
        result.add(framedMTU);
        result.add(framedProtocol);
        result.add(framedRouting);
        
        if(nasFilterRule!=null)
        	result.addAll(nasFilterRule);
        
        if(qosFilterRule!=null)
        	result.addAll(qosFilterRule);
        
        if(tunneling!=null)
        	result.addAll(tunneling);
        
        if(redirectHost!=null)
        	result.addAll(redirectHost);
        
        result.add(redirectHostUsage);
        result.add(redirectMaxCacheTime);
        
		if(proxyInfo!=null)
			result.addAll(proxyInfo);

		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		return result;
	}
}