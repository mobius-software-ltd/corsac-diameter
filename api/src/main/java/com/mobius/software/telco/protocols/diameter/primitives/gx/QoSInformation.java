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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.16	QoS-Information AVP (All access types)
	The QoS-Information AVP (AVP code 1016) is of type Grouped, and it defines the QoS information for resources requested by the UE, an IP-CAN bearer, PCC rule, QCI or APN. When this AVP is sent from the PCEF to the PCRF, it indicates the requested QoS information associated with resources requested by the UE, an IP CAN bearer or the subscribed QoS information at APN level. When this AVP is sent from the PCRF to the PCEF, it indicates the authorized QoS for:

	-	an IP CAN bearer (when appearing at CCA or RAR command level or 

	-	a service data flow (when included within the PCC rule) or 

	-	a QCI (when appearing at CCA or RAR command level with the QoS-Class-Identifier AVP and the Maximum-Requested-Bandwidth-UL AVP and/or the Maximum-Requested-Bandwidth-DL AVP) or

	-	an APN (when appearing at CCA or RAR command level with APN-Aggregate-Max-Bitrate-UL and APN-Aggregate-Max-Bitrate-DL or Extended-APN-AMBR-UL and Extended-APN-AMBR-DL).

	The QoS class identifier identifies a set of IP-CAN specific QoS parameters that define QoS, excluding the applicable bitrates and ARP. It is applicable both for uplink and downlink direction.
	The Max-Requested-Bandwidth-UL and the Extended-Max-Requested-BW-UL define the maximum bit rate allowed for the uplink direction.
	The Max-Requested-Bandwidth-DL and the Extended-Max-Requested-BW-DL defines the maximum bit rate allowed for the downlink direction.
	The Guaranteed-Bitrate-UL and the Extended-GBR-UL define the guaranteed bit rate allowed for the uplink direction.
	The Guaranteed-Bitrate-DL and the Extended-GBR-DL define the guaranteed bit rate allowed for the downlink direction.
	The APN-Aggregate-Max-Bitrate-UL and the Extended-APN-AMBR-UL define the total bandwidth usage for the uplink direction of non-GBR QCIs at the APN.
	The APN-Aggregate-Max-Bitrate-DL and the Extended-APN-AMBR-DL define the total bandwidth usage for the downlink direction of non-GBR QCIs at the APN.
	The Conditional-APN-Aggregate-Max-Bitrate defines total bandwidth usage for the uplink and downlink direction of non-GBR QCIs at the APN, with condition.
	The Bearer Identifier AVP shall be included as part of the QoS-Information AVP if the QoS information refers to an IP CAN bearer initiated by the UE and the PCRF performs the bearer binding. The Bearer Identifier AVP identifies this bearer. Several QoS-Information AVPs for different Bearer Identifiers may be provided per command.
	When the QoS-Information AVP is provided within the CCR command along with the RESOURCE_MODIFICATION_REQUEST event trigger, the QoS-information AVP includes only the QoS-Class-Identifier AVP and Guaranteed-Bitrate-UL and/or Guaranteed-Bitrate-DL AVPs or Extended-GBR-UL and/or Extended-GBR-DL AVPs (see subclause 4.5.30).
	The Allocation-Retention-Priority AVP is an indicator of the priority of allocation and retention for the Service Data Flow.
	If the QoS-Information AVP has been supplied previously but is omitted in a Diameter message or AVP, the previous information remains valid. If the QoS-Information AVP has not been supplied from the PCRF to the PCEF previously and is omitted in a Diameter message or AVP, no enforcement of the authorized QoS shall be performed.
	
	AVP Format:
	QoS-Information ::= < AVP Header: 1016 >
		 [ QoS-Class-Identifier ]
		 [ Max-Requested-Bandwidth-UL ]
		 [ Max-Requested-Bandwidth-DL ] 
		 [ Extended-Max-Requested-BW-UL ]
		 [ Extended-Max-Requested-BW-DL ]
		 [ Guaranteed-Bitrate-UL ]
		 [ Guaranteed-Bitrate-DL ]
		 [ Extended-GBR-UL ]
		 [ Extended-GBR-DL ]
		 [ Bearer-Identifier ]
		 [ Allocation-Retention-Priority ]
		 [ APN-Aggregate-Max-Bitrate-UL ]
		 [ APN-Aggregate-Max-Bitrate-DL ]
		 [ Extended-APN-AMBR-UL ]
		 [ Extended-APN-AMBR-DL ]
		*[ Conditional-APN-Aggregate-Max-Bitrate ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = 1016L, vendorId = KnownVendorIDs.TGPP_ID, name = "QoS-Information")
public interface QoSInformation extends DiameterGroupedAvp
{
	QoSClassIdentifierEnum getQoSClassIdentifier();
	
	void setQoSClassIdentifier(QoSClassIdentifierEnum value);		
	
	Long getMaxRequestedBandwidthUL();
	
	void setMaxRequestedBandwidthUL(Long value);	
	
	Long getMaxRequestedBandwidthDL();
	
	void setMaxRequestedBandwidthDL(Long value);	
	
	Long getExtendedMaxRequestedBWUL();
	
	void setExtendedMaxRequestedBWUL(Long value);	
	
	Long getExtendedMaxRequestedBWDL();
	
	void setExtendedMaxRequestedBWDL(Long value);
	
	Long getGuaranteedBitrateUL();
	
	void setGuaranteedBitrateUL(Long value);	
	
	Long getGuaranteedBitrateDL();
	
	void setGuaranteedBitrateDL(Long value);
	
	Long getExtendedGBRUL();
	
	void setExtendedGBRUL(Long value);	
	
	Long getExtendedGBRDL();
	
	void setExtendedGBRDL(Long value);
	
	ByteBuf getBearerIdentifier();
	
	void setBearerIdentifier(ByteBuf value);
	
	AllocationRetentionPriority getAllocationRetentionPriority();
	
	void setAllocationRetentionPriority(AllocationRetentionPriority value);
	
	Long getAPNAggregateMaxBitrateUL();
	
	void setAPNAggregateMaxBitrateUL(Long value);	
	
	Long getAPNAggregateMaxBitrateDL();
	
	void setAPNAggregateMaxBitrateDL(Long value);
	
	Long getExtendedAPNAMBRUL();
	
	void setExtendedAPNAMBRUL(Long value);	
	
	Long getExtendedAPNAMBRDL();
	
	void setExtendedAPNAMBRDL(Long value);
	
	List<ConditionalAPNAggregateMaxBitrate> getConditionalAPNAggregateMaxBitrate();
	
	void setConditionalAPNAggregateMaxBitrate(List<ConditionalAPNAggregateMaxBitrate> value);
}