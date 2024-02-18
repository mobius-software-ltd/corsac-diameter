package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 3.2.  Filter-Rule AVP

   The Filter-Rule AVP (AVP Code 509) is of type Grouped and defines a
   specific condition and action combination.

                       Filter-Rule ::= < AVP Header: 509 >
                                    [ Filter-Rule-Precedence ]

                                    ; Condition part of a Rule
                                    ; ------------------------

                                    [ Classifier ]
                                  * [ Time-Of-Day-Condition ]

                                    ; Action and Meta-Data
                                    ; --------------------

                                    [ Treatment-Action ]

                                    ; Info about QoS related Actions
                                    ; ------------------------------

                                    [ QoS-Semantics ]
                                    [ QoS-Profile-Template ]
                                    [ QoS-Parameters ]
                                    [ Excess-Treatment ]


                                    ; Extension Point
                                    ; ---------------
                                  * [ AVP ]

   If the QoS-Profile-Template AVP is not included in the Filter-Rule
   AVP and the Treatment-Action AVP is set to 'shape' or 'mark' then the
   default setting is assumed, namely, a setting of the Vendor-Id AVP to
   0 (for IETF) and the QoS-Profile-Id AVP to zero (0) (for the profile
   defined in [RFC5624]).  Note that the content of the QoS-Parameters
   are defined in the respective specification defining the QoS
   parameters.  When the Vendor-Id AVP is set to 0 (for IETF) and the

   QoS-Profile-Id AVP is set to zero (0), then the AVPs included in the
   QoS-Parameters AVP are the AVPs defined in [RFC5624].
 */
@DiameterAvpDefinition(code = AvpCodes.FILTER_RULE, vendorId = -1L, name = "Filter-Rule")
public interface FilterRule extends DiameterGroupedAvp
{
	Long getFilterRulePrecedence();
	
	void setFilterRulePrecedence(Long value);	
	
	Classifier getClassifier();
	
	void setClassifier(Classifier value);
	
	List<TimeOfDayCondition> getTimeOfDayCondition();
	
	void setTimeOfDayCondition(List<TimeOfDayCondition> value);
	
	TreatmentActionEnum getTreatmentAction();
	
	void setTreatmentAction(TreatmentActionEnum value);	
	
	QoSSemanticsEnum getQoSSemantics();
	
	void setQoSSemantics(QoSSemanticsEnum value);	
	
	QoSProfileTemplate getQoSProfileTemplate();
	
	void seQoSProfileTemplate(QoSProfileTemplate value);	
	
	QoSParameters getQoSParameters();
	
	void setQoSParameters(QoSParameters value);	
	
	ExcessTreatment getExcessTreatment();
	
	void setExcessTreatment(ExcessTreatment value);	
}