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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUri;

/**
*
* @author yulian oifa
*
*/

/*
	9.1.1.  SIP-Accounting-Server-URI AVP
   	The SIP-Accounting-Server-URI AVP (AVP Code 369) is of type
   	DiameterURI.  This AVP contains the address of a Diameter server that
   	is able to receive SIP-session-related accounting information.
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_ACCOUNTING_SERVER_URI, vendorId = -1, name = "SIP-Accounting-Server-URI")
public interface SIPAccountingServerURI extends DiameterUri
{
}