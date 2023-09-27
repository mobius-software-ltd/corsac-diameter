package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.15	Location-Information-Configuration
	The Location-Information-Configuration AVP is of type Grouped, and it contains the details for location reporting.
	AVP format:

	Location-Information-Configuration::=	<AVP header: 3135 10415>
			 [ MONTE-Location-Type ]
			 [ Accuracy ]
			 [ Periodic-Time ]
			*[AVP]
	
	If present, Periodic-Time contains the mimum periodic location reporting time.
 */
@DiameterAvpDefinition(code = 3135L, vendorId = KnownVendorIDs.TGPP_ID, name = "Location-Information-Configuration")
public interface LocationInformationConfiguration extends DiameterGroupedAvp
{
	MONTELocationTypeEnum getMONTELocationType();
	
	void setMONTELocationType(MONTELocationTypeEnum value);
	
	AccuracyEnum getAccuracy();
	
	void setAccuracy(AccuracyEnum value);
	
	Long getPeriodicTime();
	
	void setPeriodicTime(Long value);
}