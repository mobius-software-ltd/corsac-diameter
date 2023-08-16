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
 * 5.3.3.  Vendor-Id AVP

   The Vendor-Id AVP (AVP Code 266) is of type Unsigned32 and contains
   the IANA "SMI Network Management Private Enterprise Codes"
   [ENTERPRISE] value assigned to the Diameter Software vendor.  It is
   envisioned that the combination of the Vendor-Id, Product-Name
   (Section 5.3.7), and Firmware-Revision (Section 5.3.4) AVPs may
   provide useful debugging information.

   A Vendor-Id value of zero in the CER or CEA message is reserved and
   indicates that this field is ignored.
 */
@DiameterAvpDefinition(code = 266L, vendorId = -1L, name = "Vendor-Id")
public interface VendorId extends DiameterUnsigned32
{
}