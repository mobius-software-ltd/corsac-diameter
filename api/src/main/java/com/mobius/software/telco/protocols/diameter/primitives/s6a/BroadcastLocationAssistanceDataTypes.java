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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask64;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.225	Broadcast-Location-Assistance-Data-Types
	The Broadcast-Location-Assistance-Data-Types AVP is of type Unsigned64. The content of this AVP is a bit mask which indicates the broadcast location assistance data types for which the UE is subscribed to receive ciphering keys used to decipher broadcast assistance data.
	The meaning of the bits is defined in table 7.3.225-1:
	
	bit name
	Description

	0 Positioning SIB Type 1-1
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 1-1.

	1 Positioning SIB Type 1-2
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 1-2.

	2 Positioning SIB Type 1-3
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 1-3.

	3 Positioning SIB Type 1-4
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 1-4.

	4 Positioning SIB Type 1-5
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 1-5.

	5 Positioning SIB Type 1-6
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 1-6.

	6 Positioning SIB Type 1-7
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 1-7.

	7 Positioning SIB Type 2-1
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-1.

	8 Positioning SIB Type 2-2
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-2.

	9 Positioning SIB Type 2-3
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-3.

	10 Positioning SIB Type 2-4
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-4.

	11 Positioning SIB Type 2-5
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-5.

	12 Positioning SIB Type 2-6
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-6.

	13 Positioning SIB Type 2-7
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-7.

	14 Positioning SIB Type 2-8
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-8.

 	15 Positioning SIB Type 2-9
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-9.

	16 Positioning SIB Type 2-10
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-10.

	17 Positioning SIB Type 2-11
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-11.
	
	18 Positioning SIB Type 2-12
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-12.

	19 Positioning SIB Type 2-13
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-13.

	20 Positioning SIB Type 2-14
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-14.

	21 Positioning SIB Type 2-15
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-15.

	22 Positioning SIB Type 2-16
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-16.

	23 Positioning SIB Type 2-17
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-17.

	24 Positioning SIB Type 2-18
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-18.

	25 Positioning SIB Type 2-19
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-19.

	26 Positioning SIB Type 3-1
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 3-1.

	27 Positioning SIB Type 1-8
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 1-8.
	
	28 Positioning SIB Type 2-20
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-20.

	29 Positioning SIB Type 2-21
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-21.

	30 Positioning SIB Type 2-22
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-22.

	31 Positioning SIB Type 2-23
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type  2-23.

	32 Positioning SIB Type 2-24
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-24.

	33 Positioning SIB Type 2-25
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 2-25.

	34 Positioning SIB Type 4-1
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 4-1.
	
	35 Positioning SIB Type 5-1
	This bit, when set, indicates that the UE is subscribed to receive ciphering keys applicable to positioning SIB Type 5-1.

	NOTE:	Bits not defined in this table shall be cleared by the sending HSS and discarded by the receiving MME or SGSN.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.BROADCAST_LOCATION_ASSISTANCE_DATA_TYPE, vendorId = VendorIDs.TGPP_ID, must = false, name = "Broadcast-Location-Assistance-Data-Types")
public interface BroadcastLocationAssistanceDataTypes extends DiameterBitmask64
{
	public void setPositioningSIBBit(int type, int bit,boolean isOn) throws InvalidAvpValueException;
	
	public boolean isPositioningSIBBitSet(int type, int bit) throws InvalidAvpValueException;
	
}