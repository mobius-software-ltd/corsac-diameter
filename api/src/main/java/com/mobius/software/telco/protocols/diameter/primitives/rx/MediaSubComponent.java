package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *	5.3.18	Media-Sub-Component AVP
	The Media-Sub-Component AVP (AVP code 519) is of type Grouped, and it contains the requested bitrate and filters for the set of IP flows identified by their common Flow-Identifier. The Flow-Identifier is defined in Annex B.
	Possible Bandwidth information and Flow-Status information provided within the Media-Sub-Component AVP takes precedence over information within the encapsulating Media Component Description AVP. If a Media-Sub-Component- AVP is not supplied, or if optional AVP(s) within a Media-Sub-Component AVP are omitted, but corresponding information has been provided in previous Diameter messages, the previous information for the corresponding IP flow(s) remains valid, unless new information is provided within the encapsulating Media‑Component-Description AVP. If Flow-Description AVP(s) are supplied, they replace all previous Flow‑Description AVP(s), even if a new Flow-Description AVP has the opposite direction as the previous Flow‑Description AVP. The AF may also include the ToS-Traffic-Class AVP for requesting Type of Service or Traffic Class (for IPv4 and IPv6 respectively) based packet filter for the related flow.
	The AF-Signalling-Protocol AVP may be included only if the Flow-Usage AVP has a value of ‘AF_SIGNALLING’.
	All IP flows within a Media-Sub-Component- AVP are permanently disabled by supplying a Flow Status AVP with value "REMOVED". The server may delete corresponding filters and state information.
	AVP format:

		Media-Sub-Component ::= < AVP Header: 519 >
						   { Flow-Number }              ; Ordinal number of the IP flow
					   0*2 [ Flow-Description ]        ; UL and/or DL
						   [ Flow-Status ]
						   [ Flow-Usage ]
						   [ Max-Requested-Bandwidth-UL ]
						   [ Max-Requested-Bandwidth-DL ]
						   [ Extended-Max-Requested-BW-UL ]
						   [ Extended-Max-Requested-BW-DL ]
						   [ AF-Signalling-Protocol ]
						   [ ToS-Traffic-Class ]
						  *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MEDIA_SUBCOMPONENT, vendorId = VendorIDs.TGPP_ID, name = "Media-Sub-Component")
public interface MediaSubComponent extends DiameterGroupedAvp
{
	Long getFlowNumber();
	
	void setFlowNumber(Long value) throws MissingAvpException;
	
	List<FlowDescription> getFlowDescription();
	
	void setFlowDescription(List<FlowDescription> value) throws AvpOccursTooManyTimesException;
	
	FlowStatusEnum getFlowStatus();
	
	void setFlowStatus(FlowStatusEnum value);
	
	FlowUsageEnum getFlowUsage();
	
	void setFlowUsage(FlowUsageEnum value);	
	
	Long getMaxRequestedBandwidthUL();
	
	void setMaxRequestedBandwidthUL(Long value);	
	
	Long getMaxRequestedBandwidthDL();
	
	void setMaxRequestedBandwidthDL(Long value);
	
	Long getExtendedMaxRequestedBandwidthUL();
	
	void setExtendedMaxRequestedBandwidthUL(Long value);	
	
	Long getExtendedMaxRequestedBandwidthDL();
	
	void setExtendedMaxRequestedBandwidthDL(Long value);
	
	AFSignallingProtocolEnum getAFSignallingProtocol();
	
	void setAFSignallingProtocol(AFSignallingProtocolEnum value);
	
	ByteBuf getToSTrafficClass();
	
	void setToSTrafficClass(ByteBuf value);
}