package com.mobius.software.telco.protocols.diameter.primitives.pc4a;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.2	ProSe-Subscription-Data
	The ProSe-Subscription-Data AVP is of type Group. It shall contain the ProSe related subscription data.
	AVP format

	ProSe-Subscription-Data ::= <AVP header: 3701 10415>
		 { ProSe-Permission }
		*[ ProSe-Allowed-PLMN ] 
		 [ 3GPP-Charging-Characteristics ]
		*[AVP]

	The Authorized-Discovery-Range Information Element should only be present if the Visited-PLMN-Id is the PLMN-Id of the HPLMN; otherwise it should be absent.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PROSE_SUBSCRIPTION_DATA, vendorId = VendorIDs.TGPP_ID, name = "ProSe-Subscription-Data")
public interface ProSeSubscriptionData extends DiameterGroupedAvp
{
	ProSePermission getProSePermission();
	
	void setProSePermission(ProSePermission value) throws MissingAvpException;
	
	List<ProSeAllowedPLMN> getProSeAllowedPLMN();
	
	void setProSeAllowedPLMN(List<ProSeAllowedPLMN> value);	
	
	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);
}