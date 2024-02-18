package com.mobius.software.telco.protocols.diameter.primitives.t6a;
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
 * 	6.4.21	Serving-PLMN-Rate-Control
	The Serving-PLMN-Rate-Control AVP is of type Grouped and shall contain.
	The AVP format shall conform to:
	
	Serving-PLMN-Rate-Control::=	<AVP header: 4310 10415>
			 [ Uplink-Rate-Limit ]
			 [ Downlink-Rate-Limit ]
			*[AVP]

	A Downlink-Rate-Limit set to 0 shall be interpreted that the Serving PLMN Rate Control for downlink messages is deactivated in the MME. If the Serving PLMN Rate Control is activated, the value of Downlink-Rate-Limit shall not be less than 10, see 3GPP TS 23.401 [25].
	An Uplink-Rate-Limit set ot 0 shall be interpreted that the Serving PLMN Rate Control for uplink messages is deactivated in the MME. If Serving PLMN Rate Control is activated, the value of Uplink-Rate-Limit shall not be less than 10, see 3GPP TS 23.401 [25].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SERVING_PLMN_RATE_CONTROL, vendorId = VendorIDs.TGPP_ID, name = "Serving-PLMN-Rate-Control")
public interface ServingPLMNRateControl extends DiameterGroupedAvp
{
	Long getUplinkRateLimit();
	
	void setUplinkRateLimit(Long value);
	
	Long getDownlinkRateLimit();
	
	void setDownlinkRateLimit(Long value);
}