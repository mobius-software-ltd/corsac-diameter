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
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerCapabilities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SessionPriorityEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.77	IMS-Information AVP
	The IMS-Information AVP (AVP code 876) is of type Grouped. Its purpose is to allow the transmission of additional IMS service specific information elements. 
	It has the following ABNF grammar:

	IMS-Information :: = 	  < AVP Header: 876>
				[ Event-Type ]
				[ Role-Of-Node ]
				{ Node-Functionality }
				[ User-Session-Id ]
				[ Outgoing-Session-Id ]
				[ Session-Priority ]
		    *  	[ Calling-Party-Address ]
				[ Called-Party-Address ]
		    *  	[ Called-Asserted-Identity ]
				[ Called-Identity-Change ]
				[ Number-Portability-Routing-Information ]
				[ Carrier-Select-Routing-Information ]
				[ Alternate-Charged-Party-Address ]
		    *  	[ Requested-Party-Address ]
		    *  	[ Associated-URI ]
				[ Time-Stamps ]
		 	*  	[ Application-Server-Information ]
		 	*  	[ Inter-Operator-Identifier ]
		 	*	[ Transit-IOI-List ]
				[ IMS-Charging-Identifier ]
		 	*  	[ SDP-Session-Description ]
		 	*  	[ SDP-Media-Component ]	
				[ Served-Party-IP-Address ]
				[ Server-Capabilities ]
				[ Trunk-Group-ID ]
				[ Bearer-Service ]
				[ Service-Id ]
		 	*  	[ Service-Specific-Info ]
		 	*  	[ Message-Body ]
				[ Cause-Code ] 
		 	*  	[ Reason-Header ]
		 	*	[ Access-Network-Information ]
				[ Cellular-Network-Information ] 
		 	*  	[ Early-Media-Description ] 
				[ IMS-Communication-Service-Identifier ] 
				[ IMS-Application-Reference-Identifier ]
				[ Online-Charging-Flag ]
				[ Real-Time-Tariff-Information ]
				[ Account-Expiration ]
				[ Initial-IMS-Charging-Identifier ]
		 	* 	[ NNI-Information ] 
				[ From-Address ] 
				[ IMS-Emergency-Indicator ]
				[ IMS-Visited-Network-Identifier ]
			*  	[ Access-Network-Info-Change ]
		 	*  	[ Access-Transfer-Information ]
				[ Related-IMS-Charging-Identifier ]
				[ Related-IMS-Charging-Identifier-Node ]
				[ Route-Header-Received ]
				[ Route-Header-Transmitted ]
				[ Instance-Id ]
				[TAD-Identifier] 
				[FE-Identifier-List]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.IMS_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "IMS-Information")
public interface IMSInformation extends DiameterAvp
{
	EventType getEventType();
	
	void setEventType(EventType value);
	
	RoleOfNodeEnum getRoleOfNode();
	
	void setRoleOfNode(RoleOfNodeEnum value);
	
	NodeFunctionalityEnum getNodeFunctionality();
	
	void setNodeFunctionality(NodeFunctionalityEnum value) throws MissingAvpException;
	
	String getUserSessionId();
	
	void setUserSessionId(String value);
	
	String getOutgoingSessionId();
	
	void setOutgoingSessionId(String value);
	
	SessionPriorityEnum getSessionPriority();
	
	void setSessionPriority(SessionPriorityEnum value);
	
	List<String> getCallingPartyAddress();
	
	void setCallingPartyAddress(List<String> value);
	
	String getCalledPartyAddress();
	
	void setCalledPartyAddress(String value);
	
	List<String> getCalledAssertedIdentity();
	
	void setCalledAssertedIdentity(List<String> value);
	
	CalledIdentityChange getCalledIdentityChange();
	
	void setCalledIdentityChange(CalledIdentityChange value);
	
	String getNumberPortabilityRoutingInformation();
	
	void setNumberPortabilityRoutingInformation(String value);
	
	String getCarrierSelectRoutingInformation();
	
	void setCarrierSelectRoutingInformation(String value);
	
	String getAlternateChargedPartyAddress();
	
	void setAlternateChargedPartyAddress(String value);
	
	List<String> getRequestedPartyAddress();
	
	void setRequestedPartyAddress(List<String> value);
	
	List<String> getAssociatedURI();
	
	void setAssociatedURI(List<String> value);
	
	TimeStamps getTimeStamps();
	
	void setTimeStamps(TimeStamps value);
	
