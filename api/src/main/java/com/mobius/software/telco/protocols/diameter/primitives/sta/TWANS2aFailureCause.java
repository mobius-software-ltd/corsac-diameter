package com.mobius.software.telco.protocols.diameter.primitives.sta;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	5.2.3.31	TWAN-S2a-Failure-Cause
	The TWAN-S2a-Failure-Cause AVP (AVP Code 1533) is of type Unsigned32 and it shall contain a 32 bit cause value field which is used to indicate the cause of S2a connectivity establishment failure to the 3GPP AAA Server by the TWAN. The description of the TWAN-S2a-Failure-Cause value is specified as in Table 5.2.3.30/1:
	
	Table 5.2.3.30/1: TWAN-S2a-Failure-Cause value description
	Cause value(decimal)
	Cause Value	
	Meaning

	26 Insufficient resources
	This cause is used to indicate that the requested service cannot be provided due to insufficient resources.

	27 Unknown APN
	This cause is used to indicate that the requested service was rejected because the access point name could not be resolved.

	29 User authentication failed
	This cause is used to indicate that the requested service was rejected by the external packet data network due to a failed user authentication

	30 Request rejected by TWAN or PDN GW
	This cause is used to indicate that the requested service or operation was rejected by the TWAN or PDN GW.

	31 Request rejected, unspecified
	This cause is used to indicate that the requested service or operation was rejected due to unspecified reasons.

	32 Service option not supported
	This cause is used to indicate that the UE requests a service which is not supported by the PLMN.

	33 Requested service option not subscribed
	This cause is used to indicate that the UE requests a service option which it has no subscription.

	34	Service option temporarily out of order
	This cause is used to indicate that the network cannot serve the request because of temporary outage of one or more functions required for supporting the service.

	38 Network failure
	This cause is used to indicate that the requested service was rejected due to an error situation in the network.
	
	50 PDN type IPv4 only allowed
	This value is used to indicate that only PDN type IPv4 is allowed for the requested PDN connectivity.

	51 PDN type IPv6 only allowed
	This value is used to indicate that only PDN type IPv6 is allowed for the requested PDN connectivity.

	54 PDN connection does not exist
	This value is used at handover from a 3GPP access network to indicate that the network does not have any information about the requested PDN connection.

	113 Multiple accesses to a PDN connection not allowed
	This value is used to indicate that the request for the additional access to a PDN connection was rejected by the PDN GW.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TWAN_S2A_FAILURE_CAUSE, vendorId = VendorIDs.TGPP_ID, must = false, name = "TWAN-S2a-Failure-Cause")
public interface TWANS2aFailureCause extends DiameterUnsigned32
{
}