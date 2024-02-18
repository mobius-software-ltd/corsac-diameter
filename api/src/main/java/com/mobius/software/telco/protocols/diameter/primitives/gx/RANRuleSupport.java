package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
 * 	5.3.122 RAN-Rule-Support AVP
	The RAN-Rule-Support AVP (AVP code 2832) is of type Unsigned32, and it is used to indicate the network supports
	the RAN rule indication.
	The following values are defined in this specification:

	0 (RAN rule indication support):
 		This value shall be used to indicate that the network supports the RAN rule indication. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RAN_RULE_SUPPORT, vendorId = VendorIDs.TGPP_ID, must = false, name = "RAN-Rule-Support")
public interface RANRuleSupport extends DiameterEnumerated<RANRuleSupportEnum>
{
}