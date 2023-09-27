package com.mobius.software.telco.protocols.diameter.primitives.s6m;
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
 * 	6.4.5	Service-Parameters
	The Service-Parameters AVP is of type Grouped, and it contains the service-specific parameters related to the requested service.
	AVP format:
	
	Service-Parameters ::= <AVP header: 3105 10415>
			 [ T4-Parameters ]
		 	 [ Application-Port-Identifier ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 3105L, vendorId = KnownVendorIDs.TGPP_ID, name = "Service-Parameters")
public interface ServiceParameters extends DiameterGroupedAvp
{
	T4Parameters getT4Parameters();
	
	void setT4Parameters(T4Parameters value);
	
	Long getApplicationPortIdentifier();
	
	void setApplicationPortIdentifier(Long value);
}