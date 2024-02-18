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
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PreEmptionCapabilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PreEmptionVulnerabilityEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *	5.3.16	Media-Component-Description AVP
	The Media-Component-Description AVP (AVP code 517) is of type Grouped, and it contains service information for a single media component within an AF session or the AF signalling information. The service information may be based on the SDI exchanged between the AF and the AF session client in the UE. The information may be used by the PCRF to determine authorized QoS and IP flow classifiers for bearer authorization and PCC rule selection.
	Within one Diameter message, a single IP flow shall not be described by more than one Media-Component-Description AVP.
	Bandwidth information and Flow-Status information provided within the Media-Component-Description AVP applies to all those IP flows within the media component, for which no corresponding information is being provided within Media-Sub-Component AVP(s). As defined in 3GPP TS 29.213 [9], the bandwidth information within the media component level Max-Requested-Bandwidth-DL and Max-Requested-Bandwidth-UL AVPs applies separately to each media subcomponent except for RTCP media subcomponent.
	The mapping of bandwidth information for RTCP media subcomponent is defined in 3GPP TS 29.213 [9] clause 6.2.
	If CHEM feature is supported, Max-PLR-DL AVP and Max-PLR-UL AVP information is provided within the Media-Component-Description AVP as defined in 3GPP TS 29.213 [9].
	If the QoSHint feature is supported the Desired-Max-Latency AVP and/or Desired-Max-Loss AVP may be provided within the Media-Component-Description AVP as defined in 3GPP TS 29.213 [9].
	If FLUS feature is supported the FLUS-Identifier AVP may be provided within the Media-Component-Description AVP. Additionally, the Desired-Max-Latency AVP and/or the Desired-Max-Loss AVP may be provided as defined in 3GPP TS 29.213 [9].
	The Max-Requested-Bandwidth-UL, Max-Requested-Bandwidth-DL, Max-Supported-Bandwidth-UL, Max-Supported-Bandwidth-DL, Min-Desired-Bandwidth-UL, Min-Desired-Bandwidth-DL, Min-Requested-Bandwidth-UL and Min-Requested-Bandwidth-DL AVPs only represent bandwidth values up 2^32-1 bps. To represent higher values, the Extended-Max-Requested-Bandwidth-UL, Extended-Max-Requested-Bandwidth-DL, Extended-Max-Supported-Bandwidth-UL, Extended-Max-Supported-Bandwidth-DL, Extended-Min-Desired-Bandwidth-UL, Extended-Min-Desired-Bandwidth-DL, Extended-Min-Requested-Bandwidth-UL and Extended-Min-Requested-Bandwidth-DL AVPs may be used as described in clause 4.4.10.
	If a Media-Component-Description AVP is not supplied by the AF, or if optional AVP(s) within a Media-Component-Description AVP are omitted, but corresponding information has been provided in previous Diameter messages, the previous information for the corresponding IP flow(s) remains valid.
	All IP flows within a Media-Component-Description AVP are permanently disabled by supplying a Flow Status AVP with value "REMOVED". The server may delete corresponding filters and state information.
	Reservation-Priority provided within the Media-Component-Description AVP in the request from the AF applies to all those IP flows within the media component and describes the relative importance of the IP flow as compared to other IP flows. The PCRF may use this value to implement priority based admission. If the Reservation-Priority AVP is not specified the IP flow priority is DEFAULT (0).
	Each Media-Component-Description AVP shall contain either zero, or one, or two Codec-Data AVPs. In the case of conflicts, information contained in other AVPs either within this Media-Component-Description AVP, or within the corresponding Media-Component-Description AVP in a previous message, shall take precedence over information within the Codec-Data AVP(s). The AF shall provision all the available information in other applicable AVPs in addition to the information in the Codec-Data AVP, if such other AVPs are specified.
	If the SDP offer-answer procedures of IETF RFC 3264 [18] are applicable for the session negotiation between the two ends taking part in the communication (e.g. for IMS), the following applies:
		-	The AF shall provision information derived from an SDP answer and shall also provision information derived from the corresponding SDP offer.
		-	If the Media-Component-Description AVP contains two Codec-Data AVPs, one of them shall represent an SDP offer and the other one the corresponding SDP answer.
		-	If the Media-Component-Description AVP contains one Codec-Data AVP, and this AVP represents an SDP offer, the AF shall provision the corresponding SDP answer information in a Codec-Data AVP within a subsequent Rx message.

		NOTE 1:	Some SDP parameters for the same codec in the SDP offer and answer are independent of each other and refer to IP flows in opposite directions, for instance some MIME parameters conveyed within "a=fmtp" SDP lines and the packetization time within the "a=ptime" line. Other parameters within the SDP answer take precedence over corresponding parameters within the SDP offer.
	
	If SDP is applied without using the offer-answer procedures, zero or one Codec-Data AVP shall be provisioned.
	Sharing-Key-DL AVP and/or Sharing-Key-UL AVP provided within the Media-Component-Description AVP indicates that the media components that include the same value of the Sharing-Key-UL AVP and/or Sharing-Key-DL AVP may share resources in the related direction.

		NOTE 2: RTCP traffic is not subject to resource sharing.

	The Content-Version AVP may be included in order to indicate the content version of a media component.
	The Priority-Sharing-Indicator AVP may be included to indicate that the media component can use the same Allocation and Retention Priority as media flows which are assigned the same QCI in the PCRF belonging to other AF sessions for the same IP-CAN session that also contain the Priority-Sharing-Indicator AVP.
	The Pre-emption-Capability AVP and Pre-emption-Vulnerability AVP may be included together with Priority-Sharing-Indicator AVP for PCRF Allocation and Retention Priority decision.
	The PCRF may provide the Media-Component-Description AVP(s) within the Acceptable-Service-Info AVP in the AA-Answer command if the service information received from the AF is rejected. For this usage, the Media-Component-Description AVP shall only include the appropriate Media-Component-Number AVP and the Max-Requested-Bandwidth-UL and/or Max-Requested-Bandwidth-DL AVPs and/ or the Extended-Max-Requested-BW-UL AVP and/or the Extended-Max-Requested-BW-DL AVP (see clause 4.4.10) indicating the maximum acceptable bandwidth.

	AVP format:
		Media-Component-Description ::= < AVP Header: 517 >
			 { Media-Component-Number } ; Ordinal number of the media comp.
			*[ Media-Sub-Component ]    ; Set of flows for one flow identifier
			 [ AF-Application-Identifier ]
			 [ FLUS-Identifier ]
			 [ Media-Type ]
			 [ Max-Requested-Bandwidth-UL ]
			 [ Max-Requested-Bandwidth-DL ]
			 [ Max-Supported-Bandwidth-UL ]
			 [ Max-Supported-Bandwidth-DL ]
			 [ Min-Desired-Bandwidth-UL ]
			 [ Min-Desired-Bandwidth-DL ]
			 [ Min-Requested-Bandwidth-UL ]
			 [ Min-Requested-Bandwidth-DL ]
			 [ Extended-Max-Requested-BW-UL ]
			 [ Extended-Max-Requested-BW-DL ]
			 [ Extended-Max-Supported-BW-UL ]
			 [ Extended-Max-Supported-BW-DL ]
			 [ Extended-Min-Desired-BW-UL ]
			 [ Extended-Min-Desired-BW-DL ]
			 [ Extended-Min-Requested-BW-UL ]
			 [ Extended-Min-Requested-BW-DL ]
			 [ Flow-Status ]
			 [ Priority-Sharing-Indicator ]
			 [ Pre-emption-Capability ]
			 [ Pre-emption-Vulnerability ]
			 [ Reservation-Priority ]
			 [ RS-Bandwidth ]
			 [ RR-Bandwidth ]
		  0*2[ Codec-Data ]
			 [ Sharing-Key-DL ]
			 [ Sharing-Key-UL ]
			 [ Content-Version ]
			 [ Max-PLR-DL ]
			 [ Max-PLR-UL ]
			 [ Desired-Max-Latency ]
			 [ Desired-Max-Loss ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MEDIA_COMPONENT_DESCRIPTION, vendorId = VendorIDs.TGPP_ID, name = "Media-Component-Description")
