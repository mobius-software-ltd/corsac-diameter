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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	9.12.2.  SIP-User-Data-Contents AVP

   	The SIP-User-Data-Contents AVP (AVP Code 391) is of type OctetString.
   	The Diameter peers do not need to understand the value of this AVP.

   	The AVP contains the user profile data required for a SIP server to
   	give service to the user.
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_USER_DATA_CONTENTS, vendorId = -1, name = "SIP-User-Data-Contents")
public interface SIPUserDataContents extends DiameterOctetString
{
}