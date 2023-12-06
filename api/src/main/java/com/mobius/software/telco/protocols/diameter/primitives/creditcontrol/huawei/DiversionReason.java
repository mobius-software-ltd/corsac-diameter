package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.267  Diversion-Reason AVP

	AVP Name
	Diversion-Reason

	AVP Code
	20821

	AVP Data Type
	Enumerated

	Vendor ID
	2011

	Description
	Indicates a call forwarding reason.
	This AVP is valid for the call forwarding service.

	The Diversion-Reason AVP contains the following values:
	    - 0: UNKNOWN
	    - 1: Call Forwarding Unconditional (CFU)
	    - 2: Call Forwarding Busy (CFB)
	    - 3: Call Forwarding No Reply (CFNR)
	    - 4: Call Forwarding Offline (CFNL)
	    - 5: Call Forwarding deflection alerting response
	    - 6: Call Forwarding deflection immediate response
	    - 7: Call Forwarding on User Not Reachable (CFNRC)
	    - 8: Call Forwarding Unconditional To Mailbox
	    - 9: Call Forwarding Busy To Mailbox
	    - 10: Call Forwarding No Reply To Mailbox
	    - 11: Call Forwarding Offline To mailbox
	    - 12: Call Forwarding deflection immediate response to mailbox
	    - 13: Call Forwarding deflection alerting response to mailbox
	    - 14: Call Forwarding on User Not Reachable (CFNR) to mailbox
	    - 15: Call Forwarding by time (CFTB)
	    - 16: Call Forwarding by subscriber (CFSB)
	    - 17: Call Forwarding Do Not Disturb (DND) to mailbox
	    - 18: Call Forwarding No Reply in call wait (CW)
	    - 19: Call Forwarding Selective (CFS)
	    - 20: Anonymous Call Rejection (ACR) to mailbox
	    - 100: Caller Call Transfer (CT)
	    - 101: Called Call Transfer (CT)
	    - 102: Caller Call Transfer (CT) in Call Wait (CW)
	    - 103: Called Call Transfer (CT) in Call Wait (CW)
	    - 104: Call Forwarding Private Branch Exchange queued
	    - 105: Call Forwarding Synchronous Ring
	    - 255: Call Forwarding Butt call
	    - Others: Reserved
 */
@DiameterAvpDefinition(code = 20821L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Diversion-Reason")
public interface DiversionReason extends DiameterEnumerated<DiversionReasonEnum>
{
}