package com.mobius.software.telco.protocols.diameter.commands.sy;
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
 *  5.6.5	Spending-Status-Notification-Answer (SNA) command
	The SNA command, indicated by the Command-Code field set to 8388636 and the 'R' bit cleared in the Command Flags field, is sent by the PCRF to the OCS as part of the Spending Limit Report procedure.
	Message Format:

	<SN-Answer> ::=  < Diameter Header: 8388636, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Origin-Host }
                 { Origin-Realm }
                 [ Result-Code ]
                 [ Experimental-Result ]
                 [ Origin-State-Id ]
                 [ OC-Supported-Features ]
                 [ OC-OLR ]
                 [ Error-Message ]
                 [ Error-Reporting-Host ]
                *[ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
                 [ Failed-AVP ]
                *[ Proxy-Info ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777302, commandCode = 8388636, request = false, proxyable = true, name="SN-Answer")
public interface SpendingStatusNotificationAnswer extends SyAnswer
{	
}