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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *  17.6.2	AAA Command
	The AAA command, defined in Diameter NASREQ (IETF RFC 7155 [120]), is indicated by the Command-Code field set to 265 and the ‘R’ bit cleared in the Command Flags field., It is sent by the BM-SC to the GGSN in response to the AAR command.
	When the AAA command is used to acknowledge an AAR that activated a Trace Session, the only Gmb specific AVP that shall be included is the 3GPP-IMSI AVP.
	The relevant AVPs that are of use for the Gmb interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gmb purposes and should be ignored by the receiver or processed according to the relevant specifications.
	The bold marked AVPs in the message format indicate new optional AVPs for Gmb, or modified existing AVPs.
	Message Format:

	<AA-Answer> ::= < Diameter Header: 265, PXY >
                      	< Session-Id >
                      	{ Auth-Application-Id }
                      	{ Origin-Host }
                      	{ Origin-Realm }
                      	[ Result-Code ]
                      	[ Experimental-Result ]
                      	[ Error-Message ]
                      	[ Error-Reporting-Host ] 
                      	[ Failed-AVP ]
                      *	[ Proxy-Info ]
                      	[ Alternative-APN ]
                      	[ 3GPP-IMSI]
                      	[ TMGI ]
                      	[ Required-MBMS-Bearer-Capabilities ]
 */
@DiameterCommandDefinition(applicationId = 16777223, commandCode = 265, request = false, proxyable = true, name="AA-Answer")
public interface AAAnswer extends AuthenticationAnswer
{
	public String getAlternativeAPN();
	
	void setAlternativeAPN(String value);		
	
	String getTGPPIMSI();		
	
	void setTGPPIMSI(String value);
	
	ByteBuf getTMGI();	
	
	void setTMGI(ByteBuf value);			
	
	public String getRequiredMBMSBearerCapabilities();
	
	void setRequiredMBMSBearerCapabilities(String value);
}