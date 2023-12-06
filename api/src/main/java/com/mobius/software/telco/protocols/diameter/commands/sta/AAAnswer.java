package com.mobius.software.telco.protocols.diameter.commands.sta;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EmergencyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.2.2.3.4	AA-Answer (AAA) Command
	The AA-Answer (AAA) command, indicated by the Command-Code field set to 265 and the "R" bit cleared in the Command Flags field, is sent from a 3GPP AAA Server/Proxy to a Trusted Non-3GPP access network. The ABNF is re-used from IETF RFC 4005 [4], adding AVPs from IETF RFC 5779 [2].

	< AA-Answer > ::=	< Diameter Header: 265, PXY, 16777250 >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Auth-Request-Type }
				 { Result-Code }
				 [ Experimental-Result ]
				 { Origin-Host }
				 { Origin-Realm }
				 [ Session-Timeout ]
				 [ Accounting-Interim-Interval ]
				 [ Context-Identifier ]
				 [ APN-OI-Replacement ]
				*[ APN-Configuration ]
				 [ 3GPP-Charging-Characteristics ]
				 [ Trace-Info ]
				 [ Subscription-ID ]
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				 [ UE-Usage-Type ]
				 [ Emergency-Info]
				*[ Load ]
				…
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777272, commandCode = 265, request = false, proxyable = true, name="AA-Answer")
public interface AAAnswer extends StaAnswer
{
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);		
	
	Long getSessionTimeout();
	
	void setSessionTimeout(Long value);	
	
	Long getAccountingInterimInterval();
	
	void setAccountingInterimInterval(Long value);	
	
	Long getContextIdentifier();
	
	void setContextIdentifier(Long value);
	
	String getAPNOIReplacement();
	
	void setAPNOIReplacement(String value);
	
	List<APNConfiguration> getAPNConfiguration();
				
	void setAPNConfiguration(List<APNConfiguration> value);	
	
	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);	
	
	TraceInfo getTraceInfo();

	void setTraceInfo(TraceInfo value);
	
	SubscriptionId getSubscriptionID();
	
	void setSubscriptionID(SubscriptionId value);
					 
	public OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	
	void setOCOLR(OCOLR value);
	
	public Long getUEUsageType();
    
    public void setUEUsageType(Long value);
	
	public EmergencyInfo getEmergencyInfo();
    
    public void setEmergencyInfo(EmergencyInfo value);
	
	List<Load> getLoad();
				
	void setLoad(List<Load> value);
}