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
 * 	7.2.205A SM-Device-Trigger-Indicator AVP
	The SM-Device-Trigger-Indicator AVP (AVP code 3407) is of type Enumerated, and indicates whether the Short
	Message is related to Device Trigger, and which action is requested by the Device trigger. If this AVP is not present,
	this means the Short Message is not related to Device Trigger:
	
	0 Not DeviceTrigger
	1 Device Trigger request
	2 Device Trigger replace
	3 Device Trigger recall 
 */
@DiameterAvpDefinition(code = 3407L, vendorId = KnownVendorIDs.TGPP_ID, name = "SM-Device-Trigger-Indicator")
public interface SMDeviceTriggerIndicator extends DiameterEnumerated<SMDeviceTriggerIndicatorEnum>
{
}