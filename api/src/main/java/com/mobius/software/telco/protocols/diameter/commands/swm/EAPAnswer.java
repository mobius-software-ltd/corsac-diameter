package com.mobius.software.telco.protocols.diameter.commands.swm;
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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EmergencyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sta.AccessNetworkInfo;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *  7.2.2.1.2	Diameter-EAP-Answer (DEA) Command
	The Diameter-EAP-Answer (DER) command, indicated by the Command-Code field set to 268 and the "R" bit cleared in the Command Flags field, is sent from a 3GPP AAA Server/Proxy to the ePDG. The ABNF is based on the one in IETF RFC 5779 [2].
	
	< Diameter-EAP-Answer > ::=	< Diameter Header: 268, PXY, 16777264>
			 < Session-Id >
			 [ DRMP ]
			 { Auth-Application-Id }
		 	 { Auth-Request-Type }
			 { Result-Code }
			 { Origin-Host }
			 { Origin-Realm }
			 [ EAP-Payload ]
			 [ User-Name ]
			 [ EAP-Master-Session-Key ]
			 [ APN-OI-Replacement ]
			 [ APN-Configuration ]
			 [ MIP6-Feature-Vector ]
			 [ Mobile-Node-Identifier ]
			 [ Trace-Info ]
			 [ Subscription-ID ]
			 [ Session-Timeout ]
			 [ MIP6-Agent-Info ]
			 [ 3GPP-Charging-Characteristics ]
			*[ Redirect-Host ]
			*[ Supported-Features ]
			 [ OC-Supported-Features ]
			 [ OC-OLR ]
			*[ Load ]
			 [ Access-Network-Info ]
			 [ User-Location-Info-Time ]
			 [ UE-Usage-Type ]
			 [ Emergency-Info ]
			 [ Core-Network-Restrictions ]
			…
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777264, commandCode = 268, request = false, proxyable = true, name="Diameter-EAP-Answer")
public interface EAPAnswer extends SwmAnswer
{
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);		
	
	ByteBuf getEAPPayload();
	
	void setEAPPayload(ByteBuf value);	
	
	ByteBuf getEAPMasterSessionKey();
	
	void setEAPMasterSessionKey(ByteBuf value);	
	
	String getAPNOIReplacement();
	
	void setAPNOIReplacement(String value);
	
	List<APNConfiguration> getAPNConfiguration();
				
	void setAPNConfiguration(List<APNConfiguration> value);	
				
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	String getMobileNodeIdentifier();
	
	void setMobileNodeIdentifier(String value);	
				
	TraceInfo getTraceInfo();

	void setTraceInfo(TraceInfo value);
	
	SubscriptionId getSubscriptionID();
	
	void setSubscriptionID(SubscriptionId value);
	
	Long getSessionTimeout();
	
	void setSessionTimeout(Long value);	

	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);	
	
	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);	
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	public OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	
	void setOCOLR(OCOLR value);
	
	public List<Load> getLoad();
	
	void setLoad(List<Load> value);
	
	public AccessNetworkInfo getAccessNetworkInfo();
	
	void setAccessNetworkInfo(AccessNetworkInfo value);
	
	Date getUserLocationInfoTime();
	
	void setUserLocationInfoTime(Date value);	
	
	public Long getUEUsageType();
    
    public void setUEUsageType(Long value);
	
	public EmergencyInfo getEmergencyInfo();
    
    public void setEmergencyInfo(EmergencyInfo value);
	
    Long getCoreNetworkRestrictions();	
	
	void setCoreNetworkRestrictions(Long value);
}