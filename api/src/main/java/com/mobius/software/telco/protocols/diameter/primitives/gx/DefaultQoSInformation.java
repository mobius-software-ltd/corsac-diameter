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
 * 	5.3.103	Default-QoS-Information AVP (FBA access type)
	The Default-QoS-Information AVP (AVP code 2816) is of type Grouped, and it defines the Default QoS information for the IP-CAN session in the Fixed Broadband Access.When this AVP is sent from the PCEF to the PCRF, it indicates the default QoS information provided by the Fixed Broadband Access network. When this AVP is sent from the PCRF to the PCEF, it indicates the authorized Default QoS for the IP-CAN session.
	The Default-QoS-Information AVP can be dynamically provided or preconfigured in the PCEF. When dynamically provided, it consists of a QCI (QoS-Class-Identifier AVP) and MBR (Max-Requested-Bandwidth-UL AVP and Max-Requested-Bandwidth-DL AVP). When it is preconfigured in the PCEF it consists of the default QoS profile name included in Default-QoS-Name AVP.
	The QoS-Class-Identifier AVP identifies a set of IP-CAN specific QoS parameters that define the Default QoS.
	The Max-Requested-Bandwidth-UL AVP defines the maximum bit rate allowed for the uplink direction.
	The Max-Requested-Bandwidth-DL AVP defines the maximum bit rate allowed for the downlink direction.
	The Default-QoS-Name AVP defines the default QoS profile pre-defined in the PCEF.
	If the Default-QoS-Information AVP is omitted in a Diameter message, the previous information remains valid.
	AVP Format:

	Default-QoS-Information ::= 	< AVP Header: 2816 >
		 [ QoS-Class-Identifier ]
		 [ Max-Requested-Bandwidth-UL ]
		 [ Max-Requested-Bandwidth-DL ]
		 [ Default-QoS-Name ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DEFAULT_QOS_INFORMATION, vendorId = VendorIDs.TGPP_ID, must=false, name = "Default-QoS-Information")
public interface DefaultQoSInformation extends DiameterGroupedAvp
{
	QoSClassIdentifierEnum getQoSClassIdentifier();
	
	void setQoSClassIdentifier(QoSClassIdentifierEnum value);	
	
	Long getMaxRequestedBandwidthUL();
	
	void setMaxRequestedBandwidthUL(Long value);	
	
	Long getMaxRequestedBandwidthDL();
	
	void setMaxRequestedBandwidthDL(Long value);	
	
	String getDefaultQoSName();
	
	void setDefaultQoSName(String value);
}