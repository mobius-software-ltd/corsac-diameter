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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	9.7.1.  SIP-Reason-Code AVP

   	The SIP-Reason-Code AVP (AVP Code 384) is of type Enumerated and
   	defines the reason for the network initiated deregistration.  The
   	following values are defined:

   	o  PERMANENT_TERMINATION (0)
   
   	o  NEW_SIP_SERVER_ASSIGNED (1)
   
   	o  SIP_SERVER_CHANGE (2)
   
   	o  REMOVE_SIP_SERVER (3)
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_REASON_CODE, vendorId = -1, name = "SIP-Reason-Code")
public interface SIPReasonCode extends DiameterEnumerated<SIPReasonCodeEnum>
{
}