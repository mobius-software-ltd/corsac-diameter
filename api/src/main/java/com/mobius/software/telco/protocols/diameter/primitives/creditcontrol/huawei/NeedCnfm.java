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
 * 	3.2.193  need-cnfm AVP

	AVP Name
	need-cnfm

	AVP Code
	20606

	AVP Data Type
	Integer32

	Vendor ID
	2011

	Description
	Indicates the information need to be confirmed.

	In a CCR message,
    	- 0: indicates that the information does not need to be confirmed.
    	- 1: indicates that the information needs to be confirmed.
	
	The default value -1 indicates that the OCS system determines whether the information needs to be confirmed.
	In a CCA message,
    	- 0: indicates that the information does not need to be confirmed.
    	- 1: indicates that the information needs to be confirmed.

	If the value of this AVP is 0 in a CCR message, the value returned in the corresponding CCA message is also 0. If the value of this AVP is 1 in a CCR message, the value returned in the corresponding CCA message is also 1. If the value of this AVP is -1 in a CCR message, the value returned in the corresponding CCA message depends on the configuration in the OCS system.
 */
@DiameterAvpDefinition(code = 20606L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Need-Cnfm")
public interface NeedCnfm extends DiameterUnsigned32
{
}