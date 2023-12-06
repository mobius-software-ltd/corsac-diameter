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
 * 	3.2.277  Fav-Area-Flag AVP

	AVP Name
	Fav-Area-Flag

	AVP Code
	20917

	AVP Data Type
	Integer32

	Vendor ID
	2011

	Description
	Indicates whether a subscriber is in the favorite area. The options are as follows:
	    - 0: no
	    - 1: yes

 */
@DiameterAvpDefinition(code = 20917L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Fav-Area-Flag")
public interface FavAreaFlag extends DiameterUnsigned32
{
}