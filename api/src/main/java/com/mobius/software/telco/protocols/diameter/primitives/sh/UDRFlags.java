package com.mobius.software.telco.protocols.diameter.primitives.sh;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.28 UDR-Flags
	The UDR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined
	in 3GPP TS 29.328 [1].

	Table 6.3.28/1: UDR-Flags
	Bit Name
	0 Location-Information-EPS-Supported
	1 RAT-Type-Requested

	NOTE: Bits not defined in this table shall be cleared by the sender of the request and discarded
	by the receiver of the request. 
 */
@DiameterAvpDefinition(code = 719L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "UDR-Flags")
public interface UDRFlags extends DiameterBitmask32
{
	public static final int LOCATION_INFORMATION_EPS_SUPPORTED_BIT = 0;	
	public static final int RAT_TYPE_REQUESTED_BIT = 1;	
	
	public void setLocationInformationEPSSupportedBit(boolean isOn);
	
	public boolean isLocationInformationEPSSupportedBitSet();
	
	public void setRATTypeRequestedBit(boolean isOn);
	
	public boolean isRATTypeRequestedBitSet();
}