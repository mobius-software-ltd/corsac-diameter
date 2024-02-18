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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	20.5a.12	MBMS-Cell-List AVP
	The MBMS-Cell-List AVP (AVP code 934) is of type OctetString. It contains the MBMS Cell Listthat the E-UTRAN uses to determine a set of radio resources to be used for the broadcast. Based on the cell ID list, the set of radio resources selected may be reduced from the full set of resources defined by the MBMS service area. 
	The AVP shall consist of two octets indicating the number of cell identifiers in the list, followed by a sequence of maximum 4096 cell identifiers, coded as E-CGIs.

	Bits
	1-16 
	
	Number N of ECGI codes coded as:
	1	binary value is ‘0000 0000 0000 0000’
	4096	binary value is '0000 1111 1111 1111'
	17-(56*N+16) A consecutive list of N ECGI codes, each encoded according to subclause 8.21.5 of 3GPP TS 29.274 [81].
	
	The ECGI and its semantics are defined in subclause 19.6 of 3GPP TS 23.003 [40].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_CELL_LIST, vendorId = VendorIDs.TGPP_ID, must = false, name = "MBMS-Cell-List")
public interface MBMSCellList extends DiameterOctetString
{
}