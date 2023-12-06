package com.mobius.software.telco.protocols.diameter.commands.s13;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.19	ME-Identity-Check-Request (ECR) Command
	The ME-Identity-Check-Request (ECR) command, indicated by the Command-Code field set to 324 and the 'R' bit set in the Command Flags field, is sent from MME or SGSN to EIR.
	Message Format

	< ME-Identity-Check-Request > ::=	< Diameter Header: 324, REQ, PXY, 16777252 >
			 < Session-Id >
			 [ DRMP ]
			 [ Vendor-Specific-Application-Id ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 [ Destination-Host ]
			 { Destination-Realm }
			 { Terminal-Information }
			 [ User-Name ]
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777252, commandCode = 324, request = true, proxyable = true, name="ME-Identity-Check-Request")
public interface MEIdentityCheckRequest extends S13Request
{
	TerminalInformation getTerminalInformation();
	
	void setTerminalInformation(TerminalInformation value);	
}