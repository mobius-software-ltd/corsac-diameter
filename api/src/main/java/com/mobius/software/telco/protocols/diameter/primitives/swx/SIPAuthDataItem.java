package com.mobius.software.telco.protocols.diameter.primitives.swx;
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
 *	8.2.3.9	SIP-Auth-Data-Item
	The SIP-Auth-Data-Item AVP is defined in 3GPP TS 29.229 [24]. The optional AVPs that are needed in SWx reference point are included in the ABNF representation below.
	AVP format:
	
	SIP-Auth-Data-Item ::=	< AVP Header: 612 10415 >
			 [ SIP-Item-Number ]
			 [ SIP-Authentication-Scheme ]
			 [ SIP-Authenticate ]
			 [ SIP-Authorization ]
			 [ Confidentiality-Key ]
			 [ Integrity-Key ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = 612L, vendorId = KnownVendorIDs.TGPP_ID, name = "SIP-Auth-Data-Item")
public interface SIPAuthDataItem extends DiameterGroupedAvp
{
	Long getSIPItemNumber();
	
	void setSIPItemNumber(Long value);
	
	String getSIPAuthenticationScheme();
	
	void setSIPAuthenticationScheme(String value);
	
	ByteBuf getSIPAuthenticate();
	
	void setSIPAuthenticate(ByteBuf value);
	
	ByteBuf getSIPAuthorization();
	
	void setSIPAuthorization(ByteBuf value);
	
	ByteBuf getConfidentialityKey();
	
	void setConfidentialityKey(ByteBuf value);
	
	ByteBuf getIntegrityKey();
	
	void setIntegrityKey(ByteBuf value);
}