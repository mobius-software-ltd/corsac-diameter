package com.mobius.software.telco.protocols.diameter.primitives.np;
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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.8	Congestion-Location-Id AVP
	The Congestion-Location -Id AVP (AVP code 4006) is of type Grouped, and it indicates the identifier of a congested location in which the UE is currently located. The congested location is one of the following: the eNodeB, E-UTRAN cell or Service Area serving the UE. If ECGI is included in the 3GPP-User-Location-Info AVP within Congestion-Location-Id AVP, then the eNodeB identifier within eNodeB-Id AVP or Extended-eNodeB-Id AVP shall not be included in this AVP. This AVP is provided in the RUCI per user id and APN. If the eNodeB identifier has a length of 18 or 21 bits it shall be provided in the Extended-eNodeB-Id AVP and otherwise in the eNodeB-Id AVP.
	AVP Format:

	Congestion-Location-Id ::=     < AVP Header: 4006 >
			 [ 3GPP-User-Location-Info ]
			 [ eNodeB-Id ]
			 [ Extended-eNodeB-Id ]
 			*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CONGESTION_LOCATION_ID, vendorId = VendorIDs.TGPP_ID,must = false, name = "Congestion-Location-Id")
public interface CongestionLocationId extends DiameterGroupedAvp
{
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);
	
	ByteBuf getENodeBId();
	
	void setENodeBId(ByteBuf value);	
	
	ByteBuf getExtendedENodeBId();
	
	void setExtendedENodeBId(ByteBuf value);
}