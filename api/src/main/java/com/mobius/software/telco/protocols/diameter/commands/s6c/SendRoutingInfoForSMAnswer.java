package com.mobius.software.telco.protocols.diameter.commands.s6c;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.AdditionalServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.2.4	Send-Routing-info-for-SM-Answer (SRA) Command
	The Send-Routing-Info-for-SM-Answer command (SRA) command, indicated by the Command-Code field set to 8388647 and the 'R' bit cleared in the Command Flags field, is sent from HSS to SMS-GMSC or SMS Router or from SMS Router to SMS-GMSC.
	Message Format

	< Send-Routing-info-for-SM-Answer > ::=	< Diameter Header: 8388647, PXY, 16777312 >
					 < Session-Id >
					 [ DRMP ]
					 [ Vendor-Specific-Application-Id ]
					 [ Result-Code ]
					 [ Experimental-Result ]
					 { Auth-Session-State }
					 { Origin-Host }
					 { Origin-Realm }
					 [ User-Name ]
					*[ Supported-Features ]
					 [ Serving-Node ]
					 [ Additional-Serving-Node ]
					 [ SMSF-3GPP-Address ]
					 [ SMSF-Non-3GPP-Address ]
					 [ LMSI ]
					 [ User-Identifier ]
					 [ MWD-Status ]
					 [ MME-Absent-User-Diagnostic-SM ]
					 [ MSC-Absent-User-Diagnostic-SM ]
					 [ SGSN-Absent-User-Diagnostic-SM ]
					 [ SMSF-3GPP-Absent-User-Diagnostic-SM ]
					 [ SMSF-Non-3GPP-Absent-User-Diagnostic-SM ]
					*[ AVP ]
					 [ Failed-AVP ]
					*[ Proxy-Info ]
					*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777312, commandCode = 8388647, request = false, proxyable = true, name="Send-Routing-info-for-SM-Answer")
public interface SendRoutingInfoForSMAnswer extends S6cAnswer
{
	ServingNode getServingNode();
	 
	void setServingNode(ServingNode value);
	
	AdditionalServingNode getAdditionalServingNode();
	 
	void setAdditionalServingNode(AdditionalServingNode value);
	
	SMSF3GPPAddress getSMSF3GPPAddress();
	
	void setSMSF3GPPAddress(SMSF3GPPAddress value);
	
	SMSFNon3GPPAddress getSMSFNon3GPPAddress();
	 
	void setSMSFNon3GPPAddress(SMSFNon3GPPAddress value);
	
	ByteBuf getLMSI();
	 
	void setLMSI(ByteBuf value);
					 
	UserIdentifier getUserIdentifier();
	 
	void setUserIdentifier(UserIdentifier value);
	
	Long getMWDStatus();
	 
	void setMWDStatus(Long value);
	 		
	Long getMMEAbsentUserDiagnosticSM();
	 
	void setMMEAbsentUserDiagnosticSM(Long value);
	
	Long getMSCAbsentUserDiagnosticSM();
	
	void setMSCAbsentUserDiagnosticSM(Long value);
	
	Long getSGSNAbsentUserDiagnosticSM();
	 
	void setSGSNAbsentUserDiagnosticSM(Long value);
		
	Long getSMSF3GPPAbsentUserDiagnosticSM();
	 
	void setSMSF3GPPAbsentUserDiagnosticSM(Long value);
	
	Long getSMSFNon3GPPAbsentUserDiagnosticSM();
	 
	void setSMSFNon3GPPAbsentUserDiagnosticSM(Long value);
}