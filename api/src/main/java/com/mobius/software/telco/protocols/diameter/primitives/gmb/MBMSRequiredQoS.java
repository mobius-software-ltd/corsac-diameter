package com.mobius.software.telco.protocols.diameter.primitives.gmb;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	17.7.16	MBMS-Required-QoS AVP
	The MBMS-Required-QoS AVP (AVP code 913) is the quality of service required for the MBMS bearer service. It is specified as UTF8String with the following encoding:

	Octet

	1 	Allocation/Retention Priority  as specified in 3GPP TS 23.107 [71]. This octet encodes each priority level defined in 3GPP TS 23.107 [71] as the binary value of the priority level. It specifies the relative importance of the actual MBMS bearer service compared to other MBMS and non-MBMS bearer services for allocation and retention of the MBMS bearer service.
	2-N	QoS Profile as specified by the Quality-of-Service information element, from octet 3 onwards,  in 3GPP TS 24.008 [54].
	
 */
@DiameterAvpDefinition(code = 913L, vendorId = KnownVendorIDs.TGPP_ID, name = "MBMS-Required-QoS")
public interface MBMSRequiredQoS extends DiameterOctetString
{
}