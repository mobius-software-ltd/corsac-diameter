package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
 * 	6.3.33	Associated-Identities AVP
	The Associated-Identities AVP is of type Grouped and it contains the private user identities associated to an IMS subscription.
	AVP format

		Associated-Identities ::= < AVP header: 632, 10415 >
			*[ User-Name ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ASSOCIATED_IDENTITIES, vendorId = VendorIDs.TGPP_ID, must = false, name = "Associated-Identities")
public interface AssociatedIdentities extends DiameterGroupedAvp
{
	List<String> getUserName();
	
	void setUserName(List<String> value);
}