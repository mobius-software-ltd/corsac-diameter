package com.mobius.software.telco.protocols.diameter.primitives.tsp;
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
	6.4.13	Feature-Supported-In-Final-Target AVP
	Feature-Supported-In-Final-Target AVP (AVP code 3012) is of type Unsigned32 and contains a bitmask, and is used to indicate the features supported in target node. This AVP shall be present if any of the features are supported.
	Table 6.4.13.1: Features supported by final target node

	Feature bit
	Remote target Feature
	Description
	Applicability

	0
	Device-Trigger-Recall-Replace supported in SMS-SC
	This Feature indicates the support of the applicability to support the functionalty for device trigger recall and device trigger replace by the SMS-SC
	This Feature is applicable for the DAA command.
	If an SMS-SC does not indicate the support of the feature the SCS shall not send device trigger recall requests to an MTC-IWF and SCS shall treat the device trigger replace as a new device trigger.
	Device-Trigger-Recall-Replace

	Note 1:	Feature bit: The order number of the bit within the Feature-Supported-In-Final-Target AVP, e.g. "1".

	Note 2:	Remote target feature: A short name that can be used to refer to the bit and to the feature in the target node, e.g. "Device-Trigger-Recall-Replace".

	Note 3:	Description: A clear textual description of the feature.

	Note 4:	Applicability: Bits marked with a supported feature (e.g. "Device-Trigger-Recall-Replace") are applicable as described in clause 6.4.12.
 */
@DiameterAvpDefinition(code = 3012L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Feature-Supported-In-Final-Target")
public interface FeatureSupportedInFinalTarget extends DiameterUnsigned32
{
}