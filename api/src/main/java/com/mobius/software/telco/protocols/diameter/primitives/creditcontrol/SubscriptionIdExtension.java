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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 8.58.  Subscription-Id-Extension AVP

   The Subscription-Id-Extension AVP (AVP Code 659) is used to identify
   the end user's subscription and is of type Grouped.  The
   Subscription-Id-Extension group AVP MUST include an AVP holding the
   subscription identifier.  The type of this included AVP indicates the
   type of the subscription identifier.  For each of the enumerated
   values of the Subscription-Id-Type AVP, there is a corresponding
   sub-AVP for use within the Subscription-Id-Extension group AVP.  If a
   new identifier type is required, a corresponding new sub-AVP SHOULD
   be defined for use within the Subscription-Id-Extension group AVP.

   If full backward compatibility with [RFC4006] is required, then the
   Subscription-Id AVP MUST be used to indicate identifier types
   enumerated in the Subscription-Id-Type AVP, whereas the Subscription-
   Id-Extension AVP MUST be used only for newly defined identifier
   types.  If full backward compatibility with [RFC4006] is not
   required, then the Subscription-Id-Extension AVP MAY be used to carry
   the existing identifier types.  In this case, the Subscription-Id-
   Extension AVP MAY be sent together with the Subscription-Id AVP.

   Exactly one sub-AVP MUST be included inside the Subscription-Id-
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

@DiameterAvpDefinition(code = AvpCodes.SUBSCRIPTION_ID_EXTENSION, vendorId = -1, must = false, name = "Subscription-Id-Extension")
public interface SubscriptionIdExtension extends DiameterGroupedAvp 
{
	String getE164();
	
	void setE164(String e164) throws MissingAvpException;
	
	String getIMSI();
	
	void setIMSI(String imsi) throws MissingAvpException;
	
	String getSIPURI();
	
	void setSIPURI(String sipURI) throws MissingAvpException;
	
	String getNAI();
	
	void setNAI(String nai) throws MissingAvpException;
	
	String getPrivate();
	
	void setPrivate(String uePrivate) throws MissingAvpException;
}