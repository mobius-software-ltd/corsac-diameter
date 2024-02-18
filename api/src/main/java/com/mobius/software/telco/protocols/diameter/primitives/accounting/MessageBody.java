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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.103	Message-Body AVP
	The Message-Body AVP (AVP Code 889) is of type Grouped AVP and holds information about the message bodies including user-to-user data.
	It has the following ABNF grammar:
	
	<Message-Body>::=		< AVP Header: 889 >
			{ Content-Type }
			{ Content-Length }
			[ Content-Disposition ]
			[ Originator ]

	The message bodies shall not include the bodies' of Content-Type = "application-sdp" as these are captured in other AVPs.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MESSAGE_BODY, vendorId = VendorIDs.TGPP_ID, name = "Message-Body")
public interface MessageBody extends DiameterAvp
{
	String getContentType();
	
	void setContentType(String value) throws MissingAvpException;
	
	Long getContentLength();
	
	void setContentLength(Long value) throws MissingAvpException;
	
	String getContentDisposition();
	
	void setContentDisposition(String value);
	
	OriginatorEnum getOriginator();
	
	void setOriginator(OriginatorEnum value);
}