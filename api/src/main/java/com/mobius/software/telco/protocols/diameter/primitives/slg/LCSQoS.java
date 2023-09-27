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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.4.6	LCS-QoS
	The LCS-QoS AVP is of type Grouped.
	AVP format:

	LCS-QoS ::= <AVP header: 2504 10415>
		[ LCS-QoS-Class ]
		[ Horizontal-Accuracy ]
		[ Vertical-Accuracy ]
		[ Vertical-Requested ]
		[ Response-Time]
 */
@DiameterAvpDefinition(code = 2504L, vendorId = KnownVendorIDs.TGPP_ID, name = "LCS-QoS")
public interface LCSQoS extends DiameterAvp
{
	LCSQoSClassEnum getLCSQoSClass();
	
	void setLCSQoSClass(LCSQoSClassEnum value);
	
	Long getHorizontalAccuracy();
	
	void setHorizontalAccuracy(Long value);
	
	Long getVerticalAccuracy();
	
	void setVerticalAccuracy(Long value);
	
	VerticalRequestedEnum getVerticalRequested();
	
	void setVerticalRequested(VerticalRequestedEnum value);
	
	ResponseTimeEnum getResponseTime();
	
	void setResponseTime(ResponseTimeEnum value);
}