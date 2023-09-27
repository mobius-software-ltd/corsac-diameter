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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.157	PS-Furnish-Charging-Information AVP
	The PS-Furnish-Charging-Information AVP (AVP code 865) is of type Grouped. Its purpose is to add online charging session specific information, received via the Ro reference point, onto the Rf reference point in order to facilitate its inclusion in CDRs. This information element may be received in a CCA message via the Ro reference point. In situations where online and offline charging are active in parallel, the information element is transparently copied into an ACR to be sent on the Rf reference point. 
	It has the following ABNF grammar:

	PS-Furnish-Charging-Information :: = < AVP Header: 865>
		{ 3GPP-Charging-Id }
		{ PS-Free-Format-Data }
		[ PS-Append-Free-Format-Data ]
 */
@DiameterAvpDefinition(code = 865L, vendorId = KnownVendorIDs.TGPP_ID, name = "PS-Furnish-Charging-Information")
public interface PSFurnishChargingInformation extends DiameterAvp
{
	ByteBuf getTGPPChargingId();
	
	void setTGPPChargingId(ByteBuf value);
	
	ByteBuf getPSFreeFormatData();
	
	void setPSFreeFormatData(ByteBuf value);
	
	PSAppendFreeFormatDataEnum getPSAppendFreeFormatData();
	
	void setPSAppendFreeFormatData(PSAppendFreeFormatDataEnum value);
}