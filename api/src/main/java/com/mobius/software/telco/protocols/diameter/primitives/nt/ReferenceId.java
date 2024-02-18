package com.mobius.software.telco.protocols.diameter.primitives.nt;
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
	5.3.3	Reference-Id AVP
	The Reference-Id AVP (AVP code 4202) is of type OctetString. It is used by the PCRF to correlate an SCS/AS request with the transfer policy retrieved from the SPR. It is assigned by the PCRF and shall be globally unique per PLMN.
	NOTE:	To guarantee the uniqueness of the Reference Id, the Reference Id can follow the definition of Session Id in IETF RFC 6733 [15].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.REFERENCE_ID, vendorId = VendorIDs.TGPP_ID, name = "Reference-Id")
public interface ReferenceId extends DiameterOctetString
{
}