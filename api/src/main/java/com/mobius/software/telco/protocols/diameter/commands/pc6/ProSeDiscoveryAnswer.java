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
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryAuthResponse;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.6	ProSe-Discovery-Answer (PDA) Command
	The ProSe-Discovery-Answer (PDA) Command, indicated by the Command-Code field set to 8388669 and the "R" bit cleared in the Command Flags field, is sent from the ProSe Function in Local PLMN to the ProSe Function in the HPLMN.
	Message Format

	< ProSe-Discovery-Answer > ::=	< Diameter Header: 8388669, PXY, 16777340 >
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
			 [ Discovery-Auth-Response ]
			 [ Discovery-Entry-ID ]
			*[ AVP ]
			 [ Failed-AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777340, commandCode = 8388669, request = false, proxyable = true, name="ProSe-Discovery-Answer")
public interface ProSeDiscoveryAnswer extends Pc6Answer
{
	DiscoveryAuthResponse getDiscoveryAuthResponse();
	 
	void setDiscoveryAuthResponse(DiscoveryAuthResponse value);
	 		
	Long getDiscoveryEntryID();
	 
	void setDiscoveryEntryID(Long value);
}