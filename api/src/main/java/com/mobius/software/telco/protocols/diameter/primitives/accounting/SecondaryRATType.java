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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.188A Secondary-RAT-Type AVP
	The Secondary-RAT-Type AVP (AVP code 1304) is of type OctetString and Holds the value of Secondary RAT Type,
	as provided by the RAN. The field is provided by the RAN and transferred to the S-GW/P-GW in the RAN Traffic
	Volume element.
	The following values are defined:
	
	0 5G NR 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SECONDARY_RAT_TYPE, vendorId = VendorIDs.TGPP_ID, must = false, name = "Secondary-RAT-Type")
public interface SecondaryRATType extends DiameterOctetString
{
}