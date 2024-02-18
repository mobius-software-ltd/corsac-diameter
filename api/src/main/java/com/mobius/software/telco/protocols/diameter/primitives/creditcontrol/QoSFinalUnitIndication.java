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
 * 8.68.  QoS-Final-Unit-Indication AVP

   The QoS-Final-Unit-Indication AVP (AVP Code 669) is of type Grouped
   and indicates that the Granted-Service-Unit AVP in the
   Credit-Control-Answer or in the AA-Answer contains the final units
   for the service.  After these units have expired, the Diameter
   Credit-Control client is responsible for executing the action
   indicated in the Final-Unit-Action AVP (see Section 5.6).

   If more than one unit type is received in the Credit-Control-Answer,
   the unit type that first expired SHOULD cause the credit-control
   client to execute the specified action.

   In the first interrogation, the QoS-Final-Unit-Indication AVP with
   Final-Unit-Action set to REDIRECT or RESTRICT_ACCESS can also be
   present with no Granted-Service-Unit AVP in the Credit-Control-Answer
   or in the AA-Answer.  This indicates to the Diameter Credit-Control
   client that the client is to execute the specified action
   
   immediately.  If the home service provider policy is to terminate the
   service, naturally, the server SHOULD return the appropriate
   transient failure (see Section 9.1) in order to implement the
   policy-defined action.

   The Final-Unit-Action AVP defines the behavior of the Service Element
   when the user's account cannot cover the cost of the service and MUST
   always be present if the QoS-Final-Unit-Indication AVP is included in
   a command.

   If the Final-Unit-Action AVP is set to TERMINATE, the QoS-Final-Unit-
   Indication group AVP MUST NOT contain any other AVPs.

   If the Final-Unit-Action AVP is set to REDIRECT, then the Redirect-
   Server-Extension AVP MUST be present.  The Filter-Rule AVP or the
   Filter-Id AVP MAY be present in the Credit-Control-Answer message if
   the user is also allowed to access other services that are not
   accessible through the address given in the Redirect-Server-Extension
   AVP or if access to these services needs to be limited in some way
   (e.g., QoS).

   If the Final-Unit-Action AVP is set to RESTRICT_ACCESS, either the
   Filter-Rule AVP or the Filter-Id AVP SHOULD be present.

   The Filter-Rule AVP is defined in [RFC5777].  The Filter-Rule AVP can
   be used to define a specific combination of a condition and an
   action.  If used only with traffic conditions, it should define which
   traffic should be allowed when no more service units are granted.
   However, if QoS or treatment information exists in the AVP, these
   actions should be executed, e.g., limiting the allowed traffic with
   certain QoS information.  When multiple Filter-Rule AVPs exist,
   precedence should be determined as defined in [RFC5777].

   The Filter-Id AVP is defined in [RFC7155].  The Filter-Id AVP can be
   used to reference an IP filter list installed in the access device by
   means other than the Diameter Credit-Control application, e.g.,
   locally configured or configured by another entity.

   If the Final-Unit-Action AVP is (1) set to TERMINATE, (2) set to
   RESTRICT_ACCESS and the action required is to allow only traffic that
   could be classified using an IPFilterRule, or (3) set to REDIRECT
   using a type that is one of the types in the Redirect-Address-Type
   AVP, then the credit-control server SHOULD send the information in
   the Final-Unit-Indication AVP, in addition to or instead of the
   QoS-Final-Unit-Indication AVP.  This is done in order to preserve
   backward compatibility with credit-control clients that support only
   [RFC4006].
   
   The QoS-Final-Unit-Indication AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

         QoS-Final-Unit-Indication ::= < AVP Header: 669 >
                                   { Final-Unit-Action }
                                  *[ Filter-Rule ]
                                  *[ Filter-Id ]
                                   [ Redirect-Server-Extension ]
                                  *[ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.QOS_FINAL_UNIT_INDICATION, vendorId = -1, must = false, name = "QoS-Final-Unit-Indication")
public interface QoSFinalUnitIndication extends DiameterGroupedAvp 
{
	FinalUnitActionEnum getFinalUnitAction();
	
	void setFinalUnitAction(FinalUnitActionEnum finalUnitAction) throws MissingAvpException;
	
	List<RestrictionFilterRule> getRestrictionFilterRule();
	
	void setRestrictionFilterRule(List<RestrictionFilterRule> restrictionFilterRule);	
	
	List<String> getFilterId();
	
	void setFilterId(List<String> filterId);	
	
	RedirectServerExtension getRedirectServerExtension();
	
	void setRedirectServerExtension(RedirectServerExtension redirectServerExtension);	
}