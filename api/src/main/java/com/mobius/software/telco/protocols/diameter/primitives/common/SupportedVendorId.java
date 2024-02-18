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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*5.3.6.  Supported-Vendor-Id AVP

   The Supported-Vendor-Id AVP (AVP Code 265) is of type Unsigned32 and
   contains the IANA "SMI Network Management Private Enterprise Codes"
   [ENTERPRISE] value assigned to a vendor other than the device vendor
   but including the application vendor.  This is used in the CER and
   CEA messages in order to inform the peer that the sender supports (a
   subset of) the Vendor-Specific AVPs defined by the vendor identified
   in this AVP.  The value of this AVP MUST NOT be set to zero.
   Multiple instances of this AVP containing the same value SHOULD NOT
   be sent.
*/
@DiameterAvpDefinition(code = AvpCodes.SUPPORTED_VENDOR_ID, vendorId = -1L, name = "Supported-Vendor-Id")
public interface SupportedVendorId extends DiameterUnsigned32
{
}