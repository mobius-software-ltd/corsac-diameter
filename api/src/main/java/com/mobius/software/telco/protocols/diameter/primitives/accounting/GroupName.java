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

import com.mobius.software.telco.protocols.diameter.OneM2MAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
	A.4.9. Group-Name AVP
	The Group-Name AVP (AVP Code 1006) is of type UTF8String and identifies the group associated with a request. 
	It shall be included when the IN initiates a fanning operation. This is the same as the attribute "groupName" for 
	the group as described in Table 7.4.14.1-137.
 */
@DiameterAvpDefinition(code = OneM2MAvpCodes.GROUP_NAME, vendorId = VendorIDs.ONEM2M_ID, name = "Group-Name")
public interface GroupName extends DiameterUTF8String
{
}