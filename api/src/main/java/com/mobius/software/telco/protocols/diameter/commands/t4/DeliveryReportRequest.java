package com.mobius.software.telco.protocols.diameter.commands.t4;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.t4.AbsentSubscriberDiagnosticT4Enum;
import com.mobius.software.telco.protocols.diameter.primitives.t4.SMDeliveryOutcomeT4Enum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.5	Delivery-Report-Request (DRR) Command
	The Delivery-Report-Request (DRR) command, indicated by the Command-Code field set to 8388644 and the "R" bit set in the Command Flags field, is sent from the SMS-SC to the MTC-IWF.
	Message Format

	< Delivery-Report-Request > ::=	< Diameter Header: 8388644, REQ, PXY, 16777311 >
					 < Session-Id >
					 [ DRMP ]
					 { Auth-Session-State }
					 { Origin-Host }
					 { Origin-Realm }
					 { Destination-Host }
					 { Destination-Realm }
					 { User-Identifier }
					 { SM-RP-SMEA }
					 { SM-Delivery-Outcome-T4 }
					 [ Absent-Subscriber-Diagnostic-T4 ]
					 [ Reference-Number ]
					*[ Supported-Features ]
					*[ AVP ]
					*[ Proxy-Info ]
					*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777311, commandCode = 8388644, request = true, proxyable = true, name="Delivery-Report-Request")
public interface DeliveryReportRequest extends T4Request
{
	UserIdentifier getUserIdentifier();
	 
	void setUserIdentifier(UserIdentifier value);
	
	ByteBuf getSMRPSMEA();
	
	void setSMRPSMEA(ByteBuf value);
	 		
	SMDeliveryOutcomeT4Enum getSMDeliveryOutcomeT4();
	
	void setSMDeliveryOutcomeT4(SMDeliveryOutcomeT4Enum value);
	
	AbsentSubscriberDiagnosticT4Enum getAbsentSubscriberDiagnosticT4();
	 
	void setAbsentSubscriberDiagnosticT4(AbsentSubscriberDiagnosticT4Enum value);
	
	Long getReferenceNumber();
	
	void setReferenceNumber(Long value);	
}