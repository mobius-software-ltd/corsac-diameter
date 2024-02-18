package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpFilterRule;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.8	Flow-Description AVP
	The Flow-Description AVP (AVP code 507) is of type IPFilterRule, and defines a packet filter for an IP flow with the following information:

	-	Direction (in or out). The direction "in" refers to uplink IP flows, and the direction "out" refers to downlink IP flows.
	-	Source and destination IP address (possibly masked).
	-	Protocol.
	-	Source and destination port.

	NOTE 1:	When "ip" as key word is used in the protocol, the port(s) are used to describe the port(s) of any protocol if available.
	
	The IPFilterRule type shall be used over Rx interface with the following restrictions:
	-	The Source Port may be omitted to indicate that any source port is allowed. Lists or ranges shall not be used.
	-	Only the Action "permit" shall be used.
	-	No "options" shall be used.
	-	The invert modifier "!" for addresses shall not be used.
	-	The keyword "assigned" shall not be used.

	NOTE 2:	For TCP protocol, destination port can also be omitted.

	If any of these restrictions is not observed by the AF, the server shall send an error response to the AF containing the Experimental-Result-Code AVP with value FILTER_RESTRICTIONS.
	For the Rx interface, the Flow description AVP shall be used to describe a single IP flow.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.FLOW_DESCRIPTION, vendorId = VendorIDs.TGPP_ID, name = "Flow-Description")
public interface FlowDescription extends DiameterIpFilterRule
{
}