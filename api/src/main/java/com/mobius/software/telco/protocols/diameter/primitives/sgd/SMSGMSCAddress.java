package com.mobius.software.telco.protocols.diameter.primitives.sgd;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterE164Address;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.3.19	SMS-GMSC-Address
	The SMS-GMSC-Address AVP is of type OctetString and it shall contain the E.164 number of the SMS-GMSC or SMS Router, in international number format as described in ITU-T Recommendation E.164 [13] and encoded as a TBCD-string. See 3GPP TS 29.002 [9] for encoding of TBCD-strings. This AVP shall not include leading indicators for the nature of address and the numbering plan; it shall contain only the TBCD-encoded digits of the address.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SMS_GMSC_ADDRESS, vendorId = VendorIDs.TGPP_ID, must = false, name = "SC-Address")
public interface SMSGMSCAddress extends DiameterE164Address
{
}