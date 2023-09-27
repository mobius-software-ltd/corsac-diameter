package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.PriorityIndicationEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.205B	SM-Device-Trigger-Information AVP
	The SM-Device-Trigger-Information AVP (AVP code 3405) is of type Grouped and holds the specific device trigger details for the Short Message.
	It has the following ABNF grammar:
	
	SM-Device-Trigger-Information :: =   < AVP Header: 3405>
		[ MTC-IWF-Address ]
		[ Reference-Number ]
		[ Serving-Node ]
		[ Validity-Time ]
		[ Priority-Indication ]
		[ Application-Port-Identifier ] 
 */
@DiameterAvpDefinition(code = 3405L, vendorId = KnownVendorIDs.TGPP_ID, name = "SM-Device-Trigger-Information")
public interface SMDeviceTriggerInformation extends DiameterAvp
{
	InetAddress getMTCIWFAddress();
	
	void setMTCIWFAddress(InetAddress value);
	
	Long getReferenceNumber();
	
	void setReferenceNumber(Long value);
	
	ServingNode getServingNode();
	
	void setServingNode(ServingNode value);
	
	Long getValidityTime();
	
	void setValidityTime(Long value);
	
	PriorityIndicationEnum getPriorityIndication();
	
	void setPriorityIndication(PriorityIndicationEnum value);
	
	Long getApplicationPortIdentifier();
	
	void setApplicationPortIdentifier(Long value);
}