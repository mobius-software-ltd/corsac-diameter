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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.180	SDP-Media-Component AVP
	The SDP-Media-Component AVP (AVP code 843) is of type Grouped and contains information about media used for a IMS session.
	It has the following ABNF grammar:

	SDP-Media-Component ::=	< AVP Header: 843 >
			[ SDP-Media-Name ]
		* 	[ SDP-Media-Description ]
			[ Local-GW-Inserted-Indication ] 
			[ IP-Realm-Default-Indication ]
			[ Transcoder-Inserted-Indication ]
			[ Media-Initiator-Flag ] 
			[ Media-Initiator-Party ]
			[ 3GPP-Charging-Id ]
			[ Access-Network-Charging-Identifier-Value ]
			[ SDP-Type ]

	NOTE:	When populating the SDP-Media-Component, either the 3GPP-Charging-ID or the Access-Network-Charging-Identifier-Value should be present but not both. The 3GPP-Charging-ID is expected to be used for 3GPP defined IP-CANS (e.g. GPRS, EPS, 5GS) while the Access-Network-Charging-Identifier-Value is used for non-3GPP defined IP-CANs. 
 */
@DiameterAvpDefinition(code = 843L, vendorId = KnownVendorIDs.TGPP_ID, name = "SDP-Media-Component")
public interface SDPMediaComponent extends DiameterAvp
{
	String getSDPMediaName();
	
	void setSDPMediaName(String value);
	
	List<String> getSDPMediaDescription();
	
	void setSDPMediaDescription(List<String> value);
	
	LocalGWInsertedIndicationEnum getLocalGWInsertedIndication();
	
	void setLocalGWInsertedIndication(LocalGWInsertedIndicationEnum value);
	
	IPRealmDefaultIndicationEnum getIPRealmDefaultIndication();
	
	void setIPRealmDefaultIndication(IPRealmDefaultIndicationEnum value);
	
	TranscoderInsertedIndicationEnum getTranscoderInsertedIndication();
	
	void setTranscoderInsertedIndication(TranscoderInsertedIndicationEnum value);
	
	MediaInitiatorFlagEnum getMediaInitiatorFlag();
	
	void setMediaInitiatorFlag(MediaInitiatorFlagEnum value);
	
	String getMediaInitiatorParty();
	
	void setMediaInitiatorParty(String value);
	
	ByteBuf get3GPPChargingId();
	
	void set3GPPChargingId(ByteBuf value);
	
	ByteBuf getAccessNetworkChargingIdentifierValue();
	
	void setAccessNetworkChargingIdentifierValue(ByteBuf value);
	
	SDPTypeEnum getSDPType();
	
	void setSDPType(SDPTypeEnum value);
}