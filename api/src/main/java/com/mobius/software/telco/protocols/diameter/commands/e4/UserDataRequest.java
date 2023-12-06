package com.mobius.software.telco.protocols.diameter.commands.e4;
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
import com.mobius.software.telco.protocols.diameter.primitives.e4.GloballyUniqueAddress;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.1.1 User-Data-Request command
	The User-Data-Request (UDR) command, indicated by the Command-Code field set to 306 and the "R" bit set in the
	Command Flags field, is sent by a Diameter client to a Diameter server in order to request user data. This command is
	defined in TS 129 329 [4] and used with additional AVPs defined in the present document.

	NOTE:
	In the context of the present document the user whose data are requested using the UDR command is the NASS user.
	Message Format:

	< User-Data -Request > ::= < Diameter Header: 306, REQ, PXY, 16777231 >
				 < Session-Id >
				 { Vendor-Specific-Application-Id }
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				 [ Globally-Unique-Address ]
				 [ AF-Application-Identifier ]
				 [ User-Name]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777231, commandCode = 306, request = true, proxyable = true, name="User-Data-Request")
public interface UserDataRequest extends E4Request
{
	GloballyUniqueAddress getGloballyUniqueAddress();
	
	void setGloballyUniqueAddress(GloballyUniqueAddress value);
	
	public ByteBuf getAFApplicationIdentifier();
	 
	void setAFApplicationIdentifier(ByteBuf value);
}