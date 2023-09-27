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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.154O ProSe-UE-ID AVP
	The ProSe-UE-ID AVP (AVP code 3453) is of type OctetString and carry a link layer identifier assigned by the EPS
	that uniquely represents the UE in the context of ProSe Direct Communication. It is referred to as "ProSe UE ID" in TS
	23.303 [235].
 */
@DiameterAvpDefinition(code = 3453L, vendorId = KnownVendorIDs.TGPP_ID, name = "ProSe-UE-ID")
public interface ProSeUEID extends DiameterOctetString
{
}