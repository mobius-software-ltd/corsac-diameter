package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.37	Service-Result
	The Service-Result AVP is of type Grouped, and it contains the Error code identified during the handling of the Requested action for the Monitoring event.
	AVP format:

	Service-Result ::=	<AVP header: 3146 10415>
			 [ Vendor-Id ]
			 [ Service-Result-Code ]
			*[AVP]

	If the Service-Result-Code contains an Experimental-Result-Code value defined by 3GPP, then the Vendor-Id shall be set to the value 10415. If the Service-Result-Code contains a Result-Code value defined in the Diameter base protocol by IETF (see IETF RFC 6733 [23]), then the Vendor-Id shall be absent or set to the value 0.
 */
@DiameterAvpDefinition(code = 3146L, vendorId = KnownVendorIDs.TGPP_ID, name = "Service-Result")
public interface ServiceResult extends DiameterGroupedAvp
{
	Long getVendorId();
	
	void setVendorId(Long value);
	
	Long getServiceResultCode();
	
	void setServiceResultCode(Long value);
}