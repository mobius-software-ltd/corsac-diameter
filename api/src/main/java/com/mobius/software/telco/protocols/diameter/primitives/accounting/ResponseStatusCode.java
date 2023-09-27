package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
 	A.4.25. Response-Status-Code AVP
	The Response-Status-Code AVP (AVP Code 1020) is of type Enumerated and identifies the value of returned in the Response Status Code parameter of the Response. 
	The values are defined in clause 6.6.3.	
	
	6.6.3.2 	Informational response class
	Table 6.6.3.2-69 specifies the RSCs for acknowledgement responses for each release.

	Table 6.6.3.2‑69: Informational response class
	Numeric Code Description
	1000  ACCEPTED

	6.6.3.3 Successful response class
	Table 6.6.3.3-1 specifies the RSCs for successful responses.
	Table 6.6.3.3‑70: RSCs for successful response class
	Numeric Code Description
	2000 OK
	2001 CREATED
	2002 DELETED
	2004 UPDATED
                
	6.6.3.4 Redirection response class
	In this release, no values in this response class are defined.
	Table 6.6.3.4‑71: RSCs for redirection response class
	Numeric Code Description

	6.6.3.5 Originator error response class
	Table 6.6.3.5-1 specify the RSCs for Originator error responses.
	41xx codes are oneM2M specific.
	Table 6.6.3.5‑72: RSCs for Originator error response class
	Numeric Code Description
	4000 BAD_REQUEST
	4004 NOT_FOUND
	4005 OPERATION_NOT_ALLOWED
	4008 REQUEST_TIMEOUT
	4101 SUBSCRIPTION_CREATOR_HAS_NO_PRIVILEGE
	4102 CONTENTS_UNACCEPTABLE
	4103 ORIGINATOR_HAS_NO_PRIVILEGE
	4104 GROUP_REQUEST_IDENTIFIER_EXISTS
	4105 CONFLICT
	4106 ORIGINATOR_HAS_NOT_REGISTERED
	4107 SECURITY_ASSOCIATION_REQUIRED
	4108 INVALID_CHILD_RESOURCE_TYPE
	4109 NO_MEMBERS
	4110 GROUP_MEMBER_TYPE_INCONSISTENT
                
	6.6.3.6 Receiver error response class
	Table 6.6.3.6-1 specifies the RSCs for Receiver error responses.
	51xx codes are oneM2M specific, which are used in generic procedures.
	51xx codes are oneM2M specific, which are used in resource specific procedures.

	Table 6.6.3.6‑73: RSCs for Receiver error response class
	Numeric Code Description
	5000 INTERNAL_SERVER_ERROR
	5001 NOT_IMPLEMENTED
	5103 TARGET_NOT_REACHABLE
	5105 RECEIVER_HAS_NO_PRIVILEGE
	5106 ALREADY_EXISTS
	5203 TARGET_NOT_SUBSCRIBABLE
	5204 SUBSCRIPTION_VERIFICATION_INITIATION_FAILED
	5205 SUBSCRIPTION_HOST_HAS_NO_PRIVILEGE
	5206 NON_BLOCKING_REQUEST_NOT_SUPPORTED
	5207 NOT_ACCEPTABLE
	5209 GROUP_MEMBERS_NOT_RESPONDED

	6.6.3.7 Network system error response class
	Table 6.6.3.7-1 specifies the RSCs for when the external system reported errors over Mcn reference point.
	Table 6.6.3.7‑74: RSCs for network system error response class
	Numeric Code Description
	6003 EXTERNAL_OBJECT_NOT_REACHABLE
	6005 EXTERNAL_OBJECT_NOT_FOUND
	6010 MAX_NUMBER_OF_MEMBER_EXCEEDED
	6020 MGMT_SESSION_CANNOT_BE_ESTABLISHED
	6021 MGMT_SESSION_ESTABLISHMENT_TIMEOUT
	6022 INVALID_CMDTYPE
	6023 INVALID_ARGUMENTS
	6024 INSUFFICIENT_ARGUMENTS
	6025 MGMT_CONVERSION_ERROR
	6026 MGMT_CANCELLATION_FAILED
	6028 ALREADY_COMPLETE
	6029 MGMT_COMMAND_NOT_CANCELLABLE
*/
@DiameterAvpDefinition(code = 1020L, vendorId = KnownVendorIDs.ONEM2M_ID, name = "Response-Status-Code")
public interface ResponseStatusCode extends DiameterEnumerated<ResponseStatusCodeEnum>
{
}