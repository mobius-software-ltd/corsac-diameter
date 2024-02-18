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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
	9.12.1.  SIP-User-Data-Type AVP

   	The SIP-User-Data AVP (AVP Code 390) is of type UTF8String and
   	contains a string that identifies the type of user data included in
   	the SIP-User-Data AVP (Section 9.12).

   	This document does not specify a convention to characterize the type
   	of user data contained in the SIP-User-Data AVP (Section 9.12).  It
   	is believed that in most cases this feature will be used in
   	environments controlled by a network administrator who can configure
   	both the client and server to assign the same value type at the
   	client and server.  It is also RECOMMENDED that organizations
   	developing their own profile of SIP-User-Data AVP (Section 9.12)
   	allocate a type based on their canonical DNS name.  For instance,
   	organization "example.com" can define several types of SIP-User-Data
   	and allocate the types "type1.dsa.example.com",
   	"type2.dsa.example.com", and so on.  This convention will avoid a
   	clash in the allocation of types of SIP-User-Data AVP (Section 9.12).
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_USER_DATA_TYPE, vendorId = -1, name = "SIP-User-Data-Type")
public interface SIPUserDataType extends DiameterUTF8String
{
}