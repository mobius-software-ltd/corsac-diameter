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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.279  Service-Parameter-Type(20921) AVP
	
	AVP Name
	Service-Parameter-Type

	AVP Code
	20921

	AVP Data Type
	Unsigned32

	Vendor ID
	2011

	Description
	Parameter type:
	    - 1: Tenant ID of the non-charged party.
	    - 2: SubcosId of the non-charged party.
 */
@DiameterAvpDefinition(code = 20921L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Service-Parameter-Type")
public interface ServiceParameterType extends DiameterUnsigned32
{
}