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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.8.11.  ICMP-Type

   The ICMP-Type AVP (AVP Code 545) is of type Grouped and specifies an
   ICMP message type that must be matched.

   ICMP-Type ::= < AVP Header: 545 >
                 { ICMP-Type-Number }
               * [ ICMP-Code ]
                 [ Negated ]
               * [ AVP ]

   If the ICMP-Code AVP is present, the value MUST match that in the
   ICMP header.  If the ICMP-Code AVP is absent, the ICMP type MUST be
   present in the ICMP header but the code is wild carded.

   The Negated AVP is used in conjunction with the ICMP-Code AVPs to
   specify ICMP codes that do not match specific values.  The Negated
   AVP is used without the ICMP-Code AVP to specify ICMP headers that do
   not contain the ICMP type.  As such, the Negated AVP feature applies
   to ICMP-Code AVP if the ICMP-Code AVP is present.  If the ICMP-Code
   AVP is absent, the Negated AVP feature applies to the ICMP-Type-
   Number.
 */
@DiameterAvpDefinition(code = AvpCodes.ICMP_TYPE, vendorId = -1L, name = "ICMP-Type")
public interface ICMPType extends DiameterGroupedAvp
{
	ICMPTypeNumberEnum getICMPTypeNumber();
	
	void setICMPTypeNumber(ICMPTypeNumberEnum value) throws MissingAvpException;	
	
	List<ICMPCodeEnum> getICMPCode();
	
	void setICMPCode(List<ICMPCodeEnum> value);	
	
	NegatedEnum getNegated();
	
	void setNegated(NegatedEnum value);			
}