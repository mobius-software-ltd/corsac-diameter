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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.43 Rule-Deactivation-Time (ALL Access Types)
	The Rule-Deactivation-Time AVP (AVP code 1044) is of type Time. This value indicates the NTP time at which the
	PCEF has to stop enforcing the PCC rule. The AVP is included in Charging-Rule-Install AVP and is applicable for all
	the PCC rules included within the Charging-Rule-Install AVP. 
*/
@DiameterAvpDefinition(code = TgppAvpCodes.RULE_DEACTIVATION_TIME, vendorId = VendorIDs.TGPP_ID, name = "Rule-Deactivation-Time")
public interface RuleDeactivationTime extends DiameterTime
{
}