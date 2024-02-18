package com.mobius.software.telco.protocols.diameter.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.48	Default-EPS-Bearer-QoS AVP
	The Default-EPS-Bearer-QoS AVP (AVP code 1049) is of type Grouped, and it defines the QoS information for the EPS default bearer. When this AVP is sent from the PCEF to the PCRF, it indicates the subscribed QoS for the default EPS bearer and/or the retained QoS for the default EPS bearer in the PCEF. When this AVP is sent from the PCRF to the PCEF, it indicates the authorized QoS for the default EPS bearer.
	The QoS class identifier identifies a set of IP-CAN specific QoS parameters that define QoS, excluding the applicable bitrates and ARP. When included in the Default-EPS-Bearer-QoS AVP, it shall include only non-GBR values.
	The Allocation-Retention-Priority AVP is an indicator of the priority of allocation and retention for the default bearer.
	AVP Format:

	Default-EPS-Bearer-QoS::= 	< AVP Header: 1049 >
		 [ QoS-Class-Identifier ]
		 [ Allocation-Retention-Priority ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DEFAULT_EPS_BEARER_QOS, vendorId = VendorIDs.TGPP_ID, must=false, name = "Default-EPS-Bearer-QoS")
public interface DefaultEPSBearerQoS extends DiameterGroupedAvp
{
	QoSClassIdentifierEnum getQoSClassIdentifier();
	
	void setQoSClassIdentifier(QoSClassIdentifierEnum value);	
	
	AllocationRetentionPriority getAllocationRetentionPriority();
	
	void setAllocationRetentionPriority(AllocationRetentionPriority value);
}