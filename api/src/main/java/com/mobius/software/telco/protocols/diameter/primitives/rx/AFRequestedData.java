package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.50	AF-Requested-Data AVP
	The AF-Requested-Data AVP (AVP code 551) is of type Unsigned32 and indicates the information that the AF requested to be exposed, it shall contain a bit mask. The bit 0 shall be the least significant bit. For example, to get the value of bit 0, a bit mask of 0x0001 should be used. The meaning of the bits shall be as defined below:
	
	Table 5.3.50.1: AF-Requested-Data
	Bit Name
	Description

	0 EPC-level identities required
	This bit, when set, indicates that the AF requests the PCRF to provide the EPC-level identities (MSISDN, IMSI, IMEI(SV)) available for that IP-CAN session. 
 */
@DiameterAvpDefinition(code = 551L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "AF-Requested-Data")
public interface AFRequestedData extends DiameterUnsigned32
{
}