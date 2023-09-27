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
 * 	7.4.70	Additional-Area
	The Additional-Area AVP is of type Grouped.
	AVP format:

	Additional-Area ::= <AVP header: 2565 10415>
		 { Area-Type }
		 { Area-Identification }
		*[ AVP ]
 */
@DiameterAvpDefinition(code = 2565L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Additional-Area")
public interface AdditionalArea extends DiameterGroupedAvp
{
	Long getAreaType();
	
	void setAreaType(Long value);
	
	ByteBuf getAreaIdentification();
	
	void setAreaIdentification(ByteBuf value);
}