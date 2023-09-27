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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.9 Address-Type AVP
	The Address-Type AVP (AVP code 899) is of type Enumerated and indicates the type of address carried within the
	Address-Information AVP. It has the following values:

	0 e-mail address
	1 MSISDN
	2 IPv4 Address
	3 IPv6 Address
	4 Numeric Shortcode
	5 Alphanumeric Shortcode
	6 Other
	7 IMSI
*/
@DiameterAvpDefinition(code = 899L, vendorId = KnownVendorIDs.TGPP_ID, name = "Address-Type")
public interface AddressType extends DiameterEnumerated<AddressTypeEnum>
{
}