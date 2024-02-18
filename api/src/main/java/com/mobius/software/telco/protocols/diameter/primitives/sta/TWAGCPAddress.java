package com.mobius.software.telco.protocols.diameter.primitives.sta;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddress;

/**
*
* @author yulian oifa
*
*/

/*
	5.2.3.29	TWAG-CP-Address
	The TWAG-CP-Address AVP is of type Address and shall contain the TWAG control-plane IPv4 and/or IPv6 address that the TWAG supports, to be used for WLCP by the UE if MCM is selected.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TWAG_CP_ADDRESS, vendorId = VendorIDs.TGPP_ID, must = false, name = "TWAG-CP-Address")
public interface TWAGCPAddress extends DiameterAddress
{
}