package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
 * 	6.3.15	Server-Assignment-Type AVP
	The Server-Assignment-Type AVP is of type Enumerated, and indicates the type of server update, request or notification being performed in a Server-Assignment-Request operation. The following values are defined:

	NO_ASSIGNMENT (0)
    	• 	This value is used to request from HSS the user profile assigned to one or more public identities and to retrieve the S-CSCF restoration information for a registered Public User Identity, without affecting the registration state of those identities.

	REGISTRATION (1)
    	• 	The request is generated as a consequence of a first registration of an identity.

	RE_REGISTRATION (2)
    	• 	The request corresponds to the re-registration of an identity or update of the S-CSCF Restoration Information.

	UNREGISTERED_USER (3)
    	• 	The request is generated in the following cases:
    	• -	The S-CSCF received a request for a Public Identity that is not registered, or
    	• -	An AS sent an originating request on behalf of a Public Identity that is not registered, or
    	• -	The S-CSCF identified a P-CSCF failure for a Public User Identity that is registered with only one Private User Identity and started the P-CSCF Restoration procedure including the P-CSCF Restoration Indication in the request to the HSS.

	TIMEOUT_DEREGISTRATION (4)
    	• 	The SIP registration timer of an identity has expired.

	USER_DEREGISTRATION (5)
    	• 	The S-CSCF has received a user initiated de-registration request.

	TIMEOUT_DEREGISTRATION_STORE_SERVER_NAME (6)
    	• 	The request is generated in the following cases:
    	• 	The SIP registration timer of an identity has expired. The S-CSCF keeps the user data stored in the S-CSCF and requests HSS to store the S-CSCF name.
    	• 	The S-CSCF identified a P-CSCF failure for a Public User Identity that is registered with only one Private User Identity and started the PCRF-based P-CSCF Restoration procedure.

	USER_DEREGISTRATION_STORE_SERVER_NAME (7)
    	• 	The S-CSCF has received a user initiated de-registration request. The S-CSCF keeps the user data stored in the S-CSCF and requests HSS to store the S-CSCF name.

	ADMINISTRATIVE_DEREGISTRATION (8)
    	• 	The request is generated in the following cases:
    	• -	The S-CSCF, due to administrative reasons or network issues, has performed the de-registration of an identity.
    	• -	The S-CSCF identified a P-CSCF failure for a Public User Identity that is registered with more than one Private User Identity and started the P-CSCF Restoration procedure including the P-CSCF Restoration Indication in the request to the HSS.
    	• 	The S-CSCF identified a P-CSCF failure for a Public User Identity that is registered with more than one Private User Identity and started the PCRF-based P-CSCF Restoration procedure.

	AUTHENTICATION_FAILURE (9)
    	• 	The authentication of a user has failed.

	AUTHENTICATION_TIMEOUT (10)
    	• 	The authentication timeout has occurred.

	DEREGISTRATION_TOO_MUCH_DATA (11)
    	• 	The S-CSCF has requested user profile information from the HSS and has received a volume of data higher than it can accept.

	AAA_USER_DATA_REQUEST (12)
    	• 	Used in the SWx protocol, defined in 3GPP TS 29.273 [18]. This value is not used in the Cx protocol.

	PGW_UPDATE (13)
    	• 	Used in the SWx protocol, defined in 3GPP TS 29.273 [18]. This value is not used in the Cx protocol.
	
	RESTORATION (14)
    	• 	Used in the SWx protocol, defined in 3GPP TS 29.273 [18]. This value is not used in the Cx protocol.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SERVER_ASSIGNMENT_TYPE, vendorId = VendorIDs.TGPP_ID, name = "Server-Assignment-Type")
public interface ServerAssignmentType extends DiameterEnumerated<ServerAssignmentTypeEnum>
{
}