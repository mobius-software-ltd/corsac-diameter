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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.125  Redirection-Reason AVP
	
	AVP Name
	Redirection-Reason

	AVP Code
	20363

	AVP Data Type
	Unsigned32

	Vendor ID
	2011

	Description
	Indicates the redirection reason.

	The description of values in the CDMA network is as follows:
    	- 0: unconditional
    	- 1: user busy
    	- 2: no reply
    	- 3: mobile subscriber not reachable
    	- 4: others
	
	The description of values in the GSM network can be referred in the protocol and the description is as follows: 
    	- 1: user busy
    	- 2: no reply
    	- 3: unconditional
    	- 4: others
    	- 6: mobile subscriber not reachable
 */
@DiameterAvpDefinition(code = 20363L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Redirection-Reason")
public interface RedirectionReason extends DiameterUnsigned32
{
}