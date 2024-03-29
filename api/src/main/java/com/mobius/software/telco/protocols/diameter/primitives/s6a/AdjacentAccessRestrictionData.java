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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.187	Adjacent-Access-Restriction-Data
	The Adjacent-Access-Restriction-Data AVP is of type Grouped. This AVP shall contain a pair of PLMN ID and the associated Access Restriction Data for that PLMN.
	AVP format:

	Adjacent-Access-Restriction-Data ::= <AVP header: 1673 10415>
			 { Visited-PLMN-Id }
			 { Access-Restriction-Data }
			*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ADJACENT_ACCESS_RESTRICTION_DATA, vendorId = VendorIDs.TGPP_ID, must = false, name = "Adjacent-Access-Restriction-Data")
public interface AdjacentAccessRestrictionData extends DiameterGroupedAvp
{
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value) throws MissingAvpException;
	
	AccessRestrictionData getAccessRestrictionData();
	
	void setAccessRestrictionData(AccessRestrictionData value) throws MissingAvpException;
}