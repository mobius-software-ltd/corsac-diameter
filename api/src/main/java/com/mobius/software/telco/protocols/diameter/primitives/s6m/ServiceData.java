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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.7	Service-Data
	The Service-Data AVP is of type Grouped, and it contains the service-specific data related to the device triggering request handled by the MTC-IWF.
	
	Service-Data ::= <AVP header: 3107 10415>
		 [ T4-Data ]
 		*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SERVICE_DATA, vendorId = VendorIDs.TGPP_ID, name = "Service-Data")
public interface ServiceData extends DiameterGroupedAvp
{
	T4Data getT4Data();
	
	void setT4Data(T4Data value);
}