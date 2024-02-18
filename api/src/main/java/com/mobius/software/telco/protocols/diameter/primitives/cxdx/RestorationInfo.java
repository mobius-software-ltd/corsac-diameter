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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.52	Restoration-Info AVP
	The Restoration-Info AVP is of type Grouped and it contains the information related to a specific registration required for an S-CSCF to handle the requests for a user. The Contact AVP contains the Contact Address and Parameters in the Contact header of the registration request.
	AVP format

		Restoration-Info ::= < AVP Header: 649, 10415>
			 { Path }
			 { Contact }
			 [ Initial-CSeq-Sequence-Number ]
			 [ Call-ID-SIP-Header ]
			 [ Subscription-Info ]
			 [ P-CSCF-Subscription-Info ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RESTORATION_INFO, vendorId = VendorIDs.TGPP_ID, must = false, name = "Restoration-Info")
public interface RestorationInfo extends DiameterGroupedAvp
{
	ByteBuf getPath();
	
	void setPath(ByteBuf value) throws MissingAvpException;
	
	ByteBuf getContact();
	
	void setContact(ByteBuf value) throws MissingAvpException;
	
	Long getInitialCSeqSequenceNumber();
	
	void setInitialCSeqSequenceNumber(Long value);
	
	ByteBuf getCallIDSIPHeader();
	
	void setCallIDSIPHeader(ByteBuf value);
	
	SubscriptionInfo getSubscriptionInfo();
	
	void setSubscriptionInfo(SubscriptionInfo value);
	
	PCSCFSubscriptionInfo getPCSCFSubscriptionInfo();
	
	void setPCSCFSubscriptionInfo(PCSCFSubscriptionInfo value);
}