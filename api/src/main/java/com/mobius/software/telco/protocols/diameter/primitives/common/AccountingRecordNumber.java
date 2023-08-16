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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 9.8.3.   Accounting-Record-Number AVP

   The Accounting-Record-Number AVP (AVP Code 485) is of type Unsigned32
   and identifies this record within one session.  As Session-Id AVPs
   are globally unique, the combination of Session-Id and Accounting-
   Record-Number AVPs is also globally unique and can be used in
   matching accounting records with confirmations.  An easy way to
   produce unique numbers is to set the value to 0 for records of type
   EVENT_RECORD and START_RECORD and set the value to 1 for the first
   INTERIM_RECORD, 2 for the second, and so on until the value for
   STOP_RECORD is one more than for the last INTERIM_RECORD.
 */
@DiameterAvpDefinition(code = 485L, vendorId = -1L, name = "Accounting-Record-Number")
public interface AccountingRecordNumber extends DiameterUnsigned32
{
}