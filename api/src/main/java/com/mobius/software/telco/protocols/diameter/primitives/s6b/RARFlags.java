package com.mobius.software.telco.protocols.diameter.primitives.s6b;
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
	9.2.3.1.5	RAR-Flags
	The RAR-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 9.2.3.1.5/1:
	Table 9.2.3.1.5/1: RAR-Flags
	
	0 Trust-Relationship-Update-indication
	This bit, when set, indicates to the PDN GW that the 3GPP AAA server only initiates the re-authorization procedure send the trust relationship to the PDN GW, and the PDN GW shall not perform any authorization procedure towards the UE.

	1 P-CSCF Restoration Request
	This bit, when set, shall indicate to the PDN GW that the 3GPP AAA Server requests the execution of the HSS-based P-CSCF restoration procedures for WLAN, as described in 3GPP TS 23.380 [52] clause 5.6.
	
	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the recever of the command.
 */
@DiameterAvpDefinition(code = 1522L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "RAR-Flags")
public interface RARFlags extends DiameterBitmask32
{
	public static final int TRUST_RELATIONSHIP_UPDATE_INDICATION_BIT = 0;	
	public static final int PCSCF_RESTORATION_REQUEST_BIT = 1;	
	
	public void setTrustRelationshipUpdateIndicationBit(boolean isOn);
	
	public boolean isTrustRelationshipUpdateIndicationBitSet();
	
	public void setPCSCFRestorationRequestBit(boolean isOn);
	
	public boolean isPCSCFRestorationRequestBitSet();
}