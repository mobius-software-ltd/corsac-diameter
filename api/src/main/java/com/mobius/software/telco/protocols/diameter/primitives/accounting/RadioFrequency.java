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
 * 	7.2.160A Radio-Frequency AVP
	The Radio-Frequency AVP (AVP code 3462) is of type OctetString and identifies the radio frequency used for ProSe
	direct communication. The format of the value is according to the ARFCN-ValueEUTRA-r9 ASN.1 data type described
	in TS 36.331 [241]. 
 */
@DiameterAvpDefinition(code = 3462L, vendorId = KnownVendorIDs.TGPP_ID, name = "Radio-Frequency")
public interface RadioFrequency extends DiameterOctetString
{
}