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

import java.net.Inet4Address;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *	6.3.13	SIP-Auth-Data-Item AVP
	The SIP-Auth-Data-Item is of type Grouped, and contains the authentication and/or authorization information for the Diameter client.
	AVP format

		SIP-Auth-Data-Item :: = < AVP Header : 612 10415 >
			[ SIP-Item-Number ]
			[ SIP-Authentication-Scheme ]
			[ SIP-Authenticate ]
			[ SIP-Authorization ]
			[ SIP-Authentication-Context ]
			[ Confidentiality-Key ]
			[ Integrity-Key ]
			[ SIP-Digest-Authenticate ]
			[ Framed-IP-Address ]
			[ Framed-IPv6-Prefix ]
			[ Framed-Interface-Id ]
		  * [ Line-Identifier ]
		  * [AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SIP_AUTH_DATA_ITEM, vendorId = VendorIDs.TGPP_ID, name = "SIP-Auth-Data-Item")
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
	
	ByteBuf getSIPAuthenticationContext();
	
	void setSIPAuthenticationContext(ByteBuf value);
	
	ByteBuf getConfidentialityKey();
	
	void setConfidentialityKey(ByteBuf value);
	
	ByteBuf getIntegrityKey();
	
	void setIntegrityKey(ByteBuf value);
	
	SIPDigestAuthenticate getSIPDigestAuthenticate();
	
	void setSIPDigestAuthenticate(SIPDigestAuthenticate value);
	
	Inet4Address getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);
	
	Long getFramedInterfaceId();
	
	void setFramedInterfaceId(Long value);
	
	List<ByteBuf> getLineIdentifier();
	
	void setLineIdentifier(List<ByteBuf> value);
}