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
 * 	9.13.  SIP-User-Data-Already-Available AVP

   	The SIP-User-Data-Already-Available AVP (AVP Code 392) is of type
   	Enumerated and gives an indication to the Diameter server about
   	whether the Diameter client (SIP server) already received the portion
   	of the user profile needed in order to serve the user.  The following
   	values are defined:

   	o  	USER_DATA_NOT_AVAILABLE (0)
      	The Diameter client (SIP server) does not have the data that it
      	needs to serve the user.

   	o  	USER_DATA_ALREADY_AVAILABLE (1)
      	The Diameter client (SIP server) already has received the data
      	that it needs to serve the user.
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_USER_DATA_ALREADY_AVAILABLE, vendorId = -1, name = "SIP-User-Data-Already-Available")
public interface SIPUserDataAlreadyAvailable extends DiameterEnumerated<SIPUserDataAlreadyAvailableEnum>
{
}