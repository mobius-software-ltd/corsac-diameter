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
 * 	7.2.138 PDP-Context-Type AVP
	The PDP-Context-Type AVP (AVP code 1247) is of type Enumerated and indicates the type of a PDP context. The
	values for requested are:
	
	0 Primary
	1 Secondary
	
	This AVP shall only be present in the CCR[Initial]. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PDP_CONTEXT_TYPE, vendorId = VendorIDs.TGPP_ID, name = "PDP-Context-Type")
public interface PDPContextType extends DiameterEnumerated<PDPContextTypeEnum>
{
}