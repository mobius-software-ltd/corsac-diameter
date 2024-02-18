package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger32;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.238	5QI
	The 5QI AVP is of type Integer32. It shall contain the 5QI. See 3GPP TS 23.501 [69] for allowed values.If the 5QI is used in PC5 QoS parameter, it shall contain PQI, PQI is a special 5QI (see clause 5.4.2.1 of 3GPP TS 23.287 [68]).
 */
@DiameterAvpDefinition(code = TgppAvpCodes.FIVE_QI, vendorId = VendorIDs.TGPP_ID, must = false, name = "5QI")
public interface FiveQI extends DiameterInteger32
{
}