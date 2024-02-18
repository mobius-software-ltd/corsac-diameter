package com.mobius.software.telco.protocols.diameter.primitives.nas;
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
 * 4.4.8.  Configuration-Token AVP

   The Configuration-Token AVP (AVP Code 78) is of type OctetString and
   is sent by a Diameter server to a Diameter Proxy Agent in an AA-
   Answer command to indicate a type of user profile to be used.  It
   should not be sent to a Diameter client (NAS).

   The format of the Data field of this AVP is site specific.
 */
@DiameterAvpDefinition(code = AvpCodes.CONFIGURATION_TOKEN, vendorId = -1L, name = "Configuration-Token")
public interface ConfigurationToken extends DiameterOctetString
{
}