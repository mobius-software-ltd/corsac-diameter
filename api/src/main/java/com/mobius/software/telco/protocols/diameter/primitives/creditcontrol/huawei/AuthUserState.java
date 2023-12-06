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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.452  Auth-User-State AVP

	AVP Name
	Auth-User-State

	AVP Code
	30802

	AVP Data Type
	UTF8String
	Length Range: [0,32)

	Vendor ID
	2011

	Description
	Indicates the current life cycle state and management state of a subscriber.
	Seven digits form the AVP as CCMMMMM. 
    - Digit 1 (C): prepaid subscriber life cycle status.
    - Digit 2 (C): postpaid subscriber life cycle status.
    - Other digits (MMMMM): subscriber management status.

	The life cycle states are as follows:
    - 0: Idle
    - 1: Active
    - 2: Barred
    - 3: Suspended
    - 4: Pool

	The subscriber management states are as follows:
    - Digit 3: indicates whether a subscriber has claimed missing. (0: no; 1: yes)
    - Digit 4: indicates whether a subscriber is suspended upon the subscriber's request. (0: no; 1: yes)
    - Digit 5: indicates whether a subscriber is suspended with the number reserved. (0: no; 1: yes)
    - Digit 6: indicates whether a subscriber is blocked. (0: no; 1: yes)
    - Digit 7: indicates whether a subscriber is added to the blacklist. (0: no; 1: yes)
 */
@DiameterAvpDefinition(code = 30802L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Auth-User-State")
public interface AuthUserState extends DiameterUTF8String
{
}