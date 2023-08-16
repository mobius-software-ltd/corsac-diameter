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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.77 TDF-Application-Identifier AVP
	The TDF-Application-Identifier AVP (AVP Code 1088) is of type OctetString. It references the application detection
	filter (e.g. its value may represent an application such as a list of URLs, etc.) which the PCC rule for application
	detection and control in the PCEF applies. The TDF-Application-Identifier AVP references also the application in the
	reporting to the PCRF.
 */
@DiameterAvpDefinition(code = 1088L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "TDF-Application-Identifier")
public interface TDFApplicationIdentifier extends DiameterOctetString
{
}