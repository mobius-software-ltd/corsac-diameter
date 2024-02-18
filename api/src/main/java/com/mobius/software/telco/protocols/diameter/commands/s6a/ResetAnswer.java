package com.mobius.software.telco.protocols.diameter.commands.s6a;
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
 * 	7.2.16	Reset-Answer (RSA) Command
	The Reset-Answer (RSA) command, indicated by the Command-Code field set to 322 and the 'R' bit cleared in the Command Flags field, is sent from MME or SGSN to HSS or CSS.
	Message Format when used over the S6a/S6d application:

	< Reset-Answer> ::=	< Diameter Header: 322, PXY, 16777251 >
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				*[ Supported-Features ]
				 [ Result-Code ]
				 [ Experimental-Result ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				*[ AVP ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S6A, commandCode = CommandCodes.RESET, request = false, proxyable = true, name="Reset-Answer")
public interface ResetAnswer extends S6aAnswer
{	
}