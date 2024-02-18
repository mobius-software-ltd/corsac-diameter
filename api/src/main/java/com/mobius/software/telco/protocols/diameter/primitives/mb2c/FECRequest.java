package com.mobius.software.telco.protocols.diameter.primitives.mb2c;
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
	6.4.27	FEC-Request AVP
	The FEC-Request AVP (AVP code 3525) is of type OctetString.
	It is used by the GCS AS to request that the BM-SC applies FEC (see IETF RFC 6363 [31]).
	The FEC-Request AVP shall include an SDP description of FEC framework configuration information (see subclause 5.5 of IETF RFC 6363 [31]) formatted according to subclause 8A.5 of 3GPP TS 26.346 [5] . The description shall relate to the IP layer and higher protocols within the "User Plane Data" as depicted in Figure 7.1-1.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.FEC_REQUEST, vendorId = VendorIDs.TGPP_ID, must = false, name = "FEC-Request")
public interface FECRequest extends DiameterOctetString
{
}