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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.7	Codec-Data AVP
	The Codec-Data AVP (AVP code 524) is of type OctetString.
	The Codec-Data AVP shall contain codec related information known at the AF. This information shall be encoded as follows:
		
	-	The first line of the value of the Codec-Data AVP shall consist of either the word "uplink" or the word "downlink" (in ASCII, without quotes) followed by a new-line character. The semantics of these words are the following:
	-	"uplink" indicates that the SDP was received from the UE and sent to the network.
	-	"downlink" indicates that the SDP was received from the network and sent to the UE.

	NOTE 1:	The first line indicates the direction of the source of the SDP used to derive the information. The majority of the information within the Codec-Data AVP indicating "downlink" describes properties, for instance receiver capabilities, of the sender of the SDP, the network in this case and is therefore applicable for IP flows in the uplink direction. Similarly, the majority of the information within the Codec-Data AVP indicating "uplink" describes properties, for instance receiver capabilities, of the sender of the SDP, the UE in this case and is therefore applicable for IP flows in the downlink direction.
		
	-	The second line of the value of the Codec-Data AVP shall consist of either the word "offer" or the word "answer", or the word "description" (in ASCII, without quotes) followed by a new-line character. The semantics of these words are the following:
	-	"offer" indicates that SDP lines from an SDP offer according to RFC 3264 [18] are being provisioned in the Codec-Data AVP;
	-	"answer" indicates that SDP lines from an SDP answer according to RFC 3264 [18] are being provisioned in the Codec-Data AVP;
	-	"description" indicates that SDP lines from a SDP session description in a scenario where the offer-answer mechanism of RFC 3264 [18] is not being applied are being provisioned in the Codec-Data AVP. For instance, SDP from an RTSP "Describe" reply may be provisioned.
	-	The rest of the value shall consist of SDP line(s) in ASCII encoding separated by new-line characters, as specified in IETF RFC 4566 [13]. The first of these line(s) shall be an "m" line. The remaining lines shall be any available SDP "a" and "b" lines related to that "m" line. However, to avoid duplication of information, the SDP "a=sendrecv", "a=recvonly ", "a=sendonly", "a=inactive", "a=bw-info", "b:AS", "b:RS" and "b:RR" lines do not need to be included.

	NOTE 2:	For backwards compatibility, it is expected that the codec algorithms in the PCRF described in 3GPP TS 29.213 [9] allow the introduction of new SDP lines without rejecting the request when Codec-Data AVP is provided as part of the Media-Component-Description AVP. The QoS derivation in that case will not take the new SDP line(s) into account.
 */
@DiameterAvpDefinition(code = 524L, vendorId = KnownVendorIDs.TGPP_ID, name = "Codec-Data")
public interface CodecData extends DiameterOctetString
{
}