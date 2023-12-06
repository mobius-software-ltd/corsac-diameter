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
 * 	3.2.338  S-Called-Number-Type AVP

	AVP Name
	S-Called-Number-Type

	AVP Code
	21216

	AVP Data Type
	OctetString
	Length Range: [0,1]

	Vendor-ID
	2011

	Description
	If the called party is a group subscriber in the MO, MT, or MF process, this AVP indicates the group subscriber type of the called party. The options are as follows:
	    - 0: non-PBX user
	    - 2: PBX user
 */
@DiameterAvpDefinition(code = 21216L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "S-Called-Number-Type")
public interface SCalledNumberType extends DiameterOctetString
{
}