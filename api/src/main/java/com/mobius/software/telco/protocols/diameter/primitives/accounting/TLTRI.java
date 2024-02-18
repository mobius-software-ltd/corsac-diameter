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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.232A TLTRI AVP
	The TLTRI AVP (AVP code 1318) is of type Unsigned32, and holds the identifies the T8 Long Term Transaction
	Reference ID is which refers to long term transaction (e.g. NIDD Configuration, Group Message Request, Monitoring
	Event configuration) between the SCEF and the SCS/AS when using T8 interface. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TLTRI, vendorId = VendorIDs.TGPP_ID, must = false, name = "TLTRI")
public interface TLTRI extends DiameterUnsigned32
{
}