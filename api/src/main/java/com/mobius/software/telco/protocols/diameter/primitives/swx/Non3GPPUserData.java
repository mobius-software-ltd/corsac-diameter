package com.mobius.software.telco.protocols.diameter.primitives.swx;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AMBR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EmergencyInfo;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.3.1	Non-3GPP-User-Data
	The Non-3GPP-User-Data AVP is of type Grouped. It contains the information related to the user profile relevant for EPS.
	AVP format:

	Non-3GPP-User-Data ::=	< AVP Header: 1500 10415 >
			 [ Subscription-ID ]
			 [ Non-3GPP-IP-Access ]
			 [ Non-3GPP-IP-Access-APN ]
			*[ RAT-Type ]
			 [ Session-Timeout ]
			 [ MIP6-Feature-Vector ]
			 [ AMBR ]
			 [ 3GPP-Charging-Characteristics ]
			 [ Context-Identifier ]
			 [ APN-OI-Replacement ]
			*[ APN-Configuration ]
			 [ Trace-Info ]
			 [ TWAN-Default-APN-Context-Id ]
			*[ TWAN-Access-Info]
			 [ UE-Usage-Type ]
			 [ Emergency-Info ]
			 [ ERP-Authorization ]
			 [ Core-Network-Restrictions ]
			*[ AVP ]

	The Subscription-ID, if present in this grouped AVP, shall contain either an MSISDN (if this identity is present in the subscription), or an External Identifier (if the subscriber does not have an MSISDN identity but has an External Identifier in the subscription).
	The AMBR included in this grouped AVP shall include the AMBR associated to the user's subscription (UE-AMBR).
	The APN-OI-Replacement included in this grouped AVP shall include the UE level APN-OI-Replacement associated to the user's subscription. This APN-OI-Replacement has lower priority than APN level APN-OI-Replacement that is included in the APN-Configuration AVP.
	The Non-3GPP-User-Data AVP shall only contain APN-Configuration AVP(s) configured in the user subscription with an IP PDN type.
	The Context-Identifier in this grouped AVP shall identify the user's default APN configuration. The TWAN-Default-APN-Context-Id AVP identifies the default APN configuration for EPC access over Trusted WLAN. This AVP shall be present if the default APN configuration for EPC access over Trusted WLAN differs from the default APN configuration for 3GPP access and other non-3GPP accesses. This AVP may be present otherwise.
	The RAT-Type AVP(s) shall include the access technology type(s) not allowed for the user as specified in clause 2.13.126 of 3GPP TS 23.008 [49].
	The Emergency-Info AVP shall contain the identity of the PDN-GW used for the establishment of emergency PDN connections.
	The MIP6-Feature-Vector may provide HSM and/or NBM authorization information (see clause 8.2.3.28).
	For the conditions specified in clause 8.1.2.3.2, the Non-3GPP-User-Data AVP shall be empty, i.e. not include any AVP.
	If the Non-3GPP-User-Data AVP is not empty, the Non-3GPP-IP-Acess AVP, the Non-3GPP-IP-Access-APN AVP, the Context-Identifier AVP and at least one item of the APN-Configuration AVP shall always be included, except when the Non-3GPP-User-Data AVP is used for downloading trace activation or deactivation information on the SWx interface, for an already registered user, or when the Non-3GPP-User-Data is used for downloading the Emergency-Info. In those specific cases, the Trace-Info AVP, or respectively the Emergency-Info AVP, shall be included and the presence of any further AVPs is optional.
 */
@DiameterAvpDefinition(code = 1500L, vendorId = KnownVendorIDs.TGPP_ID, name = "Non-3GPP-User-Data")
public interface Non3GPPUserData extends DiameterGroupedAvp
{
	SubscriptionId getSubscriptionId();
	
	void setSubscriptionId(SubscriptionId value);	
	
	Non3GPPIPAccessEnum getNon3GPPIPAccess();
	
	void setNon3GPPIPAccess(Non3GPPIPAccessEnum value);
	
	Non3GPPIPAccessAPNEnum getNon3GPPIPAccessAPN();
	
	void setNon3GPPIPAccessAPN(Non3GPPIPAccessAPNEnum value);
	
	List<RATType> getRATType();
	
	void setRATType(List<RATType> value);
	
	Long getSessionTimeout();
	
	void setSessionTimeout(Long value);
	
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);
	
	AMBR getAMBR();
	
	void setAMBR(AMBR value);
	
	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);
	
	Long getContextIdentifier();
	
	void setContextIdentifier(Long value);
	
	String getAPNOIReplacement();
	
	void setAPNOIReplacement(String value);
	
	List<APNConfiguration> getAPNConfiguration();
	
	void setAPNConfiguration(List<APNConfiguration> value);
	
	TraceInfo getTraceInfo();
	
	void setTraceInfo(TraceInfo value);
	
	Long getTWANDefaultAPNContextId();
	
	void setTWANDefaultAPNContextId(Long value);
	
	List<TWANAccessInfo> getTWANAccessInfo();
	
	void setTWANAccessInfo(List<TWANAccessInfo> value);
	
	Long getUEUsageType();
	
	void setUEUsageType(Long value);
	
	EmergencyInfo getEmergencyInfo();
	
	void setEmergencyInfo(EmergencyInfo value);
	
	ERPAuthorizationEnum getERPAuthorization();
	
	void setERPAuthorization(ERPAuthorizationEnum value);
	
	Long getCoreNetworkRestrictions();	
	
	void setCoreNetworkRestrictions(Long value);
}