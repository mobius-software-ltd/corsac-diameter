package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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
 * 8.13.  Credit-Control AVP

   The Credit-Control AVP (AVP Code 426) is of type Enumerated and MUST
   be included in AA-Request messages when the Service Element has
   credit-control capabilities.  The following values are defined for
   the Credit-Control AVP:

   CREDIT_AUTHORIZATION   0

   If the home Diameter AAA server determines that the user has a
   prepaid subscription, this value indicates that the credit-control
   server MUST be contacted to perform the first interrogation.  The
   value of the Credit-Control AVP MUST always be set to 0 in an
   AA-Request sent to perform the first interrogation and to initiate a
   new credit-control session.

   RE_AUTHORIZATION       1

   This value indicates to the Diameter AAA server that a credit-control
   session is ongoing for the subscriber and that the credit-control
   server MUST NOT be contacted.  The Credit-Control AVP set to the
   value of 1 is to be used only when the first interrogation has been
   successfully performed and the credit-control session is ongoing
   
   (i.e., re-authorization triggered by authorization lifetime).  This
   value MUST NOT be used in an AA-Request sent to perform the first
   interrogation.
 */
@DiameterAvpDefinition(code = AvpCodes.CREDIT_CONTROL, vendorId = -1L, name = "Credit-Control")
public interface CreditControl extends DiameterEnumerated<CreditControlEnum>
{
}