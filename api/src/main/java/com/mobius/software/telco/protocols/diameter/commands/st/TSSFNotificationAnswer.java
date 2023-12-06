package com.mobius.software.telco.protocols.diameter.commands.st;
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
 *  5c.6.7	TSSF-Notification-Answer (TNA) Command
	The TNA command, indicated by the Command-Code field set to 8388731 and the 'R' bit cleared in the Command Flags field, is sent by the PCRF to the TSSF in response to the TNR command.
	Message Format:

	<TN-Answer> ::=  < Diameter Header: 8388731, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Vendor-Specific-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Result-Code ]
				 [ Experimental-Result ]
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				 [ Origin-State-Id ]
				 [ Error-Message ]
				 [ Error-Reporting-Host ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777349, commandCode = 8388731, request = false, proxyable = true, name="TSSF-Notification-Answer")
public interface TSSFNotificationAnswer extends StAnswer
{				
}