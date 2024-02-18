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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned64;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.6.1.  Accounting-Input-Octets AVP

   The Accounting-Input-Octets AVP (AVP Code 363) is of type Unsigned64
   and contains the number of octets received from the user.

   For NAS usage, this AVP indicates how many octets have been received
   from the port in the course of this session.  It can only be present
   in ACR messages with an Accounting-Record-Type [RFC6733] of
   INTERIM_RECORD or STOP_RECORD.
 */
@DiameterAvpDefinition(code = AvpCodes.ACCOUNTING_INPUT_OCTETS, vendorId = -1L, name = "Accounting-Input-Octets")
public interface AccountingInputOctets extends DiameterUnsigned64
{
}