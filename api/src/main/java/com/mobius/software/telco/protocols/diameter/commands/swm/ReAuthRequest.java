package com.mobius.software.telco.protocols.diameter.commands.swm;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 7.2.2.4.1	Re-Auth-Request (RAR) Command
	The Re-Auth-Request (RAR) command shall be indicated by the Command-Code field set to 258 and the "R" bit set in the Command Flags field, and shall be sent from a 3GPP AAA Server/Proxy to a ePDG. The ABNF is based on the one in IETF RFC 4005 [4] and is defined as follows.

	< Re-Auth-Request > ::=	< Diameter Header: 258, REQ, PXY, 16777264 >
			 < Session-Id >
			 [ DRMP ]
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 { Destination-Host }
			 { Auth-Application-Id }
			 { Re-Auth-Request-Type }
			 [ User-Name ]
			…
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SWM, commandCode = CommandCodes.REAUTH, request = true, proxyable = true, name="Re-Auth-Request")
public interface ReAuthRequest extends SwmRequest
{	
	public ReAuthRequestTypeEnum getReAuthRequestType();
	
	void setReAuthRequestType(ReAuthRequestTypeEnum value) throws MissingAvpException;
}