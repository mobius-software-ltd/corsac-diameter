package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.40	Sponsoring-Action AVP
	The Sponsoring-Action AVP (AVP code 542) is of type Enumerated, and contains the indication whether to enable or disable/not enable sponsored data connectivity.
	The following values are defined:

	DISABLE_SPONSORING (0)
		Disable sponsored data connectivity or not enable sponsored data connectivity

	ENABLE_SPONSORING (1)
		Enable sponsored data connectivity.

	NOTE:	The use of value DISABLE_SPONSORING (0) to "not enable" sponsored data connectivity is used at initial provisioning of session information to provide sponsor information but not enable it at that point in time and to "disable" sponsored data connectivity is used at modification of session information when disabling sponsored data connectivity previously enabled.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SPONSORING_ACTION, vendorId = VendorIDs.TGPP_ID, must = false, name = "Sponsoring-Action")
public interface SponsoringAction extends DiameterEnumerated<SponsoringActionEnum>
{
}