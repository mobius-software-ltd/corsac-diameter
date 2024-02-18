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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 6.  QoS Capability Indication

   The QoS-Capability AVP (AVP Code 578) is of type Grouped and contains
   a list of supported Quality of Service profile templates (and
   therefore the support of the respective parameter AVPs).

   The QoS-Capability AVP may be used for a simple announcement of the
   QoS capabilities and QoS profiles supported by a peer.  It may also
   be used to negotiate a mutually supported set of QoS capabilities and
   
   QoS profiles between two peers.  In such a case, handling of failed
   negotiations is application and/or deployment specific.

   QoS-Capability ::= < AVP Header: 578 >
                    1*{ QoS-Profile-Template }
                    * [ AVP ]

   The QoS-Profile-Template AVP is defined in Section 5.3.
 */
@DiameterAvpDefinition(code = AvpCodes.QOS_CAPABILITY, vendorId = -1L, name = "QoS-Capability")
public interface QoSCapability extends DiameterGroupedAvp
{
	List<QoSProfileTemplate> getQoSProfileTemplate();
	
	void setQoSProfileTemplate(List<QoSProfileTemplate> value) throws MissingAvpException;
}