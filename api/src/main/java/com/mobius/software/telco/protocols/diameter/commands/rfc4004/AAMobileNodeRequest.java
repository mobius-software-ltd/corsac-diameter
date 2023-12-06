package com.mobius.software.telco.protocols.diameter.commands.rfc4004;
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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentHost;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNAAAAuth;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPOriginatingForeignAAA;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.1.  AA-Mobile-Node-Request

   	The AA-Mobile-Node-Request (AMR), indicated by the Command-Code field
   	set to 260 and the 'R' bit set in the Command Flags field, is sent by
   	an attendant (i.e., the Foreign Agent), acting as a Diameter client,
   	to an AAAF in order to request the authentication and authorization
   	of a mobile node.  The foreign agent (or home agent in the case of a
   	co-located Mobile Node) uses information found in the Registration
   	Request to construct the following AVPs, to be included as part of
   	the AMR:

             Home Address (MIP-Mobile-Node-Address AVP)
             Home Agent Address (MIP-Home-Agent-Address AVP)
             Mobile Node NAI (User-Name AVP [DIAMBASE])
             MN-HA Key Request (MIP-Feature-Vector AVP)
             MN-FA Key Request (MIP-Feature-Vector AVP)
             MN-AAA Authentication Extension (MIP-MN-AAA-Auth AVP)
             Foreign Agent Challenge Extension (MIP-FA-Challenge AVP)
             Home Agent NAI (MIP-Home-Agent-Host AVP)
             Home AAA server NAI (Destination-Host AVP [DIAMBASE])
             Home Agent to Foreign Agent SPI (MIP-HA-to-FA-SPI AVP)

   	If the mobile node's home address is zero, the foreign or home agent
   	MUST NOT include a MIP-Mobile-Node-Address AVP in the AMR.  If the
   	home agent address is zero or all ones, the MIP-Home-Agent-Address
   	AVP MUST NOT be present in the AMR.

   	If a home agent is used in a visited network, the AAAF MAY set the
   	Foreign-Home-Agent-Available flag in the MIP-Feature-Vector AVP in
   	the AMR message to indicate that it is willing to assign a Home Agent
   	in the visited realm.
   	
   	If the mobile node's home address is all ones, the foreign or home
   	agent MUST include a MIP-Mobile-Node-Address AVP, set to all ones.

   	If the mobile node includes the home agent NAI and the home AAA
   	server NAI [AAANAI], the foreign agent MUST include the MIP-Home-
   	Agent-Host AVP and the Destination-Host AVP in the AMR.

    Message Format

    <AA-Mobile-Node-Request> ::= < Diameter Header: 260, REQ, PXY >
                                      < Session-ID >
                                      { Auth-Application-Id }
                                      { User-Name }
                                      { Destination-Realm }
                                      { Origin-Host }
                                      { Origin-Realm }
                                      { MIP-Reg-Request }
                                      { MIP-MN-AAA-Auth }
                                      [ Acct-Multi-Session-Id ]
                                      [ Destination-Host ]
                                      [ Origin-State-Id ]
                                      [ MIP-Mobile-Node-Address ]
                                      [ MIP-Home-Agent-Address ]
                                      [ MIP-Feature-Vector ]
                                      [ MIP-Originating-Foreign-AAA ]
                                      [ Authorization-Lifetime ]
                                      [ Auth-Session-State ]
                                      [ MIP-FA-Challenge ]
                                      [ MIP-Candidate-Home-Agent-Host ]
                                      [ MIP-Home-Agent-Host ]
                                      [ MIP-HA-to-FA-SPI ]
                                    * [ Proxy-Info ]
                                    * [ Route-Record ]
                                    * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 2, commandCode = 260, request = true, proxyable = true, name="AA-Mobile-Node-Request")
public interface AAMobileNodeRequest extends AuthenticationRequest
{
	ByteBuf getMIPRegRequest();
	
	void setMIPRegRequest(ByteBuf value);
	
	MIPMNAAAAuth getMIPMNAAAAuth();
	
	void setMIPMNAAAAuth(MIPMNAAAAuth value);
	
	public String getAcctMultiSessionId();
	
	void setAcctMultiSessionId(String value);

	public InetAddress getMIPMobileNodeAddress();
	
	void setMIPMobileNodeAddress(InetAddress value);
	
	public InetAddress getMIPHomeAgentAddress();
	
	void setMIPHomeAgentAddress(InetAddress value);
	
	public Long getMIPFeatureVector();
	
	void setMIPFeatureVector(Long value);
	
	public MIPOriginatingForeignAAA getMIPOriginatingForeignAAA();
	
	void setMIPOriginatingForeignAAA(MIPOriginatingForeignAAA value);
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);
	
	ByteBuf getMIPFAChallenge();
	
	void setMIPFAChallenge(ByteBuf value);	
	
	String getMIPCandidateHomeAgentHost();
	
	void setMIPCandidateHomeAgentHost(String value);	
	
	MIPHomeAgentHost getMIPHomeAgentHost();
	
	void setMIPHomeAgentHost(MIPHomeAgentHost value);	
	
	Long getMIPHAtoFASPI();
	
	void setMIPHAtoFASPI(Long value);
}