package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.35	APN-Configuration
	The APN-Configuration AVP is of type Grouped. It shall contain the information related to the user's subscribed APN configurations. The Context-Identifier in the APN-Configuration AVP shall identify that APN configuration, and it shall not have a value of zero. Furthermore, the Context-Identifier in the APN-Configuration AVP shall uniquely identify the EPS APN configuration per subscription. For a particular EPS user having multiple APN configurations, the Service-Selection AVP values shall be unique across APN-Configuration AVPs.
	The AVP format shall conform to:
	
	APN-Configuration ::= <AVP header: 1430 10415>
				{ Context-Identifier }
			* 2 [ Served-Party-IP-Address ]
				{ PDN-Type }
				{ Service-Selection}
				[ EPS-Subscribed-QoS-Profile ]
				[ VPLMN-Dynamic-Address-Allowed ]
				[MIP6-Agent-Info ]
				[ Visited-Network-Identifier ]
				[ PDN-GW-Allocation-Type ]
				[ 3GPP-Charging-Characteristics ]
				[ AMBR ]
			*	[ Specific-APN-Info ]
				[ APN-OI-Replacement ]
				[ SIPTO-Permission ]
				[ LIPA-Permission ]
				[ Restoration-Priority ]
				[ SIPTO-Local-Network-Permission ]
				[ WLAN-offloadability ]
				[ Non-IP-PDN-Type-Indicator ]
				[ Non-IP-Data-Delivery-Mechanism ]
				[ SCEF-ID ]
				[ SCEF-Realm ]
				[ Preferred-Data-Mode ]
				[ PDN-Connection-Continuity ]
				[ RDS-Indicator ]
				[ Interworking-5GS-Indicator ]
				[ Ethernet-PDN-Type-Indicator ]
			*	[ AVP ]

	The AMBR included in this grouped AVP shall include the AMBR associated to this specific APN configuration (APN-AMBR).
	The Served-Party-IP-Address AVP may be present 0, 1 or 2 times. These AVPs shall be present if static IP address allocation is used for the UE, and they shall contain either of:
	-	an IPv4 address, or
	-	an IPv6 address/prefix, or
	-	both, an IPv4 address and an IPv6 address/prefix.
	For the IPv6 prefix, the lower 64 bits of the address shall be set to zero.
	The PDN-GW-Allocation-Type AVP applies to the MIP6-Agent-Info AVP. Therefore, it shall not be present if MIP6-Agent-Info is not present.
	The APN-OI-Replacement included in this grouped AVP shall include the APN-OI-Replacement associated with this APN configuration. This APN-OI-Replacement has higher priority than UE level APN-OI-Replacement.
	The Visited-Network-Identifier AVP indicates the PLMN where the PGW was allocated, in case of dynamic PGW assignment.

	NOTE:	If interworking with MAP is needed, the Context-Identifier will be in the range of 1 and 50.

	The Non-IP-Data-Delivery-Mechanism shall only be present when Non-IP-PDN-Type-Indicator is set to TRUE (1).
	The SCEF-ID AVP and the SCEF-Realm AVP shall only be present when Non-IP-PDN-Type-Indicator is set to TRUE (1), and Non-IP-Data-Delivery-Mechanism is set to SCEF-BASED-DATA-DELIVERY (1).
	The RDS-Indicator may be present when Non-IP-PDN-Type-Indicator is set to TRUE (1), and Non-IP-Data-Delivery-Mechanism is set to SCEF-BASED-DATA-DELIVERY (1).
	Absence of PDN-Connection-Continuity AVP indicates that the handling is left to local VPLMN policy.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.APN_CONFIGURATION, vendorId = VendorIDs.TGPP_ID, name = "APN-Configuration")
public interface APNConfiguration extends DiameterGroupedAvp
{
	Long getContextIdentifier();
	
	void setContextIdentifier(Long value) throws MissingAvpException;	
	
	List<InetAddress> getServedPartyIPAddress();
	
	void setServedPartyIPAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException;
	
	PDNTypeEnum getPDNType();
	
	void setPDNType(PDNTypeEnum value) throws MissingAvpException;
	
	String getServiceSelection();
	
	void setServiceSelection(String value) throws MissingAvpException;
	
	EPSSubscribedQoSProfile getEPSSubscribedQoSProfile();
	
	void setEPSSubscribedQoSProfile(EPSSubscribedQoSProfile value);
	
	VPLMNDynamicAddressAllowedEnum getVPLMNDynamicAddressAllowed();
	
	void setVPLMNDynamicAddressAllowed(VPLMNDynamicAddressAllowedEnum value);
	
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);
	
	ByteBuf getVisitedNetworkIdentifier();
	
	void setVisitedNetworkIdentifier(ByteBuf value);
	
	PDNGWAllocationTypeEnum getPDNGWAllocationType();
	
	void setPDNGWAllocationType(PDNGWAllocationTypeEnum value);
	
	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);
	
	AMBR getAMBR();
	
	void setAMBR(AMBR value);
	
	List<SpecificAPNInfo> getSpecificAPNInfo();
	
	void setSpecificAPNInfo(List<SpecificAPNInfo> value);
	
	String getAPNOIReplacement();
	
	void setAPNOIReplacement(String value);
	
	SIPTOPermissionEnum getSIPTOPermission();
	
	void setSIPTOPermission(SIPTOPermissionEnum value);
	
	LIPAPermissionEnum getLIPAPermission();
	
	void setLIPAPermission(LIPAPermissionEnum value);
	
	Long getRestorationPriority();
	
	void setRestorationPriority(Long value);
	
	SIPTOLocalNetworkPermissionEnum getSIPTOLocalNetworkPermission();
	
	void setSIPTOLocalNetworkPermission(SIPTOLocalNetworkPermissionEnum value);
	
	WLANOffloadability getWLANOffloadability();
	
	void setWLANOffloadability(WLANOffloadability value);
	
	NonIPPDNTypeIndicatorEnum getNonIPPDNTypeIndicator();
	
	void setNonIPPDNTypeIndicator(NonIPPDNTypeIndicatorEnum value);
	
	NonIPDataDeliveryMechanismEnum getNonIPDataDeliveryMechanism();
	
	void setNonIPDataDeliveryMechanism(NonIPDataDeliveryMechanismEnum value);
	
	String getSCEFID();
	
	void setSCEFID(String value);
	
	String getSCEFRealm();
	
	void setSCEFRealm(String value);
	
	Long getPreferredDataMode();
	
	void setPreferredDataMode(Long value);
	
	PDNConnectionContinuityEnum getPDNConnectionContinuity();
	
	void setPDNConnectionContinuity(PDNConnectionContinuityEnum value);
	
	RDSIndicatorEnum getRDSIndicator();
	
	void setRDSIndicator(RDSIndicatorEnum value);
	
	Interworking5GSIndicatorEnum getInterworking5GSIndicator();
	
	void setInterworking5GSIndicator(Interworking5GSIndicatorEnum value);
	
	EthernetPDNTypeIndicatorEnum getEthernetPDNTypeIndicator();
	
	void setEthernetPDNTypeIndicator(EthernetPDNTypeIndicatorEnum value);
}