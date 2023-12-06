package com.mobius.software.telco.protocols.diameter.primitives.sy;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	5.3.6	Pending-Policy-Counter-Change-Time AVP
	The Pending-Policy-Counter-Change-Time AVP (AVP code 2906) is of type Time. This value indicates the NTP time at which the pending policy counter status becomes the current status of a policy counter.
 */
@DiameterAvpDefinition(code = 2906L, vendorId = KnownVendorIDs.TGPP_ID, name = "Pending-Policy-Counter-Change-Time")
public interface PendingPolicyCounterChangeTime extends DiameterTime
{
}