package com.mobius.software.telco.protocols.diameter.primitives.t4;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.2	Absent-Subscriber-Diagnostic-T4
	The Absent-Subscriber-Diagnostic-T4 AVP is of type Enumerated and indicates the reason why the subscriber is absent if the device trigger failed to be delivered due to absent subscriber. The following values are defined:

	NO_PAGING_RESPONSE (0)
	This value is used when there is no paging response via some of the serving nodes.

	UE_DETACHED (1)
	This value is used when the UE is detached from all of the serving nodes.

	UE_DEREGISTERED (2)
	This value is used when the UE is deregistered in the network.

	UE_PURGED (3)
	This value is used when the UE is purged by some of the serving nodes.

	ROAMING_RESTRICTION (4)
	This value is used when the UE is roaming restricted.

	UNIDENTIFIED_SUBSCRIBER (5)
	This value is used when the user is unidentified in all of the serving nodes.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ABSENT_SUBSCRIBER_DIAGNOSTIC_T4, vendorId = VendorIDs.TGPP_ID, name = "Absent-Subscriber-Diagnostic-T4")
public interface AbsentSubscriberDiagnosticT4 extends DiameterEnumerated<AbsentSubscriberDiagnosticT4Enum>
{
}