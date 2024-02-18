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
 * 	7.2.154C ProSe-Direct-Discovery-Model AVP
	The ProSe-Direst-Discovery-Model AVP (AVP code 3442) is of type Enumerated and indicates model of the Direct
	Discovery used by the UE. It is referred to as "Prose Direct Discovery Model” in TS 23.303 [235].The AVP may take
	the values as follows:
	
	0 Model A
	1 Model B 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PROSE_DIRECT_DISCOVERY_MODEL, vendorId = VendorIDs.TGPP_ID, name = "ProSe-Direct-Discovery-Model")
public interface ProSeDirectDiscoveryModel extends DiameterEnumerated<ProSeDirectDiscoveryModelEnum>
{
}