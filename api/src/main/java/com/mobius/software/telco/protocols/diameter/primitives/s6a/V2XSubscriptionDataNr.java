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
 * 	7.3.235	V2X-Subscription-Data-Nr
	The V2X-Subscription-Data-Nr AVP is of type Grouped. It shall contain the V2X related subscription data for the network scheduled NR sidelink communication.
	AVP format:

	V2X-Subscription-Data-Nr ::= <AVP header: 1710 10415>
			 [ V2X-Permission ]
			 [ UE-PC5-AMBR ]
			 [ UE-PC5-QoS ]
			*[AVP]

	The UE-PC5-AMBR AVP within the V2X-Subscription-Data AVP indicates the UE AMBR used for NR PC5 interface.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.V2X_SUBSCRIPTION_DATA_NR, vendorId = VendorIDs.TGPP_ID, must = false, name = "V2X-Subscription-Data-Nr")
public interface V2XSubscriptionDataNr extends DiameterGroupedAvp
{
	V2XPermission getV2XPermission();
	
	void setV2XPermission(V2XPermission value);
	
	Long getUEPC5AMBR();
	
	void setUEPC5AMBR(Long value);
	
	UEPC5QoS getUEPC5QoS();
	
	void setUEPC5QoS(UEPC5QoS value);
}