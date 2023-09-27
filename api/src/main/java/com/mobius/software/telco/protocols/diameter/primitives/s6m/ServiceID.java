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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.3	Service-ID
	The Service-ID AVP is of type Enumerated and it shall identify the service requested by the SCS. The following values are defined:

	DEVICE_TRIGGER (0)
	The SCS requests a control plane device triggering to the UE. .

	SMS_MO (1)
	The UE (identified by IMSI and application port identifier) requests SMS_MO to be delivered to the SCS.  
 */
@DiameterAvpDefinition(code = 3103L, vendorId = KnownVendorIDs.TGPP_ID, name = "Service-ID")
public interface ServiceID extends DiameterEnumerated<ServiceIDEnum>
{
}