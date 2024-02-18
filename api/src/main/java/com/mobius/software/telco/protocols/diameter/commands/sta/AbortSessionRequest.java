package com.mobius.software.telco.protocols.diameter.commands.sta;
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
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.2.2.2.1	Abort-Session-Request (ASR) Command
	The Abort-Session-Request (ASR) command, indicated by the Command-Code field set to 274 and the "R" bit set in the Command Flags field, is sent from a 3GPP AAA Server/Proxy to a non-3GPP access network NAS. ABNF for the ASR commands is as follows:
	
	< Abort-Session-Request >  ::=	< Diameter Header: 274, REQ, PXY, 16777250 >
			 < Session-Id >
			 [ DRMP ]
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 { Destination-Host }
			 { Auth-Application-Id }
			 [ User-Name ]
			 [ Auth-Session-State ]
			…	
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.STA, commandCode = CommandCodes.ABORT_SESSION, request = true, proxyable = true, name="Abort-Session-Request")
public interface AbortSessionRequest extends StaRequest
{
	public AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);
}