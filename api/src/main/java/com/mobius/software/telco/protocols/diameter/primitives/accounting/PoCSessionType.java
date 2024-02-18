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
 * 	7.2.148 PoC-Session-Type AVP
	The PoC-Session-Type AVP (AVP code 884) is of type Enumerated and specifies the type of the PoC session. The
	identifier can be one of the following, refer Appendix C.5.1 in OMA PoC Control Plane specification [211]:

	0 1 to 1 PoC session
	1 Chat PoC group session
	2 Pre-arranged PoC group session
	3 Ad-hoc PoC group session 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.POC_SESSION_TYPE, vendorId = VendorIDs.TGPP_ID, name = "PoC-Session-Type")
public interface PoCSessionType extends DiameterEnumerated<PoCSessionTypeEnum>
{
}