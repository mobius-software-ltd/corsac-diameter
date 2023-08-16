package com.mobius.software.telco.protocols.diameter.primitives.sh;
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
 * 	6.3.6 Subs-Req-Type AVP
	The Subs-Req-Type AVP is of type Enumerated, and indicates the type of the subscription-to-notifications request. The
	following values are defined:

	Subscribe (0)
		This value is used by an AS to subscribe to notifications of changes in data.
	Unsubscribe (1)
		This value is used by an AS to unsubscribe to notifications of changes in data. 
 */
@DiameterAvpDefinition(code = 705L, vendorId = KnownVendorIDs.TGPP_ID, name = "Subs-Req-Type")
public interface SubsReqType extends DiameterEnumerated<SubsReqTypeEnum>
{
}