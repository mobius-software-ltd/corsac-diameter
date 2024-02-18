package com.mobius.software.telco.protocols.diameter.commands.swx;
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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.2.4	Network Initiated De-Registration by HSS Procedure
	The Registration-Termination-Request (RTR) command, indicated by the Command-Code field set to 304 and the "R" bit set in the Command Flags field, is sent by a Diameter Multimedia server to a Diameter Multimedia client in order to request the de-registration of a user. This corresponds to clause 8.1.2.2.3.
	Message Format

	<Registration-Termination-Request> ::=	< Diameter Header: 304, REQ, PXY, 16777265 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Host }
			 { Destination-Realm }
			 { User-Name }
			 { Deregistration-Reason }
			*[ Supported-Features ]
			…
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SWX, commandCode = CommandCodes.REGISTRATION_TERMINATION, request = true, proxyable = true, name="Registration-Termination-Request")
public interface RegistrationTerminationRequest extends SwxRequest
{
	DeregistrationReason getDeregistrationReason();
	
	void setDeregistrationReason(DeregistrationReason value) throws MissingAvpException;
}