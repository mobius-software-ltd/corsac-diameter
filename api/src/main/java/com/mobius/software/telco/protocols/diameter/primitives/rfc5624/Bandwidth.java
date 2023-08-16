package com.mobius.software.telco.protocols.diameter.primitives.rfc5624;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterFloat32;

/**
*
* @author yulian oifa
*
*/

/*
	3.3.  Bandwidth AVP

    The Bandwidth AVP (AVP Code 502) is of type Float32 and is measured
    in octets of IP datagrams per second.  The Bandwidth AVP represents a
    simplified description of the following TMOD setting whereby the
    token rate (r) = peak traffic rate (p), the bucket depth (b) = large,
    and the minimum policed unit (m) = large when only bandwidth has to
    be expressed.
 */
@DiameterAvpDefinition(code = 502L, vendorId = -1L, name = "Bandwidth")
public interface Bandwidth extends DiameterFloat32
{
}