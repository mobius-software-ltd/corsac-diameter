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

/**
*
* @author yulian oifa
*
*/

/*8.7.  Cost-Information AVP

   The Cost-Information AVP (AVP Code 423) is of type Grouped, and it is
   used to return the cost information of a service, which the
   credit-control client can transfer transparently to the end user.
   The included Unit-Value AVP contains the cost estimate (always of
   type "money") of the service in the case of price inquiries, or the
   accumulated cost estimation in the case of a credit-control session.

   The Currency-Code AVP specifies in which currency the cost was given.
   The Cost-Unit AVP specifies the unit when the service cost is a cost
   per unit (e.g., cost for the service is $1 per minute).

   When the Requested-Action AVP with the value PRICE_ENQUIRY is
   included in the Credit-Control-Request command, the Cost-Information
   AVP sent in the succeeding Credit-Control-Answer command contains the
   cost estimation for the requested service, without any reservations
   being made.
   
   The Cost-Information AVP included in the Credit-Control-Answer
   command with the CC-Request-Type set to UPDATE_REQUEST contains the
   accumulated cost estimation for the session, without taking any
   credit reservations into account.

   The Cost-Information AVP included in the Credit-Control-Answer
   command with the CC-Request-Type set to EVENT_REQUEST or
   TERMINATION_REQUEST contains the estimated total cost for the
   requested service.

   The Cost-Information AVP is defined as follows (per grouped-avp-def
   as defined in [RFC6733]):

                   Cost-Information ::= < AVP Header: 423 >
                                        { Unit-Value }
                                        { Currency-Code }
                                        [ Cost-Unit ]
*/

@DiameterAvpDefinition(code = AvpCodes.COST_INFORMATION, vendorId = -1, name = "Cost-Information")
public interface CostInformation extends CCMoney 
{
	String getCostUnit();
	
	void setCostUnit(String costUnit);
}