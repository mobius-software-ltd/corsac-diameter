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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned64;

/**
*
* @author yulian oifa
*
*/
/*
 * 9.8.6.  Accounting-Sub-Session-Id AVP

   The Accounting-Sub-Session-Id AVP (AVP Code 287) is of type
   Unsigned64 and contains the accounting sub-session identifier.  The
   combination of the Session-Id and this AVP MUST be unique per sub-
   session, and the value of this AVP MUST be monotonically increased by
   one for all new sub-sessions.  The absence of this AVP implies no
   sub-sessions are in use, with the exception of an Accounting-Request
   whose Accounting-Record-Type is set to STOP_RECORD.  A STOP_RECORD
   message with no Accounting-Sub-Session-Id AVP present will signal the
   termination of all sub-sessions for a given Session-Id.
 */
@DiameterAvpDefinition(code = AvpCodes.ACCOUNTING_SUB_SESSION_ID, vendorId = -1L, name = "Accounting-Sub-Session-Id")
public interface AccountingSubSessionId extends DiameterUnsigned64
{
}