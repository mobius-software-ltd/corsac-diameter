package com.mobius.software.telco.protocols.diameter.primitives.swm;
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
	7.2.3.4	Emergency-Services
	The Emergency-Services AVP is of type Unsigned32 and it shall contain a bitmask. The meaning of the bits is defined in table 7.2.3.4/1:
	Table 7.2.3.4/1: Emergency-Services

	Bit Name
	Description

	0 Emergency-Indication
	This bit, when set, indicates a request to establish a PDN connection for emergency services.

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver.
 */
@DiameterAvpDefinition(code = 1538L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Emergency-Services")
public interface EmergencyServices extends DiameterBitmask32
{
	public static final int ESTABLISH_PDN_CONNECTION_BIT = 0;
	
	public void setEstablishPDNConnectionBit(boolean isOn);
	
	public boolean isEstablishPDNConnectionBitSet();
}