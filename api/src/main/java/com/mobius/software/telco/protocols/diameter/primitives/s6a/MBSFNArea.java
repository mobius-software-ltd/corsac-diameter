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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.219	MBSFN-Area
	The MBSFN-Area AVP is of type Grouped. It contains a MBSFN Area ID and a Carrier Frequency (see 3GPP TS 32.422 [23]).
	The AVP format shall conform to:
	
	MBSFN-Area ::= <AVP header: 1694 10415>
			 [ MBSFN-Area-ID ]
			 [ Carrier-Frequency ]
			*[ AVP ]

	If both MBSFN-Area-ID and Carrier-Frequency values are present, a specific MBSFN area is indicated. If Carrier-Frequency value is present, but MBSFN-Area-ID is absent, all MBSFN areas on that carrier frequency are indicated. If both MBSFN-Area-ID and Carrier-Frequency are absent, any MBSFN area is indicated.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBSFN_AREA, vendorId = VendorIDs.TGPP_ID, must = false, name = "MBSFN-Area")
public interface MBSFNArea extends DiameterGroupedAvp
{
	Long getMBSFNAreaID();
	
	void setMBSFNAreaID(Long value);
	
	Long getCarrierFrequency();
	
	void setCarrierFrequency(Long value);
}