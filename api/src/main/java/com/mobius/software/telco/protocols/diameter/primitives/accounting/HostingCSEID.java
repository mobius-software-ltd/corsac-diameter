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
	A.4.10. Hosting-CSE-ID AVP
	The Hosting-CSE-ID AVP (AVP Code 1007) is of type UTF8String and represents the identity of the Hosting CSE 
	for the request in case the receiver is not the host. The format of the CSE-ID is specified in clause 6.2.3.
 */
@DiameterAvpDefinition(code = OneM2MAvpCodes.HOSTING_CSEID, vendorId = VendorIDs.ONEM2M_ID, name = "Hosting-CSE-ID")
public interface HostingCSEID extends DiameterUTF8String
{
}