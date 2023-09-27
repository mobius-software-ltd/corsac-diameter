package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
	6.3.58	ProSe-Application-Metadata
	The ProSe-Application-Metadata AVP is of type UTF8String. This AVP shall contain the metadata associated with the ProSe Application ID contained in the Match Report. As defined in 3GPP TS 24.334 [22], the length and contents of the metadata formatted as UTF8-encoded string are out of scope of 3GPP.
 */
@DiameterAvpDefinition(code = 3853L, vendorId = KnownVendorIDs.TGPP_ID, name = "ProSe-Application-Metadata")
public interface ProSeApplicationMetadata extends DiameterUTF8String
{
}