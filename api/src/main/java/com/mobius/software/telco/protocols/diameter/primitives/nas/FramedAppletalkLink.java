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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.4.10.7.1.  Framed-Appletalk-Link AVP

   The Framed-Appletalk-Link AVP (AVP Code 37) is of type Unsigned32 and
   contains the AppleTalk network number that should be used for the
   serial link to the user, which is another AppleTalk router.  This AVP
   MUST only be present in an authorization response and is never used
   when the user is not another router.

   Despite the size of the field, values range from 0 to 65,535.  The
   special value of 0 indicates an unnumbered serial link.  A value of 1
   to 65,535 means that the serial line between the NAS and the user
   should be assigned that value as an AppleTalk network number.
 */
@DiameterAvpDefinition(code = AvpCodes.FRAMED_APPLETALK_LINK, vendorId = -1L, name = "Framed-Appletalk-Link")
public interface FramedAppletalkLink extends DiameterUnsigned32
{
}