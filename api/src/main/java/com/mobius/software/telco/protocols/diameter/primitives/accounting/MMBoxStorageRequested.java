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
 * 	7.2.109 MMBox-Storage-Requested AVP
	The MMBox-Storage-Requested AVP (AVP code 1248) is of type Enumerated and indicates whether an
	MMBoxstorage has been requested by the originator MMS User Agent or not. The values for whether an MMBox
	Storage was requested are:
 	
 	0 No
 	1 Yes 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MMBOX_STORAGE_REQUESTED, vendorId = VendorIDs.TGPP_ID, name = "MMBox-Storage-Requested")
public interface MMBoxStorageRequested extends DiameterEnumerated<MMBoxStorageRequestedEnum>
{
}