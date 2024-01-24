package com.mobius.software.telco.protocols.diameter.primitives.sta;
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
	5.2.3.27	Connectivity-Flags
	The Connectivity-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 5.2.3.26/1:
	Table 5.2.3.26/1: Connectivity-Flags

	Bit Name
	Description

	0 Initial-Attach-Indicator
	This bit may be set by the 3GPP AAA Server.
	This bit, when set, indicates that a UE performs the Initial Attach procedure from non-3GPP access network. When not set, it indicates that a UE performs the Handover procedure.

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.
 */
@DiameterAvpDefinition(code = 1529L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Connectivity-Flags")
public interface ConnectivityFlags extends DiameterBitmask32
{
	public static final int INITIAL_ATTACH_INDICATOR_BIT = 0;	
	
	public void setInitialAttachIndicatorBit(boolean isOn);
	
	public boolean isInitialAttachIndicatorBitSet();
}