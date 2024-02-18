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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/
/*
 * 7.5.  Failed-AVP AVP

   The Failed-AVP AVP (AVP Code 279) is of type Grouped and provides
   debugging information in cases where a request is rejected or not
   fully processed due to erroneous information in a specific AVP.  The
   value of the Result-Code AVP will provide information on the reason
   for the Failed-AVP AVP.  A Diameter answer message SHOULD contain an
   instance of the Failed-AVP AVP that corresponds to the error
   indicated by the Result-Code AVP.  For practical purposes, this
   Failed-AVP would typically refer to the first AVP processing error
   that a Diameter node encounters.

   The possible reasons for this AVP are the presence of an improperly
   constructed AVP, an unsupported or unrecognized AVP, an invalid AVP
   value, the omission of a required AVP, the presence of an explicitly
   excluded AVP (see tables in Section 10) or the presence of two or
   more occurrences of an AVP that is restricted to 0, 1, or 0-1
   occurrences.

   A Diameter message SHOULD contain one Failed-AVP AVP, containing the
   entire AVP that could not be processed successfully.  If the failure
   reason is omission of a required AVP, an AVP with the missing AVP
   code, the missing Vendor-Id, and a zero-filled payload of the minimum
   required length for the omitted AVP will be added.  If the failure
   reason is an invalid AVP length where the reported length is less
   
   than the minimum AVP header length or greater than the reported
   message length, a copy of the offending AVP header and a zero-filled
   payload of the minimum required length SHOULD be added.

   In the case where the offending AVP is embedded within a Grouped AVP,
   the Failed-AVP MAY contain the grouped AVP, which in turn contains
   the single offending AVP.  The same method MAY be employed if the
   grouped AVP itself is embedded in yet another grouped AVP and so on.
   In this case, the Failed-AVP MAY contain the grouped AVP hierarchy up
   to the single offending AVP.  This enables the recipient to detect
   the location of the offending AVP when embedded in a group.

   AVP Format

         <Failed-AVP> ::= < AVP Header: 279 >
                       1* {AVP}
 */
@DiameterAvpDefinition(code = AvpCodes.FAILED_AVP, vendorId = -1L, name = "Failed-Avp")
public interface FailedAvp extends DiameterGroupedAvp
{

}