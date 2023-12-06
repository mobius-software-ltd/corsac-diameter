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
import java.net.Inet6Address;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSUserDataModeIndicationEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*	17.6.6	RE-Auth-Answer Command
	The Re-Auth-Answer (RAA) command, defined in IETF RFC 6733 (DIAMETER BASE) [111], is indicated by the Command-Code set to 258 and the message flags’ ‘R’ bit clear, is sent in response to the RAR. 
	The relevant AVPs that are of use for the Gmb interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gmb purposes and should be ignored by the receiver or processed according to the relevant specifications.
	The bold marked AVPs in the message format indicate new optional  AVPs for Gmb, or modified existing AVPs.
	Message Format:
      
    <RAA>  ::= < Diameter Header: 258, PXY >
                 	< Session-Id >
                 	{ Origin-Host }
                 	{ Origin-Realm }
                 	[ Result-Code ]
                 	[ Experimental-Result ]
                 	[ MBMS-StartStop-Indication ]
                 	[ MBMS-GGSN-Address ]            ; for unicast encapsulated user data
                 	[ MBMS-GGSN-IPv6-Address ]       ; for unicast encapsulated user data
                 	[ MBMS-GW-UDP-Port]              ; for unicast encapsulated user data
                 	[ MBMS-User-Data-Mode-Indication ]
                 	[ Origin-State-Id ]
                 	[ Error-Message ]
                 	[ Error-Reporting-Host ]
                  	[ Failed-AVP ]
                 *	[ Redirected-Host ]
                 	[ Redirected-Host-Usage ]
                 	[ Redirected-Host-Cache-Time ]
                 *	[ Proxy-Info ]

If multicast user plane data are to be sent to the GGSN using IP unicast, the GGSN shall allocate an IP transport address and a separate UDP port for each MBMS bearer ( i.e the service uniquely identified by its TMGI and Flow ID and provided by the GPRS to deliver the same IP datagrams to multiple receivers in a designated location). The GGSN shall then use the destination unicast IP address and destination UDP port of user plane packets received over the Gi interface to determine on which MBMS bearer to forward the received user plane packet.

 */
@DiameterCommandDefinition(applicationId = 16777223, commandCode = 258, request = false, proxyable = true, name="Re-Auth-Answer")
public interface ReAuthAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthAnswer
{
	MBMSStartStopIndicationEnum getMBMSStartStopIndication();
	
	void setMBMSStartStopIndication(MBMSStartStopIndicationEnum value);
	
	Inet4Address getMBMSGGSNAddress();	
	
	void setMBMSGGSNAddress(Inet4Address value);
	
	Inet6Address getMBMSGGSNIPv6Address();	
	
	void setMBMSGGSNIPv6Address(Inet6Address value);
	
	ByteBuf getMBMSGWUDPPort();	
	
	void setMBMSGWUDPPort(ByteBuf value);
	
	MBMSUserDataModeIndicationEnum getMBMSUserDataModeIndication();	
	
	void setMBMSUserDataModeIndication(MBMSUserDataModeIndicationEnum value);
}