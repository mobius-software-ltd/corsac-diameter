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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	7.4.12	Supported-GAD-Shapes
	The Supported-GAD-Shapes AVP is of type Unsigned32 and it shall contain a bitmask.
	A node shall mark in the BIT STRING all Shapes defined in 3GPP TS 23.032 [3] it supports.
	Bits 10-0 in shall indicate the supported Shapes defined in 3GPP TS 23.032 [3]. Bits 11 to 31 shall be ignored.

	ellipsoidPoint (0)

	ellipsoidPointWithUncertaintyCircle (1)

	ellipsoidPointWithUncertaintyEllipse (2)

	polygon (3)

	ellipsoidPointWithAltitude (4)

	ellipsoidPointWithAltitudeAndUncertaintyElipsoid (5)

	ellipsoidArc (6)

	highAccuracyEllipsoidPointWithUncertaintyEllipse (7)

	highAccuracyEllipsoidPointWithAltitudeAndUncertaintyEllipsoid (8)

	highAccuracyEllipsoidPointWithScalableUncertaintyEllipse (9)

	highAccuracyEllipsoidPointWithAltitudeAndScalableUncertaintyEllipsoid (10) 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SUPPORTED_GAD_SHAPES, vendorId = VendorIDs.TGPP_ID, name = "Supported-GAD-Shapes")
public interface SupportedGADShapes extends DiameterUnsigned32
{
}