package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
	7.4.7	Horizontal-Accuracy
	The Horizontal-Accuracy AVP is of type Unsigned32. Bits 6-0 corresponds to Uncertainty Code defined in 3GPP TS 23.032 [3]. The horizontal location error should be less than the error indicated by the uncertainty code with 67% confidence. Bits 7 to 31 shall be ignored. 
 */
@DiameterAvpDefinition(code = 2505L, vendorId = KnownVendorIDs.TGPP_ID, name = "Horizontal-Accuracy")
public interface HorizontalAccuracy extends DiameterUnsigned32
{
}