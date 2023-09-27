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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.73	NGAP-Group AVP 
	The NGAP-Group AVP (AVP code 576) is of type Unsigned32, and it indicates the group of the NGAP cause. The value of this IE shall equal to the ASN.1 value of the specified NGAP cause group
	NGAP supports cause groups defined as separate enumerations, as specified in clause 9.4.5 of 3GPP TS 38.413 [71]. The following values are defined in this specification:

	0:
		This value indicates the NGAP cause group is "radioNetwork".
	
	1:
		This value indicates the NGAP cause group is "transport".

	2: 
		This value indicates the NGAP cause group is "nas".

	3: 
		This value indicates the NGAP cause group is "protocol".

	4: 
		This value indicates the NGAP cause group is "misc".
 */
@DiameterAvpDefinition(code = 576L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "NGAP-Group")
public interface NGAPGroup extends DiameterUnsigned32
{
}