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
 * 8.3.  CC-Request-Type AVP

   The CC-Request-Type AVP (AVP Code 416) is of type Enumerated and
   contains the reason for sending the Credit-Control-Request message.
   It MUST be present in all Credit-Control-Request messages.  The
   following values are defined for the CC-Request-Type AVP (the value
   of 0 (zero) is reserved):

   INITIAL_REQUEST       1

   This request is used to initiate a credit-control session.  It
   contains credit-control information that is relevant to the
   initiation.

   UPDATE_REQUEST        2

   This request contains credit-control information for an existing
   credit-control session.  Credit-control requests of this type SHOULD
   be sent every time a credit-control re-authorization is needed at the
   expiry of the allocated quota or validity time.  Further, additional
   service-specific events MAY trigger a spontaneous UPDATE_REQUEST.

   TERMINATION_REQUEST   3

   This request is sent to terminate a credit-control session.  It
   contains credit-control information relevant to the existing session.
   
   EVENT_REQUEST         4

   This request is used when there is no need to maintain any
   credit-control session state in the credit-control server.  It
   contains all information relevant to the service and is the only
   request of the service.  The reason for this request is further
   detailed in the Requested-Action AVP.  The Requested-Action AVP MUST
   be included in the Credit-Control-Request message when CC-Request-
   Type is set to EVENT_REQUEST.   
 */
@DiameterAvpDefinition(code = AvpCodes.CC_REQUEST_TYPE, vendorId = -1L, name = "CC-Request-Type")
public interface CcRequestType extends DiameterEnumerated<CcRequestTypeEnum>
{
}