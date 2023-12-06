package com.mobius.software.telco.protocols.diameter.commands.gmb;
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

import java.net.Inet4Address;
import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	
	17.6.1	AAR Command
	The AAR command, defined in Diameter NASREQ (IETF RFC 7155 [120]), is indicated by the Command-Code field set to 265 and the ‘R’ bit set in the Command Flags field. It, is sent by the GGSN to the BM-SC to request user authorization (authorize the activating UE to receive Data) , to modify an MBMS UE Context in the BM-SC or to register the GGSN for a particular multicast MBMS bearer service. When used for these purposes, the Additional-MBMS-Trace-Info AVP shall not be included.
	When the AAR command is used by the GGSN to modify an MBMS UE context in the BM-SC, it shall include all the parameters that have been changed according to the triggering Update MBMS Context Request, ref. fig. 35. The inclusion of CGI/SAI in the 3GPP-User-Location-Info AVP shall be according to the rules detailed in subclause 15.1.1a in 3GPP TS 23.060 [3]). The Called-Station-Id AVP, Calling-Station-Id AVP, Framed-IP-Address AVP, Framed-IPv6-Prefix AVP and Framed-Interface-Id AVP shall not be included,
	The AAR command is also used when the GGSN needs to activate a Trace Session in the BM-SC. In this case the Called-Station-Id AVP, Calling-Station-Id AVP, Framed-IP-Address AVP, Framed-IPv6-Prefix AVP, Framed-Interface-Id AVP, and RAI AVP shall not be included. For more detailed description of Trace Session activation/deactivation procedures see 3GPP TS 32.422 [69].
	The relevant AVPs that are of use for the Gmb interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gmb purposes and should be ignored by the receiver or processed according to the relevant specifications.
	The bold marked AVPs in the message format indicate new optional AVPs for Gmb, or modified existing AVPs.
	Message Format:

	<AA-Request> ::= < Diameter Header: 265, REQ, PXY >
				 	< Session-Id >
				 	{ Auth-Application-Id }
				 	{ Origin-Host }
				 	{ Origin-Realm }
				 	{ Destination-Realm }
				 	{ Auth-Request-Type }
				 	[ Destination-Host ]
					[ Called-Station-Id ]
					[ Calling-Station-Id ]
					[ Framed-IP-Address]
					[ Framed-IPv6-Prefix ]
					[ Framed-Interface-Id ]
				*	[ Proxy-Info ]
				*	[ Route-Record ]
					[ 3GPP-IMSI]
					[ RAI ]
					[ 3GPP-IMEISV ]
					[ 3GPP-RAT-Type ]
					[ 3GPP-User-Location-Info ]
					[ 3GPP-MS-TimeZone ]
					[ Additional-MBMS-Trace-Info ]

	The GGSN shall allocate a new Session-Id each time an AAR command is sent, except for the case when the AAR is sent to modify an existing MBMS UE Context in the BM-SC.
	A request for user authorisation for an MBMS bearer service is indicated by the presence of the MSISDN within the Calling-Station-Id AVP and the 3GPP-IMSI. Otherwise the request is for the GGSN to be authorised (i.e. registered) to receive the MBMS bearer service.The Framed-IPv6-Prefix AVP contains the IPv6 prefix of the multicast address identifying the MBMS bearer service.
	The Framed-Interface-Id AVP contains the IPv6 interface identifier of the multicast address identifying the MBMS bearer service.
	The Framed-IP-Address AVP contains the IPv4 multicast address identifying the MBMS bearer service.
	The Called-Station-Id AVP contains the Access Point Name (APN) on which the MBMS bearer service authorisation request was received.
 */
@DiameterCommandDefinition(applicationId = 16777223, commandCode = 265, request = true, proxyable = true, name="AA-Request")
public interface AARequest extends AuthenticationRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);				
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	String getCallingStationId();
	
	void setCallingStationId(String value);
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);	
	
	Long getFramedInterfaceId();
	
	void setFramedInterfaceId(Long value);
	
	String getTGPPIMSI();
	
	void setTGPPIMSI(String value);	
	
	String getRAI();
	
	void setRAI(String value);	
	
	ByteBuf getTGPPIMEISV();
	
	void setTGPPIMEISV(ByteBuf value);	
	
	ByteBuf getTGPPRATType();
	
	void setTGPPRATType(ByteBuf value);	
	
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);
	
	ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);
	
	ByteBuf getAdditionalMBMSTraceInfo();
	
	void setAdditionalMBMSTraceInfo(ByteBuf value);
}