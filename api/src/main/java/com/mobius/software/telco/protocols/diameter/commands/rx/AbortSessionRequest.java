package com.mobius.software.telco.protocols.diameter.commands.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.rx.AbortCauseEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.7	Abort-Session-Request (ASR) command
	The ASR command, indicated by the Command-Code field set to 274 and the ‘R’ bit set in the Command Flags field, is sent by the PCRF to inform the AF that bearer for the established session is no longer available.
	Message Format:
	
	<AS-Request>  ::= < Diameter Header: 274, REQ, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 { Destination-Host }
				 { Auth-Application-Id }
				 [ OC-Supported-Features ]
				 { Abort-Cause }
				 [ Origin-State-Id ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.RX, commandCode = CommandCodes.ABORT_SESSION, request = true, proxyable = true, name="Abort-Session-Request")
public interface AbortSessionRequest extends RxRequest
{
	AbortCauseEnum getAbortCause();
	
	void setAbortCause(AbortCauseEnum value) throws MissingAvpException;	
}