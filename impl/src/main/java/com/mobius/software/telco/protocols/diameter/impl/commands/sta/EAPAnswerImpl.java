package com.mobius.software.telco.protocols.diameter.impl.commands.sta;

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.sta.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctInterimIntervalImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionTimeoutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPMasterSessionKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPPayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5779.MobileNodeIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc6942.ERPRealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.APNOIReplacementImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ContextIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.UEUsageTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.ANTrustedImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.DEAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.MIPFARKImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.MIPFARKSPIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.TWANConnectionModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.WLCPKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swm.EmergencyServicesImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctInterimInterval;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionTimeout;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPMasterSessionKey;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPPayload;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5779.MobileNodeIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6734.Key;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6942.ERPRealm;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AMBR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNOIReplacement;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ContextIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EmergencyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UEUsageType;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrusted;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrustedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sta.DEAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sta.MIPFARK;
import com.mobius.software.telco.protocols.diameter.primitives.sta.MIPFARKSPI;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWANConnectionMode;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWANConnectivityParameters;
import com.mobius.software.telco.protocols.diameter.primitives.sta.WLCPKey;
import com.mobius.software.telco.protocols.diameter.primitives.swm.EmergencyServices;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

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
@DiameterCommandImplementation(applicationId = 16777250, commandCode = 268, request = false)
public class EAPAnswerImpl extends StaAnswerWithIdImpl implements EAPAnswer
{
	private AuthRequestType authRequestType;
	
	private EAPPayload eapPayload;
	
	private SessionTimeout sessionTimeout;
	
	private AcctInterimInterval accountingInterimInterval;
	
	private EAPMasterSessionKey eapMasterSessionKey;
	
	private ContextIdentifier contextIdentifier;
	
	private APNOIReplacement apnOIReplacement;
	
	private List<APNConfiguration> apnConfiguration;
	
	private MIP6AgentInfo mip6AgentInfo;
	
	private MIP6FeatureVector mip6FeatureVector;
	
	private MobileNodeIdentifier mobileNodeIdentifier;
	
	private TGPPChargingCharacteristics tgppChargingCharacteristics;    
	
	private AMBR ambr;
	
	private ANTrusted anTrusted;
	
	private TraceInfo traceInfo;

	private SubscriptionId subscriptionID;
	
	private OCSupportedFeatures ocSupportedFeatures;
	 
	private OCOLR ocOLR;
	
	private List<Load> load;
	
	private List<SupportedFeatures> supportedFeatures;
	
	private MIPFARK mipFARK;
	
	private MIPFARKSPI mipFARKSPI;
	
	private DEAFlags deaFlags;
	
	private TWANConnectionMode twanConnectionMode;
	
	private TWANConnectivityParameters twanConnectivityParameters;
	
	private WLCPKey wlCPKey;
	
	private TerminalInformation terminalInformation;
    
	private UEUsageType ueUsageType;
    
	private EmergencyServices emergencyServices;
    
	private EmergencyInfo emergencyInfo;
    
	private Key key;
    
	private ERPRealm erpRealm;
	
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
	public Long getSessionTimeout() 
	{
		if(sessionTimeout == null)
			return null;
		
		return sessionTimeout.getUnsigned();
	}
	
	@Override
	public void setSessionTimeout(Long value)
	{
		if(value==null)
			this.sessionTimeout = null;
		else
			this.sessionTimeout = new SessionTimeoutImpl(value, null, null);
	}

	@Override
	public Long getAccountingInterimInterval()
	{
		if(accountingInterimInterval==null)
			return null;
		
		return accountingInterimInterval.getUnsigned();
	}
	
