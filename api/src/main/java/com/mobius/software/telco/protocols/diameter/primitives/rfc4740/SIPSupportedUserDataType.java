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
	9.11.  SIP-Supported-User-Data-Type AVP

   	The SIP-Supported-User-Data-Type AVP (AVP Code 388) is of type
   	UTF8String and contains a string that identifies the type of
   	supported user data (user profile, see SIP-User-Data AVP
   	(Section 9.12)) supported in the node.  The AVP can be repeated, if
   	the SIP server supports several user data types.  In case of
   	repetition, the Diameter client should order the different instances
   	of this AVP according to its preferences.

   	When the Diameter client inserts this AVP in a SAR message, it allows
   	the Diameter client to provide an indication to the Diameter server
   	of the types of user data supported by the SIP server.  The Diameter
   	server, upon inspection of these AVPs, will return a suitable
   	SIP-User-Data AVP (Section 9.12) of the type indicated in the
   	SIP-User-Data-Type AVP (Section 9.12.1).
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_SUPPORTED_USER_DATA_TYPE, vendorId = -1, name = "SIP-Supported-User-Data-Type")
public interface SIPSupportedUserDataType extends DiameterUTF8String
{
}