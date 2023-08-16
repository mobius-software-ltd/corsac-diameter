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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.4.3.  Callback-Id AVP

   The Callback-Id AVP (AVP Code 20) is of type UTF8String and contains
   the name of a place to be called, to be interpreted by the NAS.  This
   AVP MAY be present in an authentication and/or authorization
   response.

   This AVP is not roaming-friendly as it assumes that the Callback-Id
   is configured on the NAS.  Using the Callback-Number AVP
   (Section 4.4.2) is therefore RECOMMENDED.
 */
@DiameterAvpDefinition(code = 20L, vendorId = -1L, name = "Callback-Id")
public interface CallbackId extends DiameterUTF8String
{
}