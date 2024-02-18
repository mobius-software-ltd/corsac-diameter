package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.29.  Rating-Group AVP

   The Rating-Group AVP is of type Unsigned32 (AVP Code 432) and
   contains the identifier of a rating-group.  All the services subject
   to the same rating type are part of the same rating-group.  The
   specific rating-group the request relates to is uniquely identified
   by the combination of the Service-Context-Id AVP and the Rating-Group
   AVP.

   A usage example of this AVP is illustrated in Appendix A.9.
 */
@DiameterAvpDefinition(code = AvpCodes.RATING_GROUP, vendorId = -1L, name = "Rating-Group")
public interface RatingGroup extends DiameterUnsigned32
{
}