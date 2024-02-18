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
 * 4.4.10.7.2.  Framed-Appletalk-Network AVP

   The Framed-Appletalk-Network AVP (AVP Code 38) is of type Unsigned32
   and contains the AppleTalk network number that the NAS should probe
   to allocate an AppleTalk node for the user.  This AVP MUST only be
   present in an authorization response and is never used when the user
   is not another router.  Multiple instances of this AVP indicate that
   the NAS may probe, using any of the network numbers specified.

   Despite the size of the field, values range from 0 to 65,535.  The
   special value 0 indicates that the NAS should assign a network for
   the user, using its default cable range.  A value between 1 and
   65,535 (inclusive) indicates to the AppleTalk network that the NAS
   should probe to find an address for the user.
 */
@DiameterAvpDefinition(code = AvpCodes.FRAMED_APPLETALK_NETWORK, vendorId = -1L, name = "Framed-Appletalk-Network")
public interface FramedAppletalkNetwork extends DiameterUnsigned32
{
}