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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.120 Number-Portability-Routing-Information AVP
	The Number-Portability-Routing-Information AVP (AVP code 2024) is of type UTF8String and holds information on
	routing number received by the node (e.g. S-CSCF) performing number portability look-up (ENUM/DNS). This
	information is also sent over SIP in the Requested URI header enabling other IMS nodes receiving this header to also
	report this information. 
 */
@DiameterAvpDefinition(code = 2024L, vendorId = KnownVendorIDs.TGPP_ID, name = "Number-Portability-Routing-Information")
public interface NumberPortabilityRoutingInformation extends DiameterUTF8String
{
}