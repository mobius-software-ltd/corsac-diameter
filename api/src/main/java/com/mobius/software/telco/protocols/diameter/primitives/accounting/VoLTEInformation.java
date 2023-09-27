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
import com.mobius.software.telco.protocols.diameter.primitives.rx.CalleeInformation;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.242C	VoLTE-Information AVP
	The VoLTE-Information AVP (AVP code 1323) is of type Grouped, and it contains the caller and callee Information of VoLTE. 
	It has the following ABNF grammar:
	
	VoLTE-Information ::=	< AVP Header: 1323 >
			[ Calling-Party-Address ]
			[ Callee-Information ]
 */
@DiameterAvpDefinition(code = 1323L, vendorId = KnownVendorIDs.TGPP_ID, name = "VoLTE-Information")
public interface VoLTEInformation extends DiameterAvp
{
	String getCallingPartyAddress();
	
	void setCallingPartyAddress(String value);
	
	CalleeInformation getCalleeInformation();
	
	void setCalleeInformation(CalleeInformation value);
}