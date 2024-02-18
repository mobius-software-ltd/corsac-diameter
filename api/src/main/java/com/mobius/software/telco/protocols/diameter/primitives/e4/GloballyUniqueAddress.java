package com.mobius.software.telco.protocols.diameter.primitives.e4;
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

import com.mobius.software.telco.protocols.diameter.EtsiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.1 Globally-Unique-Address AVP
	The Globally-Unique-Address AVP (AVP code 300 13019) is of type Grouped.
	AVP Format:

	Globally-Unique-Address ::= < AVP Header: 300 13019 >
		 [Frame-IP-Address]
		 [Frame-IPv6-Prefix]
		 [Address-Realm] 
 */
@DiameterAvpDefinition(code = EtsiAvpCodes.GLOBALLY_UNIQUE_ADDRESS, vendorId = VendorIDs.ETSI_ID, name = "Globally-Unique-Address")
public interface GloballyUniqueAddress extends DiameterAvp
{
	Inet4Address getFrameIPAddress();
	
	void setFrameIPAddress(Inet4Address value);	
	
	ByteBuf getFrameIPv6Prefix();
	
	void setFrameIPv6Prefix(ByteBuf value);
	
	ByteBuf getAddressRealm();
	
	void setAddressRealm(ByteBuf value);
}