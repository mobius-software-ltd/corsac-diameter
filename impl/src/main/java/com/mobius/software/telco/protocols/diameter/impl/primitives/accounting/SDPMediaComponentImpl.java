package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AccessNetworkChargingIdentifierValueImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IPRealmDefaultIndication;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IPRealmDefaultIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocalGWInsertedIndication;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocalGWInsertedIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MediaInitiatorFlag;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MediaInitiatorFlagEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MediaInitiatorParty;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPMediaComponent;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPMediaDescription;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPMediaName;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TranscoderInsertedIndication;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TranscoderInsertedIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingId;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifierValue;

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
@DiameterAvpImplementation(code = 843L, vendorId = KnownVendorIDs.TGPP_ID)
public class SDPMediaComponentImpl implements SDPMediaComponent
{
	private SDPMediaName sdpMediaName;
	private List<SDPMediaDescription> sdpMediaDescription;
	private LocalGWInsertedIndication localGWInsertedIndication; 
	private IPRealmDefaultIndication ipRealmDefaultIndication;
	private TranscoderInsertedIndication transcoderInsertedIndication;
	private MediaInitiatorFlag mediaInitiatorFlag; 
	private MediaInitiatorParty mediaInitiatorParty;
	private TGPPChargingId tgppChargingId;
	private AccessNetworkChargingIdentifierValue accessNetworkChargingIdentifierValue;
	private SDPType sdpType;
			
	public SDPMediaComponentImpl()
	{
		
	}
	
	public String getSDPMediaName()
	{
		if(sdpMediaName==null)
			return null;
		
		return sdpMediaName.getString();
	}
	
	public void setSDPMediaName(String value)
	{
		if(value==null)
			this.sdpMediaName = null;
		else
			this.sdpMediaName = new SDPMediaNameImpl(value, null, null);			
	}
	
	public List<String> getSDPMediaDescription()
	{
		if(sdpMediaDescription==null || sdpMediaDescription.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(SDPMediaDescription curr:sdpMediaDescription)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setSDPMediaDescription(List<String> value)
	{
		if(value==null || value.size()==0)
			this.sdpMediaDescription = null;
		else
		{
			this.sdpMediaDescription = new ArrayList<SDPMediaDescription>();
			for(String curr: value)
				this.sdpMediaDescription.add(new SDPMediaDescriptionImpl(curr, null, null));			
		}
	}
	
	public LocalGWInsertedIndicationEnum getLocalGWInsertedIndication()
	{
		if(localGWInsertedIndication==null)
			return null;
		
		return localGWInsertedIndication.getEnumerated(LocalGWInsertedIndicationEnum.class);
	}
	
	public void setLocalGWInsertedIndication(LocalGWInsertedIndicationEnum value)
	{
		if(value==null)
			this.localGWInsertedIndication = null;
		else
			this.localGWInsertedIndication = new LocalGWInsertedIndicationImpl(value, null, null);			
	}
	
	public IPRealmDefaultIndicationEnum getIPRealmDefaultIndication()
	{
		if(ipRealmDefaultIndication==null)
			return null;
		
		return ipRealmDefaultIndication.getEnumerated(IPRealmDefaultIndicationEnum.class);
	}
	
	public void setIPRealmDefaultIndication(IPRealmDefaultIndicationEnum value)
	{
		if(value==null)
			this.ipRealmDefaultIndication = null;
		else
			this.ipRealmDefaultIndication = new IPRealmDefaultIndicationImpl(value, null, null);			
	}
	
	public TranscoderInsertedIndicationEnum getTranscoderInsertedIndication()
	{
		if(transcoderInsertedIndication==null)
			return null;
		
		return transcoderInsertedIndication.getEnumerated(TranscoderInsertedIndicationEnum.class);
	}
	
	public void setTranscoderInsertedIndication(TranscoderInsertedIndicationEnum value)
	{
		if(value==null)
			this.transcoderInsertedIndication = null;
		else
			this.transcoderInsertedIndication = new TranscoderInsertedIndicationImpl(value, null, null);			
	}
	
	public MediaInitiatorFlagEnum getMediaInitiatorFlag()
	{
		if(mediaInitiatorFlag==null)
			return null;
		
		return mediaInitiatorFlag.getEnumerated(MediaInitiatorFlagEnum.class);
	}
	
	public void setMediaInitiatorFlag(MediaInitiatorFlagEnum value)
	{
		if(value==null)
			this.mediaInitiatorFlag = null;
		else
			this.mediaInitiatorFlag = new MediaInitiatorFlagImpl(value, null, null);			
	}
	
	public String getMediaInitiatorParty()
	{
		if(mediaInitiatorParty==null)
			return null;
		
		return mediaInitiatorParty.getString();
	}
	
	public void setMediaInitiatorParty(String value)
	{
		if(value==null)
			this.mediaInitiatorParty = null;
		else
			this.mediaInitiatorParty = new MediaInitiatorPartyImpl(value, null, null);			
	}
	
	public ByteBuf get3GPPChargingId()
	{
		if(tgppChargingId==null)
			return null;
		
		return tgppChargingId.getValue();
	}
	
	public void set3GPPChargingId(ByteBuf value)
	{
		if(value==null)
			this.tgppChargingId = null;
		else
			this.tgppChargingId = new TGPPChargingIdImpl(value, null, null);			
	}
	
	public ByteBuf getAccessNetworkChargingIdentifierValue()
	{
		if(accessNetworkChargingIdentifierValue==null)
			return null;
		
		return accessNetworkChargingIdentifierValue.getValue();
	}
	
	public void setAccessNetworkChargingIdentifierValue(ByteBuf value)
	{
		if(value==null)
			this.accessNetworkChargingIdentifierValue = null;
		else
			this.accessNetworkChargingIdentifierValue = new AccessNetworkChargingIdentifierValueImpl(value, null, null);			
	}
	
	public SDPTypeEnum getSDPType()
	{
		if(sdpType==null)
			return null;
		
		return sdpType.getEnumerated(SDPTypeEnum.class);
	}
	
	public void setSDPType(SDPTypeEnum value)
	{
		if(value==null)
			this.sdpType = null;
		else
			this.sdpType = new SDPTypeImpl(value, null, null);			
	}
}