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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.97 Low-Balance-Indication AVP
	The Low-Balance-Indication AVP (AVP code 2020) is of type Enumerated and indicates if the subscriber balance went
	below a designated threshold by its account. This indication can be used to advise the end user about the need to
	replenish his balance. It can be one of the following values:
	
	0 NOT-APPLICABLE
	1 YES 
 */
@DiameterAvpDefinition(code = 2020L, vendorId = KnownVendorIDs.TGPP_ID, name = "Low-Balance-Indication")
public interface LowBalanceIndication extends DiameterEnumerated<LowBalanceIndicationEnum>
{
}