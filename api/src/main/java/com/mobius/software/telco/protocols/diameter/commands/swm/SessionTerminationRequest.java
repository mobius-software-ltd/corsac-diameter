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
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.2.2.1	Session-Termination-Request (STR) Command
	The Session-Termination-Request (STR) command, indicated by the Command-Code field set to 275 and the "R" bit set in the Command Flags field, is sent from a ePDG to a 3GPP AAA Server/Proxy. The ABNF is based on the one in IETF RFC 6733 [58], and is defined as follows:

	< Session-Termination-Request > ::=	< Diameter Header: 275, REQ, PXY, 16777264 >
			 < Session-Id >
			 [ DRMP ]
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 [ Destination-Host ]
			 { Auth-Application-Id }
			 { Termination-Cause }
			 [ User-Name ]
			 [ OC-Supported-Features ]
			…
			*[ AVP ]	
			
	7.2.2.3.3	Session-Termination-Request (STR) Command
	The Session-Termination-Request (STR) command, indicated by the Command-Code field set to 275 and the "R" bit set in the Command Flags field, is sent from an ePDG to a 3GPP AAA Server/Proxy. The Command Code value and ABNF are re-used from the IETF RFC 6733 [58] Session-Termination-Request command.
	<Session-Termination-Request> ::=	< Diameter Header: 275, REQ, PXY, 16777264 >
			 < Session-Id >
			 [ DRMP ]
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 [ Destination-Host ]
			 { Auth-Application-Id }
			 { Termination-Cause }
			 [ User-Name ]
			 [ OC-Supported-Features ]
			…
			*[ AVP ]			
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SWM, commandCode = CommandCodes.SESSION_TERMINATION, request = true, proxyable = true, name="Session-Termination-Request")
public interface SessionTerminationRequest extends SwmRequest
{
	TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum value) throws MissingAvpException;
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
}