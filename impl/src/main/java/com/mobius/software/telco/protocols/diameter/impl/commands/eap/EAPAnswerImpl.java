package com.mobius.software.telco.protocols.diameter.impl.commands.eap;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.eap.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctInterimIntervalImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
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
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctInterimInterval;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthApplicationId;
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
@DiameterCommandImplementation(applicationId = 1, commandCode = 271, request = false)
public class EAPAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl implements EAPAnswer
{
	private AuthApplicationId authApplicationId;
	
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
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		setExperimentalResultAllowed(false);
		
		setAuthApplicationId(authApplicationId);
	}

	@Override
	public Long getAuthApplicationId() 
	{
		if(authApplicationId == null)
			return null;
		
		return authApplicationId.getUnsigned();
	}

	@Override
	public void setAuthApplicationId(Long value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Auth-Application-Id is required");	
		
		this.authApplicationId = new AuthApplicationIdImpl(value, null, null);
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
		if(authRequestType==null)
			throw new IllegalArgumentException("Auth-Request-Type is required");	
		
		this.authRequestType = new AuthRequestTypeImpl(authRequestType, null, null);
	}

	@Override
	public ByteBuf getEAPPayload() 
	{
		if(eapPayload==null)
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
	public ByteBuf getEAPReissuedPayload() 
	{
		if(eapReissuedPayload==null)
			return null;
		
		return eapReissuedPayload.getValue();
	}

	@Override
	public void setEAPReissuedPayload(ByteBuf eapReissuedPayload) 
	{
		if(eapPayload == null)
			this.eapReissuedPayload = null;
		else
			this.eapReissuedPayload = new EAPReissuedPayloadImpl(eapReissuedPayload, null, null);
	}

	@Override
	public ByteBuf getEAPMasterSessionKey() 
	{
		if(eapMasterSessionKey==null)
			return null;
		
		return eapMasterSessionKey.getValue();
	}

	@Override
	public void setEAPMasterSessionKey(ByteBuf eapMasterSessionKey) 
	{
		if(eapMasterSessionKey == null)
			this.eapMasterSessionKey = null;
		else
			this.eapMasterSessionKey = new EAPMasterSessionKeyImpl(eapMasterSessionKey, null, null);
	}

	@Override
	public ByteBuf getEAPKeyName() 
	{
		if(eapKeyName==null)
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
	public Long getAccountingEAPAuthMethod() 
	{
		if(accountingEAPAuthMethod == null)
			return null;
		
		return accountingEAPAuthMethod.getLong();
	}

	@Override
	public void setAccountingEAPAuthMethod(Long accountingEAPAuthMethod) 
	{
		if(accountingEAPAuthMethod == null)
			this.accountingEAPAuthMethod = null;
		else
			this.accountingEAPAuthMethod = new AccountingEAPAuthMethodImpl(accountingEAPAuthMethod, null, null);
	}
	
	@Override
	public Long getMultiRoundTimeOut() 
	{
		if(multiRoundTimeOut == null)
			return null;
		
		return multiRoundTimeOut.getUnsigned();
	}

	@Override
	public void setMultiRoundTimeOut(Long multiRoundTimeOut) 
	{
		if(accountingEAPAuthMethod == null)
			this.multiRoundTimeOut = null;
		else
			this.multiRoundTimeOut = new MultiRoundTimeOutImpl(multiRoundTimeOut, null, null);
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
	public void setConfigurationToken(List<ByteBuf> configurationToken) 
	{
		if(configurationToken == null || configurationToken.size()==0)
			this.configurationToken = null;
		else
		{
			this.configurationToken = new ArrayList<ConfigurationToken>();
			for(ByteBuf curr:configurationToken)
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
	public void setIdleTimeout(Long idleTimeout) 
	{
		if(idleTimeout == null)
			this.idleTimeout = null;
		else
			this.idleTimeout = new IdleTimeoutImpl(idleTimeout, null, null);
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
	public ReAuthRequestTypeEnum getReAuthRequestType() 
	{
		if(reAuthRequestType == null)
			return null;
		
		return reAuthRequestType.getEnumerated(ReAuthRequestTypeEnum.class);
	}

	@Override
	public void setReAuthRequestType(ReAuthRequestTypeEnum reAuthRequestType) 
	{
		if(reAuthRequestType == null)
			this.reAuthRequestType = null;
		else
			this.reAuthRequestType = new ReAuthRequestTypeImpl(reAuthRequestType, null, null);
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
	public void setReplyMessage(List<String> replyMessage) 
	{
		if(replyMessage == null || replyMessage.size()==0)
			this.replyMessage = null;
		else
		{
			this.replyMessage = new ArrayList<ReplyMessage>();
			for(String curr:replyMessage)
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
	public void setFramedAppletalkNetwork(List<Long> framedAppletalkNetwork) 
	{
		if(framedAppletalkNetwork == null || framedAppletalkNetwork.size()==0)
			this.framedAppletalkNetwork = null;
		else
		{
			this.framedAppletalkNetwork = new ArrayList<FramedAppletalkNetwork>(); 
			for(Long curr:framedAppletalkNetwork)
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
	public void setFramedAppletalkZone(ByteBuf framedAppletalkZone) 
	{
		if(framedAppletalkZone == null)
			this.framedAppletalkZone = null;
		else
			this.framedAppletalkZone = new FramedAppletalkZoneImpl(framedAppletalkZone, null, null);
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
	public List<Tunneling> getTunneling() 
	{
		return tunneling;
	}

	@Override
	public void setTunneling(List<Tunneling> tunneling) 
	{
		this.tunneling = tunneling;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authApplicationId==null)
			return "Auth-Application-Id is required";
		
		if(authRequestType==null)
			return "Auth-Request-Type is required";
		
		return super.validate();
	}
}