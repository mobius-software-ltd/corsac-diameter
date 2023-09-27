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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.48	Media-Component-Status AVP 
	The Media-Component-Status AVP (AVP code 549) is of type Unsigned32, and it describes the status of the PCC/QoS rule(s) related to a media component.
	The following values are defined in this specification:

	0 (ACTIVE):
		This value shall be used to indicate that the PCC/QoS rule(s) related to certain media component are active.

	1 (INACTIVE):
		This value shall be used to indicate that the PCC/QoS rule(s) related to certain media component are inactive. This is the default value applicable if this AVP is not supplied.

	NOTE:	It is assumed that the AF considers the PCC/QoS rule(s) related to the media component(s) for which the Media-Component-Status AVP(s) are not received as inactive when the Specific-Action AVP set to INDICATION_OF_FAILED_RESOURCES_ALLOCATION (9) is received.
 */
@DiameterAvpDefinition(code = 549L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Media-Component-Status")
public interface MediaComponentStatus extends DiameterEnumerated<MediaComponentStatusEnum>
{
}