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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CancellationTypeEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	Cancel-Location-Request (CLR) Command
	The Cancel-Location-Request (CLR) command, indicated by the Command-Code field set to 317 and the 'R' bit set in the Command Flags field, is sent from HSS to MME or SGSN.
	Message Format

	<Cancel-Location-Request> ::=	< Diameter Header: 317, REQ, PXY, 16777251 >
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
				 [ CLR-Flags ]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777251, commandCode = 317, request = true, proxyable = true, name="Cancel-Location-Request")
public interface CancelLocationRequest extends S6aRequest
{
	CancellationTypeEnum getCancellationType();
	
	void setCancellationType(CancellationTypeEnum value);
	
	Long getCLRFlags();
	
	void setCLRFlags(Long value);		
}