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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.6.9.  Acct-Link-Count AVP

   The Acct-Link-Count AVP (AVP Code 51) is of type Unsigned32 and
   indicates the total number of links that have been active (current or
   closed) in a given multilink session at the time the accounting
   record is generated.  This AVP MAY be included in Accounting-Request
   AVPs for any session that may be part of a multilink service.

   The Acct-Link-Count AVP may be used to make it easier for an
   accounting server to know when it has all the records for a given
   multilink service.  When the number of Accounting-Request AVPs
   received with Accounting-Record-Type = STOP_RECORD and with the same
   Acct-Multi-Session-Id and unique Session-Id AVPs equals the largest
   value of Acct-Link-Count seen in those Accounting-Request AVPs, all
   STOP_RECORD Accounting-Request AVPs for that multilink service have
   been received.

   The following example, showing eight Accounting-Request AVPs,
   illustrates how the Acct-Link-Count AVP is used.  In the table below,
   only the relevant AVPs are shown, although additional AVPs containing
   accounting information will be present in the Accounting-Requests
   AVPs.
 */
@DiameterAvpDefinition(code = 51L, vendorId = -1L, name = "Acct-Link-Count")
public interface AcctLinkCount extends DiameterUnsigned32
{
}