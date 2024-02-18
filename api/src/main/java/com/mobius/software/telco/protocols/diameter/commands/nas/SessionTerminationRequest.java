package com.mobius.software.telco.protocols.diameter.commands.nas;
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
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginAAAProtocolEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * <ST-Request> ::= < Diameter Header: 275, REQ, PXY >
                         < Session-Id >
                         { Origin-Host }
                         { Origin-Realm }
                         { Destination-Realm }
                         { Auth-Application-Id }
                         { Termination-Cause }
                         [ User-Name ]
                         [ Destination-Host ]
                       * [ Class ]
                         [ Origin-AAA-Protocol ]
                         [ Origin-State-Id ]
                       * [ Proxy-Info ]
                       * [ Route-Record ]
                       * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.NASREQ, commandCode = CommandCodes.SESSION_TERMINATION, request = true, proxyable = true, name="Session-Termination-Request")
public interface SessionTerminationRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationRequest
{
	OriginAAAProtocolEnum getOriginAAAProtocol();
	
	void setOriginAAAProtocol(OriginAAAProtocolEnum value);
}