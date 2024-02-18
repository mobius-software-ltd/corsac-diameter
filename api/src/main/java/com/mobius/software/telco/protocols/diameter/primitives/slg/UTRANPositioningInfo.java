package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
 * 	7.4.32	UTRAN-Positioning-Info
	The UTRAN-Positioning-Info AVP is of type Grouped.
	AVP format:
	
	UTRAN-Positioning-Info ::= <AVP header: 2527 10415>
		 [ UTRAN-Positioning-Data ]
		 [ UTRAN-GANSS-Positioning-Data ]
		 [ UTRAN-Additional-Positioning-Data ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.UTRAN_POSITIONING_INFO, vendorId = VendorIDs.TGPP_ID, must = false, name = "UTRAN-Positioning-Info")
public interface UTRANPositioningInfo extends DiameterGroupedAvp
{
	ByteBuf getUTRANPositioningData();
	
	void setUTRANPositioningData(ByteBuf value);
	
	ByteBuf getUTRANGANSSPositioningData();
	
	void setUTRANGANSSPositioningData(ByteBuf value);
	
	ByteBuf getUTRANAdditionalPositioningData();
	
	void setUTRANAdditionalPositioningData(ByteBuf value);
}