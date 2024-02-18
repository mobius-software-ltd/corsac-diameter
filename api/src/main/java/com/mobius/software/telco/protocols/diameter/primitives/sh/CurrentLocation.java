package com.mobius.software.telco.protocols.diameter.primitives.sh;
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
 * 6.3.8 Current-Location AVP
	The Current-Location AVP is of type Enumerated, and indicates whether an active location retrieval has to be initiated
	or not:

	DoNotNeedInitiateActiveLocationRetrieval (0)
		The request indicates that the initiation of an active location retrieval is not required.
	InitiateActiveLocationRetrieval (1)
		It is requested that an active location retrieval is initiated. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CURRENT_LOCATION, vendorId = VendorIDs.TGPP_ID, name = "Current-Location")
public interface CurrentLocation extends DiameterEnumerated<CurrentLocationEnum>
{
}