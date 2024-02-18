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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.sta.AccessNetworkInfo;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.2.1.4	Diameter-AA-Answer (AAA) Command
	The AA-Answer (AAA) command, indicated by the Command-Code field set to 265 and the "R" bit cleared in the Command Flags field, is sent from 3GPP AAA Server/Proxy to a ePDG.

	<AA-Answer> ::=	< Diameter Header: 265, REQ, PXY, 16777264 >
			 < Session-Id >
			 [ DRMP ]
			 { Auth-Application-Id }
			 { Auth-Request-Type }
			 { Result-Code }
			 { Origin-Host }
			 { Origin-Realm }
			 [ User-Name ]
			 [ APN-OI-Replacement ]
			 [ APN-Configuration ]
			 [ Trace-Info ]
			 [ Subscription-ID ]
			 [ 3GPP-Charging-Characteristics ]
			 [ Session-Timeout ]
			 [ OC-Supported-Features ]
			 [ OC-OLR ]
			*[ Load ]
			 [ Access-Network-Info ]
			 [ User-Location-Info-Time ]
			…
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SWM, commandCode = CommandCodes.AAA, request = false, proxyable = true, name="AA-Answer")
public interface AAAnswer extends SwmAnswer
{
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value) throws MissingAvpException;		
	
	String getAPNOIReplacement();
	
	void setAPNOIReplacement(String value);
	
	APNConfiguration getAPNConfiguration();
				
	void setAPNConfiguration(APNConfiguration value);	
	
	TraceInfo getTraceInfo();

	void setTraceInfo(TraceInfo value);
	
	SubscriptionId getSubscriptionID();
	
	void setSubscriptionID(SubscriptionId value);
		
	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);	
				
	Long getSessionTimeout();
	
	void setSessionTimeout(Long value);	
	
	public OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	
	void setLoad(List<Load> value);
	
	public AccessNetworkInfo getAccessNetworkInfo();
	
	void setAccessNetworkInfo(AccessNetworkInfo value);
	
	Date getUserLocationInfoTime();
	
	void setUserLocationInfoTime(Date value);			
}