public interface MediaComponentDescription extends DiameterGroupedAvp
{
	Long getMediaComponentNumber();
	
	void setMediaComponentNumber(Long value) throws MissingAvpException;
	
	List<MediaSubComponent> getMediaSubComponent();
	
	void setMediaSubComponent(List<MediaSubComponent> value);
	
	ByteBuf getAFApplicationIdentifier();
	
	void setAFApplicationIdentifier(ByteBuf value);
	
	ByteBuf getFLUSIdentifier();
	
	void setFLUSIdentifier(ByteBuf value);
	
	MediaTypeEnum getMediaType();
	
	void setMediaType(MediaTypeEnum value);
	
	Long getMaxRequestedBandwidthUL();
	
	void setMaxRequestedBandwidthUL(Long value);	
	
	Long getMaxRequestedBandwidthDL();
	
	void setMaxRequestedBandwidthDL(Long value);
	
	Long getMaxSuppportedBandwidthUL();
	
	void setMaxSuppportedBandwidthUL(Long value);	
	
	Long getMaxSuppportedBandwidthDL();
	
	void setMaxSuppportedBandwidthDL(Long value);
	
	Long getMinDesiredBandwidthUL();
	
	void setMinDesiredBandwidthUL(Long value);	
	
	Long getMinDesiredBandwidthDL();
	
