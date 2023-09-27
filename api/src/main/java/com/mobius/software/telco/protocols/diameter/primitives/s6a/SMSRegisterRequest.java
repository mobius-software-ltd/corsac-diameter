package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
 * 	7.3.162	SMS-Register-Request
	The SMS-Register-Request AVP is of type Enumerated and it shall indicate whether the MME or the SGSN requires to be registered for SMS (e.g. SGs interface not supported) or if the MME or the SGSN prefers not to be registered for SMS or if the MME or the SGSN has no preference.
	The following values are defined:

	SMS_REGISTRATION_REQUIRED (0)

	SMS_REGISTRATION_NOT_PREFERRED (1)

	NO_PREFERENCE (2)

	The criteria for setting these values are defined in 3GPP TS 23.272 [44] and 3GPP TS 23.060 [12].
	When the MME/SGSN includes the SMS-Register-Request AVP in ULR in order to modify its registration status for SMS, the MME/SGSN shall not set the "Skip Subscriber Data" flag within the ULR-Flags AVP.
 */
@DiameterAvpDefinition(code = 1648L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "SMS-Register-Request")
public interface SMSRegisterRequest extends DiameterEnumerated<SMSRegisterRequestEnum>
{
}