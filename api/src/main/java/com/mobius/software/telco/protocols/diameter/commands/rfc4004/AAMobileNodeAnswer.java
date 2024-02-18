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
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAtoHAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAtoMNMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoMNMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoFAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoHAMSA;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *   5.2.  AA-Mobile-Node-Answer

   	The AA-Mobile-Node-Answer (AMA), indicated by the Command-Code field
   	set to 260 and the 'R' bit cleared in the Command Flags field, is
   	sent by the AAAH in response to the AA-Mobile-Node-Request message.
   	The User-Name MAY be included in the AMA if it is present in the AMR.
   	The Result-Code AVP MAY contain one of the values defined in section
   	6, in addition to the values defined in [DIAMBASE].

   	An AMA message with the Result-Code AVP set to DIAMETER_SUCCESS MUST
   	include the MIP-Home-Agent-Address AVP, MUST include the MIP-Mobile-
   	Node-Address AVP, and includes the MIP-Reg-Reply AVP if and only if
   	the Co-Located-Mobile-Node bit was not set in the MIP-Feature-Vector
   	AVP.  The MIP-Home-Agent-Address AVP contains the Home Agent assigned
   	to the mobile node, while the MIP-Mobile-Node-Address AVP contains
   	the home address that was assigned.  The AMA message MUST contain the
   	MIP-FA-to-HA-MSA and MIP-FA-to-MN-MSA if they were requested in the
   	AMR and were present in the HAR.  The MIP-MN-to-HA-MSA and MIP-HA-
   	to-MN-MSA AVPs MUST be present if the session keys were requested in
   	the AMR and the Co-Located-Mobile-Node bit was set in the MIP-
   	Feature-Vector AVP.

    Message Format

    <AA-Mobile-Node-Answer> ::= < Diameter Header: 260, PXY >
                                     < Session-Id >
                                     { Auth-Application-Id }
                                     { Result-Code }
                                     { Origin-Host }
                                     { Origin-Realm }
                                     [ Acct-Multi-Session-Id ]
                                     [ User-Name ]
                                     [ Authorization-Lifetime ]
                                     [ Auth-Session-State ]
                                     [ Error-Message ]
                                     [ Error-Reporting-Host ]
                                     [ Re-Auth-Request-Type ]
                                     [ MIP-Feature-Vector ]
                                     [ MIP-Reg-Reply ]
                                     [ MIP-MN-to-FA-MSA ]
                                     [ MIP-MN-to-HA-MSA ]
                                     [ MIP-FA-to-MN-MSA ]
                                     [ MIP-FA-to-HA-MSA ]
                                     [ MIP-HA-to-MN-MSA ]
                                     [ MIP-MSA-Lifetime ]
                                     [ MIP-Home-Agent-Address ]
                                     [ MIP-Mobile-Node-Address ]
                                   * [ MIP-Filter-Rule ]
                                     [ Origin-State-Id ]
                                   * [ Proxy-Info ]
                                   * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.MOBILE_IPV4, commandCode = CommandCodes.AA_MOBILE_NODE, request = false, proxyable = true, name="AA-Mobile-Node-Answer")
public interface AAMobileNodeAnswer extends DiameterAnswer
{
	Long getAuthApplicationId();
	
	void setAuthApplicationId(Long value) throws MissingAvpException;
	
	String getAcctMultiSessionId();
	
	void setAcctMultiSessionId(String value);
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);
	
	ReAuthRequestTypeEnum getReAuthRequestType();
	
	void setReAuthRequestType(ReAuthRequestTypeEnum value);
	
	Long getMIPFeatureVector();
	
	void setMIPFeatureVector(Long value);
	
	ByteBuf getMIPRegReply();
	
	void setMIPRegReply(ByteBuf value);
	
	MIPMNtoFAMSA getMIPMNtoFAMSA();
	
	void setMIPMNtoFAMSA(MIPMNtoFAMSA value);
	
	MIPMNtoHAMSA getMIPMNtoHAMSA();
	
	void setMIPMNtoHAMSA(MIPMNtoHAMSA value);
	
	MIPFAtoMNMSA getMIPFAtoMNMSA();
	
	void setMIPFAtoMNMSA(MIPFAtoMNMSA value);
	
	MIPFAtoHAMSA getMIPFAtoHAMSA();
	
	void setMIPFAtoHAMSA(MIPFAtoHAMSA value);
	
	MIPHAtoMNMSA getMIPHAtoMNMSA();
	
	void setMIPHAtoMNMSA(MIPHAtoMNMSA value);
	
	Long getMIPMSALifetime();
	
	void setMIPMSALifetime(Long value);
	
	InetAddress getMIPHomeAgentAddress();
	
	void setMIPHomeAgentAddress(InetAddress value);
	
	InetAddress getMIPMobileNodeAddress();
	
	void setMIPMobileNodeAddress(InetAddress value);
	
	List<MIPFilterRule> getMIPFilterRule();
	
	void setMIPFilterRule(List<MIPFilterRule> value);		
}