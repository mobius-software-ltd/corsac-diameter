package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
 * 	5.3.121 Access-Availability-Change-Reason AVP
	The Access-Availability-Change-Reason AVP (AVP code 2833) is of type Unsigned32 and it is used to indicate the
	reason why the avalibility of an access is changed by the PCEF.
	The following values are defined in this specification:

	0 (Access stratum indication):
		This value shall be used to indicate that the availablitlity of an access is changed due to theAccess stratum
		indication.
	1 (Access usable/unusable):
 		This value shall be used to indicate that the availablitlity of an access is changed due to the access is unusable or
		usable again. 
 */
@DiameterAvpDefinition(code = 2833L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Access-Availability-ChangeReason")
public interface AccessAvailabilityChangeReason extends DiameterEnumerated<AccessAvailabilityChangeReasonEnum>
{
}