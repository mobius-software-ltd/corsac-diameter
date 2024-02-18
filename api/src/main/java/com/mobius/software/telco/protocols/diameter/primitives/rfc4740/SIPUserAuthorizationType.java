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
 * 	9.10.  SIP-User-Authorization-Type AVP

   	The SIP-User-Authorization-Type AVP (AVP Code 387) is of type
   	Enumerated and indicates the type of user authorization being
   	performed in a User Authorization operation, i.e., the Diameter
   	User-Authorization-Request (UAR) command.  The following values are
   	defined:

   	o  	REGISTRATION (0)
      	This value is used for initial registration or re-registration.
      	This is the default value.

   	o  	DEREGISTRATION (1)
      	This value is used for deregistration.

   	o  	REGISTRATION_AND_CAPABILITIES (2)
      	This value is used for initial registration or re-registration
      	when the SIP server explicitly requests the Diameter server to get
      	capability information.  This capability information helps the SIP
      	server to allocate another SIP server to serve the user.
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_USER_AUTHORIZATION_TYPE, vendorId = -1, name = "SIP-User-Authorization-Type")
public interface SIPUserAuthorizationType extends DiameterEnumerated<SIPUserAuthorizationTypeEnum>
{
}