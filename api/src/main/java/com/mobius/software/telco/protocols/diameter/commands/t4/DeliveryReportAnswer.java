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

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.6	Delivery-Report-Answer (DRA) Command
	The Delivery-Report-Answer (DRA) command, indicated by the Command-Code field set to 8388644 and the "R" bit cleared in the Command Flags field, is sent from the MTC-IWF to the SMS-SC.
	Message Format

	< Delivery-Report-Answer > ::=	< Diameter Header: 8388644, PXY, 16777311 >
					< Session-Id >
					 [ DRMP ]
					 [ Vendor-Specific-Application-Id ]
					 [ Result-Code ]
					 [ Experimental-Result ]
					 { Auth-Session-State }
					 { Origin-Host }
					 { Origin-Realm }
					*[ Supported-Features ]
					*[ AVP ]
					 [ Failed-AVP ]
					*[ Proxy-Info ]
					*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777311, commandCode = 8388644, request = false, proxyable = true, name="Delivery-Report-Answer")
public interface DeliveryReportAnswer extends T4Answer
{
}