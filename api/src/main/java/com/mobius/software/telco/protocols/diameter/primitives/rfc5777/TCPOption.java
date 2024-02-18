package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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
 * 4.1.8.6.  TCP-Option AVP

   The TCP-Option AVP (AVP Code 540) is of type Grouped and specifies a
   TCP header option that must be matched.

   TCP-Option ::= < AVP Header: 540 >
                  { TCP-Option-Type }
                * [ TCP-Option-Value ]
                  [ Negated ]
                * [ AVP ]

   If one or more TCP-Option-Value AVPs are present, one of the values
   MUST match the value in the TCP header option.  If the TCP-Option-
   Value AVP is absent, the option type MUST be present in the TCP
   header but the value is wild carded.

   The Negated AVP is used in conjunction that the TCP-Option-Value AVPs
   to specify TCP header options that do not match specific values.  The
   Negated AVP is used without the TCP-Option-Value AVP to specify TCP
   headers that do not contain the option type.
 */
@DiameterAvpDefinition(code = AvpCodes.TCP_OPTION, vendorId = -1L, name = "TCP-Option")
public interface TCPOption extends DiameterGroupedAvp
{
	TCPOptionTypeEnum getTCPOptionType();
	
	void setTCPOptionType(TCPOptionTypeEnum value) throws MissingAvpException;	
	
	ByteBuf getTCPOptionValue();
	
	void setTCPOptionValue(ByteBuf value);
	
	NegatedEnum getNegated();
	
	void setNegated(NegatedEnum value);			
}