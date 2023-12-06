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
 * 	3.2.143  Cost-Type AVP

	AVP Name 
	Cost-Type

	AVP Code 
	20392

	AVP Data Type 
	Integer32

	Vendor ID
	2011

	Description 
	Indicates the service fee. The value of Cost-Type refers to local fee, roaming fee, deduction fee of e-commerce, free times of e-commerce and so on.
 */
@DiameterAvpDefinition(code = 20392L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Cost-Type")
public interface CostType extends DiameterUnsigned32
{
}