package com.mobius.software.telco.protocols.diameter.primitives.sgmb;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;

/**
*
* @author yulian oifa
*
*/

/*
	20.5a.11	Diagnostic-Info AVP
	The Diagnostic-Info AVP (AVP code 933) is of type Unsigned32.
	It shall contain a bit mask. The meaning of the bits shall be as defined in table 20.5a.11.1:
	Table 20.5a.11.1 : Diagnostic-Info

	Bit Name
	Description

	0 UPFAIL
	User Plane Failure:
	This bit, when set, indicates the detection of a User Plane Failure by the MBMS GW (see subclause 20.3.2.1 of 3GPP TS 23.007 [104]).

	NOTE: 	Bits not defined in this table shall be cleared by the sending MBMS GW and ignored by the receiving BM-SC.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DIAGNOSTIC_INFO, vendorId = VendorIDs.TGPP_ID, must = false, name = "Diagnostic-Info")
public interface DiagnosticInfo extends DiameterBitmask32
{
	public static final int UPFAIL_BIT = 0;	
	
	public void setUPFAILBit(boolean isOn);
	
	public boolean isUPFAILBitSet();
}