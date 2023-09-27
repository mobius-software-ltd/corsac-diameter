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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned64;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.49	Content-Version AVP
	The Content-Version AVP (AVP code 552) is of type Unsigned64, and it indicates the version of some content, e.g. of the content of a media component included within the Media-Component-Description AVP. The content version shall be unique for the content and for the lifetime of that content.

	NOTE:	The method of assigning content versions within the Content-Version AVPs is implementation specific. Example implementations are a monotonically increasing number or a value based on a timestamp.
 */
@DiameterAvpDefinition(code = 552L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Content-Version")
public interface ContentVersion extends DiameterUnsigned64
{
}