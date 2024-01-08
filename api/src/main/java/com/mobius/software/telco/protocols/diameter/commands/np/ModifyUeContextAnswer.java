package com.mobius.software.telco.protocols.diameter.commands.np;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.6	Modify-Uecontext-Answer (MUA) command
	The MUA command, indicated by the Command-Code field set to 8388722 and the 'R' bit set in the Command Flags field, is sent by the RCAF to the PCRF as a response to the request for congestion reporting restrictions to or remove the context a specific user id and PDN ID.
	Message Format:

	< Modify-Uecontext‑Answer > ::= < Diameter Header: 8388722, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Vendor-Specific-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 [ Result-Code ]
                 [ Experimental-Result ]
                 [ Failed-AVP ]
                 [ Origin-State-Id ]
                 [ OC-Supported-Features ]
                 [ OC-OLR ]
                *[ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
                *[ Proxy-Info ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777342, commandCode = 8388722, request = false, proxyable = true, name="Modify-Uecontext‑Answer")
public interface ModifyUeContextAnswer extends NpAnswer
{
	
}