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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 8.46.  Subscription-Id AVP

   The Subscription-Id AVP (AVP Code 443) is used to identify the
   end user's subscription and is of type Grouped.  The Subscription-Id
   AVP includes a Subscription-Id-Data AVP that holds the identifier and
   a Subscription-Id-Type AVP that defines the identifier type.

   The Subscription-Id AVP is defined as follows (per grouped-avp-def as
   defined in [RFC6733]):

         Subscription-Id ::= < AVP Header: 443 >
                             { Subscription-Id-Type }
                             { Subscription-Id-Data }
 */

@DiameterAvpDefinition(code = AvpCodes.SUBSCRIPTION_ID, vendorId = -1, name = "Subscription-Id")
public interface SubscriptionId extends DiameterAvp 
{
	SubscriptionIdTypeEnum getSubscriptionIdType();
	
	void setSubscriptionIdType(SubscriptionIdTypeEnum value) throws MissingAvpException;
	
	String getSubscriptionIdData();
	
	void setSubscriptionIdData(String value) throws MissingAvpException;
}