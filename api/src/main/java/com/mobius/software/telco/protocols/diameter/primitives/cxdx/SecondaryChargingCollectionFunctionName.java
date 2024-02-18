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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUri;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.23	Secondary-Charging-Collection-Function-Name AVP
	The Secondary-Charging-Collection-Function-Name AVP is of type DiameterURI. This AVP contains the address of the Secondary 
	Charging Data Function. The Destination-Host and Destination-Realm for the Diameter accounting requests values should be 
	extracted from the DiameterURI in the way indicated in clause 6.3.20.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SECONDARY_CHARGING_COLLECTION_FUNCTION_NAME, vendorId = VendorIDs.TGPP_ID, name = "Secondary-Charging-Charging-Function-Name")
public interface SecondaryChargingCollectionFunctionName extends DiameterUri
{
}