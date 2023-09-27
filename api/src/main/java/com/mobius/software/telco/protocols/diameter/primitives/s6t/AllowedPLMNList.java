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

import java.util.List;

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
 * 	8.4.54	Allowed-PLMN-List
	The Allowed-PLMN-List AVP is of type Grouped and shall identify the complete set of serving PLMNs where Enhanced Coverage is allowed.
	AVP format:

	Allowed-PLMN-List ::=	<AVP header: 3158 10415>
			*[Visited-PLMN-Id ]
			*[AVP]
	
	Absence of Visited-PLMN-Id AVPs indicates that Enhanced Coverage is restricted in all serving PLMNs.
 */
@DiameterAvpDefinition(code = 3158L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Allowed-PLMN-List")
public interface AllowedPLMNList extends DiameterGroupedAvp
{
	List<ByteBuf> getVisitedPLMNId();
	
	void setVisitedPLMNId(List<ByteBuf> value);
}