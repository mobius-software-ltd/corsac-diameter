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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.74	PDP-Context
	The PDP-Context AVP is of type Grouped. For a particular GPRS user having multiple PDP Context configurations, the Service-Selection AVP values may be the same for different PDP-Context AVPs.
	AVP format
	
	PDP-Context ::= <AVP header: 1469 10415>
			 { Context-Identifier }
			 { PDP-Type }
			 [ PDP-Address ]
			 { QoS-Subscribed }
			 [ VPLMN-Dynamic-Address-Allowed ]
			 { Service-Selection }
			 [3GPP-Charging-Characteristics]
			 [ Ext-PDP-Type ]
			 [ Ext-PDP-Address ]
			 [ AMBR ]
			 [ APN-OI-Replacement ]
			 [ SIPTO-Permission ]
			 [ LIPA-Permission ]
			 [ Restoration-Priority ]
			 [ SIPTO-Local-Network-Permission ]
			 [ Non-IP-Data-Delivery-Mechanism ]
			 [ SCEF-ID ]
			*[AVP]

	The Ext-PDP-Address AVP may be present only if the PDP-Address AVP is present. If the Ext-PDP-Address AVP is present, then it shall not contain the same address type (IPv4 or IPv6) as the PDP-Address AVP.
	When PDP-Type takes the value Non-IP (HEX 02), the Ext-PDP-Type AVP shall be absent.
	The AMBR included in this grouped AVP shall include the AMBR associated to the APN included in the PDP-Context AVP (APN-AMBR).
	The APN-OI-Replacement included in this grouped AVP shall include the APN-OI-Replacement associated to the APN included in the PDP-Context. This APN-OI-Replacement has higher priority than UE level APN-OI-Replacement.
	The Non-IP-Data-Delivery-Mechanism shall only be present when PDP-Type takes the value Non-IP (HEX 02).
	The SCEF-ID shall only be present when Non-IP-Data-Delivery-Mechanism takes the value SCEF-BASED-DATA-DELIVERY (1).
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PDP_CONTEXT, vendorId = VendorIDs.TGPP_ID, name = "PDP-Context")
public interface PDPContext extends DiameterGroupedAvp
{
	Long getContextIdentifier();
	
	void setContextIdentifier(Long value) throws MissingAvpException;	
	
	ByteBuf getPDPType();
	
	void setPDPType(ByteBuf value);
	
	InetAddress getPDPAddress();
	
	void setPDPAddress(InetAddress value);
	
	ByteBuf getQoSSubscribed();
	
	void setQoSSubscribed(ByteBuf value) throws MissingAvpException;
	
	VPLMNDynamicAddressAllowedEnum getVPLMNDynamicAddressAllowed();
	
	void setVPLMNDynamicAddressAllowed(VPLMNDynamicAddressAllowedEnum value);
	
	String getServiceSelection();
	
	void setServiceSelection(String value) throws MissingAvpException;
	
	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);	
	
	ByteBuf getExtPDPType();
	
	void setExtPDPType(ByteBuf value);	
	
	InetAddress getExtPDPAddress();
	
	void setExtPDPAddress(InetAddress value);	
	
	AMBR getAMBR();
	
	void setAMBR(AMBR value);	
	
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
	
	NonIPDataDeliveryMechanismEnum getNonIPDataDeliveryMechanism();
	
	void setNonIPDataDeliveryMechanism(NonIPDataDeliveryMechanismEnum value);
	
	String getSCEFID();
	
	void setSCEFID(String value);
}