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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.3.16	Destination-SIP-URI
	The Destination-SIP-URI AVP is of type UTF8String. It shall contain the Public identity of the IMS UE without MSISDN which is the recipient of a short message, in the context of MSISDN-less SMS delivery in IMS (see 3GPP TS 23.204 [17]).
 */
@DiameterAvpDefinition(code = 3327L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Destination-SIP-URI")
public interface DestinationSIPURI extends DiameterUTF8String
{
}