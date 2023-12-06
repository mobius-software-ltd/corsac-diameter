package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.248  Release-Reason AVP

	AVP Name
	Release-Reason

	AVP Code
	20780

	AVP Data Type
	Integer32

	Vendor ID
	2011

	Description
	Indicates the call release cause.
    	- 0: Unknown
    	- 1: OVER_MAXIMUM_CALL_DURATION
	
	Indicates exceeding the maximum call duration.
	    - 2: The calling or called party hangs up.
	    - 3: The CCA message is returned. Due to account change, the delivered call duration is shorter than the requested call duration, but the call is not released.
	    - 4: The account balance is used up.
	    - 5: After the A->B session is released in the MT process, a session in the direction of A->B->VM is initiated.
 */
@DiameterAvpDefinition(code = 20780L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Release-Reason")
public interface ReleaseReason extends DiameterInteger32
{
}