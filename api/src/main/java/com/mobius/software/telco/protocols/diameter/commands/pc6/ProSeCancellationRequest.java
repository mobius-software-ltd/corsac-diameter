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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.17	ProSe-Cancellation-Request (PCR) Command
	The ProSe-Cancellation-Request (PCR) Command, indicated by the Command-Code field set to 8388675 and the "R" bit set in the Command Flags field, is sent from the ProSe Function in the HPLMN to the ProSe Function in a local/visited PLMN.
	Message Format

	< ProSe-Cancellation-Request > ::=	< Diameter Header: 8388675, REQ, PXY, 16777340 >
			 < Session-Id >
			 [ DRMP ] 
			 [ Vendor-Specific-Application-Id ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 [ Destination-Host ]
			 { Destination-Realm }
			*[ Supported-Features ]
			 [ OC-Supported-Features ]
			 { Requesting-EPUID }
			 { Targeted-EPUID }
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777340, commandCode = 8388675, request = true, proxyable = true, name="ProSe-Cancellation-Request")
public interface ProSeCancellationRequest extends Pc6Request
{
	String getRequestingEPUID();
	
	void setRequestingEPUID(String value);
	
	String getTargetedEPUID();
	
	void setTargetedEPUID(String value);
}