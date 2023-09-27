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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	20.5a.4	MBMS-BMSC-SSM-UDP-Port AVP
	The MBMS-BMSC-SSM-UDP-Port AVP (AVP code 926) is of type OctetString and contains the Sgi-mb (transport) plane source UDP port number at the BM-SC for IP multicast encapsulation of IP multicast datagrams.
 */
@DiameterAvpDefinition(code = 926L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "MBMS-BMSC-SSM-UDP-Port")
public interface MBMSBMSCSSMUDPPort extends DiameterOctetString
{
}