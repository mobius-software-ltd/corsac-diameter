package com.mobius.software.telco.protocols.diameter.primitives.e4;
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

import com.mobius.software.telco.protocols.diameter.EtsiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.22 Initial-Gate-Setting-ID AVP
	The Initial-Gate-Setting-ID AVP (AVP code 314 13019) is of type Unsigned32 and contains a pointer to a pre-defined
	set of initial gate setting information. This AVP and the Initial-Gate-Setting-Description AVP shall not be used in the
	same command 
 */
@DiameterAvpDefinition(code = EtsiAvpCodes.INITIAL_GATE_SETTING_ID, vendorId = VendorIDs.ETSI_ID, must = false, name = "Initial-Gate-Setting-ID")
public interface InitialGateSettingID extends DiameterUTF8String
{
}