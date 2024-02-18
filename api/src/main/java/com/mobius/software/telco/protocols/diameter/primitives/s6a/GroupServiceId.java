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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.190	Group-Service-Id
	The Group-Service-Id AVP is of type Unsigned32 and it shall identify the specific service for which the IMSI-Group-Id is used. The  following values are defined:
	Table 7.3.190-1: Group-Service-Id

	Value Description

	1 Group specific NAS level congestion control

	2 Group specific Monitoring of Number of UEs present in a geographical area

	Values greater than 1000 are reserved for home operator specific use. IMSI-Group-IDs with a Group-Service-Id in this range shall not be sent outside the HPLMN unless roaming agreements allow so.
*/
@DiameterAvpDefinition(code = TgppAvpCodes.GROUP_SERVICE_ID, vendorId = VendorIDs.TGPP_ID, must = false, name = "Group-Service-Id")
public interface GroupServiceId extends DiameterUnsigned32
{
}