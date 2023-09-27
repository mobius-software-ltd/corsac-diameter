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
 * 	7.2.46abA CP-CIoT-EPS-Optimisation-Indicator AVP
	The CP-CIoT-EPS-Optimisation-Indicator AVP (AVP code 3930) is of type Enumerated, and indicates whether
	Control Plane CIoT EPS optimisation is used by this PDN connection for data transfer with the UE. The following
	values are defined:
	
	0 Not Apply
	1 Apply 
 */
@DiameterAvpDefinition(code = 3930L, vendorId = KnownVendorIDs.TGPP_ID, name = "CP-CIoT-EPS-Optimisation-Indicator")
public interface CPCIoTEPSOptimisationIndicator extends DiameterEnumerated<CPCIoTEPSOptimisationIndicatorEnum>
{
}