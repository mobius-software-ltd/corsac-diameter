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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.58A	Enhanced-Diagnostics AVP
	The Enhanced-Diagnostics AVP (AVP code 3901) is of type Grouped and provides a set of causes for the release. It complements the Change-Condition AVP for Offline Charging from PCN Nodes.
	It has the following ABNF grammar:

	Enhanced-Diagnostics :: = 	< AVP Header: 3901>
		*	[ RAN-NAS-Release-Cause ]

	NOTE: The RAN-NAS-Release-Cause AVP is under a grouped AVP to allow extensions to other types of release causes in the future. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ENHANCED_DIAGNOSTICS, vendorId = VendorIDs.TGPP_ID, name = "Enhanced-Diagnostics")
public interface EnhancedDiagnostics extends DiameterAvp
{
	List<ByteBuf> getRANNASReleaseCause();
	
	void setRANNASReleaseCause(List<ByteBuf> value);
}