package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.84	LCS-Info
	The LCS-Info AVP is of type Grouped. This AVP shall contain the following LCS related information for a subscriber:
	-	list of GMLCs in the HPLMN that are permitted to issue a call/session unrelated or call/session related MT-LR location request for this UE;
	-	privacy exception list that is applicable only over the S6d interface;
	-	MO-LR list.

	AVP format
	LCS-Info ::= <AVP header: 1473 10415>
		*[ GMLC-Number]
		*[ LCS-PrivacyException ]
		*[ MO-LR ]
		*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LCS_INFO, vendorId = VendorIDs.TGPP_ID, name = "LCS-Info")
public interface LCSInfo extends DiameterGroupedAvp
{
	List<String> getGMLCNumber();
	
	void setGMLCNumber(List<String> value);	
	
	List<LCSPrivacyException> getLCSPrivacyException();
	
	void setLCSPrivacyException(List<LCSPrivacyException> value);	
	
	List<MOLR> getMOLR();
	
	void setMOLR(List<MOLR> value);	
}