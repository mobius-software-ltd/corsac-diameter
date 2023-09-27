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

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.58	Early-Media-Description AVP
	The Early-Media-Description AVP (AVP code 1272) is of type grouped and describes the SDP session, media parameters and timestamps related to media components set to active according to SDP signalling exchanged during a  SIP session establishment before the final successful or unsuccessful SIP answer to the initial SIP INVITE message is received. Once a media component has been set to active, subsequent status changes shall also be registered.
	It has the following ABNF grammar:
	
	<Early-Media-Description>:: =	 <AVP Header: 1272>
			[ SDP-TimeStamps ] 
		* 	[ SDP-Media-Component ]
		* 	[ SDP-Session-Description ]

	Media can be considered as inactive in range of situations, such as the listed below according to RFC 3264 [408]:
	-	Media marked with "a=inactive" attribute.
	-	Media offered with zero bandwith.
	In contrast, media with directionality marked as "a=recvonly", "a=sendonly", "a=sendrecv" shall be considered in state  "active" and thus, it may be exchanged in one or both directions.
 */
@DiameterAvpDefinition(code = 1272L, vendorId = KnownVendorIDs.TGPP_ID, name = "Early-Media-Description")
public interface EarlyMediaDescription extends DiameterAvp
{
	SDPTimeStamps getSDPTimeStamps();
	
	void setSDPTimeStamps(SDPTimeStamps value);
	
	List<SDPMediaComponent> getSDPMediaComponent();
	
	void setSDPMediaComponent(List<SDPMediaComponent> value);
	
	List<String> getSDPSessionDescription();
	
	void setSDPSessionDescription(List<String> value);
}