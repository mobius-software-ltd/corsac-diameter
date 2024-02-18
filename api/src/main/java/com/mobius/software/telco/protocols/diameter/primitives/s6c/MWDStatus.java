package com.mobius.software.telco.protocols.diameter.primitives.s6c;
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
	5.3.3.8	MWD-Status
	The MWD-Status AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 5.3.3.8/1:

	Table 5.3.3.8/1: MWD Status
	bit name
	Description

	0 SC-Address Not included
	This bit when set shall indicate that the SC Address has not been added to the Message Waiting Data in the HSS.

	1 MNRF-Set
	This bit, when set, shall indicate that the MNRF flag is set in the HSS
	
	2 MCEF-Set
	This bit, when set, shall indicate that the MCEF flag is set in the HSS.

	3 MNRG-Set
	This bit, when set, shall indicate that the MNRG flag is set in the HSS

	4 MNR5G-Set
	This bit, when set, shall indicate that the HSS/UDM is waiting for a reachability notification / registration from 5G serving nodes.

	NOTE:	Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving MME.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MWD_STATUS, vendorId = VendorIDs.TGPP_ID, name = "MWD-Status")
public interface MWDStatus extends DiameterBitmask32
{
	public static final int MNRF_BIT = 0;	
	public static final int MCEF_BIT = 1;	
	public static final int MNRG_BIT = 2;	
	public static final int MNRG5G_BIT = 3;	
	
	public void setMNRFBit(boolean isOn);
	
	public boolean isMNRFBitSet();
	
	public void setMCEFFlowBit(boolean isOn);
	
	public boolean isMCEFBitSet();
	
	public void setMNRGBit(boolean isOn);
	
	public boolean isMNRGBitSet();
	
	public void setMNRG5GBit(boolean isOn);
	
	public boolean isMNRG5GBitSet();
}