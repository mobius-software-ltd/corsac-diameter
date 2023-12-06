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
import com.mobius.software.telco.protocols.diameter.primitives.t4.MTCErrorDiagnosticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.t4.TriggerActionEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.4	Device-Trigger-Answer (DTA) Command
	The Device-Trigger-Answer (DTA) command, indicated by the Command-Code field set to 8388643 and the "R" bit cleared in the Command Flags field, is sent from the SMS-SC to the MTC-IWF.
	Message Format

	< Device-Trigger-Answer > ::=	< Diameter Header: 8388643, PXY, 16777311 >
				< Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 [ Result-Code ]
				 [ Experimental-Result ]
				 [ MTC-Error-Diagnostic ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Old-Reference-Number ]
				 [ Trigger-Action ]
				*[ Supported-Features ]
				*[ AVP ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777311, commandCode = 8388643, request = false, proxyable = true, name="Device-Trigger-Answer")
public interface DeviceTriggerAnswer extends T4Answer
{
	MTCErrorDiagnosticEnum getMTCErrorDiagnostic();
	 
	void setMTCErrorDiagnostic(MTCErrorDiagnosticEnum value);
	
	Long getOldReferenceNumber();
	
	void setOldReferenceNumber(Long value);	
	
	TriggerActionEnum getTriggerAction();
	
	void setTriggerAction(TriggerActionEnum value);	
}