package com.mobius.software.telco.protocols.diameter.primitives.gq;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.5 V4-Transport-address AVP
	The V4-Transport-Address AVP (AVP code 454) is of type Grouped and contains a single IPv4 address and a single
	port number.
	AVP format:

	V4-Transport-Address ::= < AVP Header: 454 13019>
		 { Framed-IP-Address } ;
		 { Port-Number }
*/
@DiameterAvpDefinition(code = EtsiAvpCodes.V4_TRANSPORT_ADDRESS, vendorId = VendorIDs.ETSI_ID, must = false, name = "V4-Transport-Address")
public interface V4TransportAddress extends DiameterAvp
{
	Inet4Address getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value) throws MissingAvpException;	
	
	Long getPortNumber();
	
	void setPortNumber(Long value) throws MissingAvpException;
}