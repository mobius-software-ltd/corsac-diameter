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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.23	Service-URN AVP
	The Service-URN AVP (AVP code 525) is of type OctetString, and it indicates that an AF session is used for emergency or RLOS traffic.
	It contains values of the service URN and it may include subservices, as defined in [21] for emergency and other well-known services or registered at IANA. The string "urn:service:" in the beginning of the URN shall be omitted in the AVP and all subsequent text shall be included. Examples of valid values of the AVP are "sos", "sos.fire", "sos.police" and "sos.ambulance".
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SERVICE_URN, vendorId = VendorIDs.TGPP_ID, name = "Service-URN")
public interface ServiceURN extends DiameterOctetString
{
}