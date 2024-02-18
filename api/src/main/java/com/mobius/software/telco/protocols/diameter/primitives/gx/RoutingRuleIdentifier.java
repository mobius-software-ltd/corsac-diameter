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
 * 	5.3.71 Routing-Rule-Identifier AVP
	The Routing-Rule-Identifier AVP (AVP code 1077) is of type OctetString, and it defines a unique identifier for IP flow
	mobility routing rule or NBIFOM routing rule. It uniquely identifies a IP flow mobility routing rule or NBIFOM routing
	rule within one IP CAN session. The identifier value is assigned by the PCEF when instructing the PCRF to install the
	IP flow mobility routing rule. The identifier value is assigned by the PCEF or the PCRF for the NBIFOM as defined in
	subclause 4.3c.2.
	The Routing-Rule-Identifier AVP content shall be encoded as a UTF8String and begin with the type of node that
	assigned the NBIFOM routing ruleidentifier, i.e. "PCEF" or "PCRF", the remainder of the Routing-Rule-Identifier AVP
	is delimited by a ";" character and may be any sequence. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ROUTING_RULE_IDENTIFIER, vendorId = VendorIDs.TGPP_ID, must = false, name = "Routing-Rule-Identifier")
public interface RoutingRuleIdentifier extends DiameterOctetString
{
}