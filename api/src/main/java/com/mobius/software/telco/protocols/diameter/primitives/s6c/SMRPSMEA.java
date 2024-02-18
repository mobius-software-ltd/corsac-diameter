package com.mobius.software.telco.protocols.diameter.primitives.s6c;
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
	5.3.3.3	SM-RP-SMEA
	The SM-RP-SMEA AVP is of type OctetString and shall contain the RP-Originating SME-address of the Short Message Entity that has originated the SM. It shall be formatted according to the formatting rules of the address fields described in 3GPP TS 23.040 [3].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SM_RP_SMEA, vendorId = VendorIDs.TGPP_ID, name = "SM-RP-SMEA")
public interface SMRPSMEA extends DiameterOctetString
{
}