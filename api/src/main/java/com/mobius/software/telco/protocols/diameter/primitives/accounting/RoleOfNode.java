package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.177 Role-Of-Node AVP
	The Role-Of-Node AVP (AVP code 829) is of type Enumerated and specifies whether the IMS (except the MRFC) or
	VCS node is serving the calling, called, or forwarding party. The identifier can be one of the following:
 	
 	0 ORIGINATING_ROLE
 	The node is applying an originating role, serving the calling party.
 	
 	1 TERMINATING_ROLE
 	The node is applying a terminating role, serving the called party.
 	
 	2 FORWARDING_ROLE
 	The node is applying a originating role, serving the forwarding party. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ROLE_OF_NODE, vendorId = VendorIDs.TGPP_ID, name = "Role-Of-Node")
public interface RoleOfNode extends DiameterEnumerated<RoleOfNodeEnum>
{
}