package com.mobius.software.telco.protocols.diameter.commands.gq;
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
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.6	Session-Termination-Answer (STA) command
	The STA command, indicated by the Command-Code field set to 275 and the 'R' bit cleared in the Command Flags field, is sent by the PDF to the AF in response to the STR command.
	Message Format:
	
	<ST-Answer>  ::= < Diameter Header: 275, PXY >
				 < Session-Id >
				 { Origin-Host }
				 { Origin-Realm }
				 [ Result-Code ]
				 [ Experimental-Result ]
				 [ Error-Message ]
				 [ Error-Reporting-Host ]
				*[ Failed-AVP ]
				 [ Origin-State-Id ]
				*[ Redirect-Host ]
				 [ Redirect-Host-Usage ]
				 [ Redirect-Max-Cache-Time ]
				*[ Proxy-Info ]
				 [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.GQ, commandCode = CommandCodes.SESSION_TERMINATION, request = false, proxyable = true, name="Session-Termination-Answer")
public interface SessionTerminationAnswer extends AuthenticationAnswer
{
}