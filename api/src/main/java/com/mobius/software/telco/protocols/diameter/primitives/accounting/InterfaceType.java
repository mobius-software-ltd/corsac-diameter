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
 * 	7.2.74 Interface-Type AVP
	The Interface-Type AVP (AVP code 2006) is of type Enumerated and contains information about type of interface /
	nature of the transaction in the messaging node for which the charging event occurs. The AVP can take the following
	values:
	
	0 Unknown
	1 MOBILE_ORIGINATING
	2 MOBILE_TERMINATING
	3 APPLICATION_ORIGINATING
	4 APPLICATION_TERMINATION 
 */
@DiameterAvpDefinition(code = 2006L, vendorId = KnownVendorIDs.TGPP_ID, name = "Interface-Type")
public interface InterfaceType extends DiameterEnumerated<InterfaceTypeEnum>
{
}