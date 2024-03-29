package com.mobius.software.telco.protocols.diameter.primitives.slh;
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

/**
*
* @author yulian oifa
*
*/

/*
	6.4.8 Additional-Serving-Node
	The Additional-Serving-Node AVP is of type Grouped. This AVP shall contain the information about the network node
	serving the targeted user.

	AVP format
		Additional-Serving-Node ::= <AVP header: 2406 10415>
			 [ SGSN-Number ]
			 [ MME-Name ]
			 [ SGSN-Name ]
			 [ SGSN-Realm ]
			 [ MME-Realm ] 
			 [ MSC-Number ]
			 [ 3GPP-AAA-Server-Name ]
			 [ LCS-Capabilities-Sets ]
			 [ GMLC-Address ]
			*[AVP] 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ADDITIONAL_SERVING_NODE, vendorId = VendorIDs.TGPP_ID, name = "Additional-Serving-Node")
public interface AdditionalServingNode extends ServingNode
{
}