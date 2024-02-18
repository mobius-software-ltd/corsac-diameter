package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 *	5.3.69	5GS-RAN-NAS-Release-Cause AVP (3GPP-5GS and Non-3GPP-5GS access type)
	The 5GS-RAN-NAS-Release-Cause AVP (AVP code 572) is of type Grouped, and indicates the RAN or NAS release cause code information in 3GPP-5GS and non-3GPP-5GS access types.
	AVP Format:

		5GS-RAN-NAS-Release-Cause ::= < AVP Header: 572 >
					  [5GMM-Cause]
					  [5GSM-Cause]
					  [NGAP-Cause]
					 *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.FIVE_GS_RAN_NAS_RELEASE_CAUSE, vendorId = VendorIDs.TGPP_ID, must = false, name = "5GS-RAN-NAS-Release-Cause")
public interface FiveGSRANNASReleaseCause extends DiameterGroupedAvp
{
	Long get5GMMCause();
	
	void set5GMMCause(Long value);
	
	Long get5GSMCause();
	
	void set5GSMCause(Long value);	
	
	NGAPCause getNGAPCause();
	
	void setNGAPCause(NGAPCause value);	
}