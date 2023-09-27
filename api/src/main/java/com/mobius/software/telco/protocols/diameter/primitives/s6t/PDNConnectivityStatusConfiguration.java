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
 * 	8.4.76	PDN-Connectivity-Status-Configuration
	The PDN-Connectivity-Status-Configuration AVP is of type Grouped and it indicates the APN(s) for which the PDN Connectivity Status is to be monitored. If the Service-Selection AVP is included, then the monitoring applies to that specific APN; if the Service-Selection is absent, the monitoring request applies to all APNs.
	AVP format:

	PDN-Connectivity-Status-Configuration ::= <AVP header: 3180 10415>
			 [ Service-Selection ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 3180L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "PDN-Connectivity-Status-Configuration")
public interface PDNConnectivityStatusConfiguration extends DiameterGroupedAvp
{
	String getServiceSelection();
	
	void setServiceSelection(String value);
}