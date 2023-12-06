package com.mobius.software.telco.protocols.diameter.commands.s7a;
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
 * 	7.2.12	Delete-Subscriber-Data-Answer (DSA) Command
	The Delete-Subscriber Data-Answer (DSA) command, indicated by the Command-Code field set to 320 and the 'R' bit cleared in the Command Flags field, is sent from MME or SGSN to HSS or CSS.
	Message Format when used over the S7a /S7d application:

	< Delete-Subscriber-Data-Answer> ::= < Diameter Header: 320, PXY, 16777308>
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
@DiameterCommandDefinition(applicationId = 16777308, commandCode = 320, request = false, proxyable = true, name="Delete-Subscriber-Data-Answer")
public interface DeleteSubscriberDataAnswer extends S7aAnswer
{
}