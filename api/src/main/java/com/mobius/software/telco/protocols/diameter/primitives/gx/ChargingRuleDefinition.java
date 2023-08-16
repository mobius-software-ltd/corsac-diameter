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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.4 Charging-Rule-Definition AVP (All access types)

	The Charging-Rule-Definition AVP (AVP code 1003) is of type Grouped, and it defines the PCC rule sent by the PCRF
	to the PCEF. The Charging-Rule-Name AVP uniquely identifies the PCC rule and it is used to reference to a PCC rule
	in communication between the PCEF and the PCRF within one IP CAN session. The Flow-Information AVP(s) or the
	application detection filter referenced by the TDF-Application-Identifier AVP determines the traffic that belongs to the
	service data flow. Either Flow-Information AVP(s) or TDF-Application-Identifier AVP shall exist in a Charging-RuleDefinition AVP.
	
	If optional AVP(s) within a Charging-Rule-Definition AVP are omitted, but corresponding information has been
	provided in previous Gx messages, the previous information remains valid. If Flow-Information AVP(s) are supplied,
	they replace all previous Flow-Information AVP(s). If Flows AVP(s) are supplied, they replace all previous Flows
	AVP(s).
	
	The Default-Bearer-Indication AVP is an indicator for the PCRF to the PCEF whether the corresponding PCC rule shall
	be bound to the default bearer. If the Default-Bearer-Indication AVP with value “BIND_TO_DEF_BEARER (0)” is
	supplied or has been supplied within the most recent Default-Bearer-Indication AVP, information within the QoSClass-Identifier AVP and the Allocation-Retention-Priority AVP within the QoS-Information AVP shall not be used for
	bearer binding purposes.

	The PS-to-CS-Session-Continuity AVP indicates if a service data flow is a candidate for PS to CS session continuity.
	
	Flows AVP may appear if and only if AF-Charging-Identifier AVP is also present.

	AF-Signalling-Protocol AVP may appear if the PCC Rule applies for IMS signalling.

	Monitoring-Key AVP contains the monitoring key that may apply to the PCC rule.

	Mute-Notification status shall not be changed during the lifetime of the PCC rules.
	
	Sponsor-Identity AVP and Application-Service-Provider-Identity AVP shall be included if the Reporting-Level AVP is
	set to the value SPONSORED_CONNECTIVITY_LEVEL for the service data flow.

	Required-Access-Info AVP may appear if the AF requests PCRF to report user access network information.

	Sharing-Key-UL AVP and/or Sharing-Key-DL AVP may appear if the PCC rule is a candidate for resource sharing.

	Traffic-Steering-Policy-Identifier-UL AVP and/or Traffic-Steering-Policy-Identifier-DL AVP may appear if the traffic
	steering control is required for the service data flow. If the traffic steering policies are identical in both downlink and
	uplink directions, the values of the Traffic-Steering-Policy-Identifier-UL AVP and the Traffic-Steering-PolicyIdentifier-DL AVP shall be identical.

	The Content-Version AVP may be included if the PCC rule is installed or modified.

	The Max-PLR-DL AVP and/or Max-PLR-UL AVP may be included if the RAN-Support-Info feature is supported.

	The Calling-Party-Address AVP and Callee-Information AVP may be included if VBCLTE feature is supported.

	AVP Format: 

			Charging-Rule-Definition ::= < AVP Header: 1003 >
 						  { Charging-Rule-Name }
						  [ Service-Identifier ]
						  [ Rating-Group ]
						 *[ Flow-Information ]
						  [ Default-Bearer-Indication ]
						  [ TDF-Application-Identifier ]
						  [ Flow-Status ]
						  [ QoS-Information ]
						  [ PS-to-CS-Session-Continuity ]
						  [ Reporting-Level ]
						  [ Online ]
						  [ Offline ]
						  [ Max-PLR-DL ]
						  [ Max-PLR-UL ]
						  [ Metering-Method ]
						  [ Precedence ]
						  [ AF-Charging-Identifier ]
						 *[ Flows ]
						  [ Monitoring-Key]
				      0*2 [ Redirect-Information ]
						  [ Mute-Notification ]
						  [ AF-Signalling-Protocol ]
						  [ Sponsor-Identity ]
						  [ Application-Service-Provider-Identity ]
						 *[ Required-Access-Info ]
						  [ Sharing-Key-DL ]
						  [ Sharing-Key-UL ]
						  [ Traffic-Steering-Policy-Identifier-DL ]
						  [ Traffic-Steering-Policy-Identifier-UL ]
						  [ Content-Version ]
						 *[ Calling-Party-Address ]
						  [ Callee-Information ]
						 *[ AVP ] 
*/
@DiameterAvpDefinition(code = 1003L, vendorId = KnownVendorIDs.TGPP_ID, name = "Charging-Rule-Definition")
public interface ChargingRuleDefinition extends DiameterGroupedAvp
{
	Long getApplicationEntityID();
	
	void setApplicationEntityID(Long value);
	
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