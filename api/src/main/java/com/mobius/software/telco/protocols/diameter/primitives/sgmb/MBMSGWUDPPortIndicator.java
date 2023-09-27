package com.mobius.software.telco.protocols.diameter.primitives.sgmb;
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
 * 	20.5a.6	MBMS-GW-UDP-Port-Indicator AVP
	MBMS-GW-UDP-Port-Indicator AVP (AVP code 928) is of type Enumerated. It indicates that the payload related to the MBMS service is required to be delivered in the MBMS UDP Port assigned by the MBMS-GW.
	
	UDP-PORT-REQUIRED (1)
	Value 1 indicates that the user plane data corresponding to the MBMS service shall be delivered on the UDP Port provided by the MBMS-GW.
 */
@DiameterAvpDefinition(code = 928L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "MBMS-GW-UDP-Port-Indicator")
public interface MBMSGWUDPPortIndicator extends DiameterEnumerated<MBMSGWUDPPortIndicatorEnum>
{
}