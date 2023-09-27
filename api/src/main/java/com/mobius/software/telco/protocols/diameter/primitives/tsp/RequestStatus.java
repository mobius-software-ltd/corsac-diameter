package com.mobius.software.telco.protocols.diameter.primitives.tsp;
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
 *	6.4.9	Request-Status AVP
	The Request-Status AVP (AVP code 3008) is of type Enumerated, and informs the SCS of the status of a device action request. It can include the result of MTC-IWF checks, the HSS/HLR interrogation and the SMS-SC submission trigger. The Request-Status AVP can be included in the Device-Action-Answer command.
	The following values are defined:

	SUCCESS (0)
	This value indicates that device action requested is confirmed.

	TEMPORARYERROR (201)
	This value indicates any unspecified temporary errors.

	INVPAYLOAD (101)
	This value indicates an error with the payload, where the payload is valid according to Diameter AVP definition but an implementation limit such as maximum accepted length is exceeded.

	INVEXTID (102)
	This value indicates an error with the External Identifier, where the identifier is valid according to Diameter AVP definition but the value is rejected by the 3GPP network for example because it is an unknown subscription. The result code specified in TS 29.336 [12], clause 6.3.3.1 shall be mapped to this value.

	INVSCSID (103)
	This value indicates an error with the SCS identity, where the identity is valid according to Diameter AVP definition but the value is rejected by the 3GPP network for example because it is an unexpected value for this SCS.

	INVPERIOD (104)
	This value indicates an error with the validity period, where the validity period is valid according to Diameter AVP definition but the value is rejected by the 3GPP network for example because a maximum allowed validity period is exceeded.

	NOTAUTHORIZED (105)
	This value indicates that the SCS is not authorized to perform the action requested for this UE. The result code specified in TS 29.336 [12], clause 6.3.3.2 shall be mapped to this value.

	SERVICEUNAVAILABLE (106)
	This value indicates that the trigger service is not available for this UE. The result code specified in TS 29.336 [12], clause 6.3.3.3 shall be mapped to this value.

	PERMANENTERROR (107)
	This value indicates a permanent error. Any result code specified in TS 29.337 [17], clause 7.3 shall be mapped to this value unless otherwise specified in this specification.
	
	QUOTAEXCEEDED (108)
	This value indicates that the SCS has exceeded allocated quota.

	RATEEXCEEDED (109)
	This value indicates that the rate at which the SCS is initiating Tsp requests has been exceeded.

	REPLACEFAIL (110)
	This value indicates that the device trigger replace request has failed to replace the device trigger indicated by the Old-Reference-Number in the SMS-SC for other reasons than ORIGINALMESSAGESENT i.e. message could not be replaced and new message could not be stored as a new message. The result code DIAMETER_ERROR_TRIGGER_REPLACE_FAILURE specified in TS 29.337 [17], clause 7.3.5 shall be mapped to this value.

	RECALLFAIL (111)
	This value indicates that the device trigger recall request has failed for other reasons than ORIGINALMESSAGESENT. The result code DIAMETER_TRIGGER_RECALL_FAILURE specified in TS 29.337 [17], clause 7.3.6 shall be mapped to this value.

	ORIGINALMESSAGESENT (112)
	This value indicates that the message which was intended to be recalled or replaced has already been sent. The result code DIAMETER_ERROR_ORIGINAL_MESSAGE_NOT_PENDING specified in TS 29.337 [17], clause 7.3.7 shall be mapped to this value.
 */
@DiameterAvpDefinition(code = 3008L, vendorId = KnownVendorIDs.TGPP_ID, name = "Request-Status")
public interface RequestStatus extends DiameterEnumerated<RequestStatusEnum>
{
}