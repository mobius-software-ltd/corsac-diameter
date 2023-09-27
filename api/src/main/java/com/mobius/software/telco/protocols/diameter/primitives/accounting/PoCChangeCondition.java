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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.139 PoC-Change-Condition AVP
	The PoC-Change-Condition AVP (AVP code 1261) is of type Enumerated and contains the reason for closing a
	container and the addition of a new container. The AVP may take the following values:
 	
 	0 ServiceChange
 	1 VolumeLimit
 	2 TimeLimit
 	3 NumberofTalkBurstLimit
 	4 NumberofActiveParticipants
 	5 TariffTime 
 */
@DiameterAvpDefinition(code = 1261L, vendorId = KnownVendorIDs.TGPP_ID, name = "PoC-Change-Condition")
public interface PoCChangeCondition extends DiameterEnumerated<PoCChangeConditionEnum>
{
}