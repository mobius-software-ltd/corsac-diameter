package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
	7.3.22	HPLMN-ODB
	The HPLMN-ODB AVP is of type Unsigned32 and it shall contain a bit mask indicating the HPLMN specific services of a subscriber that are barred by the operator. The meaning of the bits is HPLMN specific:

	Table 7.3.22/1: HPLMN-ODB
	Bit Description

	0 HPLMN specific barring type 1
	
	1 HPLMN specific barring type 2

	2 HPLMN specific barring type 3
	
	3 HPLMN specific barring type 4

	HPLMN-ODB may apply to mobile originated short messages; See 3GPP TS 23.015 [36].
 */
@DiameterAvpDefinition(code = 1418L, vendorId = KnownVendorIDs.TGPP_ID, name = "HPLMN-ODB")
public interface HPLMNODB extends DiameterBitmask32
{
	public static final int TYPE_1_BIT = 0;
	public static final int TYPE_2_BIT = 1;
	public static final int TYPE_3_BIT = 2;
	public static final int TYPE_4_BIT = 3;
	
	public void setType1Bit(boolean isOn);
	
	public boolean isType1BitSet();
	
	public void setType2Bit(boolean isOn);
	
	public boolean isType2BitSet();
	
	public void setType3Bit(boolean isOn);
	
	public boolean isType3BitSet();
	
	public void setType4Bit(boolean isOn);
	
	public boolean isType4BitSet();
}