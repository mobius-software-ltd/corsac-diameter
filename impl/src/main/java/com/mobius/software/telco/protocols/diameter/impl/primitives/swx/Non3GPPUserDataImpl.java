package com.mobius.software.telco.protocols.diameter.impl.primitives.swx;
/*
 * Mobius Software LTD
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionTimeoutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.APNOIReplacementImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ContextIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.CoreNetworkRestrictionsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.UEUsageTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionTimeout;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AMBR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNOIReplacement;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ContextIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CoreNetworkRestrictions;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EmergencyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UEUsageType;
import com.mobius.software.telco.protocols.diameter.primitives.swx.ERPAuthorization;
import com.mobius.software.telco.protocols.diameter.primitives.swx.ERPAuthorizationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.swx.Non3GPPIPAccess;
import com.mobius.software.telco.protocols.diameter.primitives.swx.Non3GPPIPAccessAPN;
import com.mobius.software.telco.protocols.diameter.primitives.swx.Non3GPPIPAccessAPNEnum;
import com.mobius.software.telco.protocols.diameter.primitives.swx.Non3GPPIPAccessEnum;
import com.mobius.software.telco.protocols.diameter.primitives.swx.Non3GPPUserData;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TWANAccessInfo;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TWANDefaultAPNContextId;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1500L, vendorId = KnownVendorIDs.TGPP_ID)
public class Non3GPPUserDataImpl extends DiameterGroupedAvpImpl implements Non3GPPUserData
{
	private SubscriptionId subscriptionID;
	private Non3GPPIPAccess non3GPPIPAccess;
	private Non3GPPIPAccessAPN non3GPPIPAccessAPN;
	private List<RATType> ratType;
	private SessionTimeout sessionTimeout;
	private MIP6FeatureVector mip6FeatureVector;
	private AMBR ambr;
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	private ContextIdentifier contextIdentifier;
	private APNOIReplacement apnOIReplacement;
	private List<APNConfiguration> apnConfiguration;
	private TraceInfo traceInfo;
	private TWANDefaultAPNContextId twanDefaultAPNContextId;
	private List<TWANAccessInfo> twanAccessInfo;
	private UEUsageType ueUsageType;
	private EmergencyInfo emergencyInfo;
	private ERPAuthorization erpAuthorization;
	private CoreNetworkRestrictions coreNetworkRestrictions;
	
	public Non3GPPUserDataImpl()
	{
		
	}
	
	public SubscriptionId getSubscriptionId()
	{
		return subscriptionID;
	}
	
	public void setSubscriptionId(SubscriptionId value)
	{
		this.subscriptionID = value;
	}
	
	public Non3GPPIPAccessEnum getNon3GPPIPAccess()
	{
		if(non3GPPIPAccess==null)
			return null;
		
		return non3GPPIPAccess.getEnumerated(Non3GPPIPAccessEnum.class);
	}
	
	public void setNon3GPPIPAccess(Non3GPPIPAccessEnum value)
	{
		if(value==null)
			this.non3GPPIPAccess = null;
		else
			this.non3GPPIPAccess = new Non3GPPIPAccessImpl(value, null, null);
	}
	
	public Non3GPPIPAccessAPNEnum getNon3GPPIPAccessAPN()
	{
		if(non3GPPIPAccessAPN==null)
			return null;
		
		return non3GPPIPAccessAPN.getEnumerated(Non3GPPIPAccessAPNEnum.class);
	}
	
	public void setNon3GPPIPAccessAPN(Non3GPPIPAccessAPNEnum value)
	{
		if(value==null)
			this.non3GPPIPAccessAPN = null;
		else
			this.non3GPPIPAccessAPN = new Non3GPPIPAccessAPNImpl(value, null, null);
	}
	
	public List<RATType> getRATType()
	{
		return ratType;
	}
	
	public void setRATType(List<RATType> value)
	{
		this.ratType = value;
	}
	
	public Long getSessionTimeout()
	{
		if(sessionTimeout==null)
			return null;
		
		return sessionTimeout.getUnsigned();
	}
	
	public void setSessionTimeout(Long value)
	{
		if(value==null)
			this.sessionTimeout = null;
		else
			this.sessionTimeout = new SessionTimeoutImpl(value, null, null);
	}
	
	public Long getMIP6FeatureVector()
	{
		if(mip6FeatureVector==null)
			return null;
		
		return mip6FeatureVector.getLong();
	}
	
	public void setMIP6FeatureVector(Long value)
	{
		if(value==null)
			this.mip6FeatureVector = null;
		else
			this.mip6FeatureVector = new MIP6FeatureVectorImpl(value, null, null);
	}
	
	public AMBR getAMBR()
	{
		return ambr;
	}
	
	public void setAMBR(AMBR value)
	{
		this.ambr = value;
	}
	
	public String getTGPPChargingCharacteristics()
	{
		if(tgppChargingCharacteristics==null)
			return null;
		
		return tgppChargingCharacteristics.getString();
	}
	
	public void setTGPPChargingCharacteristics(String value)
	{
		if(value==null)
			this.tgppChargingCharacteristics = null;
		else
			this.tgppChargingCharacteristics = new TGPPChargingCharacteristicsImpl(value, null, null);
	}
	
	public Long getContextIdentifier()
	{
		if(contextIdentifier==null)
			return null;
		
		return contextIdentifier.getUnsigned();
	}
	
	public void setContextIdentifier(Long value)
	{
		if(value==null)
			this.contextIdentifier = null;
		else
			this.contextIdentifier = new ContextIdentifierImpl(value, null, null);
	}
	
	public String getAPNOIReplacement()
	{
		if(apnOIReplacement==null)
			return null;
		
		return apnOIReplacement.getString();
	}
	
	public void setAPNOIReplacement(String value)
	{
		if(value==null)
			this.apnOIReplacement = null;
		else
			this.apnOIReplacement = new APNOIReplacementImpl(value, null, null);
	}
	
	public List<APNConfiguration> getAPNConfiguration()
	{
		return apnConfiguration;
	}
	
	public void setAPNConfiguration(List<APNConfiguration> value)
	{
		this.apnConfiguration = value;
	}
	
	public TraceInfo getTraceInfo()
	{
		return traceInfo;
	}
	
	public void setTraceInfo(TraceInfo value)
	{
		this.traceInfo = value;
	}
	
	public Long getTWANDefaultAPNContextId()
	{
		if(twanDefaultAPNContextId==null)
			return null;
		
		return twanDefaultAPNContextId.getUnsigned();
	}
	
	public void setTWANDefaultAPNContextId(Long value)
	{
		if(value==null)
			this.twanDefaultAPNContextId = null;
		else
			this.twanDefaultAPNContextId = new TWANDefaultAPNContextIdImpl(value, null, null);
	}
	
	public List<TWANAccessInfo> getTWANAccessInfo()
	{
		return twanAccessInfo;
	}
	
	public void setTWANAccessInfo(List<TWANAccessInfo> value)
	{
		this.twanAccessInfo = value;
	}
	
	public Long getUEUsageType()
	{
		if(ueUsageType==null)
			return null;
		
		return ueUsageType.getUnsigned();
	}
	
	public void setUEUsageType(Long value)
	{
		if(value==null)
			this.ueUsageType = null;
		else
			this.ueUsageType = new UEUsageTypeImpl(value, null, null);
	}
	
	public EmergencyInfo getEmergencyInfo()
	{
		return emergencyInfo;
	}
	
	public void setEmergencyInfo(EmergencyInfo value)
	{
		this.emergencyInfo = value;				
	}
	
	public ERPAuthorizationEnum getERPAuthorization()
	{
		if(erpAuthorization==null)
			return null;
		
		return erpAuthorization.getEnumerated(ERPAuthorizationEnum.class);
	}
	
	public void setERPAuthorization(ERPAuthorizationEnum value)
	{
		if(value==null)
			this.erpAuthorization = null;
		else
			this.erpAuthorization = new ERPAuthorizationImpl(value, null, null);
	}
	
	public Long getCoreNetworkRestrictions()
	{
		if(coreNetworkRestrictions==null)
			return null;
		
		return coreNetworkRestrictions.getUnsigned();
	}
	
	public void setCoreNetworkRestrictions(Long value)
	{
		if(value==null)
			this.coreNetworkRestrictions = null;
		else
			this.coreNetworkRestrictions = new CoreNetworkRestrictionsImpl(value, null, null);
	}
}