package com.mobius.software.telco.protocols.diameter.primitives.cip;
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

import com.mobius.software.telco.protocols.diameter.EricssonAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/*
  	4.4.9 Service-Setup-Result-Requested AVP
	The Service-Setup-Result-Requested AVP (AVP code 1136) is included and
	has the value RESULT_REQUESTED if the result of the service setup should
	be reported for all services, even if the service isn't under credit control or for
	failed service setups.
	The Service-Setup-Result-Requested is of the type Enumerated.
			The possible values are:
			• 0 = RESULT_NOT_NEEDED
			• 1 = RESULT_REQUESTED
 */
@DiameterAvpDefinition(code = EricssonAvpCodes.SERVICE_SETUP_RESULT_REQUESTED, vendorId = VendorIDs.ERICSSON_ID, name = "Service-Setup-Result-Requested")
public interface ServiceSetupResultRequested extends DiameterEnumerated<ServiceSetupResultRequestedEnum>
{
}