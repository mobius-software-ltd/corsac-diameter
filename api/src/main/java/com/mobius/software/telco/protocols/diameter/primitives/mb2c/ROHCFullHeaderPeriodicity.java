package com.mobius.software.telco.protocols.diameter.primitives.mb2c;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterFloat32;

/**
*
* @author yulian oifa
*
*/

/*
	6.4.29	ROHC-Full-Header-Periodicity AVP
	The ROHC-Full-Header-Periodicity AVP (AVP code 3527) is of type Float32.
	It shall indicate the target periodicity for ROHC (see IETF RFC 5795 [29] and IETF RFC 3095 [30]) full header packets in units of seconds.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ROHC_FULL_HEADER_PERIODICITY, vendorId = VendorIDs.TGPP_ID, must = false, name = "ROHC-Full-Header-Periodicity")
public interface ROHCFullHeaderPeriodicity extends DiameterFloat32
{
}