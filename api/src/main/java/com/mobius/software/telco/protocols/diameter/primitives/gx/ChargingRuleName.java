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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.6 Charging-Rule-Name AVP (All access types)
	The Charging-Rule-Name AVP (AVP code 1005) is of type OctetString, and it defines a name for PCC rule. For PCC
	rules provided by the PCRF it uniquely identifies a PCC rule within one IP CAN session. For PCC rules pre-defined at
	the PCEF it uniquely identifies a PCC rule within the PCEF. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CHARGING_RULE_NAME, vendorId = VendorIDs.TGPP_ID, name = "Charging-Rule-Name")
public interface ChargingRuleName extends DiameterOctetString
{
}