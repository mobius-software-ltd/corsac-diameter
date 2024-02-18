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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoFAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoMNMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoFAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoHAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPOriginatingForeignAAA;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.  Home-Agent-MIP-Request

   	The AAA sends the Home-Agent-MIP-Request (HAR), indicated by the
   	Command-Code field set to 262 and the 'R' bit set in the Command
   	Flags field, to the Home Agent.  If the Home Agent is to be assigned
   	in a foreign network, the HAR is issued by the AAAH and forwarded by
   	the AAAF to the HA if no redirect servers are involved.  If any are,
   	the HAR is sent directly to the HA via a security association.  If
   	the HAR message does not include a MIP-Mobile-Node-Address AVP, the
   	Registration Request has 0.0.0.0 for the home address, and the HAR is
   	successfully processed, the Home Agent MUST allocate the mobile nodes
   	address.  If, on the other hand, the home agent's local AAA server
   	allocates the mobile node's home address, the local AAA server MUST
   	include the assigned address in a MIP-Mobile-Node-Address AVP.

   	When session keys are requested for use by the mobile node, the AAAH
   	MUST create them and include them in the HAR message.  When a FA-HA
   	session key is requested, it will be created and distributed by the
   	AAAH server.

    Message Format

    <Home-Agent-MIP-Request> ::= < Diameter Header: 262, REQ, PXY >
                                      < Session-Id >
                                      { Auth-Application-Id }
                                      { Authorization-Lifetime }
                                      { Auth-Session-State }
                                      { MIP-Reg-Request }
                                      { Origin-Host }
                                      { Origin-Realm }
                                      { User-Name }
                                      { Destination-Realm }
                                      { MIP-Feature-Vector }
                                      [ Destination-Host ]
                                      [ MIP-MN-to-HA-MSA ]
                                      [ MIP-MN-to-FA-MSA ]
                                      [ MIP-HA-to-MN-MSA ]
                                      [ MIP-HA-to-FA-MSA ]
                                      [ MIP-MSA-Lifetime ]
                                      [ MIP-Originating-Foreign-AAA ]
                                      [ MIP-Mobile-Node-Address ]
                                      [ MIP-Home-Agent-Address ]
                                    * [ MIP-Filter-Rule ]
                                      [ Origin-State-Id ]
                                    * [ Proxy-Info ]
                                    * [ Route-Record ]
                                    * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.MOBILE_IPV4, commandCode = CommandCodes.HOME_AGENT_MIP, request = true, proxyable = true, name="Home-Agent-MIP-Request")
public interface HomeAgentMIPRequest extends AuthenticationRequest
{
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value) throws MissingAvpException;	
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException;
	
	ByteBuf getMIPRegRequest();
	
	void setMIPRegRequest(ByteBuf value) throws MissingAvpException;
	
	public Long getMIPFeatureVector();
	
	void setMIPFeatureVector(Long value) throws MissingAvpException;
	
	MIPMNtoHAMSA getMIPMNtoHAMSA();
	
	void setMIPMNtoHAMSA(MIPMNtoHAMSA value);
	
	MIPMNtoFAMSA getMIPMNtoFAMSA();
	
	void setMIPMNtoFAMSA(MIPMNtoFAMSA value);
	
	MIPHAtoMNMSA getMIPHAtoMNMSA();
	
	void setMIPHAtoMNMSA(MIPHAtoMNMSA value);
	
	MIPHAtoFAMSA getMIPHAtoFAMSA();
	
	void setMIPHAtoFAMSA(MIPHAtoFAMSA value);
	
	Long getMIPMSALifetime();
	
	void setMIPMSALifetime(Long value);
	
	public MIPOriginatingForeignAAA getMIPOriginatingForeignAAA();
	
	void setMIPOriginatingForeignAAA(MIPOriginatingForeignAAA value);	
	
	public InetAddress getMIPMobileNodeAddress();
	
	void setMIPMobileNodeAddress(InetAddress value);
	
	public InetAddress getMIPHomeAgentAddress();
	
	void setMIPHomeAgentAddress(InetAddress value);
	
	List<MIPFilterRule> getMIPFilterRule();
	
	void setMIPFilterRule(List<MIPFilterRule> value);			
}