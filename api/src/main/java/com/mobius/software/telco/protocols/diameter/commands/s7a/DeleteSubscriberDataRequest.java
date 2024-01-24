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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DSRFlags;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.11	Delete-Subscriber-Data-Request (DSR) Command
	The Delete-Subscriber Data-Request (DSR) command, indicated by the Command-Code field set to 320 and the 'R' bit set in the Command Flags field, is sent from HSS or CSS to MME or SGSN.
	Message Format when used over the S7a/S7d application:

	< Delete-Subscriber-Data-Request > ::=	< Diameter Header: 320, REQ, PXY, 16777308 >
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Host }
				 { Destination-Realm }
				 { User-Name }
				*[ Supported-Features ]
				 { DSR-Flags }
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777308, commandCode = 320, request = true, proxyable = true, name="Delete-Subscriber-Data-Request")
public interface DeleteSubscriberDataRequest extends S7aRequest
{
	DSRFlags getDSRFlags();
	
	void setDSRFlags(DSRFlags value);		
}