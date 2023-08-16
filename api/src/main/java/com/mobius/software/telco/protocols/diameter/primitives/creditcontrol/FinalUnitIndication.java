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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/
/*
 * 
 * 8.34.  Final-Unit-Indication AVP

   The Final-Unit-Indication AVP (AVP Code 430) is of type Grouped and
   indicates that the Granted-Service-Unit AVP in the Credit-Control-
   Answer or in the AA-Answer contains the final units for the service.
   After these units have expired, the Diameter Credit-Control client is
   responsible for executing the action indicated in the Final-Unit-
   Action AVP (see Section 5.6).

   If more than one unit type is received in the Credit-Control-Answer,
   the unit type that first expired SHOULD cause the credit-control
   client to execute the specified action.

   In the first interrogation, the Final-Unit-Indication AVP with
   Final-Unit-Action set to REDIRECT or RESTRICT_ACCESS can also be
   present with no Granted-Service-Unit AVP in the Credit-Control-Answer
   or in the AA-Answer.  This indicates to the Diameter Credit-Control
   client that the client is to execute the specified action
   immediately.  If the home service provider policy is to terminate the
   service, naturally, the server SHOULD return the appropriate
   transient failure (see Section 9.1) in order to implement the policy-
   defined action.

   The Final-Unit-Action AVP defines the behavior of the Service Element
   when the user's account cannot cover the cost of the service and MUST
   always be present if the Final-Unit-Indication AVP is included in a
   command.

   If the Final-Unit-Action AVP is set to TERMINATE, the Final-Unit-
   Indication group AVP MUST NOT contain any other AVPs.

   If the Final-Unit-Action AVP is set to REDIRECT, the Redirect-Server
   AVP or the Redirect-Server-Extension AVP (at least one) MUST be
   present.  The Restriction-Filter-Rule AVP or the Filter-Id AVP MAY be
   present in the Credit-Control-Answer message if the user is also
   allowed to access other services that are not accessible through the
   address given in the Redirect-Server AVP.

   If the Final-Unit-Action AVP is set to RESTRICT_ACCESS, either the
   Restriction-Filter-Rule AVP or the Filter-Id AVP SHOULD be present.
   
   The Filter-Id AVP is defined in [RFC7155].  The Filter-Id AVP can be
   used to reference an IP filter list installed in the access device by
   means other than the Diameter Credit-Control application, e.g.,
   locally configured or configured by another entity.

   If the Final-Unit-Action AVP is set to REDIRECT and the type of
   server is not one of the enumerations in the Redirect-Address-Type
   AVP, then the QoS-Final-Unit-Indication AVP SHOULD be used together
   with the Redirect-Server-Extension AVP instead of the Final-Unit-
   Indication AVP.

   If the Final-Unit-Action AVP is set to RESTRICT_ACCESS or REDIRECT
   and the classification of the restricted traffic cannot be expressed
   using an IPFilterRule, or if actions (e.g., QoS) other than just
   allowing traffic need to be enforced, then the QoS-Final-Unit-
   Indication AVP SHOULD be used instead of the Final-Unit-Indication
   AVP.  However, if the credit-control server wants to preserve
   backward compatibility with credit-control clients that support only
   [RFC4006], the Final-Unit-Indication AVP SHOULD be used together with
   the Filter-Id AVP.

   The Final-Unit-Indication AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

         Final-Unit-Indication ::= < AVP Header: 430 >
                                   { Final-Unit-Action }
                                  *[ Restriction-Filter-Rule ]
                                  *[ Filter-Id ]
                                   [ Redirect-Server ]
 *
 */
@DiameterAvpDefinition(code = 430L, vendorId = -1, name = "Final-Unit-Indication")
public interface FinalUnitIndication extends DiameterAvp 
{
	FinalUnitActionEnum getFinalUnitAction();
	
	void setFinalUnitAction(FinalUnitActionEnum finalUnitAction);
	
	List<RestrictionFilterRule> getRestrictionFilterRule();
	
	void setRestrictionFilterRule(List<RestrictionFilterRule> restrictionFilterRule);	
	
	List<String> getFilterId();
	
	void setFilterId(List<String> filterId);	
	
	RedirectServer getRedirectServer();
	
	void setRedirectServer(RedirectServer redirectServer);	
}