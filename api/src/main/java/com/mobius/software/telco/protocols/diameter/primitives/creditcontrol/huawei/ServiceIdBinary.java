package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;
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
 * 	3.2.177  Service-Id AVP

	AVP Name
	Service-Id

	AVP Code
	20506

	AVP Data Type
	OctetString
	Length Range: [0,32)

	Vendor ID
	2011

	Description
	Indicates the service ID, which uniquely identifies a service.

	NOTE
	The AVP is used in GPRS and MMS process.
 */
@DiameterAvpDefinition(code = 20506L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Service-Id")
public interface ServiceIdBinary extends DiameterOctetString
{
}