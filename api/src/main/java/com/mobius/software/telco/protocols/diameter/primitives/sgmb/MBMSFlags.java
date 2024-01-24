package com.mobius.software.telco.protocols.diameter.primitives.sgmb;
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
	20.5a.9	MBMS-Flags AVP
	The MBMS-Flags AVP (AVP coce 931) is of type Unsigned32. It provides control indications. 
	It shall contain a bit mask. The meaning of the bits shall be as defined in table 20.5a.9.1:
	Table 20.5a.9.1 : MBMS-Flags

	Bit Name
	Description

	0 MSRI
	MBMS Session Re-establishment Indication :
	This bit, when set, indicates that the MBMS Session Start Request message is used to re-establish an MBMS session (see 3GPP TS 23.007 [104]).

	1 LMBCRI
	Local MBMS Bearer Context Release Indication :
	This bit, when set, indicates that the MBMS Session Stop Request message is used to locally release the MBMS bearer context in the MBMS‑GW and in the associated MME/SGSNs (see3GPP TS 23.007 [104] 

	NOTE: 	Bits not defined in this table shall be cleared by the sending BM-SC and ignored by the receiving MBMS GW.
 */
@DiameterAvpDefinition(code = 931L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "MBMS-Flags")
public interface MBMSFlags extends DiameterBitmask32
{
	public static final int MSRI_BIT = 0;	
	public static final int LMBCRI_BIT = 1;	
	
	public void setMSRIBit(boolean isOn);
	
	public boolean isMSRIBitSet();
	
	public void setLMBCRIBit(boolean isOn);
	
	public boolean isLMBCRIBitSet();
}