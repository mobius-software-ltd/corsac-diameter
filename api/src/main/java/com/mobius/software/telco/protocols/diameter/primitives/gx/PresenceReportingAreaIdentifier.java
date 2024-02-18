package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
 * 	5.3.108 Presence-Reporting-Area-Identifier AVP (3GPP-EPS access type)
	The Presence-Reporting-Area-Identifier AVP (AVP code 2821) is of type OctetString, and it indicates the presence
	reporting area or presence reporting areas set to which specific information refers. The Presence Reporting Area
	Identifier, which is specified in 3GPP TS 29.274 [22] in the Presence Reporting Area Information IE in octets 5 to 7,
	shall contain the identifier of the Presence Reporting Area the UE is entering or leaving or the identifier of the Presence
	Reporting Area set if applicable. It shall be encoded using full hexadecimal representation (binary not ASCII encoding). 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PRESENCE_REPORTING_AREA_IDENTIFIER, vendorId = VendorIDs.TGPP_ID, must = false, name = "Presence-Reporting-Area-Identifier")
public interface PresenceReportingAreaIdentifier extends DiameterOctetString
{
}