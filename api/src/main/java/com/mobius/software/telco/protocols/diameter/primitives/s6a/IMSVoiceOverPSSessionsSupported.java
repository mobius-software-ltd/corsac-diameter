package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
 * 	7.3.106	IMS-Voice-Over-PS-Sessions-Supported
	The IMS-Voice-Over-PS-Sessions-Supported AVP is of type Enumerated. The following values are defined:

	NOT_SUPPORTED (0)
	This value indicates that "IMS Voice over PS Sessions" is not supported by the UE's most recently used TA or RA in the serving node.

	SUPPORTED (1)
	This value indicates that "IMS Voice over PS Sessions" is supported by the UE's most recently used TA or RA in the serving node.
 */
@DiameterAvpDefinition(code = 1492L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "IMS-Voice-Over-PS-Sessions-Supported")
public interface IMSVoiceOverPSSessionsSupported extends DiameterEnumerated<IMSVoiceOverPSSessionsSupportedEnum>
{
}