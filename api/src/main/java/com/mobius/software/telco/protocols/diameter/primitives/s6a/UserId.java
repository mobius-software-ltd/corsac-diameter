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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.50	User-Id
	The User-Id AVP shall be of type UTF8String. It shall contain the leading digits of an IMSI (i.e. MCC, MNC, leading digits 
	of MSIN, see 3GPP TS 23.003 [3], clause 2.2) formatted as a character string. Within a HSS, a User-Id identifies a set of 
	subscribers, each with identical leading IMSI digits.
 */
@DiameterAvpDefinition(code = 1444L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "User-Id")
public interface UserId extends DiameterUTF8String
{
}