	void setMinDesiredBandwidthDL(Long value);
	
	Long getMinRequestedBandwidthUL();
	
	void setMinRequestedBandwidthUL(Long value);	
	
	Long getMinRequestedBandwidthDL();
	
	void setMinRequestedBandwidthDL(Long value);
	
	Long getExtendedMaxRequestedBandwidthUL();
	
	void setExtendedMaxRequestedBandwidthUL(Long value);	
	
	Long getExtendedMaxRequestedBandwidthDL();
	
	void setExtendedMaxRequestedBandwidthDL(Long value);
	
	Long getExtendedMaxSuppportedBandwidthUL();
	
	void setExtendedMaxSuppportedBandwidthUL(Long value);	
	
	Long getExtendedMaxSuppportedBandwidthDL();
	
	void setExtendedMaxSuppportedBandwidthDL(Long value);
	
	Long getExtendedMinDesiredBandwidthUL();
	
	void setExtendedMinDesiredBandwidthUL(Long value);	
	
	Long getExtendedMinDesiredBandwidthDL();
	
	void setExtendedMinDesiredBandwidthDL(Long value);
	
	Long getExtendedMinRequestedBandwidthUL();
	
	void setExtendedMinRequestedBandwidthUL(Long value);	
	
	Long getExtendedMinRequestedBandwidthDL();
	
	void setExtendedMinRequestedBandwidthDL(Long value);
	
	FlowStatusEnum getFlowStatus();
	
	void setFlowStatus(FlowStatusEnum value);	
	
	PrioritySharingIndicatorEnum getPrioritySharingIndicator();
	
	void setPrioritySharingIndicator(PrioritySharingIndicatorEnum value);	
	
	PreEmptionCapabilityEnum getPreEmptionCapability();
	
	void setPreEmptionCapability(PreEmptionCapabilityEnum value);	
	
	PreEmptionVulnerabilityEnum getPreEmptionVulnerability();
	
	void setPreEmptionVulnerability(PreEmptionVulnerabilityEnum value);	
	
	ReservationPriorityEnum getReservationPriority();
	
	void setReservationPriority(ReservationPriorityEnum value);	
	
	Long getRSBandwidth();
	
	void setRSBandwidth(Long value);
	
	Long getRRBandwidth();
	
	void setRRBandwidth(Long value);
	
	List<ByteBuf> getCodecData();
	
	void setCodecData(List<ByteBuf> value) throws AvpOccursTooManyTimesException;
	
	Long getSharingKeyDL();
	
	void setSharingKeyDL(Long value);
	
	Long getSharingKeyUL();
	
	void setSharingKeyUL(Long value);
	
	Long getContentVersion();
	
	void setContentVersion(Long value);
	
	Long getMaxPLRDL();
	
	void setMaxPLRDL(Long value);
	
	Long getMaxPLRUL();
	
	void setMaxPLRUL(Long value);
	
	Float getDesiredMaxLatency();
	
	void setDesiredMaxLatency(Float value);
	
	Float getDesiredMaxLoss();
	
	void setDesiredMaxLoss(Float value);
}