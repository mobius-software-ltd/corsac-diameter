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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * Exactly one sub-AVP MUST be included inside the Subscription-Id-
   Extension AVP.

   The Subscription-Id-Extension AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

         Subscription-Id-Extension ::= < AVP Header: 659 >
                                   [ Subscription-Id-E164 ]
                                   [ Subscription-Id-IMSI ]
                                   [ Subscription-Id-SIP-URI ]
                                   [ Subscription-Id-NAI ]
                                   [ Subscription-Id-Private ]
                                   [ AVP ]
 */

@DiameterAvpDefinition(code = 659L, vendorId = -1, must = false, name = "Subscription-Id-Extension")
public interface SubscriptionIdExtension extends DiameterGroupedAvp 
{
	String getE164();
	
	void setE164(String e164);
	
	String getIMSI();
	
	void setIMSI(String imsi);
	
	String getSIPURI();
	
	void setSIPURI(String sipURI);
	
	String getNAI();
	
	void setNAI(String nai);
	
	String getPrivate();
	
	void setPrivate(String uePrivate);
}