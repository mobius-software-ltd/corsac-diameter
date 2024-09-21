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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/*
	4.4.8 Service-Setup-Result AVP
	The Service-Setup-Result AVP (AVP code 1135) Indicates the result of the
	service setup result and is used for session based services.
	The Service-Setup-Result AVP is of the type Unsigned32.
		The possible Service-Setup-Result values are:
			• 0 = Successful - Released by service
			• 1 = Successful - Disconnected by calling party
			• 2 = Successful - Disconnect by called party
			• 3 = Successful - Ongoing (toll free)
			• 4 = Non-Successful - Called party route select failure
			• 5 = Non-Successful - Called party busy
			• 6 = Non-Successful - Called party not reachable
			• 7 = Non-Successful - Called party no answer
			• 8 = Non-Successful - Calling party abandon
			• 14 = Non-Successful - Other-Reason
			• 15 = Call Forwarding bas been invoked - Charging cancelled
*/

@DiameterAvpDefinition(code = EricssonAvpCodes.SERVICE_SETUP_RESULT, vendorId = VendorIDs.ERICSSON_ID, name = "Service-Setup-Result")
public interface ServiceSetupResult extends DiameterUnsigned32
{
}