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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	B.2.1	3GPP-OC-Rating-Group AVP
	The OC-Rating-Group AVP (AVP code 1321), is of type Unsigned32. It contains the charging key (defined in TS 23.203 [218]) that the overload control is applied to, i.e. which Rating Groups should be restricted.
 */
@DiameterAvpDefinition(code = 1321L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "3GPP-OC-Rating-Group")
public interface TGPPOCRatingGroup extends DiameterUnsigned32
{
}