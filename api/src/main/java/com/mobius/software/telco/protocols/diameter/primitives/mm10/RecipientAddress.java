package com.mobius.software.telco.protocols.diameter.primitives.mm10;
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
 * 	6.3.11	Recipient-Address AVP
	The Recipient-Address AVP (AVP code 1108) is of type UTF8String. It contains the Recipient address of a multimedia message. The UTF8String identifying the Recipient shall be represented according to the following ABNF definition:
	Recipient-Address = {Recipient Type} {Recipient}
	Recipient Type = ( "To:" / "Cc:" / "Bcc:" )
	Recipient = Address ; Address is coded according to the MMS addressing model defined in [6].
 */
@DiameterAvpDefinition(code = 1108L, vendorId = -1L, name = "Recipient-Address")
public interface RecipientAddress extends DiameterUTF8String
{
}