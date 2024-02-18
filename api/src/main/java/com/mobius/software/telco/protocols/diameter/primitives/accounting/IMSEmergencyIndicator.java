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
 * 	7.2.76A IMS-Emergency-Indicator AVP
	The IMS-Emergency-Indicator AVP (AVP code 2322) is of type Enumerated, and indicates the IMS session is an IMS
	emergency session or IMS registration. If this AVP is not present, this means the IMS session or registration is not
	detected as an emergency session or registration. The following values are defined:
	
	0 Non Emergency
	1 Emergency 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.IMS_EMERGENCY_INDICATOR, vendorId = VendorIDs.TGPP_ID, name = "IMS-Emergency-Indicator")
public interface IMSEmergencyIndicator extends DiameterEnumerated<IMSEmergencyIndicatorEnum>
{
}