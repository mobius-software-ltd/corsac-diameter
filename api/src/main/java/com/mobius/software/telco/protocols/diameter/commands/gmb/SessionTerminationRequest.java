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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	17.6.3	STR Command
	The STR command, defined in IETF RFC 6733 (DIAMETER BASE) [111], is indicated by the Command-Code field set to 275 and the ‘R’ bit set in the Command Flags field, It is sent by the GGSN to the BM-SC to terminate a DIAMETER session.
	A DIAMETER session for a multicast MBMS service is terminated when the last MBMS UE context for the MBMS bearer service is deleted. This informs the BM-SC that the GGSN would like to be deleted from the distribution tree of a particular MBMS bearer service (De-registration procedure). 
	A DIAMETER session for an individual UE’s multicast MBMS service authorisation is terminated when the UE has requested to the GGSN to leave the MBMS bearer service.
	A DIAMETER session for a broadcast MBMS service may be terminated by the GGSN in exceptional cases.
	The STR command is also used to deactivate a Trace Session previously activated in the BM-SC and to terminate the associated Diameter Session initiated by the AAR that activated the Trace session. The Gmb specific AVP Additonal-MBMS-Trace-Info shall be included in the STR command only in the case of a Trace Session deactivation. For more detailed description of Trace Session activation/deactivation procedures see 3GPP TS 32.422 [69].
	The relevant AVPs that are of use for the Gmb interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gmb purposes and should be ignored by the receiver or processed according to the relevant specifications.
	Message Format:

	<ST-Request> ::= < Diameter Header: 275, REQ, PXY >
                      	< Session-Id >
                      	{ Origin-Host }
                      	{ Origin-Realm }
                      	{ Destination-Realm }
                      	{ Auth-Application-Id }
                      	{ Termination-Cause }
                      	[ Destination-Host ]
                      *	[ Class ]
                      	[ Origin-State-Id ]
                      *	[ Proxy-Info ]
                      *	[ Route-Record ]
                      	[ Additional-MBMS-Trace-Info ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.GMB, commandCode = CommandCodes.SESSION_TERMINATION, request = true, proxyable = true, name="Session-Termination-Request")
public interface SessionTerminationRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationRequest
{
	ByteBuf getAdditionalMBMSTraceInfo();
	
	void setAdditionalMBMSTraceInfo(ByteBuf value);
}