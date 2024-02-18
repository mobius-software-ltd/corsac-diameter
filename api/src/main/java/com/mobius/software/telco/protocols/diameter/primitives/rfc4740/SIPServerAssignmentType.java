package com.mobius.software.telco.protocols.diameter.primitives.rfc4740;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	9.4.  SIP-Server-Assignment-Type AVP

   	The SIP-Server-Assignment-Type AVP (AVP Code 375) is of type
   	Enumerated and indicates the type of server update being performed in
   	a Diameter Server-Assignment-Request (SAR) operation.  The following
   	values are defined:

   	o  	NO_ASSIGNMENT (0)
      	The Diameter client uses this value to request the user profile of
      	a SIP AOR, without affecting the registration state of that
      	identity.

   	o  	REGISTRATION (1)
      	First SIP registration of a SIP AOR.

   	o  	RE_REGISTRATION (2)
      	Subsequent SIP registration of a SIP AOR.

   	o  	UNREGISTERED_USER (3)
      	The SIP server has received a SIP request (e.g., SIP INVITE)
      	addressed for a SIP AOR that is not registered.

   	o  	TIMEOUT_DEREGISTRATION (4)
      	The SIP registration timer of an identity has expired.

   	o  	USER_DEREGISTRATION (5)
      	The SIP server has received a request to deregister a SIP AOR.

   	o  	TIMEOUT_DEREGISTRATION_STORE_SERVER_NAME (6)
      	The SIP registration timer of an identity has expired.  The SIP
      	server keeps the user data stored and requests the Diameter server
      	to store the SIP server address.

   	o  	USER_DEREGISTRATION_STORE_SERVER_NAME (7)
      	The SIP server has received a user-initiated deregistration
      	request.  The SIP server keeps the user data stored and requests
      	the Diameter server to store the SIP server address.

   	o  	ADMINISTRATIVE_DEREGISTRATION (8)
      	The SIP server, due to administrative reasons, has deregistered a
      	SIP AOR.

   	o  	AUTHENTICATION_FAILURE (9)
      	The authentication of a user has failed.

   	o  	AUTHENTICATION_TIMEOUT (10)
      	The authentication timer has expired.

   	o  	DEREGISTRATION_TOO_MUCH_DATA (11)
      	The SIP server has requested user profile information from the
      	Diameter server and has received a volume of data higher than it
      	can accept.
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_SERVER_ASSIGNMENT_TYPE, vendorId = -1, name = "SIP-Server-Assignment-Type")
public interface SIPServerAssignmentType extends DiameterEnumerated<SIPServerAssignmentTypeEnum>
{
}