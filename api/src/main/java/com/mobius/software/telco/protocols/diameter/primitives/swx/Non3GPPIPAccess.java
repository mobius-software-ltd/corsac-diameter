package com.mobius.software.telco.protocols.diameter.primitives.swx;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.3.3 Non-3GPP-IP-Access
	The Non-3GPP-IP-Access AVP (AVP code 1501) is of type Enumerated, and allows operators to determine barring of
	3GPP - non-3GPP interworking subscription. The following values are defined:
 
 	NON_3GPP_SUBSCRIPTION_ALLOWED (0)
 	The subscriber has non-3GPP subscription to access EPC network.
 
 	NON_3GPP_SUBSCRIPTION_BARRED (1) 
 	The subscriber has no non-3GPP subscription to access EPC network
 */
@DiameterAvpDefinition(code = 1501L, vendorId = KnownVendorIDs.TGPP_ID, name = "Non-3GPP-IP-Access")
public interface Non3GPPIPAccess extends DiameterEnumerated<Non3GPPIPAccessEnum>
{
}