	List<ApplicationServerInformation> getApplicationServerInformation();
	
	void setApplicationServerInformation(List<ApplicationServerInformation> value);
	
	List<InterOperatorIdentifier> getInterOperatorIdentifier();
	
	void setInterOperatorIdentifier(List<InterOperatorIdentifier> value);
	
	List<String> getTransitIOIList();
	
	void setTransitIOIList(List<String> value);
	
	String getIMSChargingIdentifier();
	
	void setIMSChargingIdentifier(String value);
	
	List<String> getSDPSessionDescription();
	
	void setSDPSessionDescription(List<String> value);
	
	List<SDPMediaComponent> getSDPMediaComponent();
	
	void setSDPMediaComponent(List<SDPMediaComponent> value);
	
	InetAddress getServedPartyIPAddress();
	
	void setServedPartyIPAddress(InetAddress value);
	
	ServerCapabilities getServerCapabilities();
	
	void setServerCapabilities(ServerCapabilities value);
	
	TrunkGroupID getTrunkGroupID();
	
	void setTrunkGroupID(TrunkGroupID value);
	
	ByteBuf getBearerService();
	
	void setBearerService(ByteBuf value);
	
	String getServiceID();
	
	void setServiceID(String value);
	
	List<ServiceSpecificInfo> getServiceSpecificInfo();
	
	void setServiceSpecificInfo(List<ServiceSpecificInfo> value);
	
	List<MessageBody> getMessageBody();
	
	void setMessageBody(List<MessageBody> value);
	
	Long getCauseCode();
	
	void setCauseCode(Long value);
	
	List<String> getReasonHeader();
	
	void setReasonHeader(List<String> value);
	
	List<ByteBuf> getAccessNetworkInformation();
	
	void setAccessNetworkInformation(List<ByteBuf> value);
	
	ByteBuf getCellularNetworkInformation();
	
	void setCellularNetworkInformation(ByteBuf value);
	
	List<EarlyMediaDescription> getEarlyMediaDescription();
	
	void setEarlyMediaDescription(List<EarlyMediaDescription> value);
	
	String getIMSCommunicationServiceIdentifier();
	
	void setIMSCommunicationServiceIdentifier(String value);
	
	String getIMSApplicationReferenceIdentifier();
	
	void setIMSApplicationReferenceIdentifier(String value);
	
	OnlineChargingFlagEnum getOnlineChargingFlag();
	
	void setOnlineChargingFlag(OnlineChargingFlagEnum value);
	
	RealTimeTariffInformation getRealTimeTariffInformation();
	
	void setRealTimeTariffInformation(RealTimeTariffInformation value);
	
	Date getAccountExpiration();
	
	void setAccountExpiration(Date value);
	
	String getInitialIMSChargingIdentifier();
	
	void setInitialIMSChargingIdentifier(String value);	
	
	List<NNIInformation> getNNIInformation();
	
	void setNNIInformation(List<NNIInformation> value);
	
	String getFromAddress();
	
	void setFromAddress(String value);	
	
	IMSEmergencyIndicatorEnum getIMSEmergencyIndicator();
	
	void setIMSEmergencyIndicator(IMSEmergencyIndicatorEnum value);	
	
	String getIMSVisitedNetworkIdentifier();
	
	void setIMSVisitedNetworkIdentifier(String value);	
	
	List<AccessNetworkInfoChange> getAccessNetworkInfoChange();
	
	void setAccessNetworkInfoChange(List<AccessNetworkInfoChange> value);
	
	List<AccessTransferInformation> getAccessTransferInformation();
	
	void setAccessTransferInformation(List<AccessTransferInformation> value);
	
	String getRelatedIMSChargingIdentifier();
	
	void setRelatedIMSChargingIdentifier(String value);	
	
	RelatedIMSChargingIdentifierNode getRelatedIMSChargingIdentifierNode();
	
	void setRelatedIMSChargingIdentifierNode(RelatedIMSChargingIdentifierNode value);	
	
	String getRouteHeaderReceived();
	
	void setRouteHeaderReceived(String value);	
	
	String getRouteHeaderTransmitted();
	
	void setRouteHeaderTransmitted(String value);	
	
	String getInstanceId();
	
	void setInstanceId(String value);	
	
	TADIdentifierEnum getTADIdentifier();
	
	void setTADIdentifier(TADIdentifierEnum value);	
	
	String getFEIdentifierList();
	
	void setFEIdentifierList(String value);
}