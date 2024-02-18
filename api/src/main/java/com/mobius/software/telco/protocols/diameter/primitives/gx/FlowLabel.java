package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
 * 	5.3.52 Flow-Label AVP (All access types)
	The Flow-Label AVP (AVP code 1057) is of type OctetString, and it contains the Ipv6 flow label header field. One
	example is that of a TFT packet filter as defined in 3GPP TS 24.008 [13].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.FLOW_LABEL, vendorId = VendorIDs.TGPP_ID, must = false, name = "Flow-Label")
public interface FlowLabel extends DiameterOctetString
{
}