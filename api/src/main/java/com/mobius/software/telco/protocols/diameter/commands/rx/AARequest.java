package com.mobius.software.telco.protocols.diameter.commands.rx;
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

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFRequestedData;
import com.mobius.software.telco.protocols.diameter.primitives.rx.CalleeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.IMSContentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MPSActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaComponentDescription;
import com.mobius.software.telco.protocols.diameter.primitives.rx.PreEmptionControlInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfoEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RxRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SIPForkingIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ServiceInfoStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsoredConnectivityData;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.1	AA-Request (AAR) command
	The AAR command, indicated by the Command-Code field set to 265 and the ‘R’ bit set in the Command Flags field, is sent by an AF to the PCRF in order to provide it with the Session Information.
	Message Format:

	<AA-Request> ::= < Diameter Header: 265, REQ, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 [ Destination-Host ]
				 [ IP-Domain-Id ]
				 [ Auth-Session-State ]
				 [ AF-Application-Identifier ]
				*[ Media-Component-Description ]
				 [ Service-Info-Status ]
				 [ AF-Charging-Identifier ]
				 [ SIP-Forking-Indication ]
				*[ Specific-Action ]
				*[ Subscription-Id ]
				 [ OC-Supported-Features ]
				*[ Supported-Features ]
				 [ Reservation-Priority ]
				 [ Framed-IP-Address ]
				 [ Framed-Ipv6-Prefix ]
				 [ Called-Station-Id ]
				 [ Service-URN ]
				 [ Sponsored-Connectivity-Data ]
				 [ MPS-Identifier ]
				 [ GCS-Identifier ]
				 [ MCPTT-Identifier ]
				 [ MCVideo-Identifier ]
				 [ IMS-Content-Identifier ]
				 [ IMS-Content-Type ]
				*[ Calling-Party-Address ]
				 [ Callee-Information ]
				 [ Rx-Request-Type ]
				*[ Required-Access-Info ]
				 [AF-Requested-Data ]
				 [ Reference-Id ]
				 [ Pre-emption-Control-Info ]
				 [ MPS-Action ]
				 [ Origin-State-Id ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.RX, commandCode = CommandCodes.AAA, request = true, proxyable = true, name="AA-Request")
public interface AARequest extends RxRequest
{	
	public ByteBuf getIPDomainId();
	
	void setIPDomainId(ByteBuf value);				
	
	public AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);				
	
	public ByteBuf getAFApplicationIdentifier();
	
	void setAFApplicationIdentifier(ByteBuf value);				
	
	public List<MediaComponentDescription> getMediaComponentDescription();
	
	void setMediaComponentDescription(List<MediaComponentDescription> value);				
	
	public ServiceInfoStatusEnum getServiceInfoStatus();
	
	void setServiceInfoStatus(ServiceInfoStatusEnum value);				
	
	public ByteBuf getAFChargingIdentifier();
	
	void setAFChargingIdentifier(ByteBuf value);				
		
	public SIPForkingIndicationEnum getSIPForkingIndication();
	
	void setSIPForkingIndication(SIPForkingIndicationEnum value);				
	
	public List<SpecificActionEnum> getSpecificAction();
	
	void setSpecificAction(List<SpecificActionEnum> value);				
	
	public List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> value);				
	
	public List<SupportedFeatures> getSupportedFeatures();
	
	void setSupportedFeatures(List<SupportedFeatures> value);				
	
	public ReservationPriorityEnum getReservationPriority();
	
	void setReservationPriority(ReservationPriorityEnum value);				
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);	
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	ByteBuf getServiceURN();
	
	void setServiceURN(ByteBuf value);	
	
	SponsoredConnectivityData getSponsoredConnectivityData();
	
	void setSponsoredConnectivityData(SponsoredConnectivityData value);	
	
	ByteBuf getMPSIdentifier();
	
	void setMPSIdentifier(ByteBuf value);	
	
	ByteBuf getGCSIdentifier();
	
	void setGCSIdentifier(ByteBuf value);	
	
	ByteBuf getMCPTTIdentifier();
	
	void setMCPTTIdentifier(ByteBuf value);	
	
	ByteBuf getMCVideoIdentifier();
	
	void setMCVideoIdentifier(ByteBuf value);	
	
	ByteBuf getIMSContentIdentifier();
	
	void setIMSContentIdentifier(ByteBuf value);	
	
	IMSContentTypeEnum getIMSContentType();
	
	void setIMSContentType(IMSContentTypeEnum value);	
	
	public List<String> getCallingPartyAddress();
	
	void setCallingPartyAddress(List<String> value);				
	
	CalleeInformation getCalleeInformation();
	
	void setCalleeInformation(CalleeInformation value);	
	
	RxRequestTypeEnum getRxRequestType();
	
	void setRxRequestType(RxRequestTypeEnum value);	
	
	public List<RequiredAccessInfoEnum> getRequiredAccessInfo();
	
	void setRequiredAccessInfo(List<RequiredAccessInfoEnum> value);				
	
	AFRequestedData getAFRequestedData();
	
	void setAFRequestedData(AFRequestedData value);	
	
	ByteBuf getReferenceId();
	
	void setReferenceId(ByteBuf value);	
	
	PreEmptionControlInfo getPreemptionControlInfo();
	
	void setPreemptionControlInfo(PreEmptionControlInfo value);	
	
	MPSActionEnum getMPSAction();
	
	void setMPSAction(MPSActionEnum value);		
}