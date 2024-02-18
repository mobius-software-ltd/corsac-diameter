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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.OneM2MAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	A.4.14. M2M-Information AVP
 *  The M2M-Information AVP (AVP code 1011) is of type Grouped. Its purpose is to allow the transmission of service information elements used for OneM2M specific charging.
	It has the following ABNF grammar:
	M2M-Information :: =  < AVP Header: 1011>
		
			[ Application-Entity-ID ]
			[ External-ID ]
			[ Receiver ]
			[ Originator ]
			[ Hosting-CSE-ID ]
			[ Target-ID ]
			[ Protocol-Type ]
			[ Request-Operation ]
			[ Request-Headers-Size ]
			[ Request-Body-Size ]
			[ Response-Headers-Size ]
			[ Response-Body-Size ]
			[ Response-Status-Code ]
			[ Rating-Group ]
			[ M2M-Event-Record-Timestamp ]
			[ Control-Memory-Size ]
			[ Data-Memory-Size ]
			[ Access-Network-Identifier ]
			[ Occupancy ]
			[ Group-Name ]
			[ Maximum-Number-Members ]
			[ Current-Number-Members ]
			[ Subgroup-Name ]
			[ Node-Id ]
 		  * [ AVP ]
 */
@DiameterAvpDefinition(code = OneM2MAvpCodes.M2M_INFORMATION, vendorId = VendorIDs.ONEM2M_ID, name = "M2M-Information")
public interface M2MInformation extends DiameterGroupedAvp
{
	String getApplicationEntityID();
	
	void setApplicationEntityID(String value);
	
	String getExternalID();
	
	void setExternalID(String value);	
	
	String getReceiver();
	
	void setReceiver(String value);	
	
	String getOriginator();
	
	void setOriginator(String value);	
	
	String getHostingCSEID();
	
	void setHostingCSEID(String value);	
	
	String getTargetID();
	
	void setTargetID(String value);	
	
	ProtocolTypeEnum getProtocolType();
	
	void setProtocolType(ProtocolTypeEnum value);	
	
	RequestOperationEnum getRequestOperation();
	
	void setRequestOperation(RequestOperationEnum value);	
	
	Long getRequestHeadersSize();
	
	void setRequestHeadersSize(Long value);	
	
	Long getRequestBodySize();
	
	void setRequestBodySize(Long value);	
	
	Long getResponseHeadersSize();
	
	void setResponseHeadersSize(Long value);	
	
	Long getResponseBodySize();
	
	void setResponseBodySize(Long value);	
	
	ResponseStatusCodeEnum getResponseStatusCode();
	
	void setResponseStatusCode(ResponseStatusCodeEnum value);	
	
	Long getRatingGroup();
	
	void setRatingGroup(Long value);	
	
	Date getM2MEventRecordTimestamp();
	
	void setM2MEventRecordTimestamp(Date value);	
	
	Long getControlMemorySize();
	
	void setControlMemorySize(Long value);	
	
	Long getDataMemorySize();
	
	void setDataMemorySize(Long value);	
	
	Long getAccessNetworkIdentifier();
	
	void setAccessNetworkIdentifier(Long value);	
	
	Long getOccupancy();
	
	void setOccupancy(Long value);	
	
	String getGroupName();
	
	void setGroupName(String value);	
	
	Long getMaximumNumberMembers();
	
	void setMaximumNumberMembers(Long value);	
	
	Long getCurrentNumberMembers();
	
	void setCurrentNumberMembers(Long value);	
	
	String getSubgroupName();
	
	void setSubgroupName(String value);	
	
	String getNodeId();
	
	void setNodeId(String value);	 				  
}