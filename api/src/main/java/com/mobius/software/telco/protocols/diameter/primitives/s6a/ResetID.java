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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.184	Reset-ID
	The Reset-ID is of type OctetString. The value shall uniquely (within the HSS's realm) identify a resource in the HSS that may fail or has restarted.
	In the Reset procedure, when used to add/modify/delete subscription data shared by multiple subscribers, the Reset-ID is used to identify the set of affected subscribers.
*/
@DiameterAvpDefinition(code = TgppAvpCodes.RESET_ID, vendorId = VendorIDs.TGPP_ID, must = false, name = "Reset-ID")
public interface ResetID extends DiameterOctetString
{
}