package com.mobius.software.telco.protocols.diameter.commands.cip;
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

/*
  	3.4 Re-Auth-Request
	The Re-Auth-Request (RAR) is indicated by the command code set to 258 and
	the ‘R’ bit is set in the command flag field. It is sent from SDP to the CIP/IP
	Client, that will translate and forward the request to an external client. It is
	used by applications supporting a server initiated re-authorization procedure
	for ongoing sessions.
	
	The Auth-Application-Id for CIP/IP applies (16777232). As this
	is a standard Diameter Base Protocol command there will be no
	Vendor-Specific-Application-Id added.
	
			<RAR> ::= < Diameter Header: 258, REQ, PXY>
					< Session-Id >
					{ Origin-Host }
					{ Origin-Realm }
					{ Destination-Realm }
					{ Destination-Host }
					{ Auth-Application-Id }
					{ Re-Auth-Request-Type }
				   *[ AVP ]

*/

@DiameterCommandDefinition(applicationId = ApplicationIDs.CIP, commandCode = CommandCodes.REAUTH, request = true, proxyable = true, name="Re-Auth-Request")
public interface ReAuthRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthRequest
{
	
}