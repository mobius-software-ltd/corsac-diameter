package com.mobius.software.telco.protocols.diameter.commands.pc6;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.10	ProSe-Match-Report-Info-Answer (PIA) Command
	The ProSe-Match-Report-Info-Answer (PIA) Command, indicated by the Command-Code field set to 8388671 and the "R" bit cleared in the Command Flags field, is sent from the ProSe Function of the PLMN in which the announcing UE is roaming to the ProSe Function in the HPLMN of the monitoring UE. 
	Message Format

	< ProSe-Match-Report-Info-Answer > ::=	< Diameter Header: 8388671, PXY, 16777340 >
			 < Session-Id >
			 [ DRMP ] 
			 [ Vendor-Specific-Application-Id ]
			 [ Result-Code ]
			 [ Experimental-Result ] 
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			*[ Supported-Features ]
			 [ OC-Supported-Features ]
			 [ OC-OLR ]
			*[ Load ]
			*[ AVP ]
			 [ Failed-AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.PC6, commandCode = CommandCodes.PROSE_MATCH_REPORT_INFO, request = false, proxyable = true, name="ProSe-Match-Report-Info-Answer")
public interface ProSeMatchReportInfoAnswer extends Pc6Answer
{
}