package com.mobius.software.telco.protocols.diameter.primitives.nas;
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

/**
*
* @author yulian oifa
*
*/
/*
 * 4.4.7.  Filter-Id AVP

   The Filter-Id AVP (AVP Code 11) is of type UTF8String and contains
   the name of the filter list for this user.  It is intended to be
   human readable.  Zero or more Filter-Id AVPs MAY be sent in an
   authorization answer message.

   Identifying a filter list by name allows the filter to be used on
   different NASes without regard to filter-list implementation details.
   However, this AVP is not roaming-friendly, as filter naming differs
   from one service provider to another.

   In environments where backward compatibility with RADIUS is not
   required, it is RECOMMENDED that the NAS-Filter-Rule AVP
   (Section 4.4.6) be used instead.
 */
@DiameterAvpDefinition(code = 11L, vendorId = -1L, name = "Filter-Id")
public interface FilterId extends DiameterUTF8String
{
}