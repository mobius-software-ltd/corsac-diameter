package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.70	P-CSCF-Subscription-Info AVP
	The P-CSCF-Subscription-Info AVP is of type Grouped and it contains the P-CSCF''s subscription information. The Contact AVP contains the Contact Address and Parameters in the Contact header of the subscription request.
	AVP format

		P-CSCF-Subscription-Info ::= < AVP Header: 660, 10415>
			{ Call-ID-SIP-Header }
			{ From-SIP-Header }
			{ To-SIP-Header }
			{ Contact }
			*[ AVP ]
 */
@DiameterAvpDefinition(code = 660L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "P-CSCF-Subscription-Info")
public interface PCSCFSubscriptionInfo extends DiameterGroupedAvp
{
	ByteBuf getCallIDSIPHeader();
	
	void setCallIDSIPHeader(ByteBuf value);
	
	ByteBuf getFromSIPHeader();
	
	void setFromSIPHeader(ByteBuf value);
	
	ByteBuf getToSIPHeader();
	
	void setToSIPHeader(ByteBuf value);
	
	ByteBuf getContact();
	
	void setContact(ByteBuf value);	
}