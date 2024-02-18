package com.mobius.software.telco.protocols.diameter.primitives.common;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 9.8.5.  Acct-Multi-Session-Id AVP

   The Acct-Multi-Session-Id AVP (AVP Code 50) is of type UTF8String,
   following the format specified in Section 8.8.  The Acct-Multi-
   Session-Id AVP is used to link multiple related accounting sessions,
   where each session would have a unique Session-Id but the same Acct-
   Multi-Session-Id AVP.  This AVP MAY be returned by the Diameter
   server in an authorization answer, and it MUST be used in all
   accounting messages for the given session.
 */
@DiameterAvpDefinition(code = AvpCodes.ACCT_MULTI_SESSION_ID, vendorId = -1L, name = "Subscription-Id-Data")
public interface AcctMultiSessionId extends DiameterUTF8String
{
}