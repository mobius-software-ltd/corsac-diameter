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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	9.7.  SIP-Deregistration-Reason AVP

   	The SIP-Deregistration-Reason AVP (AVP Code 383) is of type Grouped
   	and indicates the reason for a deregistration operation.

   	The SIP-Deregistration-Reason AVP is defined as follows (per the
   	grouped-avp-def of RFC 3588 [RFC3588]):

      SIP-Deregistration-Reason ::= < AVP Header: 383 >
                                    { SIP-Reason-Code }
                                    [ SIP-Reason-Info ]
                                  * [ AVP ]                            
 */
@DiameterAvpDefinition(code = 383L, vendorId = -1L, name = "SIP-Deregistration-Reason")
public interface SIPDeregistrationReason extends DiameterGroupedAvp
{
	SIPReasonCodeEnum getSIPReasonCode();
	
	void setSIPReasonCode(SIPReasonCodeEnum value);	
	
	String getSIPReasonInfo();
	
	void setSIPReasonInfo(String value);			
}