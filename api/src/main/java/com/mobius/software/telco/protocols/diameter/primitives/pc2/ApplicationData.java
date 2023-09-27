package com.mobius.software.telco.protocols.diameter.primitives.pc2;
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
	6.4.7	Application-Data AVP
	The Application-Data AVP (AVP code 3605) is of type UTF8String, and it contains

	-	a list of target RPAUIDs of UEs in restricted ProSe Direct Discovery for monitoring or query requests.

	-	information related to suffix allocation for an announcing UE when application-controlled extension is used.
	
	-	a list of successfully authenticated target RPAUIDs of UEs in restricted ProSe Direct Discovery.
 */
@DiameterAvpDefinition(code = 3605L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Application-Data")
public interface ApplicationData extends DiameterUTF8String
{
}