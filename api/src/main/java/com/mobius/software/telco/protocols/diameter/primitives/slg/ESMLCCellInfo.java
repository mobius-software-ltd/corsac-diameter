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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.4.57	ESMLC-Cell-Info
	The ESMLC-Cell-Info AVP is of type Grouped.
	AVP format:

	ESMLC-Cell-Info ::= <AVP header: 2552 10415>
		 [ ECGI ]
		 [ Cell-Portion-ID ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = 2552L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "ESMLC-Cell-Info")
public interface ESMLCCellInfo extends DiameterGroupedAvp
{
	ByteBuf getECGI();
	
	void setECGI(ByteBuf value);
	
	Long getCellPortionID();
	
	void setCellPortionID(Long value);
}