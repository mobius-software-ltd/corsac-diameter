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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/*	
  	4.4.2 CDR-Information AVP
	The CDR-Information AVP (AVP code 1064) is an AVP that contains CDR
	information sent from SDP to CIP/IP Client in the CIA command. The CDR
	information is per service.
	The CDR-Information AVP is of type Octetstring.
*/

@DiameterAvpDefinition(code = EricssonAvpCodes.CDR_INFORMATION, vendorId = VendorIDs.ERICSSON_ID, name = "CDR-Information")
public interface CDRInformation extends DiameterOctetString
{
	
}