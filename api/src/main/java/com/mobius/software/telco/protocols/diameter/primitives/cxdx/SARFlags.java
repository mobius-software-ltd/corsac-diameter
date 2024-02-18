package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.63	SAR-Flags
	The SAR-Flags AVP is of type Unsigned32 and it contains a bit mask. The meaning of the bits is defined in the following table:
	Table 6.3.63.1: SAR-Flags
	Bit Name
	Description

	0 P-CSCF Restoration Indication
	This bit, when set, indicates that the P-CSCF-Restoration-mechanism feature shall be executed, as described in 3GPP TS 23.380 [24], clause 5.4.
	
	This AVP is optionally present only when Server-Assignment-Type takes the value ADMINISTRATIVE_DEREGISTRATION or UNREGISTERED_USER.

	Note:	Bits not defined in this table shall be cleared by the sending S-CSCF and discarded by the receiving HSS.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SAR_FLAGS, vendorId = VendorIDs.TGPP_ID, must = false, name = "SAR-Flags")
public interface SARFlags extends DiameterBitmask32
{
	public static final int PCSCF_RESTORATION_INDICATION_BIT = 0;	
	
	public void setPCSCFRestorationIndicationBit(boolean isOn);
	
	public boolean isPCSCFRestorationIndicationBitSet();	
}