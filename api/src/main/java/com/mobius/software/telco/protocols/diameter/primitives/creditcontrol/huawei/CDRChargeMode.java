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
 * 	3.2.200  CDRChargeMode AVP

	AVP Name
	CDRChargeMode

	AVP Code
	20626

	AVP Data Type
	Integer32

	Vendor ID
	2011

	Description
	Charge mode referring to the following values:
    
	    - -1: NA 
	    - 0: Monthly charge
	    - 1: Charging by times
	    - 2: Charging by items
	    - 3: Charging by pages
	    - 4: Charging by volume
	    - 5: Charging by duration
	    - 6: Fixed fee
	    - 7: Free
	    - 8: Fixed fee of seconds
	    - 9: Fixed fee of times
	    - 10: Fixed fee of days
	    - 11: Fixed fee of volume
	    - 12: Fixed fee of item
	    - 13: Fixed months fee
 */
@DiameterAvpDefinition(code = 20626L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "CDR-Charge-Mode")
public interface CDRChargeMode extends DiameterInteger32
{
}