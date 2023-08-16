package com.mobius.software.telco.protocols.diameter.primitives.nas;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.2.7.  Connect-Info AVP

   The Connect-Info AVP (AVP Code 77) is of type UTF8String and is sent
   in the AA-Request message or an ACR message with the value of the
   Accounting-Record-Type AVP set to STOP.  When sent in the AA-Request,
   it indicates the nature of the user's connection.  The connection
   speed SHOULD be included at the beginning of the first Connect-Info
   AVP in the message.  If the transmit and receive connection speeds
   differ, both may be included in the first AVP with the transmit speed
   listed first (the speed at which the NAS modem transmits), then a
   slash (/), then the receive speed, and then other optional
   information.

   For example: "28800 V42BIS/LAPM" or "52000/31200 V90"

   If sent in an ACR message with the value of the Accounting-Record-
   Type AVP set to STOP, this attribute may summarize statistics
   relating to session quality.  For example, in IEEE 802.11, the
   Connect-Info AVP may contain information on the number of link layer
   retransmissions.  The exact format of this attribute is
   implementation specific.
 */
@DiameterAvpDefinition(code = 77L, vendorId = -1L, name = "Connect-Info")
public interface ConnectInfo extends DiameterUTF8String
{
}