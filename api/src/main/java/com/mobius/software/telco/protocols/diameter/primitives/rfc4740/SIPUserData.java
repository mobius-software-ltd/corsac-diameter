package com.mobius.software.telco.protocols.diameter.primitives.rfc4740;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
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
 * 	9.12.  SIP-User-Data AVP

   	The SIP-User-Data AVP (AVP Code 389) is of type Grouped.  This AVP
   	allows the Diameter server to transport user-specific data, such as a
   	user profile, to the SIP server (in the Diameter client).  The
   	Diameter server selects a type of user data that is understood by the
   	SIP server in the Diameter client, and has been indicated in a
   	SIP-Supported-User-Data-Type AVP.  In case the Diameter client
   	indicated support for several types of user data, the Diameter server
   	SHOULD choose the first type supported by the client.

   	The SIP-User-Data grouped AVP contains a SIP-User-Data-Type AVP that
   	indicates the type of user data included in the
   	SIP-User-Data-Contents-AVP.

   	The SIP-User-Data AVP is defined as follows (per the grouped-avp-def
   	of RFC 3588 [RFC3588]):

      SIP-User-Data ::= < AVP Header: 389 >
                        { SIP-User-Data-Type }
                        { SIP-User-Data-Contents }
                      * [ AVP ]                            
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_USER_DATA, vendorId = -1L, name = "SIP-User-Data")
public interface SIPUserData extends DiameterGroupedAvp
{
	String getSIPUserDataType();
	
	void setSIPUserDataType(String value) throws MissingAvpException;	
	
	ByteBuf getSIPUserDataContents();
	
	void setSIPUserDataContents(ByteBuf value) throws MissingAvpException;			
}