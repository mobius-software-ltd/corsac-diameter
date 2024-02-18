package com.mobius.software.telco.protocols.diameter.primitives.gq;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaTypeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *	6.5.18	Media-Component-Description AVP
	The Media-Component-Description AVP (AVP code 517) is of type Grouped, and it contains service information for a single media component within an AF session. It may be based on the SDI exchanged between the AF and the AF client in the UE. The information may be used by the server to determine authorized QoS and IP flow classifiers for bearer authorization and charging rule selection.
	Within one Diameter message, a single IP flow shall not be described by more than one Media-Component-Description AVP.
	Bandwidth information and Flow-Status information provided within the Media-Component-Description AVP applies to all those IP flows within the media component, for which no corresponding information is being provided within Media-Sub-Component AVP(s).
	If a Media-Component-Description AVP is not supplied, or if optional AVP(s) within a Media-Component-Description AVP are omitted, but corresponding information has been provided in previous Diameter messages, the previous information for the corresponding IP flow(s) remains valid. 
	All IP flows within a Media-Component-Description AVP are permanently disabled by supplying a Flow Status AVP with value "REMOVED". The server may delete corresponding filters and state information.
	
	AVP format:
		Media-Component-Description ::= < AVP Header: 517 >
			 { Media-Component-Number } ; Ordinal number of the media comp.
			*[ Media-Sub-Component ]        ; Set of flows for one flow identifier
			 [ AF-Application-Identifier ]
			 [ Media-Type ]
			 [ Max-Requested-Bandwidth-UL ]
			 [ Max-Requested-Bandwidth-DL ]
			 [ Flow-Status ]
			 [ RS-Bandwidth ]
			 [ RR-Bandwidth ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MEDIA_COMPONENT_DESCRIPTION, vendorId = VendorIDs.TGPP_ID, name = "Media-Component-Description")
public interface MediaComponentDescription extends DiameterAvp
{
	Long getMediaComponentNumber();
	
	void setMediaComponentNumber(Long value) throws MissingAvpException;
	
	List<MediaSubComponent> getMediaSubComponent();
	
	void setMediaSubComponent(List<MediaSubComponent> value);
	
	ByteBuf getAFApplicationIdentifier();
	
	void setAFApplicationIdentifier(ByteBuf value);
	
	MediaTypeEnum getMediaType();
	
	void setMediaType(MediaTypeEnum value);
	
	Long getMaxRequestedBandwidthUL();
	
	void setMaxRequestedBandwidthUL(Long value);	
	
	Long getMaxRequestedBandwidthDL();
	
	void setMaxRequestedBandwidthDL(Long value);
	
	FlowStatusEnum getFlowStatus();
	
	void setFlowStatus(FlowStatusEnum value);
	
	Long getRSBandwidth();
	
	void setRSBandwidth(Long value);
	
	Long getRRBandwidth();
	
	void setRRBandwidth(Long value);
}