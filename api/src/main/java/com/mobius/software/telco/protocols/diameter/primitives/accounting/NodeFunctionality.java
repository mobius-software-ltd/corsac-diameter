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
 * 	7.2.113 Node-Functionality AVP
	The Node-Functionality AVP (AVP code 862) is of type Enumerated and includes the functionality identifier of the
	node. The functionality identifier can be one of the following:
	
	0 S-CSCF
	1 P-CSCF
	2 I-CSCF
	3 MRFC
	4 MGCF
	5 BGCF
	6 AS
	7 IBCF
	8 S-GW
	9 P-GW
	10 HSGW
	11 E-CSCF
	12 MME
	13 TRF
	14 TF
	15 ATCF
	16 Proxy Function
	17 ePDG
	18 TDF
	19 TWAG
	20 SCEF
	21 IWK-SCEF 
 */
@DiameterAvpDefinition(code = 862L, vendorId = KnownVendorIDs.TGPP_ID, name = "Node-Functionality")
public interface NodeFunctionality extends DiameterEnumerated<NodeFunctionalityEnum>
{
}