package com.mobius.software.telco.protocols.diameter.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.44 Session-Release-Cause (All access types)
	Session-Release-Cause AVP (AVP code 1045) is of type Enumerated, and determines the cause of release the IP-CAN
	session by the PCRF. The following values are defined:
	
	UNSPECIFIED_REASON (0)
 		This value is used for unspecified reasons.
	UE_SUBSCRIPTION_REASON (1)
 		This value is used to indicate that the subscription of UE has changed (e.g. removed) and the session needs to be
		terminated.
	INSUFFICIENT_SERVER_RESOURCES (2)
 		This value is used to indicate that the server is overloaded and needs to abort the session.
	IP_CAN_SESSION_TERMINATION (3)
 		This value is used to indicate that the corresponding IP-CAN session is terminated. The
		IP_CAN_SESSION_TERMINATION value is introduced in order to be used by Sd only, when PCRF initiates
		the TDF session termination within IP-CAN session termination.
	UE_IP_ADDRESS_RELEASE (4)
 		This value is used to indicate that the Ipv4 address of a dual stack IP-CAN session is released. The
		UE_IP_ADDRESS_RELEASE value is introduced in order to be used by Sd only, when PCRF initiates the TDF
		session termination if the Ipv4 address of a dual stack IP-CAN session is released and if there is an active Ipv4
		address related TDF session for that IP-CAN session. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SESSION_RELEASE_CAUSE, vendorId = VendorIDs.TGPP_ID, name = "Session-Release-Cause")
public interface SessionReleaseCause extends DiameterEnumerated<SessionReleaseCauseEnum>
{
}