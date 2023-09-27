package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
 * 	7.2.171 Refund-Information AVP
	The Refund-Information AVP (AVP code 2022) is of type OctetString and it conveys relevant information for the OCS
	application relative to refund mechanism. When refund mechanism is implemented in the OCS this AVP may be
	included in the CCA of the previous IEC. This AVP shall be used by the CTF in case of a refund scenario and thus shall
	be included in the CCR for refund if previously received in CCA for IEC. 
 */
@DiameterAvpDefinition(code = 2022L, vendorId = KnownVendorIDs.TGPP_ID, name = "Refund-Information")
public interface RefundInformation extends DiameterOctetString
{
}