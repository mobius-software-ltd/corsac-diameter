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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddress;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.199 SGSN-Address AVP
	The SGSN-Address AVP (AVP code 1228) is of type Address and holds the IP-address of the SGSN/Serving Node (e.g.
	S-GW, AGW, ePDG, TWAG from the P-GW/TDF and S4-SGSN, MME from the S-GW) that was used during a report.
 */
@DiameterAvpDefinition(code = 1228L, vendorId = KnownVendorIDs.TGPP_ID, name = "SGSN-Address")
public interface SGSNAddress extends DiameterAddress
{
}