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
 * 	8.2.3.4 Non-3GPP-IP-Access-APN
	The Non-3GPP-IP-Access-APN AVP (AVP code 1502) is of type Enumerated, and allows operator to disable all APNs
	for a subscriber at one time. The following values are defined:
 
 	Non_3GPP_APNS_ENABLE (0)
 	Enable all APNs for a subscriber.
 
 	Non_3GPP_APNS_DISABLE (1)
 	Disable all APNs for a subscriber
 */
@DiameterAvpDefinition(code = 1502L, vendorId = KnownVendorIDs.TGPP_ID, name = "Non-3GPP-IP-Access-APN")
public interface Non3GPPIPAccessAPN extends DiameterEnumerated<Non3GPPIPAccessAPNEnum>
{
}