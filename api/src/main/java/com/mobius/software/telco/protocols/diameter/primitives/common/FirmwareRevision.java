package com.mobius.software.telco.protocols.diameter.primitives.common;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 5.3.4.  Firmware-Revision AVP

   The Firmware-Revision AVP (AVP Code 267) is of type Unsigned32 and is
   used to inform a Diameter peer of the firmware revision of the
   issuing device.

   For devices that do not have a firmware revision (general-purpose
   computers running Diameter software modules, for instance), the
   revision of the Diameter software module may be reported instead.
 */
@DiameterAvpDefinition(code = 267L, vendorId = -1L, must = false, name = "Firmware-Revision")
public interface FirmwareRevision extends DiameterUnsigned32
{
		
}