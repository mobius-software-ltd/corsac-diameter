package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
 * 	8.4.52	Enhanced-Coverage-Restriction-Data
	The Enhanced-Coverage-Restriction-Data AVP is of type Grouped and shall identify the current visited PLMN (if any) and the current settings of Enhanced-Coverage-Restriction.
	AVP format:

	Enhanced-Coverage-Restriction-Data ::=	<AVP header: 3156 10415>
			 { Enhanced-Coverage-Restriction }
			 [ Visited-PLMN-Id ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 3156L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Enhanced-Coverage-Restriction-Data")
public interface EnhancedCoverageRestrictionData extends DiameterGroupedAvp
{
	EnhancedCoverageRestriction getEnhancedCoverageRestriction();
	
	void setEnhancedCoverageRestriction(EnhancedCoverageRestriction value);
	
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);
}