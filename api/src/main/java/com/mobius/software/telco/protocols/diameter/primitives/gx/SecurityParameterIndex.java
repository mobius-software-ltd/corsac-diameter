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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.51 Security-Parameter-Index AVP (All access types)
	The Security-Parameter-Index AVP (AVP code 1056) is of type OctetString, and it contains the security parameter
	index of the IPSec packet. One example is that of a TFT packet filter as defined in 3GPP TS 24.008 [13]. 
 */
@DiameterAvpDefinition(code = 1056L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Security-Parameter-Index")
public interface SecurityParameterIndex extends DiameterOctetString
{
}