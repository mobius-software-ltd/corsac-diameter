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
 * 	7.2.207 SM-Message-Type AVP
	The SM-Message-Type AVP (AVP code 2007) is of type Enumerated and indicates the type of the message which
	caused the charging interaction. The values are given below:
	
	0 SUBMISSION
	1 DELIVERY_REPORT 
	2. SM Service Request
	3 T4 Device Trigger
	4 SM Device Trigger
	5 MO-SMS T4 submission
 */
@DiameterAvpDefinition(code = 2007L, vendorId = KnownVendorIDs.TGPP_ID, name = "SM-Message-Type")
public interface SMMessageType extends DiameterEnumerated<SMMessageTypeEnum>
{
}