	@Override
	public void setAccountingInterimInterval(Long value)
	{
		if(value == null)
			this.accountingInterimInterval = null;
		else
			this.accountingInterimInterval = new AcctInterimIntervalImpl(value, null, null);
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
	public Long getContextIdentifier()
	{
		if(contextIdentifier==null)
			return null;
		
		return contextIdentifier.getUnsigned();
	}
	
	@Override
	public void setContextIdentifier(Long value)
	{
		if(value == null)
			this.contextIdentifier = null;
		else
			this.contextIdentifier = new ContextIdentifierImpl(value, null, null);
	}
	
	@Override
	public String getAPNOIReplacement()
	{
		if(apnOIReplacement==null)
			return null;
		
		return apnOIReplacement.getString();
	}
	
	@Override
	public void setAPNOIReplacement(String value) 
	{
		if(value == null)
			this.apnOIReplacement = null;
		else
			this.apnOIReplacement = new APNOIReplacementImpl(value, null, null);
	}
	
	@Override
	public List<APNConfiguration> getAPNConfiguration()
	{
		return this.apnConfiguration;
	}
				
	@Override
	public void setAPNConfiguration(List<APNConfiguration> value)
	{
		this.apnConfiguration = value;
	}
	
	@Override
	public MIP6AgentInfo getMIP6AgentInfo()
	{
		return this.mip6AgentInfo;
	}
	
	@Override
	public void setMIP6AgentInfo(MIP6AgentInfo value)
	{
		this.mip6AgentInfo = value;
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
	public String getMobileNodeIdentifier()
	{
		if(mobileNodeIdentifier==null)
			return null;
		
		return mobileNodeIdentifier.getString();
	}
	
	@Override
	public void setMobileNodeIdentifier(String value)
	{
		if(value == null)
			this.mobileNodeIdentifier = null;
		else
			this.mobileNodeIdentifier = new MobileNodeIdentifierImpl(value, null, null);
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
	public AMBR getAMBR()
	{
		return this.ambr;
	}
	
	@Override
	public void setAMBR(AMBR value)
	{
		this.ambr = value;
	}
					 
	@Override
	public ANTrustedEnum getANTrusted()
	{
		if(anTrusted == null)
			return null;
		
		return anTrusted.getEnumerated(ANTrustedEnum.class);
	}
	
	@Override
	public void setANTrusted(ANTrustedEnum value)
	{
		if(value==null)
			this.anTrusted = null;
		else
			this.anTrusted = new ANTrustedImpl(value, null, null);
	}	
	
	@Override
	public TraceInfo getTraceInfo()
	{
		return traceInfo;
	}

	@Override
	public void setTraceInfo(TraceInfo value)
	{
		this.traceInfo = value;
	}
	
	@Override
	public SubscriptionId getSubscriptionID()
	{
		return this.subscriptionID;
	}
	
	@Override
	public void setSubscriptionID(SubscriptionId value)
	{
		this.subscriptionID = value;
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
	public OCOLR getOCOLR()
	{
		return this.ocOLR;
	}
	 
	@Override
	public void setOCOLR(OCOLR value)
	{
		this.ocOLR = value;
	}
    
	@Override
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	@Override
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
	
	@Override
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;				
	}
			 
	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
	}
	
	@Override
	public ByteBuf getMIPFARK()
	{
		if(mipFARK == null)
			return null;
		
		return mipFARK.getValue();
	}
	
	@Override
	public void setMIPFARK(ByteBuf value)
	{
		if(value==null)
			this.mipFARK = null;
		else
			this.mipFARK = new MIPFARKImpl(value, null, null);
	}
	
	@Override
	public Long getMIPFARKSPI()
	{
		if(mipFARKSPI == null)
			return null;
		
		return mipFARKSPI.getUnsigned();
	}
	
	@Override
	public void setMIPFARKSPI(Long value)
	{
		if(value==null)
			this.mipFARKSPI = null;
		else
			this.mipFARKSPI = new MIPFARKSPIImpl(value, null, null);
	}
	
	@Override
	public Long getDEAFlags()
	{
		if(deaFlags == null)
			return null;
		
		return deaFlags.getUnsigned();
	}
	
	@Override
	public void setDEAFlags(Long value)
	{
		if(value==null)
			this.deaFlags = null;
		else
			this.deaFlags = new DEAFlagsImpl(value, null, null);
	}
	
	@Override
	public Long getTWANConnectionMode()
	{
		if(twanConnectionMode == null)
			return null;
		
		return twanConnectionMode.getUnsigned();
	}
	
	@Override
	public void setTWANConnectionMode(Long value)
	{
		if(value==null)
			this.twanConnectionMode = null;
		else
			this.twanConnectionMode = new TWANConnectionModeImpl(value, null, null);
	}
	
	@Override
	public TWANConnectivityParameters getTWANConnectivityParameters()
	{
		return this.twanConnectivityParameters;
	}
	
	@Override
	public void setTWANConnectivityParameters(TWANConnectivityParameters value)
	{
		this.twanConnectivityParameters = value;
	}
	
	@Override
	public ByteBuf getWLCPKey()
	{
		if(wlCPKey == null)
			return null;
		
		return wlCPKey.getValue();
	}
	
	@Override
	public void setWLCPKey(ByteBuf value)
	{
		if(value==null)
			this.wlCPKey = null;
		else
			this.wlCPKey = new WLCPKeyImpl(value, null, null);
	}
	
	@Override
	public TerminalInformation getTerminalInformation()
	{
		return this.terminalInformation;
	}
    
	@Override
	public void setTerminalInformation(TerminalInformation value)
	{
		this.terminalInformation = value;
	}
    
	@Override
	public Long getUEUsageType()
	{
		if(ueUsageType==null)
			return null;
		
		return ueUsageType.getUnsigned();
	}
    
	@Override
	public void setUEUsageType(Long value)
	{
		if(value==null)
			this.ueUsageType = null;
		else
			this.ueUsageType = new UEUsageTypeImpl(value, null, null);
	}
    
	@Override
	public Long getEmergencyServices()
	{
		if(emergencyServices == null)
			return null;
		
		return emergencyServices.getUnsigned();
	}
    
	@Override
	public void setEmergencyServices(Long value)
	{
		if(value==null)
			this.emergencyServices = null;
		else
			this.emergencyServices = new EmergencyServicesImpl(value, null, null);
	}
    
	@Override
	public EmergencyInfo getEmergencyInfo()
	{
    	return this.emergencyInfo;
	}
    
	@Override
	public void setEmergencyInfo(EmergencyInfo value)
	{
		this.emergencyInfo = value;
	}
    
	@Override
	public Key getKey()
	{
		return this.key;
	}
    
	@Override
	public void setKey(Key value)
	{
		this.key = value;
	}
    
	@Override
	public String getERPRealm()
	{
		if(erpRealm == null)
			return null;
		
		return erpRealm.getIdentity();
	}
    
	@Override
	public void setERPRealm(String value)
	{
		if(value==null)
			this.erpRealm = null;
		else
			this.erpRealm = new ERPRealmImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authRequestType==null)
			return "Auth-Request-Type is required";
		
		return super.validate();
	}
}