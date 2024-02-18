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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 9.8.2.  Acct-Interim-Interval AVP

   The Acct-Interim-Interval AVP (AVP Code 85) is of type Unsigned32 and
   is sent from the Diameter home authorization server to the Diameter
   client.  The client uses information in this AVP to decide how and
   when to produce accounting records.  With different values in this
   AVP, service sessions can result in one, two, or two+N accounting
   records, based on the needs of the home organization.  The following
   accounting record production behavior is directed by the inclusion of
   this AVP:

   1.  The omission of the Acct-Interim-Interval AVP or its inclusion
       with Value field set to 0 means that EVENT_RECORD, START_RECORD,
       and STOP_RECORD are produced, as appropriate for the service.

   2.  The inclusion of the AVP with Value field set to a non-zero value
       means that INTERIM_RECORD records MUST be produced between the
       START_RECORD and STOP_RECORD records.  The Value field of this
       AVP is the nominal interval between these records in seconds.
       The Diameter node that originates the accounting information,
       known as the client, MUST produce the first INTERIM_RECORD record
       roughly at the time when this nominal interval has elapsed from
 	   the START_RECORD, the next one again as the interval has elapsed
       once more, and so on until the session ends and a STOP_RECORD
       record is produced.

       The client MUST ensure that the interim record production times
       are randomized so that large accounting message storms are not
       created either among records or around a common service start
       time.
 */
@DiameterAvpDefinition(code = AvpCodes.ACCT_INTERIM_INTERVAL, vendorId = -1L, name = "Acct-Interim-Interval")
public interface AcctInterimInterval extends DiameterUnsigned32
{
}