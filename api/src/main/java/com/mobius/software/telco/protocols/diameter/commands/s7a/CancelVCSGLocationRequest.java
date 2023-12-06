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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CancellationTypeEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.23	Cancel-VCSG-Location-Request (CVR) Command
	The Cancel-VCSG-Location-Request (CVR) command, indicated by the Command-Code field set to 8388642 and the 'R' bit set in the Command Flags field, is sent from CSS to MME or SGSN.
	Message Format

	< Cancel-VCSG-Location-Request> ::=	< Diameter Header: 8388642, REQ, PXY,  >
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
				 { Cancellation-Type }
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777308, commandCode = 8388642, request = true, proxyable = true, name="Cancel-VCSG-Location-Request")
public interface CancelVCSGLocationRequest extends S7aRequest
{
	CancellationTypeEnum getCancellationType();
	
	void setCancellationType(CancellationTypeEnum value);		
}