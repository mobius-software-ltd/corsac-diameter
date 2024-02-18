package com.mobius.software.telco.protocols.diameter.commands.pc2;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.6.5	ProXimity-Application-Answer (XAA) command
	The XAA command, indicated by the Command-Code field set to 8388727 and the 'R' bit cleared in the Command Flags field, is sent by the ProSe Function to the ProSe Application Server in response to the XAR command as part of the discovery authorization update procedure.
	Message Format:

	<XA-Answer> ::=  < Diameter Header: 8388727, PXY >
				< Session-Id >
				{ Auth-Application-Id }
				{ Auth-Session-State }
				{ Origin-Host }
				{ Origin-Realm }
				[ Result-Code ]
				[ Experimental-Result ]
				[ Error-Message ]
				[ Error-Reporting-Host ]
				[ Failed-AVP ]
				[ Origin-State-Id ]
				*[ Redirect-Host ]
				[ Redirect-Host-Usage ]
				[ Redirect-Max-Cache-Time ]
				*[ Proxy-Info ]
				{ ProSe-Request-Type }
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.PC2, commandCode = CommandCodes.PROXIMITY_APPLICATION, request = false, proxyable = true, name="XA-Answer")
public interface ProXimityApplicationAnswer extends Pc2Answer
{
}