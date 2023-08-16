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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 5.6.  Excess-Treatment AVP

   The Excess-Treatment AVP (AVP Code 577) is of type Grouped and
   indicates how out-of-profile traffic, i.e., traffic not covered by
   the original QoS-Profile-Template and QoS-Parameters AVPs, is
   treated.  The additional Treatment-Action, QoS-Profile-Template, and
   QoS-Parameters AVPs carried inside the Excess-Treatment AVP provide
   information about the QoS treatment of the excess traffic.  In case
   the Excess-Treatment AVP is absent, then the treatment of the out-of-
   profile traffic is left to the discretion of the node performing QoS
   treatment.

   Excess-Treatment ::= < AVP Header: 577 >
                        { Treatment-Action }
                        [ QoS-Profile-Template ]
                        [ QoS-Parameters ]
                      * [ AVP ]
 */
@DiameterAvpDefinition(code = 577L, vendorId = -1L, name = "Excess-Treatment")
public interface ExcessTreatment extends DiameterGroupedAvp
{
	TreatmentActionEnum getTreatmentAction();
	
	void setTreatmentAction(TreatmentActionEnum value);	
	
	QoSProfileTemplate getQoSProfileTemplate();
	
	void setQoSProfileTemplate(QoSProfileTemplate value);
	
	QoSParameters getQoSParameters();
	
	void setQoSParameters(QoSParameters value);
}